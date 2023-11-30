package khodro;

public class Mashin extends Khodro implements SandoghDar, Gearbox {
    public static int tedadForoush;
    boolean ayaDarBazAst; //false

    boolean ayaRoshanAst; //false
    String mark;
    double gonjayeshSandogh;
    String noeDande;

    public Mashin(String mark, int gonjayeshSandogh, String noeDande) {
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
}
