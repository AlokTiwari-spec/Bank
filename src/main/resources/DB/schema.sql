-- Create the database if it does not exist
CREATE DATABASE IF NOT EXISTS bank_management;

-- Use the bank_management database
USE bank_management;

-- Create the customer table if it does not exist
CREATE TABLE IF NOT EXISTS customer (
    customerid INT AUTO_INCREMENT PRIMARY KEY,
    customername VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    state VARCHAR(50),
    country VARCHAR(50),
    email VARCHAR(100),
    contact VARCHAR(15),
    date_of_birth DATE,
    account_type VARCHAR(50)
);