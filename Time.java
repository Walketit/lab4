import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {
    private String hour;
    private String min;
    private String sec;
    private String day;
    private String month;
    private String year;
    private String fullDate;

    public void currentTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("|yyyy-MM-dd HH:mm:ss|");
        fullDate = dateFormat.format(calendar.getTime());

        dateFormat = new SimpleDateFormat("dd");
        day = dateFormat.format(calendar.getTime());

        dateFormat = new SimpleDateFormat("MM");
        month = dateFormat.format(calendar.getTime());

        dateFormat = new SimpleDateFormat("yyyy");
        year = dateFormat.format(calendar.getTime());

        dateFormat = new SimpleDateFormat("HH");
        hour = dateFormat.format(calendar.getTime());

        dateFormat = new SimpleDateFormat("mm");
        min = dateFormat.format(calendar.getTime());

        dateFormat = new SimpleDateFormat("ss");
        sec = dateFormat.format(calendar.getTime());
    }

    public void printCurrentTime() {
        currentTime();
        System.out.printf("Сегодня: %s-%s-%s\n", day, month, year);
        System.out.printf("Время: %s:%s:%s\n\n", hour, min, sec);
    }

    public String getFullDate() {
        currentTime();
        return fullDate;
    }

    public void parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = dateFormat.parse(dateStr);
            fullDate = dateFormat.format(date);

            dateFormat = new SimpleDateFormat("dd");
            day = dateFormat.format(date);

            dateFormat = new SimpleDateFormat("MM");
            month = dateFormat.format(date);

            dateFormat = new SimpleDateFormat("yyyy");
            year = dateFormat.format(date);

            dateFormat = new SimpleDateFormat("HH");
            hour = dateFormat.format(date);

            dateFormat = new SimpleDateFormat("mm");
            min = dateFormat.format(date);

            dateFormat = new SimpleDateFormat("ss");
            sec = dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
