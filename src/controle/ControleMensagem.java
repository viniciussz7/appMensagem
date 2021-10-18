package controle;

import java.io.IOException;
import java.util.ArrayList;
import modelo.Mensagem;
import modelo.Contato;

public class ControleMensagem {
    
    //------------------cadastro----------------------
    public void cadastrarMensagem(String id, String data, String assunto, String conteudo, ArrayList<Contato> contatosDaMensagem) throws IOException, ClassNotFoundException {
        Mensagem msg = new Mensagem(id, data, assunto, conteudo, contatosDaMensagem);
        msg.cadastrarMensagem(msg);
    }

    //-----------------remoção------------------------
    public void removerMensagem(String id) throws IOException, ClassNotFoundException {
        Mensagem msg = pesquisarMensagem(id);
        msg.removeMensageml(msg);
    }

    //--------------pesquisa-------------------------
    public Mensagem pesquisarMensagem(String id) throws IOException, ClassNotFoundException {
        Mensagem msg = null;
        ArrayList<Mensagem> lsMensagem = listarMensagem();
        for (Mensagem mensagem : lsMensagem) {
            if (id.equals(mensagem.getId())) {
                msg = mensagem;
                break;
            }
        }
        return msg;
    }

    //--------------------lista----------------------
    public ArrayList<Mensagem> listarMensagem() throws IOException, ClassNotFoundException {
        Mensagem msg = new Mensagem();
        return msg.listarMensagem();
    }

    //-----------------imprimir----------------------
    public String imprimirMensagem() throws IOException, ClassNotFoundException {
        String msg = "";
        ArrayList<Mensagem> lsMensagem = listarMensagem();
        for (Mensagem mensagem : lsMensagem) {
            msg += mensagem.imprimirMensagem();
        }
        return msg;
    }
}
