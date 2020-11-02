package error;

public class StringEmpty extends Exception {
    public StringEmpty(String str) {
        super(str + " não pode ser vazia.");
    }
}
