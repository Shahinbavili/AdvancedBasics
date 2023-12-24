package functional.principles;

public class ImpureMethod {
    int v = 0;
    int total = 0;
    public int impureMethod(int a){
        total += a;
        return total;
    }

    public int sum(int a, int b){
        v++;
        return a + b;
    }
}
