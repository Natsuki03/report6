package jp.ac.uryukyu.ie.e195767;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AfterDayTest {

    /**
     *今日(2020年01月20日)の1日後を求めるテスト。
     * テストする日によって、assartEqualsのexpectedのところを変更しないといけないのが難点。
     */
    @Test
    void calDay() {
        SimpleDateFormat d = new SimpleDateFormat("yyyy年MM月dd日");
        Date Today = new Date();
        int addDay = 1;
        Calendar cal = Calendar.getInstance();
        cal.setTime(Today);
        cal.add(Calendar.DATE,addDay);
        Date d1 = cal.getTime();
        String d2 = d.format(d1);
        assertEquals("2020年01月21日",d2);
    }
}