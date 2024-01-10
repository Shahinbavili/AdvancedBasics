package company;

public interface Company {
    default double calculateTax(double annualTurnover) {
        return annualTurnover * getTaxPercentage();
    }

    default double getTaxPercentage() {
        return 0.1;
    }
}
