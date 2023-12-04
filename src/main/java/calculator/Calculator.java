package calculator;

import static java.lang.Double.parseDouble;

public class Calculator {

    public String add(String adadAval, String adadDovom) {
        double d1 = parseDouble(adadAval);
        double d2 = parseDouble(adadDovom);
        double result = d1 + d2;
        return String.valueOf(result);
    }
}
