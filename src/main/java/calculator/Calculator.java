package calculator;

import static java.lang.Double.parseDouble;

public class Calculator {

    public String add(String adadAval, String adadDovom) {

        double d1, d2;
        try {
            d1 = parseDouble(adadAval);
            d2 = parseDouble(adadDovom);
        } catch (NumberFormatException nfe) {
            System.out.println("The entered number format is not allowed");
            throw nfe;
        }
        double result = d1 + d2;
        return String.valueOf(result);
    }
}
