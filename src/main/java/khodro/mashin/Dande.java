package khodro.mashin;

import static java.lang.System.out;

public enum Dande {
    AUTOMATIC("Otomatik", "Automatique"),
    MANUAL("Dasti", "Manuel");

    private final String toPersian;
    private final String toFrench;

    Dande(String toPersian, String toFrench) {
        this.toPersian = toPersian;
        this.toFrench = toFrench;
    }

    public static void print() {
        Dande[] values = Dande.values();
        for (int i = 0; i < values.length; i++) {
            out.println(values[i].toPersian);

        }
    }

    public static void printInPersian() {
        Dande[] values = Dande.values();
        for (int i = 0; i < values.length; i++) {
            out.println(values[i].toPersian);

        }
    }

    public static void printInFrench() {
        Dande[] values = Dande.values();
        for (int i = 0; i < values.length; i++) {
            out.println(values[i].toFrench);

        }
    }

    public String getToPersian() {
        return toPersian;
    }

    public String getToFrench() {
        return toFrench;
    }
}
