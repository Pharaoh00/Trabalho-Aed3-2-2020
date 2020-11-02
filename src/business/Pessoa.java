package business;

import error.DataIgualZero;
import error.DataNegativa;
import error.StringEmpty;
import tools.Tools;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Know Bugs:
 *
 */

public class Pessoa {
    private String nomePessoa;
    private String nomeMae;
    private int cpf;
    private LocalDate dataNascimento;
    private byte idade;
    private String sexo;

    public Pessoa() {

    }
    public Pessoa(String nomePessoa, String nomeMae, int cpf, String dataNascimento, String sexo) throws Exception {
        if(Tools.checkString(nomePessoa, "Nome da Pessoa"))
            this.nomePessoa = nomePessoa;
        if(Tools.checkString(nomeMae, "Nome da Mãe"))
            this.nomeMae = nomeMae;
        if(this.cpfValido(cpf))
            this.cpf = cpf;
        this.dataNascimento = this.parseData(dataNascimento);
        if(this.checkSexo(sexo))
            this.sexo = sexo;
        else
            throw new RuntimeException("Sexo " + "'" + sexo + "'" + " não é valido.");
        // Calculando os anos de vida da pessoa.
        Period p = Period.between(this.dataNascimento, LocalDate.now());
        // Pegando os anos do calculo feito.
        this.idade = (byte)p.getYears();
    }

    /**
     *
     * @param cpf Inteiro relativo ao numero do cpf a ser avaliado.
     * @return Retorna verdadeiro se o cpf for maior que zero e menor que 999999999.
     *         Retorna falso para numeros de cpf invalidos.
     */
    public boolean cpfValido(int cpf) {
        if(cpf > 0 && cpf <= 999999999)
            return true;
        return false;
    }

    /**
     *
     * @param data Inteiro relativo a data a ser comparada.
     * @param msg String relativa a mensagem customizada desejada.
     * @throws DataNegativa se data é menor que zero.
     * @throws DataIgualZero se data é igual à zero.
     * @return Retorna verdadeiro para datas validas.
     *         (Data valida se é maior que zero).
     */
    protected boolean checkData(int data, String msg) throws Exception{
        // Data Negativa
        if(Integer.compare(data, 0) < 0) {
            throw new DataNegativa(data, msg);
        }
        else if(Integer.compare(data, 0) == 0) {
            throw new DataIgualZero(msg);
        }
        return true;
    }

    public LocalDate parseData(String data) throws Exception {
        String[] tokens = data.split("[/.]");
        int dia = 0;
        int mes = 0;
        int ano = 0;

        // Dia
        int temp = Integer.parseInt(tokens[0]);
        if(this.checkData(temp, "dia")) {
            dia = Integer.parseInt(tokens[0]);
        }
        else {
            throw new NumberFormatException("Valor 'Dia' não pode ser convertido.");
        }

        // Mes
        temp = Integer.parseInt(tokens[1]);
        if(this.checkData(temp, "mes")) {
            mes = Integer.parseInt(tokens[1]);
        }
        else {
            throw new NumberFormatException("Valor 'Mes' não pode ser convertido.");
        }

        // Ano
        temp = Integer.parseInt(tokens[2]);
        if(this.checkData(temp, "ano")) {
            ano = Integer.parseInt(tokens[2]);
        }
        else {
            throw new NumberFormatException("Valor 'Ano' não pode ser convertido.");
        }

        return LocalDate.of(ano, mes, dia);
    }

    // Metodo deve ser protected
    /**
     *
     * @param sexo String relativa ao sexo a ser avaliado.
     * @return Retorna verdadeiro se a string é valida,
     *         (a String é valida se ela não for null ou não for fazia ou não tiver o tamanho igual a 0),
     *         e se a String for somente 'm' ou 'f'.
     *         Retorna falso se a String não for valida.
     * @throws StringEmpty
     */
    public boolean checkSexo(String sexo) throws Exception {
        // String valida
        if(Tools.checkString(sexo, "sexo")) {
            return sexo.equalsIgnoreCase("m") || sexo.equalsIgnoreCase("f");
        }
        return false;
    }

    public String getNomePessoa() {
        return this.nomePessoa;
    }
    public void setNomePessoa(String nome) throws Exception {
        if(Tools.checkString(nome, "Nome da Pessoa"))
            this.nomePessoa = nome;
    }

    public String getNomeMae() {
        return this.nomeMae;
    }
    public void setNomeMae(String nome) throws Exception {
        if(Tools.checkString(nome, "Nome da Pessoa"))
            this.nomePessoa = nome;
    }

    public int getCpf() {
        return this.cpf;
    }

    public String getDataNascimento() throws ParseException {
        return this.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public void setDataNascimento(String data) throws Exception {
        this.dataNascimento = this.parseData(data);
    }

    public int getIdade() {
        return (int)this.idade;
    }

    public String getSexo() {
        return this.sexo;
    }
}
