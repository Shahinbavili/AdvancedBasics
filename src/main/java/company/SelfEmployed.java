package company;

public class SelfEmployed implements Company {
    private final double taxPercentage = 0.25;

    public double calculateTax(double annualTurnover) {
        return annualTurnover * taxPercentage;
    }
}
