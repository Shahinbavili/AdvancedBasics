package functional.principles;

@FunctionalInterface
public interface Operation {
    int applyOperation(int number);

    default int anotherOperation(int number) {
        return 0;
    }
}
