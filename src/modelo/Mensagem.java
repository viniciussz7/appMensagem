package modelo;

import java.util.ArrayList;
import java.io.IOException;
import java.io.Serializable;

import dados.MensagemDados;

public class Mensagem implements Serializable {
    private String id;
    private String data;
    private String assunto;
    private String conteudo;

    ArrayList<Contato> contatosDaMensagem = new ArrayList<Contato>();

    public Mensagem() {}

    public Mensagem(String id, String data, String assunto, String conteudo, ArrayList<Contato> contatosDaMensagem) {
        this.id = id;
        this.data = data;
        this.assunto = assunto;
        this.conteudo = conteudo;
        this.contatosDaMensagem = contatosDaMensagem;
    }

    //-----------------------setters------------------------------------
    public void setId(String id) {
        this.id = id;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
    //-------------------getters---------------------------------------
    public String getId() {
        return this.id;
    }
    public String getData() {
        return this.data;
    }
    public String getAssunto() {
        return this.assunto;
    }
    public String getConteudo() {
        return this.conteudo;
    }

    //------------------contatos---------------------------------------
    public void inserirContatoNaMensagem(Contato contato) {
        this.contatosDaMensagem.add(contato);
    }

    public void removerContatoDaMensagem(Contato contato) {
        this.contatosDaMensagem.remove(contato);
    }

    //------------------imprimir---------------------------------------
    public String imprimirMensagem() {
        String mensagem = "\nID: " + getId() + "\nData: " + getData() + "\nAssunto: " + getAssunto() + "\nPara: ";
        for (Contato contato : contatosDaMensagem) {
            mensagem += contato.getNome() + "(" + contato.getTipo() + "); ";
        }
        mensagem += "\nMensagem: . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .\n";
        mensagem += getConteudo();
        mensagem += "\n. . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .\n";

        return mensagem;
    }

    //------------------arquivo-------------------------------------
    public void cadastrarMensagem(Mensagem msg) throws IOException, ClassNotFoundException {
        MensagemDados msgd = new MensagemDados();
        msgd.cadastrarMensagem(msg);
    }
    public void removeMensageml(Mensagem msg) throws IOException, ClassNotFoundException {
        MensagemDados msgd = new MensagemDados();
        msgd.removerMensagem(msg);
    }
    public ArrayList<Mensagem> listarMensagem() throws IOException, ClassNotFoundException {
        MensagemDados msgd = new MensagemDados();
        return msgd.listarMensagem();
    }
}
