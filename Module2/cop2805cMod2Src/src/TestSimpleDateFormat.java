import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestSimpleDateFormat {
    public static void main(String[] args) {
        final SimpleDateFormat DATEFORMATTER = new SimpleDateFormat("MM/dd/yyyy");
        try {
            Date newDate = DATEFORMATTER.parse("1/1/2016");
            System.out.println(DATEFORMATTER.format(newDate));

            newDate = new GregorianCalendar(2016, 1, 1).getTime();
            System.out.println(newDate);
        } catch (ParseException pe) {
            System.err.println("Exception!" + pe);
        }
    }
}
