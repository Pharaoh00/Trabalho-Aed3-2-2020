package business;

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
    private int exameId = 0;
    private String nomeMedico;
    private String nomeInstituicao;

    public FichaTecnica(String nomeMedico, String nomeInstituicao) {
        /*
        A ideia aqui é ter um sistema de ids unicos.
        global_id, sendo static, todos as instancia teram o mesmo id,
        local_id vai receber o global_id atual e no final global_id vai atualizar com +1.
         */
        global_id = 1;
        local_id = global_id;
        this.nomeMedico = nomeMedico.toLowerCase();
        this.nomeInstituicao = nomeInstituicao.toLowerCase();

        global_id++;
    }

    public boolean addExame(String exame) {
        if(Exame.checkExame(exame)) {
            this.exame.put(this.exameId, exame.toLowerCase());
            this.exameId++;
            return true;
        }
        return false;
    }
}
