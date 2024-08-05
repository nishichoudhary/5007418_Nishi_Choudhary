------------------------------------------------ Create Customers table ------------------------------------------------
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(100),
    CustomerEmail VARCHAR2(100)
);

------------------------------------------------ Create ErrorLog table --------------------------------------------------
CREATE TABLE ErrorLog (
    LogID NUMBER PRIMARY KEY,
    ErrorMessage VARCHAR2(4000),
    ErrorDate DATE
);

------------------------------------------------ Create sequences for primary keys ---------------------------------------
CREATE SEQUENCE CustomersSeq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE ErrorLogSeq START WITH 1 INCREMENT BY 1;

------------------------------------------------ Create Procedure --------------------------------------------------------
CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_CustomerID IN NUMBER,
    p_CustomerName IN VARCHAR2,
    p_CustomerEmail IN VARCHAR2
) IS
    v_ErrorMsg VARCHAR2(4000);
BEGIN
    -- Attempt to insert the new customer
    BEGIN
        INSERT INTO Customers (CustomerID, CustomerName, CustomerEmail)
        VALUES (p_CustomerID, p_CustomerName, p_CustomerEmail);
        
        -- Commit the transaction
        COMMIT;
        
        DBMS_OUTPUT.PUT_LINE('Customer added successfully.');
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            -- Handle the case where the customer ID already exists
            v_ErrorMsg := 'Customer with ID ' || p_CustomerID || ' already exists.';
            DBMS_OUTPUT.PUT_LINE(v_ErrorMsg);  -- Print the error message
            INSERT INTO ErrorLog (LogID, ErrorMessage, ErrorDate)
            VALUES (ErrorLogSeq.NEXTVAL, v_ErrorMsg, SYSDATE);
            ROLLBACK;
        WHEN OTHERS THEN
            -- Handle any other exceptions
            v_ErrorMsg := SQLERRM;
            DBMS_OUTPUT.PUT_LINE('Error: ' || v_ErrorMsg);  -- Print the error message
            INSERT INTO ErrorLog (LogID, ErrorMessage, ErrorDate)
            VALUES (ErrorLogSeq.NEXTVAL, v_ErrorMsg, SYSDATE);
            ROLLBACK;
    END;
END;
/

------------------------------------------------ Test Procedure ------------------------------------------------------

BEGIN
    -- Attempt to add a new customer
    AddNewCustomer(1, 'Nishi Choudhary', 'nishichoudhary49@gmail.com');
END;
/

BEGIN
    -- Attempt to add a customer with an existing ID
    AddNewCustomer(1, 'Amrita Kumari', 'amritakumari01@gmail.com');
END;
/

-- Check contents of Customers to see if any changes were made
SELECT * FROM Customers;
