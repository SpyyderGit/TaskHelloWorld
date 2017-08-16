import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;


public class HelloTest {

    private static final Logger log = Logger.getLogger(HelloWorld.class);

    private HelloWorld hello;
    private Calendar calendar = Calendar.getInstance();
    private int h;
    private int m;
    private int s;
    private String night = "Good Night, World! ";
    private String morning = "Good Morning, World! ";
    private String day = "Good Day, World! ";
    private String everning = "Good Evening, World! ";

    @Before
    public void init() {
        Locale locale = Locale.getDefault();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("en", locale);
        hello = new HelloWorld(resourceBundle);
        h = calendar.get(calendar.HOUR_OF_DAY);
        m = calendar.get(calendar.MINUTE);
        s = calendar.get(calendar.SECOND);
    }

    //=================== Testing time ======================
    @Test
    public void testHour() {
        int expected = h;
        int actual = hello.getH();
        assertEquals(expected, actual);

        if (actual == expected) {
            log.info("testHour test OK ");
        } else {
            log.error("testHour test error");
        }
    }

    @Test
    public void testMinutes() {
        int expected = m;
        int actual = hello.getM();
        assertEquals(expected, actual);
        if (actual == expected) {
            log.info("testMinutes test OK ");
        } else {
            log.error("testMinutes test error");
        }

    }

    @Test
    public void testSec() {
        int expected = s;
        int actual = hello.getS();
        assertEquals(expected, actual);

        if (actual == expected) {
            log.info("testSec test OK ");
        } else {
            log.error("testSec test error");
        }
    }

    @Test
    public void testTimeFormat() {
        String expected = h + ":" + m;
        String actual = hello.getH() + ":" + hello.getM();
        assertEquals(expected, actual);

        if (actual.equals(expected)) {
            log.info("test testTimeFormat OK ");
        } else {
            log.error("test testTimeFormat error");
        }
    }

    //=================== Testing good night =========================================
    @Test
    public void testBeforeMidnight() {
        hello.setH(23);
        String expected = night + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);

        if (actual.equals(expected)) {
            log.info("test testBeforeMidnight OK ");
        } else {
            log.error("test testBeforeMidnight error");
        }

    }


    @Test
    public void testMidnight() {
        hello.setH(0);
        String expected = night + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);

        if (actual.equals(expected)) {
            log.info("test testMidnight OK ");
        } else {
            log.error("test testMidnight error");
        }
    }


    @Test
    public void testAfterMidnight() {
        hello.setH(1);
        String expected = night + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);
        if (actual.equals(expected)) {
            log.info("test testAfterMidnight OK ");
        } else {
            log.error("test testAfterMidnight error");
        }

    }


    @Test
    public void testAfterEverning() {
        hello.setH(23);
        hello.setM(01);
        hello.setS(01);
        String expected = night + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);

        if (actual.equals(expected)) {
            log.info("test testAfterEverning OK ");
        } else {
            log.error("test testAfterEverning error");
        }
    }


    @Test
    public void testBeforeMorning() {
        hello.setH(5);
        hello.setM(59);
        hello.setS(59);
        String expected = night + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);

        if (actual.equals(expected)) {
            log.info("test testBeforeMorning OK ");
        } else {
            log.error("test testBeforeMorning error");
        }

    }

    //=================== Testing good morning =========================================

    @Test
    public void testMorning() {
        hello.setH(6);
        String expected = morning + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);

        if (actual.equals(expected)) {
            log.info("test testMorning OK ");
        } else {
            log.error("test testMorning error");
        }
    }


    @Test
    public void testMiddleMorning() {
        hello.setH(8);
        String expected = morning + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);

        if (actual.equals(expected)) {
            log.info("test testMiddleMorning OK ");
        } else {
            log.error("test testMiddleMorning error");
        }
    }


    @Test
    public void testAfterNight() {
        hello.setH(6);
        hello.setM(1);
        hello.setS(1);
        String expected = morning + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);

        if (actual.equals(expected)) {
            log.info("test testAfterNight OK ");
        } else {
            log.error("test testAfterNight error");
        }
    }

    @Test
    public void testBeforeDay() {
        hello.setH(8);
        hello.setM(59);
        hello.setS(59);
        String expected = morning + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);

        if (actual.equals(expected)) {
            log.info("test testBeforeDay OK ");
        } else {
            log.error("test testBeforeDay error");
        }
    }

    //=================== Testing good day =========================================
    @Test
    public void testDay() {
        hello.setH(9);
        String expected = day + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);


        if (actual.equals(expected)) {
            log.info("test testDay OK ");
        } else {
            log.error("test testDay error");
        }
    }


    @Test
    public void testMiddleDay() {
        hello.setH(12);
        String expected = day + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);

        if (actual.equals(expected)) {
            log.info("test testMiddleDay OK ");
        } else {
            log.error("test testMiddleDay error");
        }
    }


    @Test
    public void testEndOfDay() {
        hello.setH(12);
        String expected = day + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);

        if (actual.equals(expected)) {
            log.info("test testEndOfDay OK ");
        } else {
            log.error("test testEndOfDay error");
        }
    }

    @Test
    public void testAfterMorning() {
        hello.setH(9);
        hello.setM(1);
        hello.setS(1);
        String expected = day + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);
        if (actual.equals(expected)) {
            log.info("test testAfterMorning OK ");
        } else {
            log.error("test testAfterMorning error");
        }

    }

    @Test
    public void testBeforeEvetning() {
        hello.setH(18);
        hello.setM(59);
        hello.setS(59);
        String expected = day + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);
        if (actual.equals(expected)) {
            log.info("test testBeforeEvetning OK ");
        } else {
            log.error("test testBeforeEvetning error");
        }

    }


    //=================== Testing good everning =========================================
    @Test
    public void testEverning() {
        hello.setH(19);
        String expected = everning + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);
        if (actual.equals(expected)) {
            log.info("test testEverning OK ");
        } else {
            log.error("test testEverning error");
        }

    }


    @Test
    public void testMiddleEverning() {
        hello.setH(21);
        String expected = everning + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);

        if (actual.equals(expected)) {
            log.info("test testMiddleEverning OK ");
        } else {
            log.error("test testMiddleEverning error");
        }
    }


    @Test
    public void testEndOfEverning() {
        hello.setH(22);
        String expected = everning + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);

        if (actual.equals(expected)) {
            log.info("test testEndOfEverning OK ");
        } else {
            log.error("test testEndOfEverning error");
        }
    }

    @Test
    public void testAfterDay() {
        hello.setH(19);
        hello.setM(1);
        hello.setS(1);
        String expected = everning + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);
        if (actual.equals(expected)) {
            log.info("test testAfterDay OK ");
        } else {
            log.error("test testAfterDay error");
        }
    }

    @Test
    public void testBeforeNight() {
        hello.setH(22);
        hello.setM(59);
        hello.setS(59);
        String expected = everning + hello.getH() + ":" + hello.getM();
        String actual = hello.getTimeOfDay();
        assertEquals(expected, actual);

        if (actual.equals(expected)) {
            log.info("test testBeforeNight OK ");
        } else {
            log.error("test testBeforeNight error");
        }
    }
}