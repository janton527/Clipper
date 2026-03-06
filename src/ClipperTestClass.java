import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClipperTestClass {

    @Test
    public void Day31MonthDeadlineTest() {
        Date dl1 = new Date(1,1, 2026);
        Date dl2 = new Date(1, 29, 2026);

        assertEquals("5 January", dl1.getDeadline());
        assertEquals("2 February", dl2.getDeadline());
    }

    @Test
    public void Day30MonthDeadlineTest() {
        Date dl1 = new Date(4, 1, 2026);
        Date dl2 = new Date(4, 29, 2026);

        assertEquals("5 April", dl1.getDeadline());
        assertEquals("3 May", dl2.getDeadline());
    }

    @Test
    public void FebruaryNoLeapYearDeadlineTest() {
        Date dl1 = new Date(2, 1, 2026);    // Non-Leap Year, no roll-over
        Date dl2 = new Date(2, 27, 2026);   // Non-Leap year, roll-over

        assertEquals("5 February", dl1.getDeadline());
        assertEquals("3 March", dl2.getDeadline());
    }

    @Test
    public void FebruaryLeapYearDeadlineTest() {
        Date dl1 = new Date(2, 1, 2024);    // Leap Year, no roll-over
        Date dl2 = new Date(2, 27, 2024);   // Leap year, roll-over

        assertEquals("5 February", dl1.getDeadline());
        assertEquals("2 March", dl2.getDeadline());
    }

    @Test
    public void NewYearDeadlineTest() {
        Date dl1 = new Date(12, 31, 2025);

        assertEquals("4 January", dl1.getDeadline());
    }
}
