package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.Mensagem;

public class MensagemDados {
    public void cadastrarMensagem(Mensagem msg) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();
        File arquivo = new File ("mensagem.ser");
        if (arquivo.exists()) {
            mensagens = listarMensagem();
        }

        mensagens.add(msg);
        FileOutputStream fluxo = new FileOutputStream(arquivo);
        try(ObjectOutputStream save = new ObjectOutputStream(fluxo)) {
            save.writeObject(mensagens);
        }
    }

    public ArrayList<Mensagem> listarMensagem() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();
        File arquivo = new File ("mensagem.ser");
        if (arquivo.exists()) {
            FileInputStream fluxo = new FileInputStream(arquivo);
            ObjectInputStream load = new ObjectInputStream(fluxo);
            mensagens = (ArrayList<Mensagem>)load.readObject();
            load.close();
            return mensagens;            
        } else {
            return mensagens;
        }
    }

    public void removerMensagem(Mensagem msg) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();
        File arquivo = new File ("mensagem.ser");
        if (arquivo.exists()) {
            mensagens = listarMensagem();
        }

        for (Mensagem mensagem : mensagens) {
            if (msg.getId().equals(mensagem.getId())) {
                mensagens.remove(mensagem);
                break;
            }
        }

        FileOutputStream fluxo = new FileOutputStream(arquivo);
        try(ObjectOutputStream save = new ObjectOutputStream(fluxo)) {
            save.writeObject(mensagens);
        }
    }
}
