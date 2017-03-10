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


    public Report() {
        diningHall = "";
        vendor = "";
        lineTime = 25;
        prepTime = 25;
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

    @Override
    public String toString() {
        // {"ABP at GLC", "", "Tuesday", 23, 13, 51, 33, 13}
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.US);
        String dayOfWeek = sdf.format(Calendar.DAY_OF_WEEK);
        String hour = String.format("%s", Calendar.HOUR_OF_DAY);
        String minute = String.format("%s", Calendar.MINUTE);
        String second = String.format("%s", Calendar.SECOND);
        return "{\"" + diningHall + "\", \"" + vendor + "\", \"" + dayOfWeek + "\", " + hour +
                ", " + second + ", " + String.format("%s", lineTime) + ", " +
                String.format("%s", prepTime) + "}";
    }

}
