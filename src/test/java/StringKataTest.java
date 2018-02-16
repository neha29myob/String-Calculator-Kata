import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StringKataTest {

    private static final String EMPTY_STRING = "";
    private static final String SINGLE_NUMBER_STRING = "3";
    private static final String TWO_NUMBER_STRING = "3,5";
    private static final String FOUR_NUMBER_STRING = "3,5,10,20";
    private static final String LINEBREAK_NUMBER_STRING = "3\n5\n3,10";
    private static final String DELIMITERS_NUMBER_STRING = "//;\n8;2";
    private static final String NEGATIVE_NUMBER_STRING = "-1,2,-3";
    private static final String BIGGER_NUMBER_STRING = "1002,1005,2";
    private static final String ANY_LENGTH_DELIMITERS_NUMBER_STRING = "[***]\n1***2***3";
    private static final String MULTIPLE_DELIMITERS_NUMBER_STRING = "//[*][%]\n7*2%3";
    private static final String MULTIPLE_LONGER_DELIMITERS_NUMBER_STRING = "[***][#][%]\n1***2#3%4";
    private static final String NUMBERS_AS_DELIMITERS_STRING = "//[*1*][%]\\n1*1*2%3";


    private StringKata stringKata;

    @Before
    public void setUp(){
        stringKata = new StringKata();
    }

    @Test
    public void whenEmptyStringReturnZero () throws Exception {
        int result = stringKata.add(EMPTY_STRING);
        assertEquals(0, result);
    }

    @Test
    public void whenSingleNumberReturnsSameNumber() throws Exception {
        int result = stringKata.add(SINGLE_NUMBER_STRING);
        assertEquals(3, result);
    }

    @Test
    public void whenTwoNumbersReturnSum() throws Exception {
        int result = stringKata.add(TWO_NUMBER_STRING);
        assertEquals(8,result);
    }

    @Test
    public void whenAnyNumbersReturnSum() throws Exception {
        int result = stringKata.add(FOUR_NUMBER_STRING);
        assertEquals(38,result);
    }

    @Test
    public void WhenNumbersWithLineBreakReturnSum() throws Exception {
        int result = stringKata.add(LINEBREAK_NUMBER_STRING);
        assertEquals(21,result);
    }

    @Test
    public void WhenNumbersWithDifferentDelimitersReturnSum() throws Exception {
        int result = stringKata.add(DELIMITERS_NUMBER_STRING);
        assertEquals(10,result);
    }

    @Test (expected = Exception.class)
    public void WhenNegativeNumbersThrowException() throws Exception {
      stringKata.add(NEGATIVE_NUMBER_STRING);
    }

    @Test
    public void WhenNumberGreaterThan1000IgnoreAndReturnSum() throws Exception {
        int result = stringKata.add(BIGGER_NUMBER_STRING);
        assertEquals(2,result);
    }

    @Test
    public void WhenNumbersWithAnyLengthDelimitersReturnSum() throws Exception {
        int result = stringKata.add(ANY_LENGTH_DELIMITERS_NUMBER_STRING);
        assertEquals(6,result);
    }

    @Test
    public void WhenNumbersWithMultipleDelimitersReturnSum() throws Exception {
        int result = stringKata.add(MULTIPLE_DELIMITERS_NUMBER_STRING);
        assertEquals(12,result);
    }


    @Test
    public void WhenNumbersWithMultipleLongDelimitersReturnSum() throws Exception {
        int result = stringKata.add(MULTIPLE_LONGER_DELIMITERS_NUMBER_STRING);
        assertEquals(10,result);
    }

    @Test
    public void WhenNumberAsDelimiterIgnoreAndReturnSum() throws Exception {
        int result = stringKata.add(NUMBERS_AS_DELIMITERS_STRING);
        assertEquals(6,result);
    }
}
