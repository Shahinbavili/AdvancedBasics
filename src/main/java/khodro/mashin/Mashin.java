package khodro.mashin;

import khodro.Gearbox;
import khodro.Khodro;
import khodro.SandoghDar;

public class Mashin extends Khodro implements SandoghDar, Gearbox {
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
}
