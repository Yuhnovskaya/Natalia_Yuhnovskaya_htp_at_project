package utilites;

public class StringToDigitsConverter {
    public static int converterStringToDigit(String string){
        string=string.replaceAll("[^0-9]+","");
        int digit=Integer.parseInt(string);
        return digit;
    }
}
