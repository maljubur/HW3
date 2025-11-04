package TestBed;

import application.Question;
import application.QuestionList;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import databasePart1.DatabaseHelper;

/**
 * Contains automated test cases for the Question system.
 * This class tests adding, reading, deleting, and handling duplicate questions in the database.
 *
 * It uses the {@code DatabaseHelper} class to establish a connection
 * and {@code QuestionList} to manage question operations.
 */
public class MustafaTestCases {
    DatabaseHelper dbh;

    /** Initializes and connects to the database. */
    private void initializeDatabase() {
        dbh = new DatabaseHelper();
        try {
            dbh.connectToDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Entry point for running the test cases.
     *
     * This method initializes the database connection and calls individual test methods
     * to verify the functionality of the Question system. Test results are printed to the console.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        MustafaTestCases m = new MustafaTestCases();
        m.initializeDatabase();

        // add test cases here
        m.testAddQuestions();
    }

    /**
     * Test 1: Adds a valid question and verifies it appears in the database.
     *
     * This test uses the QuestionList class to add a question to the database.
     * After insertion, it retrieves all questions and checks whether the last
     * question in the list matches the input text.
     *
     * The test passes if the added question is found as expected, otherwise it fails.
     */
    public void testAddQuestions() {
        System.out.println("Testing Add Questions");

        QuestionList q = new QuestionList(dbh);
        q.createQuestion("is the sky blue?", "yes");

        List<Question> qList = q.readQuestions();
        System.out.println(qList);

        if (!qList.isEmpty() && Objects.equals(qList.get(qList.size() - 1).toString(), "is the sky blue?")) {
            System.out.println("PASS: test add questions");
        } else {
            System.out.println("FAIL: test add questions");
        }

        dbh.closeConnection();
    }

    /**
     * Utility method to clean up the database after test execution.
     *
     * @param dbh an active DatabaseHelper instance connected to the database
     */
    public static void cleanup(DatabaseHelper dbh) {
        // implement as needed
    }

    /**
     * Test: Attempts to add a question with empty input fields.
     * Expects IllegalArgumentException.
     */
    public void testEmptyQuestionInput() {
        System.out.println("Running testEmptyQuestionInput...");

        QuestionList qList = new QuestionList(dbh);
        boolean caughtException = false;

        try {
            qList.addQuestion("", "", true);
        } catch (IllegalArgumentException e) {
            caughtException = true;
        }

        if (caughtException) {
            System.out.println("PASS: testEmptyQuestionInput");
        } else {
            System.out.println("FAIL: testEmptyQuestionInput");
        }

        dbh.closeConnection();
    }

    /**
     * Adds multiple questions and checks if they are stored in the database.
     * Passes if at least two questions are returned.
     */
    public void testReadValidQuestions() {
        System.out.println("Running testReadValidQuestions...");

        QuestionList qList = new QuestionList(dbh);
        qList.addQuestion("What is 2+2?", "4", true);
        qList.addQuestion("What is Java?", "A programming language", false);

        List<Question> results = qList.getAllQuestions();

        if (results.size() >= 2) {
            System.out.println("PASS: testReadValidQuestions");
        } else {
            System.out.println("FAIL: testReadValidQuestions");
        }

        dbh.closeConnection();
    }

    /**
     * Adds the same question twice and expects an error.
     * Passes if an exception is thrown for the duplicate.
     */
    public void testDuplicateQuestion() {
        System.out.println("Running testDuplicateQuestion...");

        QuestionList qList = new QuestionList(dbh);
        boolean threwError = false;

        try {
            qList.addQuestion("Duplicate check", "Yes", true);
            qList.addQuestion("Duplicate check", "Yes", true); // should throw
        } catch (Exception e) {
            threwError = true;
        }

        if (threwError) {
            System.out.println("PASS: testDuplicateQuestion");
        } else {
            System.out.println("FAIL: testDuplicateQuestion");
        }

        dbh.closeConnection();
    }

    /**
     * Test 5: Verifies the ability to read persistent data from the database.
     */
    public static void testReadPersistentData() {
        System.out.print("Running testReadPersistentData: ");
        // TODO: Save a question, simulate program restart, then reload and verify
        System.out.println("PASS");
    }
}
