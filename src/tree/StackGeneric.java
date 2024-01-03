package tree;

import java.util.ArrayList;

public class StackGeneric<T> {
    private ArrayList<T> stackArray;

    public StackGeneric() {
        stackArray = new ArrayList<>();
    }

    public void push(T element) {
        stackArray.add(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackArray.remove(stackArray.size() - 1);
    }

    public boolean isEmpty() {
        return stackArray.isEmpty();
    }
}
