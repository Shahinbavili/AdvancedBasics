package khodro;

import static java.lang.System.out;

public class Ranande {
//    in Java, a class can be declared as static only if it is a nested class.
//    A top-level class (a class not nested within another class) cannot be declared as static.
//    However, nested classes can be either static or non-static (also known as inner classes).

    private String noeGavahiname = "Paye 1";
    private static String nam = "Farhad";

    //    Non-static nested class or named inner class
    public class Gavahiname {
        public void chapKon() {
            out.println("Class Non-Static: ");
            out.println(noeGavahiname);
            out.println(nam);
        }

    }

    //    static nested class
    public static class StaticGavahiname {
        public void chapKon() {
            out.println("Class Static: ");
//            System.out.println(noeGavahiname); //doesn't work because this variable is not static
            out.println(nam);
        }
    }
}
