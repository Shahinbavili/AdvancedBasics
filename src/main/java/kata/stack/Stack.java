package kata.stack;

import java.util.LinkedList;

public class Stack {
    private final LinkedList<String> elements;
    private final int limit;

    public Stack(int limit) {
        this.limit = limit;
        this.elements = new LinkedList<>();
    }

    public int getSize() {
        return elements.size();
    }

    public void push(String element) {
        if (elements.size() >= limit) {
            throw new StackOverflowException();
        }
        elements.add(element);
    }

    public void pop() {
        elements.removeLast();
    }
}
