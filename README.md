# Sprint4Batch2Group18

This repository contains a Java-based application developed as part of Sprint 4, Batch 2, Group 18. The project demonstrates object-oriented programming, modular design, and test-driven development.

## Project Overview

The application is designed to manage a simple banking system, supporting functionalities such as account creation, deposit, withdrawal, and transaction history. It follows best practices in Java development, including the use of interfaces, exception handling, and unit testing with JUnit.

## Directory Structure

```
Sprint4Batch2Group18/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── group18/
│   │               ├── Bank.java
│   │               ├── Account.java
│   │               ├── Transaction.java
│   │               └── Main.java
│   └── test/
│       └── java/
│           └── com/
│               └── group18/
│                   ├── BankTest.java
│                   └── AccountTest.java
├── README.md
└── pom.xml
```

## Key Features

- **Account Management:** Create, view, and manage bank accounts.
- **Transactions:** Deposit and withdraw funds, with validation and exception handling.
- **Transaction History:** View a list of all transactions for each account.
- **Unit Testing:** Comprehensive tests using JUnit for core functionalities.
- **Modular Design:** Separation of concerns using classes such as `Bank`, `Account`, and `Transaction`.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven (for build and dependency management)

### Build and Run

1. **Clone the repository:**

   ```sh
   git clone https://github.com/yourusername/Sprint4Batch2Group18.git
   cd Sprint4Batch2Group18
   ```

2. **Build the project:**

   ```sh
   mvn clean install
   ```

3. **Run the application:**
   ```sh
   mvn exec:java -Dexec.mainClass="com.group18.Main"
   ```

### Running Tests

```sh
mvn test
```

## Example Usage

- Create a new account
- Deposit funds
- Withdraw funds
- View transaction history

## Contributing

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/YourFeature`).
3. Commit your changes.
4. Push to your branch.
5. Open a Pull Request.

## License

This project is licensed under the MIT License.

---

\*Update this README as the project evolves or if new features
