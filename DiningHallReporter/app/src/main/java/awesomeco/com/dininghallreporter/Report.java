package awesomeco.com.dininghallreporter;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Adam Zelenka on 1/2/2017.
 */
public class Report {

    private String diningHall;
    private String vendor;
    private int lineTime;
    private int prepTime;
    private Calendar reportTime;

    public Report(String hall, String vend, int line, int prep) {
        diningHall = hall;
        vendor = vend;
        lineTime = line;
        prepTime = prep;
        reportTime = Calendar.getInstance();
    }

    public Report() {
        diningHall = "";
        vendor = "";
        lineTime = 25;
        prepTime = 25;
        reportTime = Calendar.getInstance();
    }

    public String getDiningHall() {
        return diningHall;
    }

    public String getVendor() {
        return vendor;
    }

    public int getLineTime() {
        return lineTime;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public Calendar getReportTime() {
        return reportTime;
    }

    public void setDiningHall(String hall) {
        diningHall = hall;
    }

    public void setVendor(String vend) {
        vendor = vend;
    }

    public void setLineTime(int time) {
        lineTime = time;
    }

    public void setPrepTime(int time) {
        prepTime = time;
    }

    public void setReportTime(Calendar date) {
        reportTime = date;
    }

    @Override
    public String toString() {
        // {"ABP at GLC", "", "Tuesday", 23, 13, 51, 33, 13}
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.US);
        String dayOfWeek = sdf.format(reportTime.getTime());
        String hour = Integer.toString(reportTime.HOUR_OF_DAY);
        String minute = Integer.toString(reportTime.MINUTE);
        String second = Integer.toString(reportTime.SECOND);
        return "{\"" + diningHall + "\", \"" + vendor + "\", \"" + dayOfWeek + "\", " + hour +
                ", " + second + ", " + Integer.toString(lineTime) + ", " +
                Integer.toString(prepTime) + "}";
    }

}