package Matar;

public class EmptyCapacityException extends StackException {
    public EmptyCapacityException() {
        super("The stack is empty");
    }
}
