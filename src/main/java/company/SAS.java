package company;

public class SAS implements Company {
    private final double taxPercentage = 0.33;

    @Override
    public double calculateTax(double annualTurnover) {
        return annualTurnover * taxPercentage;
    }
}
