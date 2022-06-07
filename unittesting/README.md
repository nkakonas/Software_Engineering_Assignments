# Unittesting

## Contents

1. [Description of the project](#1-description-of-the-project)
2. [Requirements](#2-requirements)
3. [How to run the project](#3-how-to-run-the-tests)

## 1. Description of the project

- This project is a module maven project.
- In this project there are two main packages (gr.aueb.dmst.nkakonas.io and gr.aueb.dmst.nkakonas.math) in which there are some java classes.
    - io:
        - FileIo.java
    - math:
        - ArithmeticOperations.java
        - ArrayOperations.java
        - MyMath.java
- The purpose of these classes is to prctice in unit testing
- All the tests are inside the corresponding packages of the tests
    - io:
        - FileIoTest.java
    - math:
        - ArithmeticOperationsTest.java
        - ArrayOperationsTest.java
        - MyMathParameterizedTest.java
        - MyMathTest.java
        - MyMathTestSuite.java
- Inside the folder test/resources there are the following files which are used in order to run some test cases:
    - invalidEntries.txt
    - noNumbers.txt
    - numbers.txt
    - primeNumbers.txt

## 2. Requirements
- maven
- java

## 3. How to run the tests
- Clone the repository into your computer
- Inside the folder unittesting type:
```bash
$ mvn test
```

