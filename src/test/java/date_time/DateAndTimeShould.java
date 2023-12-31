package date_time;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.time.Duration.between;
import static java.time.ZonedDateTime.now;
import static java.time.format.DateTimeFormatter.ofPattern;
import static org.assertj.core.api.Assertions.assertThat;

public class DateAndTimeShould {
//    Thread safety

    @Test
    void get_current_time() {
//           Before Java 8:
        final Date date = new Date();
        System.out.println(date);

//         From java 8:
//        LocalDateTime
//        DateTimeFormatter
        final LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatterBis = ofPattern("HH:mm:ss dd:MM:yyyy");
        String humanFormattedTime = now.format(formatterBis);
        System.out.println(humanFormattedTime);

//        ZonedDateTime
        final ZoneId australiaBrisbaneZone = ZoneId.of("Australia/Brisbane");
        final ZonedDateTime nowInBrisbane = now(australiaBrisbaneZone);
        // Define a custom date and time format
        DateTimeFormatter formatter = ofPattern("HH:mm:ss dd:MM:yyyy (z)");
        // Format the ZonedDateTime using the specified formatter
        String formattedTime = nowInBrisbane.format(formatter);

        System.out.println(formattedTime);
    }

    @Test
    void get_5_hours_earlier() {
        //           Before Java 8:
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.HOUR, -5);
        final Date time = calendar.getTime();
        System.out.println(time);

        //         From java 8:
        final LocalTime now = LocalTime.now();
        final LocalTime nowMinus5Hours = now.minusHours(5);
        System.out.println(nowMinus5Hours);
    }

    @Test
    void should_compare_dates() {
        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime nowPlusFiveDays = now.plusDays(5);

        assertThat(now.isBefore(nowPlusFiveDays)).isTrue();
        assertThat(nowPlusFiveDays.isAfter(now)).isTrue();
        assertThat(now.isEqual(nowPlusFiveDays)).isFalse();

        final Duration duration = between(now, nowPlusFiveDays);

        assertThat(duration).isEqualTo(Duration.ofDays(5));

        final LocalDate nowByLocalDate = LocalDate.now();
        final LocalDate nowByLocalDatePlusFive = nowByLocalDate.plusDays(5);
        final Period period = Period.between(nowByLocalDate, nowByLocalDatePlusFive);

        assertThat(period.getDays()).isEqualTo(5);
    }
}
