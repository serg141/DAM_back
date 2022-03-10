package DAM.Parametrs;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

public class GetDate {
    final Long currentDate, plusOneDay, plusOneMonth, plusOneYear, minusOneMonth;

    public GetDate() {
        LocalDate localDate = LocalDate.now();
        Instant instant = localDate.atTime(LocalTime.MIDNIGHT).atZone(ZoneId.systemDefault()).toInstant();
        this.currentDate = instant.toEpochMilli();
        plusOneDay = currentDate + 86400000L;
        plusOneMonth = currentDate + 2629743000L;
        plusOneYear = currentDate + 3155692000L;

        minusOneMonth = currentDate - 2629743000L;
    }

    public Long getCurrentDate() {
        return currentDate;
    }

    public Long getPlusOneDay() {
        return plusOneDay;
    }

    public Long getPlusOneMonth() {
        return plusOneMonth;
    }

    public Long getPlusOneYear() {
        return plusOneYear;
    }

    public Long getMinusOneMonth() {
        return minusOneMonth;
    }
}
