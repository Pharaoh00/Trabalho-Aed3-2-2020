package business;

import error.ExameInvalido;
import tools.Tools;

public class Exame {
    private static String[] examesValidos = {"laboratorial", "radiologico", "outro"};
    private String exame;

    public Exame(String exame) {
        if (Exame.checkExame(exame))
            this.exame = exame;
    }

    public static boolean checkExame(String nome) {
        if (Tools.checkString(nome))
            return nome.equalsIgnoreCase("laboratorial") ||
                    nome.equalsIgnoreCase("radiologico") ||
                    nome.equalsIgnoreCase("outro");

        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < examesValidos.length; i++) {
            builder.append(examesValidos[i]);
            if (i != examesValidos.length - 1)
                builder.append(", ");
            else
                builder.append(".");
        }
        return builder.toString();
    }

    public static String getExamesValidos() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < examesValidos.length; i++) {
            builder.append(examesValidos[i]);
            if (i != examesValidos.length - 1)
                builder.append(", ");
            else
                builder.append(".");
        }
        return builder.toString();
    }
}
