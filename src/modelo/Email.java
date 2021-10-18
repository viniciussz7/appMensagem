package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import dados.EmailDados;

public class Email implements Contato, Serializable {
    private String nome;
    private String enderecoEletronico;

    public Email(){}

    public Email(String nome, String enderecoEletronico) {
        this.nome = nome;
        this.enderecoEletronico = enderecoEletronico;
    }

    //-----------------------setters------------------------------------
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEnderecoEletronico(String enderecoEletronico) {
        this.enderecoEletronico = enderecoEletronico;
    }

    //-------------------getters---------------------------------------
    public String getNome() { //------Interface--------
        return this.nome;
    }
    public String getEnderecoEletronico() {
        return this.enderecoEletronico;
    }
    public String getTipo() { //------Interface--------
        return "Email";
    }
    public String getContato() { //------Interface--------
        return "\n|Tipo|: " + getTipo() +
            "\nNome: " + getNome() +
            "\nEmail: " + getEnderecoEletronico();
    }

    //------------------arquivo-------------------------------------
    public void cadastrarEmail(Email e) throws IOException, ClassNotFoundException {
        EmailDados ed = new EmailDados();
        ed.cadastrarEmail(e);
    }
    public void removerEmail(Email e) throws IOException, ClassNotFoundException {
        EmailDados ed = new EmailDados();
        ed.removerEmail(e);
    }
    public ArrayList<Email> listarEmail() throws IOException, ClassNotFoundException {
        EmailDados ed = new EmailDados();
        return ed.listarEmail();
    }

}
