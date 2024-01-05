package tree;

import java.util.ArrayList;

// Generic stack implementation using an ArrayList
public class StackGeneric<T> {

    private ArrayList<T> stackArray; // ArrayList to store stack elements

    // Constructor to initialize the stack
    public StackGeneric() {
        stackArray = new ArrayList<>(); // Creating a new ArrayList instance
    }

    // Push an element onto the stack
    public void push(T element) {
        stackArray.add(element); // Adding the element to the end of the ArrayList
    }

    // Pop an element from the stack
    public T pop() {
        // Check if the stack is empty before attempting to pop
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        // Remove and return the last element in the ArrayList (LIFO)
        return stackArray.remove(stackArray.size() - 1);
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return stackArray.isEmpty(); // Check if the ArrayList representing the stack is empty
    }
}
