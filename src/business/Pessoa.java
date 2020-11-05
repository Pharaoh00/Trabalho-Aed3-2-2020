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
 */

public class Pessoa {
    private String nome;
    private int cpf;
    private LocalDate dataNascimento;
    private byte idade;
    private char sexo;

    public Pessoa() {

    }

    /**
     * Construtor contendo data de nascimento "customizada"
     * @param nome String relativa ao nome de Pessoa.
     * @param cpf int relativo ao CPF de Pessoa.
     * @param dataNascimento String relativo a data nascimento de Pessoa.
     * @param sexo String sexo relativo de Pessoa.
     *             (Valores Possiveis, "m" ou "f"
     */
    public Pessoa(String nome, int cpf, String dataNascimento, char sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = this.parseData(dataNascimento);
        this.sexo = sexo;
        // Calculando os anos de vida da pessoa.
        Period p = Period.between(this.dataNascimento, LocalDate.now());
        // Pegando os anos do calculo feito.
        this.idade = (byte) p.getYears();
    }

    /**
     * Construtor sem data de nascimento. No caso será o dia de "hoje". (LocalDate.now())
     * @param nome String relativa ao nome de Pessoa.
     * @param cpf int relativo ao CPF de Pessoa.
     * @param sexo String sexo relativo de Pessoa.
     *             (Valores Possiveis, "m" ou "f"
     */
    public Pessoa(String nome, int cpf, String sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = LocalDate.now();
    }

    /**
     * @param cpf Inteiro relativo ao numero do cpf a ser avaliado.
     * @return Retorna verdadeiro se o cpf for maior que zero e menor que 999999999.
     * Retorna falso para numeros de cpf invalidos.
     */
    public boolean cpfValido(int cpf) {
        if (cpf > 0 && cpf <= 999999999)
            return true;
        return false;
    }

    /**
     * @param data Inteiro relativo a data a ser comparada.
     * @param msg  String relativa a mensagem customizada desejada.
     * @return Retorna verdadeiro para datas validas.
     * (Data valida se é maior que zero).
     * @throws DataNegativa  se data é menor que zero.
     * @throws DataIgualZero se data é igual à zero.
     */
    protected boolean checkData(int data, String msg) {
        // Data Negativa
        if (Integer.compare(data, 0) < 0)
            return false;
        else if (Integer.compare(data, 0) == 0)
            return false;
        return true;
    }

    public LocalDate parseData(String data) {
        String[] tokens = data.split("[/.]");
        int dia = 0;
        int mes = 0;
        int ano = 0;

        // Dia
        int temp = Integer.parseInt(tokens[0]);
        if (this.checkData(temp, "dia"))
            dia = Integer.parseInt(tokens[0]);

        // Mes
        temp = Integer.parseInt(tokens[1]);
        if (this.checkData(temp, "mes"))
            mes = Integer.parseInt(tokens[1]);

        // Ano
        temp = Integer.parseInt(tokens[2]);
        if (this.checkData(temp, "ano"))
            ano = Integer.parseInt(tokens[2]);

        return LocalDate.of(ano, mes, dia);
    }

    // Metodo deve ser protected

    /**
     * @param sexo String relativa ao sexo a ser avaliado.
     * @return Retorna verdadeiro se a string é valida,
     * (a String é valida se ela não for null ou não for fazia ou não tiver o tamanho igual a 0),
     * e se a String for somente 'm' ou 'f'.
     * Retorna falso se a String não for valida.
     * @throws StringEmpty
     */
    public boolean checkSexo(String sexo) {
        // String valida
        if (Tools.checkString(sexo)) {
            return sexo.equalsIgnoreCase("m") || sexo.equalsIgnoreCase("f");
        }
        return false;
    }

    public String getNomePessoa() {
        return this.nome;
    }

    public void setNomePessoa(String nome) {
        if (Tools.checkString(nome))
            this.nome = nome;
    }

    public int getCpf() {
        return this.cpf;
    }

    public String getDataNascimento() throws ParseException {
        return this.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setDataNascimento(String data) {
        this.dataNascimento = this.parseData(data);
    }

    public int getIdade() {
        return (int) this.idade;
    }

    public char getSexo() {
        return this.sexo;
    }
}
