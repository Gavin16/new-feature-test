package datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * @Title: new-feature-test
 * @Package datetime
 * @Description:
 * @author: 80002748
 * @date 2018/8/18 12:25
 */
public class TestDatetime {

    public static void main(String[] args) {

//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        String dateStr = sdf.format(date);
//        System.out.println(dateStr);

        Instant instant = Instant.now();
        // nano second
        System.out.println(instant.getNano());

        // Date
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        DateTimeFormatter dtFormater = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        System.out.println(localDate.format(dtFormater)); // 2018年08月18日

        /** LocalDate 包含 年，月，日及星期信息 */
        System.out.println(localDate.getDayOfWeek()); // SATURDAY
        System.out.println(localDate.getDayOfWeek().getValue()); // 6
        

        /** LocalDateTime, DateTime = Date + Time */
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getDayOfYear()); // 230; 当前年的第多少天
        System.out.println(localDateTime.toLocalDate());  // 2018-08-18; 截取日期
        System.out.println(localDateTime);

        /** LocalTime 相当于 LocalDateTime 比 LocalDate 多出的那一部分； 代码略*/
        "fhsid".startsWith("z");
    }
}

