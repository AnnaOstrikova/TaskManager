import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void shouldMatchesSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Boolean actual = simpleTask.matches("Позвонить");
        Boolean expected = true;
        System.out.println();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldNoMatchesSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Boolean actual = simpleTask.matches("маме");
        Boolean expected = false;
        System.out.println();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldMatchesEpic() {
        String[] subtasks = {
                "Убрать",
                "Позвонить",
                "Приготовить",
                "Увезти"
        };

        Epic epic = new Epic(55, subtasks);
        Boolean actual = epic.matches("Позвонить");
        Boolean expected = true;
        System.out.println();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldNoMatchesEpic() {
        String[] subtasks = {
                "Убрать",
                "Позвонить",
                "Приготовить",
                "Увезти"
        };

        Epic epic = new Epic(55, subtasks);
        Boolean actual = epic.matches("Сходить");
        Boolean expected = false;
        System.out.println();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldMatchesMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Boolean actual = meeting.matches("НетоБанк");
        Boolean expected = true;
        System.out.println();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeetingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Boolean actual = meeting.matches("приложен");
        Boolean expected = true;
        System.out.println();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldNoMatchesMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Boolean actual = meeting.matches("Проверка");
        Boolean expected = false;
        System.out.println();
        Assertions.assertEquals(expected,actual);
    }
}
