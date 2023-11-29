package khodro;

public class Motor extends Khodro implements SandoghDar, Gearbox {
    @Override
    public boolean ayaDarHalHarekatAst() {
        return false;
    }

    @Override
    public String getMark() {
        return "Motor";
    }
}
