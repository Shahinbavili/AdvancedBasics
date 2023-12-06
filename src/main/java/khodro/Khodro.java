package khodro;

public abstract class Khodro {
    @Override
    public String toString() {
        return "Khodro{}";
    }

    boolean ayaRoshanAst;

    public void roshan() {
        ayaRoshanAst = true;
    }

    public void khamoush() {
        ayaRoshanAst = false;
    }

    public abstract boolean ayaDarHalHarekatAst();

    public abstract String getMark();

    protected void protectedMethod() {
        System.out.println("This method is protected!");
    }
}
