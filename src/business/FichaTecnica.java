package business;

import tools.Tools;

import java.util.HashMap;

public class FichaTecnica {
/*    private enum Exame {
        laboratoriais(1) {
            @Override
            public String toString() {
                return "Exame laboratorial";
            }
        },
        radiologicos(2) {
            @Override
            public String toString() {
                return "Exame radiológico";
            }
        },
        outro(3) {
            @Override
            public String toString() {
                return "Outro exame";
            }
        };
        private int exame;
        Exame(int exame) {
            this.exame = exame;
        }
        public int getExame() {
            return this.exame;
        }
    }*/
    private static int global_id;
    private int local_id;
    private HashMap<Integer, String> exame;
    private String nomeMedico;
    private String nomeInstituicao;

    public FichaTecnica(String nomeMedico, String nomeInstituicao) throws Exception {
        global_id = 1;
        local_id = global_id;
        if(Tools.checkString(nomeMedico, "Nome médico"))
            this.nomeMedico = nomeMedico.toLowerCase();
        if(Tools.checkString(nomeInstituicao, "Nome Instituição"))
            this.nomeInstituicao = nomeInstituicao.toLowerCase();

        global_id++;
    }
    /*
    Notas:
    Fazer a função para mapear os exames as consultas.
    Fazer os gets e setters.
     */
}
