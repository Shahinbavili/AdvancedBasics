package khodro;

public class Mashin extends Khodro implements SandoghDar, Gearbox {
    boolean ayaDarBazAst;
    String mark;
    double gonjayeshSandogh;
    String noeDande;

    public Mashin(String mark, int gonjayeshSandogh, String noeDande) {
        this.mark = mark;
        this.gonjayeshSandogh = gonjayeshSandogh;
        this.noeDande = noeDande;
    }


    @Override
    public boolean ayaDarHalHarekatAst() {
        return false;
    }

    @Override
    public String getMark() {
        return mark;
    }
}
