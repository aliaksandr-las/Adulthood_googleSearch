package task1.date;

import lombok.SneakyThrows;

import java.time.LocalDate;
import java.util.function.Predicate;


public class Adulthood implements Predicate<String> {
    public boolean isAdult(String date) throws BirthdateFormatException{
        if(date == null) {
            return false;
        } else if (!isDateFormatCorrect(date)) {
            throw new BirthdateFormatException(date);
        }

        return test(date);
    }

    @Override
    @SneakyThrows
    public boolean test(String date){
        LocalDate now = LocalDate.now();
        LocalDate datePlusEighteen = LocalDate.parse(date).plusYears(18);

        return (now.isAfter(datePlusEighteen) || now.equals(datePlusEighteen));
    }

    private boolean isDateFormatCorrect(String date){
        String regEx = "\\d{4}-\\d{2}-\\d{2}";
        return date.matches(regEx);
    }
}
