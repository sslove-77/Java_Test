/** 时间日期 Date，Calendar，DateFormat
 * DateFormat是抽象类，具体子类为SimpleDateFormat
 * 构造方法：SimpleDateFormat sdf = new SimpleDateFormat()/
                                 new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    * String format(time):将时间以指定字符串形式输出
    * Date parse(String dateStr) ：解析字符串时间

 Calendar无构造方法：
 * static Calendar	getInstance()：使用默认时区和区域设置获取日历。
 * static Calendar	getInstance(TimeZone zone, Locale aLocale)
    获取具有指定时区和区域设置的日历。
 * Date	getTime()：返回一个 Date表示此物体 Calendar的时间值
 * void	set(int field, int value)：将给定的日历字段设置为给定的值。
 * void	set(int year, int month, int date)
    设置日历字段中的值 YEAR ， MONTH和 DAY_OF_MONTH 。
 * void	setFirstDayOfWeek(int value)：设置一周的第一天是什么？
* */
package com.nuist.BasicTest;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class TimeTest {
    public static void main(String[] args) throws ParseException {
//        创建时间对象
        Date date = new Date(100000);  // 时间起点1970/01/01 00:00:00
        System.out.println(date);   // CST时间格式

//        创建时间格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//          以指定的日期格式输出
        String time = sdf.format(date);
        System.out.println(time);

//        将字符串解析为时间
        String timeStr = "2022-07-14 12:35:29";
        Date date1 = sdf.parse(timeStr);
        System.out.println(date1);

//        创建calendar对象
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022,4,24);  // 月份从0开始
        System.out.println(calendar.getTime());  // 返回时间

        calendar.setFirstDayOfWeek(0);  // 设置周一为一周的第一天
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

//        20月后的日期
        calendar.add(Calendar.MONTH,20);
        System.out.println(calendar.getTime());
    }

    @Test
    public void dateTest() {
//        Date类的使用
        Date date = new Date();    // 不加参数，默认当前时间
        System.out.println(date);
//        获取时间戳
        long time = date.getTime();
        System.out.println(time);

    }

    @Test
    public void simpleDateFormatTest() throws ParseException {

//        以指定日期格式显示
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println(simpleDateFormat.format(date));

//        解析字符串时间
        String str = "2020-05-01 18:23:45";
        Date parse = simpleDateFormat.parse(str);
        System.out.println(parse);
    }

    @Test
    public void calendarTest() {
//        Calendar类是抽象类，创建实例方法如下
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 7, 7, 10, 30, 30);
//        转换成Date
        Date time = calendar.getTime();
        System.out.println(time);

//      获取指定日期的年月日，周几
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        calendar.setFirstDayOfWeek(0);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
    }

    @Test
    public void instantTest() {
        Instant now = Instant.now();
        System.out.println(now);

        Instant parse = Instant.parse("2007-12-03T10:15:30.00Z");
        System.out.println(parse);
    }

    @Test
    public void localDateTest() {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
    }
}
