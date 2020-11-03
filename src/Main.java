import business.Exame;
import business.FichaTecnica;

public class Main {
    public static void main(String[] args) {
        try {
            FichaTecnica ficha = new FichaTecnica("medico", "instituicao");
            Exame exame = new Exame("outros");
            //System.out.println(exame);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
