package java17;
//sealed subclasses can be "final", "sealed" or "non-sealed"

public final class Rectangle extends Shape {
    private final Double width;
    private final double height;

    public Rectangle(Double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
