CREATE DATABASE bankdb_ex3;
USE bankdb_ex3;
CREATE TABLE SavingsAccounts (
    AccountID INT PRIMARY KEY,
    CustomerName VARCHAR(100),
    Balance DECIMAL(10,2)
);
INSERT INTO SavingsAccounts VALUES
(1, 'John', 10000.00),
(2, 'Alice', 15000.00),
(3, 'Bob', 20000.00);
DELIMITER $$

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    UPDATE SavingsAccounts
    SET Balance = Balance + (Balance * 0.01);
END$$

DELIMITER ;
CALL ProcessMonthlyInterest();
SELECT * FROM SavingsAccounts;
CREATE TABLE Employees (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(100),
    Department VARCHAR(100),
    Salary DECIMAL(10,2)
);
INSERT INTO Employees VALUES
(1, 'Ravi', 'IT', 50000.00),
(2, 'Sara', 'HR', 40000.00),
(3, 'Nina', 'it', 55000.00); 
DELIMITER $$

CREATE PROCEDURE UpdateEmployeeBonus(
    IN deptName VARCHAR(100),
    IN bonusPercent DECIMAL(5,2)
)
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * bonusPercent / 100)
    WHERE LOWER(Department) = LOWER(deptName);
END$$

DELIMITER ;
CALL UpdateEmployeeBonus('IT', 10);
SELECT * FROM Employees;
CREATE TABLE Accounts (
    AccountNumber INT PRIMARY KEY,
    HolderName VARCHAR(100),
    Balance DECIMAL(10,2)
);
INSERT INTO Accounts VALUES
(101, 'John', 8000.00),
(102, 'Alice', 6000.00);
DELIMITER $$

CREATE PROCEDURE TransferFunds(
    IN fromAccount INT,
    IN toAccount INT,
    IN amount DECIMAL(10,2)
)
BEGIN
    DECLARE fromBalance DECIMAL(10,2);

    SELECT Balance INTO fromBalance
    FROM Accounts
    WHERE AccountNumber = fromAccount;

    IF fromBalance >= amount THEN
        UPDATE Accounts
        SET Balance = Balance - amount
        WHERE AccountNumber = fromAccount;

        UPDATE Accounts
        SET Balance = Balance + amount
        WHERE AccountNumber = toAccount;
    ELSE
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient funds in source account';
    END IF;
END$$

DELIMITER ;
CALL TransferFunds(101, 102, 2000);
SELECT * FROM Accounts;






