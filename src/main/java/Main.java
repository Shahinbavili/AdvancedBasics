import khodro.mashin.Mashin;

import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.System.out;
import static khodro.mashin.Dande.valueOf;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            out.println(args[i]);
        }

        String mark = args[0];
        String gonjayeshSandogh = args[1];
        String noeDande = args[2];
        Mashin mashin = new Mashin(mark, parseInt(gonjayeshSandogh), valueOf(noeDande));
        if (mashin.ayaDarHalHarekatAst()) {
            out.println("Mashin dar hal harekat ast.");
        } else {
            out.println("Mashin park ast.");
        }
        out.println(mashin.getMark());

        Scanner scanner = new Scanner(System.in);

        out.println("What is your name?");
        String name = scanner.nextLine();

        out.println("Please enter your age:");
        String age = scanner.nextLine();

        out.println("Where do you live?");
        String residentCity = scanner.nextLine();

        out.println("I am " + name + ", " + age + " years old and from " + residentCity);


        out.println("Payan ejra");
    }

}
