import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void testTrueAndFalseSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Assertions.assertTrue(simpleTask.matches("Позвонить"));
        Assertions.assertTrue(simpleTask.matches("родителям"));
        Assertions.assertFalse(simpleTask.matches("позвонить"));
        Assertions.assertFalse(simpleTask.matches("позванить"));
        Assertions.assertFalse(simpleTask.matches("Родителям"));
        Assertions.assertFalse(simpleTask.matches("родитилям"));
    }

    @Test
    public void testTrueAndFalseEpic() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);
        Assertions.assertTrue(epic.matches("Молоко"));
        Assertions.assertFalse(epic.matches("молоко"));
        Assertions.assertFalse(epic.matches("Малоко"));
        Assertions.assertTrue(epic.matches("Яйца"));
        Assertions.assertFalse(epic.matches("яйца"));
        Assertions.assertFalse(epic.matches("Яйцо"));
        Assertions.assertTrue(epic.matches("Хлеб"));
        Assertions.assertFalse(epic.matches("хлеб"));
        Assertions.assertFalse(epic.matches("Хлеп"));
    }

    @Test
    public void testTrueAndFalseMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Assertions.assertTrue(meeting.matches("Выкатка"));
        Assertions.assertFalse(meeting.matches("выкатка"));
        Assertions.assertFalse(meeting.matches("Выкотка"));
        Assertions.assertTrue(meeting.matches("3й"));
        Assertions.assertFalse(meeting.matches("3 й"));
        Assertions.assertFalse(meeting.matches("3Й"));
        Assertions.assertTrue(meeting.matches("приложения"));
        Assertions.assertFalse(meeting.matches("Приложения"));
        Assertions.assertFalse(meeting.matches("приложение"));
        Assertions.assertTrue(meeting.matches("Приложение"));
        Assertions.assertFalse(meeting.matches("прилажение"));
        Assertions.assertTrue(meeting.matches("НетоБанка"));
        Assertions.assertFalse(meeting.matches("нетобанка"));
        Assertions.assertFalse(meeting.matches("НетБанка"));
    }
}
