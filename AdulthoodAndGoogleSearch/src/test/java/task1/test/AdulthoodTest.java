package task1.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import task1.date.Adulthood;
import task1.date.BirthdateFormatException;

import java.time.LocalDate;

public class AdulthoodTest {
    @DataProvider(name = "data_provider")
    public Object[][] dpMethod() {
        return new Object[][]{
                {1, "1973-07-07"},
                {2, "2002-07-07"},
                {3, "2004-07-07"},
                {4, "2005-09-17"},
                {5, LocalDate.now().minusYears(18).toString()}, // true: today is 18
                {6, "2006-07-07"},                 // false: NO adulthood
                {7, null},                         // false: NO adulthood
                {8, "1996--01--01"},               // Exception: BirthdateFormatException
        };
    }

    /** PASSED: 5 tests
     *  FAILED: 3 tests
     * */
    @Test(dataProvider = "data_provider")
    public void checkOnAdulthood(int idx, String date) throws BirthdateFormatException {
        System.out.println(idx + ": date = " + date);
        Adulthood adulthood = new Adulthood();

        Assert.assertTrue(adulthood.isAdult(date));
    }
}
