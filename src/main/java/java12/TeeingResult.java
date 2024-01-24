package java12;

public class TeeingResult {
    private final int sum;
    private final int product;

    public TeeingResult(int sum, int product) {
        this.sum = sum;
        this.product = product;
    }

    public int getSum() {
        return sum;
    }

    public int getProduct() {
        return product;
    }
}

