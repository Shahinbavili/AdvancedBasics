package java14;

import static java.lang.System.out;

public class SwitchExpressions {
    public String dayType(int dayOfWeek) {
        return switch (dayOfWeek) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> {
                out.println("Have a good weekend");
                yield "Weekend";
            }
            default -> throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeek);
        };
    }
}
