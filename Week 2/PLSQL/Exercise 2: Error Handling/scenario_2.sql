--------------------------------------------------- Create Employees table --------------------------------------------------- 
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    EmployeeName VARCHAR2(100),
    Salary NUMBER
);

---------------------------------------------------  Create ErrorLog table --------------------------------------------------- 
CREATE TABLE ErrorLog (
    LogID NUMBER PRIMARY KEY,
    ErrorMessage VARCHAR2(4000),
    ErrorDate DATE
);

---------------------------------------------------  Create sequences for primary keys ---------------------------------------
CREATE SEQUENCE EmployeesSeq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE ErrorLogSeq START WITH 1 INCREMENT BY 1;

---------------------------------------------------  Insert sample data into Employees table ---------------------------------
INSERT INTO Employees (EmployeeID, EmployeeName, Salary) VALUES (EmployeesSeq.NEXTVAL, 'Nishi Choudhary', 50000);
INSERT INTO Employees (EmployeeID, EmployeeName, Salary) VALUES (EmployeesSeq.NEXTVAL, 'Amrita Kumari', 60000);


--------------------------------------------------- Create Procedure ----------------------------------------------------------
CREATE PROCEDURE UpdateSalary (
    p_EmployeeID IN NUMBER,
    p_Percentage IN NUMBER
) IS
    v_EmployeeName VARCHAR2(100);
    v_ErrorMsg VARCHAR2(4000);
BEGIN
    -- Try to find the employee
    SELECT EmployeeName INTO v_EmployeeName FROM Employees WHERE EmployeeID = p_EmployeeID;

    -- If the employee exists, update the salary
    UPDATE Employees SET Salary = Salary + (Salary * p_Percentage / 100) WHERE EmployeeID = p_EmployeeID;

    -- Commit the transaction
    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        -- Handle the case where the employee ID does not exist
        v_ErrorMsg := 'Employee with ID ' || p_EmployeeID || ' does not exist.';
        DBMS_OUTPUT.PUT_LINE(v_ErrorMsg);  -- Print the error message
        INSERT INTO ErrorLog (LogID, ErrorMessage, ErrorDate)
        VALUES (ErrorLogSeq.NEXTVAL, v_ErrorMsg, SYSDATE);
        ROLLBACK;
    WHEN OTHERS THEN
        -- Handle any other exceptions
        v_ErrorMsg := SQLERRM;
        DBMS_OUTPUT.PUT_LINE('Error: ' || v_ErrorMsg); 
        INSERT INTO ErrorLog (LogID, ErrorMessage, ErrorDate)
        VALUES (ErrorLogSeq.NEXTVAL, v_ErrorMsg, SYSDATE);
        ROLLBACK;
END;
/


-------------------------------------------------- Test Procedure ----------------------------------------------------
BEGIN
    -- Salary updated
    UpdateSalary(1, 10); 
END;
/

BEGIN
    -- Attempt to update salary for a non-existent employee
    UpdateSalary(999, 10); 
END;
/
