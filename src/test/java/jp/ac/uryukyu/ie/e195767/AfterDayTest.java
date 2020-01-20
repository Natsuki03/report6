package jp.ac.uryukyu.ie.e195767;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AfterDayTest {

    @Test
    void calDay() {
        SimpleDateFormat d = new SimpleDateFormat("yyyy年MM月dd日");//日付のフォーマット。2020年01月01日のように表示される。
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