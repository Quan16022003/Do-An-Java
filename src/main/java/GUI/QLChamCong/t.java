package GUI.QLChamCong;

import java.time.Duration;
import java.time.LocalTime;

public class t {
    public static void main(String[] args) {
        LocalTime time1 = LocalTime.parse("09:00");
        LocalTime time2 = LocalTime.parse("12:30");

        Duration duration = Duration.between(time1, time2);
        System.out.println(duration.toHours() + ":" + duration.toMinutes()%60);

    }
}
