CREATE DATABASE bankdb;
USE bankdb;
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR(100),
    Age INT,
    Balance DECIMAL(10,2),
    IsVIP BOOLEAN DEFAULT FALSE
);
CREATE TABLE Loans (
    LoanID INT PRIMARY KEY,
    CustomerID INT,
    InterestRate DECIMAL(5,2),
    DueDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
SHOW TABLES;
INSERT INTO Customers VALUES
(1, 'John', 65, 12000, FALSE),
(2, 'Alice', 45, 8000, FALSE),
(3, 'Bob', 70, 15000, FALSE);

INSERT INTO Loans VALUES
(101, 1, 7.5, CURDATE() + INTERVAL 10 DAY),
(102, 2, 8.0, CURDATE() + INTERVAL 35 DAY),
(103, 3, 6.5, CURDATE() + INTERVAL 5 DAY);

SELECT * FROM Customers;
SELECT * FROM Loans;
DELIMITER $$

CREATE PROCEDURE ApplySeniorDiscount()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE custId INT;

    DECLARE cur CURSOR FOR 
        SELECT CustomerID FROM Customers WHERE Age > 60;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO custId;
        IF done THEN
            LEAVE read_loop;
        END IF;

        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = custId;
    END LOOP;

    CLOSE cur;
END$$

DELIMITER ;
CALL ApplySeniorDiscount();
SELECT * FROM Loans;
SET SQL_SAFE_UPDATES = 0;
UPDATE Customers
SET IsVIP = TRUE
WHERE Balance > 10000;
SELECT * FROM Customers;
DELIMITER $$

CREATE PROCEDURE SendLoanReminders()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE custName VARCHAR(100);
    DECLARE dueDate DATE;

    DECLARE cur CURSOR FOR 
        SELECT C.Name, L.DueDate 
        FROM Customers C
        JOIN Loans L ON C.CustomerID = L.CustomerID
        WHERE L.DueDate <= CURDATE() + INTERVAL 30 DAY;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO custName, dueDate;
        IF done THEN
            LEAVE read_loop;
        END IF;

        SELECT CONCAT('Reminder: ', custName, ', your loan is due on ', dueDate) AS Reminder;
    END LOOP;

    CLOSE cur;
END$$

DELIMITER ;
CALL SendLoanReminders();
SELECT * FROM Loans;
DROP PROCEDURE IF EXISTS SendLoanReminders;
DELIMITER $$

CREATE PROCEDURE SendLoanReminders()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE custName VARCHAR(100);
    DECLARE dueDate DATE;

    DECLARE cur CURSOR FOR 
        SELECT C.Name, L.DueDate 
        FROM Customers C
        JOIN Loans L ON C.CustomerID = L.CustomerID
        WHERE L.DueDate <= CURDATE() + INTERVAL 30 DAY;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;
    FETCH cur INTO custName, dueDate;

    WHILE NOT done DO
        SELECT CONCAT('Reminder: ', custName, ', your loan is due on ', dueDate) AS Reminder;
        FETCH cur INTO custName, dueDate;
    END WHILE;

    CLOSE cur;
END$$

DELIMITER ;
CALL SendLoanReminders();

