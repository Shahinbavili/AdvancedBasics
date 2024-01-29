package java17;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SealedClassShould {
    @Test
    void restrict_the_subclasses() {
        final Circle circle = new Circle(5.0);
        final Rectangle rectangle = new Rectangle(4.0, 3.0);

        assertThat(circle).isInstanceOf(Shape.class);
        assertThat(rectangle).isInstanceOf(Shape.class);

        assertThat(circle.getRadius()).isEqualTo(5.0);
        assertThat(rectangle.getWidth()).isEqualTo(4.0);
        assertThat(rectangle.getHeight()).isEqualTo(3.0);
    }
}
