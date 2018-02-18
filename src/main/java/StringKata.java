
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringKata {

    public int add (String numbersList) throws Exception {

        String result = extractDelimiters(numbersList);
        List<Integer> numbers = extractNumbers(result);
        validateNegativeNumbers(numbers);
        List<Integer> smallerNumbers = getNumbersLessThan1000(numbers);

        int sum = 0;
        for(Integer i : smallerNumbers){
         sum += i;
        }
            return sum;
    }

    public List<Integer> extractNumbers (String numbersList) {


        String digitsFetch = "-?\\d+";

        List<Integer> numbers = new ArrayList<Integer>();

        Pattern pattern = Pattern.compile(digitsFetch);
        Matcher matcher = pattern.matcher(numbersList);

        while (matcher.find()) {

            int number = Integer.parseInt(matcher.group(0));
            numbers.add(number);
        }
        return numbers;
    }

    public void validateNegativeNumbers (List<Integer> extractedNumbers) throws Exception {

        List<Integer> negativeNumbers = getNegativeNumbers(extractedNumbers);

        if(negativeNumbers.size() > 0){
            throw new Exception("Negatives not allowed :" + negativeNumbers.toString());
        }
    }

    public List<Integer> getNegativeNumbers (List<Integer> extractedNumbers)
    {
        List<Integer> negativeNumbers = new ArrayList<Integer>();

        for(Integer i : extractedNumbers)
        {
            if (i < 0){
                negativeNumbers.add(i);
            }
        }
        return negativeNumbers;
    }

    public List<Integer> getNumbersLessThan1000 (List<Integer> extractedNumbers) {

        List<Integer> smallerNumbers = getNegativeNumbers(extractedNumbers);

        for( Integer i : extractedNumbers){
            if(i <= 1000){
                smallerNumbers.add(i);
            }
        }
        return smallerNumbers;
    }

    public String extractDelimiters (String numbersList) {

        String delimitersFetch = "\\[(.*?)\\]";
        Pattern pattern = Pattern.compile(delimitersFetch);
        Matcher matcher = pattern.matcher(numbersList);

        while (matcher.find()) {
            numbersList = numbersList.replace(matcher.group(1),"#");
        }
        return numbersList;
    }

}
