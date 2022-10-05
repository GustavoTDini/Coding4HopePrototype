package Model;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Classe para definir um cadastro básico inicial que incluem o ‘login’, e o endereço eletrônico,
 * e uma senha, além de atribuir um ‘id’ único com o tipo UUID
 * @author Turing
 */
public class Usuario {

    private UUID _id;
    private String login;
    private String senha;
    private String email;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String url;
    private String nomeEmpresa;
    private String cnpj;
    private boolean admin;
    private boolean doador;

    public Usuario() {
        this._id = UUID.randomUUID();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        if (isCnpj(cnpj)){
            this.cnpj = cnpj;
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isDoador() {
        return doador;
    }

    public void setDoador(boolean doador) {
        this.doador = doador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (isCpf(cpf)){
            this.cpf = cpf;
        }
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }


    /**
     * Método que irá validar a entrada de CNPJ, realizando o algoritmo disponível do Governo, para este fim
     * @param cnpj String contendo o número do CNPJ
     * @return Retorna true se o CNPJ é valido
     * @author Turing
     */
    public boolean isCnpj(String cnpj) {

        if (cnpj == null){
            return false;
        }

        /*A primeira validação será verificar se o cnpj fornecido é um que possui dígitos iguais ou se ele tem tamanho superior a 14*/
        if(cnpj.equals("00000000000000")||cnpj.equals("11111111111111")||cnpj.equals("22222222222222")||cnpj.equals("33333333333333")
                ||cnpj.equals("44444444444444")||cnpj.equals("55555555555555")||cnpj.equals("66666666666666")||cnpj.equals("77777777777777")
                ||cnpj.equals("88888888888888")||cnpj.equals("99999999999999")|| (cnpj.length()!=14)) {
            return false;
        }
        /*Agora verificaremos o calculo do 1º digito*/
        int valorCalculado = 0, peso;
        peso = 5;
        for (int i = 0; i < 12; i++) {
            valorCalculado += ((int)cnpj.charAt(i)) * peso;
            peso--;
            if (peso < 2){
                peso = 9;
            }
        }
        int resultado = valorCalculado % 11;
        if (resultado < 2){
            resultado = 0;
        } else {
            resultado = 11 - resultado % 11;
        }
        if (resultado != (int)cnpj.charAt(12)){
            return false;
        }

        /*Agora verificaremos o calculo do 2º digito*/
        valorCalculado = 0;
        peso = 6;
        for (int i = 0; i < 13; i++) {
            valorCalculado += ((int)cnpj.charAt(i)) * peso;
            peso--;
            if (peso < 2){
                peso = 9;
            }
        }
        resultado = valorCalculado % 11;
        if (resultado < 2){
            resultado = 0;
        } else {
            resultado = 11 - resultado % 11;
        }
        return resultado == (int) cnpj.charAt(13);
    }

    /**
     * Método que irá validar a entrada de CPF, realizando o algoritmo disponível do Governo, para este fim
     * @param cpf String contendo o número do CPF
     * @return Retorna true se o CPF é valido
     * @author Turing
     */
    public boolean isCpf(String cpf) {
        /*A primeira validação será verificar se o cpf fornecido é um que possui dígitos iguais ou se ele tem tamanho superior a 11*/
        if(cpf.equals("00000000000")||cpf.equals("11111111111")||cpf.equals("22222222222")||cpf.equals("33333333333")
                ||cpf.equals("44444444444")||cpf.equals("55555555555")||cpf.equals("66666666666")||cpf.equals("77777777777")
                ||cpf.equals("88888888888")||cpf.equals("99999999999")|| (cpf.length()!=11)) {
            return false;
        }
		/*caso o CPF tenha passado no primeiro teste, vamos submeter ao teste do primeiro dígito. Para isso,
		vamos criar duas variáveis que auxiliarão no cálculo: a variável valor calculado, que verificará se o CPF é
		igual ao dígito verificador e a variável peso, que será usada nas multiplicações*/
        int valorCalculado=0, i, peso=10;

        for(i=0;i<9;i++) {
            //O looping rodará uma vez para cada um dos 9 dígitos relevantes ao cálculo
            //Cada dígito será convertido em inteiro, multiplicado pelo peso e acumulado em valorCalculado
            valorCalculado+= ((int)cpf.charAt(i)-48) * peso;
            //Atendendo ao cálculo, a cada volta o peso diminui
            peso--;
        }
        //A parte final do cálculo do primeiro dígito verificador é realizada
        valorCalculado = valorCalculado * 10 %11;
        if(valorCalculado==10) {
            valorCalculado=0;
        }
        //Se o cálculo dos 9 dígitos relevantes for diferente do dígito verificador, retorna-se false
        if(valorCalculado!=(cpf.charAt(9)-48)) {
            return false;
        }

        valorCalculado = 0;
        peso = 11;

        for(i=0;i<10;i++) {
            //O looping rodará uma vez para cada um dos 10 dígitos relevantes ao cálculo
            //Cada dígito será convertido em inteiro, multiplicado pelo peso e acumulado em valorCalculado
            valorCalculado+= ((int)cpf.charAt(i)-48) * peso;
            //Atendendo ao cálculo, a cada volta o peso diminui
            peso--;
        }
        valorCalculado = valorCalculado * 10 %11;
        if(valorCalculado==10) {
            valorCalculado=0;
        }
        //Se o cálculo dos 10 dígitos relevantes for diferente do 2º dígito verificador, retorna-se false
        //Caso nenhum dos returns anteriores tenha sido atingido, retorna-se verdadeiro
        return valorCalculado == (cpf.charAt(10) - 48);

    }


}