package khodro.mashin;

import java.util.Comparator;

public class MashinComparator implements Comparator<Mashin> {
    @Override
    public int compare(Mashin o1, Mashin o2) {
        return o1.getMark().compareTo(o2.getMark());
    }
}
