# HW3 – Automated Testing and Javadoc Documentation

This repository contains my individual submission for Homework 3. The purpose is to practice automated testing, use Javadoc for internal documentation, and prepare for later JUnit work by building a standalone Java test application.

## Assignment requirements

- Run the automated tests divided among the team
- Apply professional Javadoc-style documentation
- Build a standalone test app named `HW3`
- Generate and include Javadoc output
- Record a screencast explaining the tests and their results

## My Test Cases

Working from our TP2 submission, I implemented the following five cases:

- **Add a Valid Question**  
  Insert a new question and verify it is stored in the database.

- **Create Empty Question Input**  
  Attempt to add a question with empty fields and expect an exception.

- **Read Valid List of Questions**  
  Add multiple questions and confirm they can all be retrieved.

- **Create Duplicate Question**  
  Insert the same question twice and confirm the second insert fails with an error.

- **Read Persistent Data from Database**  
  Add a question, simulate an application restart, and verify the question still exists.

## Testing info

- Implemented a standalone Java application (`HW3`) with test logic in `main()`
- Followed a structure similar to the earlier PasswordEvaluationTestbed from HW1
- Console output reports a clear **PASS** or **FAIL** for each case
- JUnit not used in this submission (optional)

## Javadoc inspiration

- Wrote Javadoc comments for each test method and the main test class
- Documentation style and organization aligned with standard Java library docs

### Javadoc Output info
- Reference style: standard Java Collections Framework documentation approach

## Screencast outlook

- Recorded a short walkthrough covering:
  - The five automated tests and how each operates
  - How the Javadoc was structured and generated
  - The resulting test outputs

## Access to Repository Link

- Link to HW3: https://github.com/maljubur/HW3
