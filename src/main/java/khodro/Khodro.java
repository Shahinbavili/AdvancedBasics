package khodro;

public abstract class Khodro {
    boolean ayaRoshanAst;

    public void roshan() {
        ayaRoshanAst = true;
    }

    public void khamoush() {
        ayaRoshanAst = false;
    }

    public abstract boolean ayaDarHalHarekatAst();

    public abstract String getMark();
}
