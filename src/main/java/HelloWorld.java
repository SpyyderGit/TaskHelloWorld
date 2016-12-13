import org.apache.logging.log4j.LogManager;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * Created by Jerald_PC on 12.12.2016.
 * 6-9 утро
 * 9-19 день
 * 19-23 вечер
 * 23-6 ночь *
 */
public class HelloWorld {

    private Calendar c = Calendar.getInstance();

//    static  Logger log = (Logger) LogManager.getLogger(HelloWorld.class);

    private int h = c.get(c.HOUR_OF_DAY);
    private int m = c.get(c.MINUTE);
    private int s = c.get(c.SECOND);

    public int getH() {
        return h;
    }

    public int getM() {
        return m;
    }

    public int getS() {
        return s;
    }


    public void setH(int h) {
        this.h = h;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setS(int s) {
        this.s = s;
    }


    public String getTimeOfDay() {
        String hm = null;

        if (h >= 6 && h < 9) {
            hm = "Good Morning, World!";
        } else if (h >= 9 && h < 19) {
            hm = "Good Day, World!";
        } else if (h >= 19 && h < 23) {
            hm = "Good Evening, World!";
        } else if (h >= 23 || h < 6) {
            hm = "Good Night, World!";
        }
        return (hm + " " + h + ":" + m);
    }

    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();


        //        Locale locale = Locale.getDefault();
//      ResourceBundle myResources = ResourceBundle.getBundle("log.properties");
//        log.info(hw.getTimeOfDay());

        if (Locale.getDefault().getDisplayLanguage().equals("русский")) {
            System.out.print("Я говорю по-русски!\n");
            Locale.setDefault(Locale.ENGLISH);
        }

        if (Locale.getDefault().getDisplayLanguage().equals("Deutsch"))
            System.out.print("Ich spreche Deutsch!\n");



    }
}