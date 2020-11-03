package business;

import error.ExameInvalido;
import tools.Tools;

public class Exame {
    private static final String[] examesValidos = {"laboratorial", "radiologico", "outro"};
    private String exame;

    public Exame(String exame) throws Exception {
        if(this.checkExame(exame))
            this.exame = exame;
    }

    private boolean checkExame(String nome) throws Exception {
        if(Tools.checkString(nome, "exame")) {
            if(nome.equalsIgnoreCase("laboratorial") ||
                    nome.equalsIgnoreCase("radiologico")  ||
                    nome.equalsIgnoreCase("outro"))
                return true;
            throw new ExameInvalido(nome);
        }
        throw new ExameInvalido(nome);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < examesValidos.length; i++) {
            builder.append(examesValidos[i]);
            if(i != examesValidos.length-1)
                builder.append(", ");
            else
                builder.append(".");
        }
        return builder.toString();
    }

    public static String getExamesValidos() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < examesValidos.length; i++) {
            builder.append(examesValidos[i]);
            if(i != examesValidos.length-1)
                builder.append(", ");
            else
                builder.append(".");
        }
        return builder.toString();
    }
}
