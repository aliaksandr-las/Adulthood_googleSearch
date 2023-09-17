package task1.date;

public class BirthdateFormatException extends Exception {
    public BirthdateFormatException(String date) {
        super("Birthdate Format Exception: " + date + "; Next format is need: 2000-08-12");
    }
}
