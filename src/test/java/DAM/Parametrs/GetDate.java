package DAM.Parametrs;

public class GetDate {
    final Long currentDate, plusOneDay, plusOneMonth, plusOneYear;

    public GetDate() {
        this.currentDate = System.currentTimeMillis();
        plusOneDay = currentDate + 86400000L;
        plusOneMonth = currentDate + 2629743000L;
        plusOneYear = currentDate + 3155692000L;
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
}
