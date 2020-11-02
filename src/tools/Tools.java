package tools;

import error.StringEmpty;
import error.StringInvalida;

public class Tools {
    public static boolean onlyLetters(String str) {
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isLetter(c) || c == ' ' || c == '-')
                continue;
            return false;
        }
        return true;
    }

    /**
     *
     * @param str String relativa para a checagem se está null ou vazia.
     * @return Retorna verdadeiro se a String é valida.
     *         (String valida se é diferente que null ou não está vazia ou o tamanho é diferente de 0).
     * @throws StringEmpty Se a String está vazia ou tamanho 0.
     */
    public static boolean checkString(String str, String msg) throws Exception {
        if(str == null)
            throw new NullPointerException("String não foi inicializada e está 'null'.");
        if(str.isEmpty())
            throw new StringEmpty(msg);
        if(Tools.onlyLetters(str))
            return true;
        throw new StringInvalida(msg);
    }
}
