-- Creating Customers table
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Age NUMBER,
    Balance NUMBER,
    IsVIP VARCHAR2(5)
);



-- Creating Loans table
CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    Amount NUMBER,
    InterestRate NUMBER,
    DueDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);



-- Inserting sample data into Customers table
INSERT INTO Customers (CustomerID, Name, Age, Balance, IsVIP) VALUES (1, 'Niharika Das', 65, 15000, 'FALSE');
INSERT INTO Customers (CustomerID, Name, Age, Balance, IsVIP) VALUES (2, 'Amrita Kumari', 45, 8000, 'FALSE');
INSERT INTO Customers (CustomerID, Name, Age, Balance, IsVIP) VALUES (3, 'Riya Mathur', 70, 12000, 'FALSE');
INSERT INTO Customers (CustomerID, Name, Age, Balance, IsVIP) VALUES (4, 'Lisa Smith', 30, 9000, 'FALSE');



-- Inserting sample data into Loans table
INSERT INTO Loans (LoanID, CustomerID, Amount, InterestRate, DueDate) VALUES (1, 1, 10000, 5.0, SYSDATE + 20);
INSERT INTO Loans (LoanID, CustomerID, Amount, InterestRate, DueDate) VALUES (2, 2, 8000, 4.5, SYSDATE + 35);
INSERT INTO Loans (LoanID, CustomerID, Amount, InterestRate, DueDate) VALUES (3, 3, 12000, 5.5, SYSDATE + 10);
INSERT INTO Loans (LoanID, CustomerID, Amount, InterestRate, DueDate) VALUES (4, 4, 9000, 4.0, SYSDATE + 25);



-- Scenario 1: Apply a 1% discount to loan interest rates for customers above 60 years old
BEGIN
    FOR customer IN (SELECT CustomerID FROM Customers WHERE Age > 60) LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = customer.CustomerID;
    END LOOP;
    COMMIT;
END;
/
Select * from loans;



-- Scenario 2: Set IsVIP to TRUE for customers with a balance over $10,000
BEGIN
    FOR customer IN (SELECT CustomerID FROM Customers WHERE Balance > 10000) LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = customer.CustomerID;
    END LOOP;
    COMMIT;
END;
/
Select * from customers;



-- Scenario 3: Fetch loans due in the next 30 days and print reminder messages
BEGIN
    FOR loan IN (SELECT LoanID, CustomerID FROM Loans WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30) LOOP
        DECLARE
            customerName VARCHAR2(100);
        BEGIN
            SELECT Name INTO customerName FROM Customers WHERE CustomerID = loan.CustomerID;
            DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || loan.LoanID || ' for customer ' || customerName || ' is due within the next 30 days.');
        END;
    END LOOP;
END;
/
