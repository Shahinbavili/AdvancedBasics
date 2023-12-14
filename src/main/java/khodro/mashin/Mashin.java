package khodro.mashin;

import khodro.Gearbox;
import khodro.Khodro;
import khodro.SandoghDar;

import java.util.Objects;

public class Mashin extends Khodro implements SandoghDar, Gearbox, Comparable<Mashin> {
    public static int tedadForoush;
    boolean ayaDarBazAst; //false

    boolean ayaRoshanAst; //false
    String mark;
    double gonjayeshSandogh;
    Dande noeDande;

    public Mashin(String mark, int gonjayeshSandogh, Dande noeDande) {
        this.mark = mark;
        this.gonjayeshSandogh = gonjayeshSandogh;
        this.noeDande = noeDande;
    }

    public Mashin() {
    }

    void bazKardanDar() {
        ayaDarBazAst = true;
    }

    void bastanDar() {
        ayaDarBazAst = false;
    }

    @Override
    public boolean ayaDarHalHarekatAst() {
        protectedMethod();
        return ayaRoshanAst && !ayaDarBazAst;
    }

    @Override
    public String getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "Mashin{" +
                "ayaDarBazAst=" + ayaDarBazAst +
                ", ayaRoshanAst=" + ayaRoshanAst +
                ", mark='" + mark + '\'' +
                ", gonjayeshSandogh=" + gonjayeshSandogh +
                ", noeDande='" + noeDande.getToPersian() + " - " + noeDande.getToFrench() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mashin mashin = (Mashin) o;
        return Double.compare(gonjayeshSandogh, mashin.gonjayeshSandogh) == 0 && Objects.equals(mark, mashin.mark) && noeDande == mashin.noeDande;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, gonjayeshSandogh, noeDande);
    }

    @Override
    public int compareTo(Mashin o) {
        int compareByGonjayeshSandogh = Integer.compare((int) this.gonjayeshSandogh, (int) o.gonjayeshSandogh);
        if (compareByGonjayeshSandogh == 0) {
            if (Objects.equals(this.noeDande, Dande.MANUAL)) {
                return -1;
            } else {
                return 1;
            }
        }
        return compareByGonjayeshSandogh;
    }
}
