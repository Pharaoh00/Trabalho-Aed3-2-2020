package business;

public class PacienteAdulto extends Pessoa {
    private char estadoCivil;
    private FichaTecnica ficha;
    private String nomeMae;

    public PacienteAdulto(String nome, int cpf, String dataNascimento, char sexo,
                          char EstadoCivil, FichaTecnica ficha, String nomeMae) {
        super(nome, cpf, dataNascimento, sexo);
        this.estadoCivil = estadoCivil;
        this.ficha = ficha;
        this.nomeMae = nomeMae;
    }

    /**
     * Compara a string passado com os estados validos.
     * s para Solteiro(a).
     * c para Casado(a).
     * d para Divorciado(a).
     * v para Viuvo(a).
     * p para Separado(a).
     * @param estado char Relativo ao estado civil a ser checado.
     * @return Retorna true se estado é valido.
     */
    public boolean checkEstadoCivil(char estado) {
        return estado == 's' ||
               estado == 'c' ||
               estado == 'd' ||
               estado == 'v' ||
               estado == 'p';
    }
    public char getEstadoCivil() {
        return this.estadoCivil;
    }
    public boolean setEstadoCivil(char estado) {
        if(checkEstadoCivil(estado)) {
            this.estadoCivil = estado;
            return true;
        }
        return false;
    }
}
