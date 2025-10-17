# String Calculator TDD Kata

A Java implementation of the String Calculator kata following Test-Driven Development (TDD) principles.

## Overview

This project demonstrates TDD practices by implementing a string calculator that can parse and sum numbers from a string input with support for custom delimiters, multiple delimiters, and various input formats.

## Features

- ✅ Sum numbers separated by commas or newlines
- ✅ Support for custom single-character delimiters
- ✅ Support for custom delimiters of any length
- ✅ Support for multiple custom delimiters
- ✅ Negative number detection with detailed error messages
- ✅ Ignore numbers greater than 1000
- ✅ Comprehensive test coverage

## Requirements

- Java 8 or higher
- Maven 3.6+

## Getting Started

### Clone the repository

```bash

git clone https://github.com/AJAY007L/string-calculator-tdd.git
cd string-calculator-tdd
```

### Build the project

```bash

mvn clean install
```

### Run tests

```bash

mvn test
```

## Usage Examples

```java
// Basic usage
StringCalculator.add("");           // returns 0
StringCalculator.add("1");          // returns 1
StringCalculator.add("1,2");        // returns 3

// Multiple numbers
StringCalculator.add("1,2,3,4,5");  // returns 15

// Newline delimiter
StringCalculator.add("1\n2,3");     // returns 6

// Custom delimiter
StringCalculator.add("//;\n1;2");   // returns 3

// Custom delimiter with any length
StringCalculator.add("//[***]\n1***2***3");  // returns 6

// Multiple delimiters
StringCalculator.add("//[*][%]\n1*2%3");     // returns 6

// Ignore numbers > 1000
StringCalculator.add("2,1001");     // returns 2

// Negative numbers throw exception
StringCalculator.add("1,-2,3");     // throws IllegalArgumentException: "Negative not allowed: -2"
```

## TDD Approach

This project was developed using the Red-Green-Refactor cycle:

1. **Red** - Write a failing test
2. **Green** - Write minimal code to make the test pass
3. **Refactor** - Improve code while keeping tests green

Each feature was implemented incrementally with corresponding tests written first.

## Project Structure

```
string-calculator-tdd/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── incubyte/
│   │               └── StringCalculator.java
│   └── test/
│       └── java/
│           └── com/
│               └── incubyte/
│                   └── StringCalculatorTest.java
├── pom.xml
├── .gitignore
└── README.md
```

## Key Implementation Details

### Delimiter Parsing
- Handles default delimiters (`,` and `\n`)
- Parses custom delimiters from `//[delimiter]\n` format
- Supports multiple delimiters with `//[delim1][delim2]\n` format

### Number Processing
- Filters out numbers greater than 1000
- Detects all negative numbers and reports them in exceptions
- Uses Java Streams for efficient processing

## Testing

The project includes comprehensive unit tests covering:
- Empty string input
- Single and multiple numbers
- Various delimiter configurations
- Negative number validation
- Number filtering (> 1000)
- Edge cases

Run tests with coverage:
```bash

mvn test jacoco:report
```

## Commit History

This project follows conventional commit messages with a clear TDD workflow:
- `red:` - Adding failing tests
- `green:` - Implementing features to pass tests
- `refactor:` - Code improvements without changing behavior
- `chore:` - Project configuration and setup

## References

- [Original TDD Kata by Roy Osherove](https://osherove.com/tdd-kata-1/)
- [Test-Driven Development principles](https://en.wikipedia.org/wiki/Test-driven_development)

## Author

Developed as part of the Incubyte TDD assessment.

## License

This project is created for educational purposes.