package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import dados.CaixaPostalDados;

public class CaixaPostal implements Contato, Serializable {
    private String nome;
    private String endereco;
    private String cidade;
    private String cep;

    public CaixaPostal(){}

    public CaixaPostal(String nome, String endereco, String cidade, String cep) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.cep = cep;
    }

    //-----------------------setters------------------------------------
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    //-------------------getters---------------------------------------
    public String getNome() { //------Interface--------
        return this.nome;
    }
    public String getEndereco() {
        return this.endereco;
    }
    public String getCidade() {
        return this.cidade;
    }
    public String getCep() {
        return this.cep;
    }
    public String getTipo() { //------Interface--------
        return "Caixa Postal";
    }
    public String getContato() { //------Interface--------
        return "\n|Tipo|: " + getTipo() +
            "\nNome: " + getNome() +
            "\nEndereço: " + getEndereco() +
            "\nCidade: " + getCidade() +
            "\nCEP: " + getCep();
    }

    //------------------arquivo-------------------------------------
    public void cadastrarCaixaPostal(CaixaPostal cx) throws IOException, ClassNotFoundException {
        CaixaPostalDados cpd = new CaixaPostalDados();
        cpd.cadastrarCaixaPostal(cx);
    }
    public void removerCaixaPostal(CaixaPostal cx) throws IOException, ClassNotFoundException {
        CaixaPostalDados cpd = new CaixaPostalDados();
        cpd.removerCaixaPostal(cx);
    }
    public ArrayList<CaixaPostal> listarCaixaPostal() throws IOException, ClassNotFoundException {
        CaixaPostalDados cpd = new CaixaPostalDados();
        return cpd.listarCaixaPostal();
    }
}
