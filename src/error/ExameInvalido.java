package error;

import business.Exame;

public class ExameInvalido extends Exception{
    public ExameInvalido(String msg) {
        super("'"+msg + "'" +" não é valido. Os exames válidos são: " + Exame.getExamesValidos());
    }
}
