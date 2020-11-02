package error;

public class DataIgualZero extends Exception{
    public DataIgualZero(String msg) {
        super("'" + msg +"'" + " não pode ser zero. Somente" + " " + msg + " maiores ou iguais a 1.");
    }
}
