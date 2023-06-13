/** LocalDate, LocalDateTime, LocalTime, Instance
* */
package com.nuist.Date;

//  单元测试
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeTest {
    @Test
    public void localDate() {
//        指定日期
        LocalDate date = LocalDate.of(2022, 7, 18);
//        指定时间
        LocalTime time = LocalTime.of(14, 30, 24);
//        指定时间日期
        LocalDateTime dateTime = LocalDateTime.of(2022, 7, 18,
                14, 24, 30);
//    打印时间日期
        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);
        System.out.println();

//        now的用法
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println();
    }

    @Test
    public void localDateTime() {
//        当前时间
        LocalDateTime now = LocalDateTime.now();

        //      getXXX()用法，获取指定参数
        int dayOfMonth = now.getDayOfMonth();  // 获取某天
        System.out.println(dayOfMonth);
        DayOfWeek dayOfWeek = now.getDayOfWeek();  // 获取周几
        System.out.println(dayOfWeek);
        System.out.println();

//        withXXX()用法，修改指定参数
        LocalDateTime hour = now.withHour(10);  // 修改小时
        System.out.println(hour);
        LocalDateTime day = now.withDayOfMonth(20);  // 修改天数
        System.out.println(day);
        System.out.println();

//        加上或减去指定时间plus,minus
        LocalDateTime newTime = now.plusHours(2);
        System.out.println(newTime);
        LocalDateTime newDay = now.minusDays(3);
        System.out.println(newDay);
    }

    @Test
    public void timeFormat() {
        LocalDateTime now = LocalDateTime.now();
        //        格式化时间  String	format(DateTimeFormatter formatter)
//          使用指定的格式化程序格式化此日期时间。
//        static DateTimeFormatter	ofPattern(String pattern)
//              使用指定的模式创建格式化程序。
        String dateFormat = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(dateFormat);

//        static LocalDateTime	parse(CharSequence text)
//        从一个文本字符串（如 2007-12-03T10:15:30获取一个 LocalDateTime的实例。
        LocalDateTime parseTime = LocalDateTime.parse("2022-07-18 14:30:21",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(parseTime);

//        static LocalDateTime	parse(CharSequence text, DateTimeFormatter formatter)
//        使用特定的格式化 LocalDateTime从文本字符串获取 LocalDateTime的实例
    }
}
