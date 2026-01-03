
# ATM Simulator Project

## Description
A Java Swing-based ATM Simulator that allows users to log in securely, check balances, deposit, withdraw, and view transaction history. 
Built with JDBC and MySQL for database integration.

## Features
- Secure login using account number and PIN
- Balance inquiry
- Cash deposit and withdrawal
- Transaction history tracking
- Input validation and error handling

## Requirements
- Java 17+
- Eclipse IDE (or IntelliJ)
- MySQL database

## Setup
1. Clone the repository.
2. Import into Eclipse IDE.
3. Configure database connection in Conn.java:
   - Update JDBC URL, username, and password.
4. Create database tables:
   - `accounts (id, account_number, pin, balance)`
   - `transactions (id, account_number, type, amount, timestamp)`
5. Run `Login.java` to start the application.

## Usage
- Enter account number and PIN to log in.
- Choose from options: Balance Inquiry, Deposit, Withdraw, Transaction History.
- Log out securely after use.

