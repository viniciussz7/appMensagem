package controle;

import java.io.IOException;
import java.util.ArrayList;
import modelo.CaixaPostal;
import modelo.Email;
import modelo.Telefone;

public class ControleContato {

    //------------------cadastro----------------------
    public void cadastrarContato(String nome, String endereco, String cidade, String cep) throws IOException, ClassNotFoundException {
        CaixaPostal cx = new CaixaPostal(nome, endereco, cidade, cep);
        cx.cadastrarCaixaPostal(cx);
    }

    public void cadastrarContato(String nome, String enderecoEletronico) throws IOException, ClassNotFoundException {
        Email e = new Email(nome, enderecoEletronico);
        e.cadastrarEmail(e);
    }

    public void cadastrarContato(String nome, int ddd, long numero, String operadora) throws IOException, ClassNotFoundException {
        Telefone t = new Telefone(nome, ddd, numero, operadora);
        t.cadastrarTelefone(t);
    }

    //-----------------remoção------------------------
    public void removerContato(String nome, String endereco) throws IOException, ClassNotFoundException {
        CaixaPostal cx = pesquisarContato(nome,endereco);
        cx.removerCaixaPostal(cx);
    }

    public void removerContato(String enderecoEletronico) throws IOException, ClassNotFoundException {
        Email e = pesquisarContato(enderecoEletronico);
        e.removerEmail(e);
    }

    public void removerContato(int ddd, long numero) throws IOException, ClassNotFoundException {
        Telefone t = pesquisarContato(ddd, numero);
        t.removerTelefone(t);
    }

    //--------------pesquisa-------------------------
    public CaixaPostal pesquisarContato(String nome, String endereco) throws IOException, ClassNotFoundException {
        CaixaPostal cx = null;
        ArrayList<CaixaPostal> lsCaixaPostal = listarCaixaPostal();
        for (CaixaPostal caixaPostal : lsCaixaPostal) {
            if (nome.equalsIgnoreCase(caixaPostal.getNome()) && endereco.equalsIgnoreCase(caixaPostal.getEndereco())) {
                cx = caixaPostal;
                break;
            }
        }
        return cx;
    }

    public Email pesquisarContato(String enderecoEletronico) throws IOException, ClassNotFoundException {
        Email e = null;
        ArrayList<Email> lsEmail = listarEmail();
        for (Email email : lsEmail) {
            if (enderecoEletronico.equals(email.getEnderecoEletronico())) {
                e = email;
                break;
            }
        }
        return e;
    }

    public Telefone pesquisarContato(int ddd, long numero) throws IOException, ClassNotFoundException {
        Telefone t = null;
        ArrayList<Telefone> lsTelefone = listarTelefone();
        for (Telefone telefone : lsTelefone) {
            if (ddd == telefone.getDdd() && numero == telefone.getNumero()) {
                t = telefone;
                break;
            }
        }
        return t;
    }

    //--------------------lista----------------------
    public ArrayList<CaixaPostal> listarCaixaPostal() throws IOException, ClassNotFoundException {
        CaixaPostal cx = new CaixaPostal();
        return cx.listarCaixaPostal();
    }

    public ArrayList<Email> listarEmail() throws IOException, ClassNotFoundException {
        Email e = new Email();
        return e.listarEmail();
    }

    public ArrayList<Telefone> listarTelefone() throws IOException, ClassNotFoundException {
        Telefone t = new Telefone();
        return t.listarTelefone();
    }

    //----------------------imprimir---------------------------
    public String getContato() throws IOException, ClassNotFoundException {
        String contatos = "";
        ArrayList<CaixaPostal> lsCaixaPostal = listarCaixaPostal();
        ArrayList<Email> lsEmail = listarEmail();
        ArrayList<Telefone> lsTelefone = listarTelefone();

        if (!lsCaixaPostal.isEmpty()) {
            for (CaixaPostal caixaPostal : lsCaixaPostal) {
                contatos += caixaPostal.getContato() + "\n---------------------\n";
            }            
        }

        if (!lsEmail.isEmpty()) {
            for (Email email : lsEmail) {
                contatos += email.getContato() + "\n---------------------\n";
            }            
        }

        if (!lsTelefone.isEmpty()) {
            for (Telefone telefone : lsTelefone) {
                contatos += telefone.getContato() + "\n---------------------\n";
            }            
        }

        return contatos;
    }


}
