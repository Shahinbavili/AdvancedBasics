package khodro;

import java.util.StringJoiner;

public class NamKhodroChapKon {
    Khodro[] khodroha;

    public NamKhodroChapKon(Khodro[] khodroha) {
        this.khodroha = khodroha;
    }

    public String execute() {
        StringJoiner namKhodroha = new StringJoiner("-");
        for (int i = 0; i < khodroha.length; i++) {
            Khodro khodro = khodroha[i];
            namKhodroha.add(khodro.getMark());
        }
        return namKhodroha.toString();
    }
}
