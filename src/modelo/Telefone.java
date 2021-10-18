package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import dados.TelefoneDados;

public class Telefone implements Contato, Serializable {
    private String nome;
    private int ddd;
    private long numero;
    private String operadora;

    public Telefone(){}

    public Telefone(String nome, int ddd, long numero, String operadora) {
        this.nome = nome;
        this.ddd = ddd;
        this.numero = numero;
        this.operadora = operadora;
    }

    //-----------------------setters------------------------------------
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDdd(int ddd) {
        this.ddd = ddd;
    }
    public void setNumero(long numero) {
        this.numero = numero;
    }
    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    //-------------------getters---------------------------------------
    public String getNome() { //------Interface--------
        return this.nome;
    }
    public int getDdd() {
        return this.ddd;
    }
    public long getNumero() {
        return this.numero;
    }
    public String getOperadora() {
        return this.operadora;
    }
    public String getTipo() { //------Interface--------
        return "Telefone";
    }
    public String getContato() { //------Interface--------
        return "\n|Tipo|: " + getTipo() +
            "\nNome: " + getNome() +
            "\nNúmero: " + "(" + getDdd() + ") " + getNumero() +
            "\nOperadora: " + getOperadora();
    }

    //------------------arquivo-------------------------------------
    public void cadastrarTelefone(Telefone t) throws IOException, ClassNotFoundException {
        TelefoneDados td = new TelefoneDados();
        td.cadastrarTelefone(t);
    }
    public void removerTelefone(Telefone t) throws IOException, ClassNotFoundException {
        TelefoneDados td = new TelefoneDados();
        td.removerTelefone(t);
    }
    public ArrayList<Telefone> listarTelefone() throws IOException, ClassNotFoundException {
        TelefoneDados td = new TelefoneDados();
        return td.listarTelefone();
    }
}
