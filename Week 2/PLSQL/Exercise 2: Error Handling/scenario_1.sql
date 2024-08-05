--------------------------------------------------- Create Accounts table ------------------------------------------------------ 
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    AccountHolder VARCHAR2(100),
    Balance NUMBER
);

-------------------------------------------------- Create a table for recording transactions------------------------------------ 
CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    SenderID NUMBER,
    ReceiverID NUMBER,
    Amount NUMBER(18, 2),
    TransactionType VARCHAR2(50),
    TransactionDate DATE
);

--------------------------------------------------- Sequence for primary keys --------------------------------------------------- 
CREATE SEQUENCE AccountsSeq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE TransactionsSeq START WITH 1 INCREMENT BY 1;

--------------------------------------------------- Insert sample data into Accounts table---------------------------------------
INSERT INTO Accounts (AccountID, AccountHolder, Balance) VALUES (AccountsSeq.NEXTVAL, 'Nishi Choudhary', 1000);
INSERT INTO Accounts (AccountID, AccountHolder, Balance) VALUES (AccountsSeq.NEXTVAL, 'Riya Singh', 500);
INSERT INTO Accounts (AccountID, AccountHolder, Balance) VALUES (AccountsSeq.NEXTVAL, 'Amrita Kumari', 300);


---------------------------------------------------  Create Procedure ----------------------------------------------------------- 
CREATE PROCEDURE TransferFunds (
    p_SenderID IN NUMBER,
    p_ReceiverID IN NUMBER,
    p_TransferAmount IN NUMBER
) IS
    v_SenderBalance NUMBER;
BEGIN
    -- Start a transaction
    -- Check if the sender has enough balance
    SELECT Balance INTO v_SenderBalance FROM Accounts WHERE AccountID = p_SenderID FOR UPDATE;

    IF v_SenderBalance < p_TransferAmount THEN
        -- If not enough balance, issue a ROLLBACK and an error message
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in sender account');
    END IF;

    -- Deduct the amount from the sender’s account
    UPDATE Accounts
    SET Balance = Balance - p_TransferAmount
    WHERE AccountID = p_SenderID;

    -- Add it to the receiver’s account
    UPDATE Accounts
    SET Balance = Balance + p_TransferAmount
    WHERE AccountID = p_ReceiverID;

    -- Record the transaction in the Transactions table with the type 'TRANSFER'
    INSERT INTO Transactions (TransactionID, SenderID, ReceiverID, Amount, TransactionType, TransactionDate)
    VALUES (TransactionsSeq.NEXTVAL, p_SenderID, p_ReceiverID, p_TransferAmount, 'TRANSFER', SYSDATE);

    -- Commit the transaction if all operations are successful
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END;
/
  
---------------------------------------------------  Test procedures -------------------------------------------------- 
BEGIN
    -- Successful transfer from AccountID 1 to AccountID 2
    TransferFunds(1, 2, 200);
END;
/

BEGIN
    -- Attempt to transfer 2000 from AccountID 1 to AccountID 3
    -- Fails due to insufficient funds
    TransferFunds(1, 3, 2000);
END;
/
