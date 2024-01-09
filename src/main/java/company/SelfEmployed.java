package company;

public class SelfEmployed implements Company {

    @Override
    public double getTaxPercentage() {
        return 0.25;
    }
}
