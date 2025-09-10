package ui;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

import task.*;

/**
 * JUnit tests for the ui.Ui class.
 * Tests the behavior of methods that format and display task information.
 * ensuring the correct output is printed to System.out.
 */
class UiTest {

    private Ui ui;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
     * Sets up a new Ui instance and redirects System.out to capture printed output
     * before each test.
     */
    @BeforeEach
    void setUp() {
        ui = new Ui();
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Restores the original System.out after each test.
     */
    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    /**
     * Tests that showTaskAdded prints the correct message when a task is added.
     */
    @Test
    void testShowTaskAdded() {
        Task t = new Todo("Test todo", TaskType.TODO);
        ui.showTaskAdded(t, 1);

        String output = outContent.toString();
        assertTrue(output.contains("Got it. I've added this task:"), "Should contain add message");
        assertTrue(output.contains("Test todo"), "Should contain task description");
        assertTrue(output.contains("Now you have 1 tasks in the list."), "Should contain task count");
    }

    /**
     * Tests that showList prints the correct task list with numbering.
     */
    @Test
    void testShowList() {
        TaskList tasks = new TaskList();
        tasks.add(new Todo("First task", TaskType.TODO));
        tasks.add(new Deadline("Second task", TaskType.DEADLINE, "2025-08-30"));

        ui.showList(tasks);

        String output = outContent.toString();
        assertTrue(output.contains("Here are the tasks in your list:"), "Should contain list header");
        assertTrue(output.contains("1.[T][ ] First task"), "Should contain first task with index 1");
        assertTrue(output.contains("2.[D][ ] Second task"), "Should contain second task with index 2");
    }
}
