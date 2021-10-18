package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.Telefone;

public class TelefoneDados {
    
    public void cadastrarTelefone(Telefone t) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Telefone> contatosTelefone = new ArrayList<Telefone>();
        File arquivo = new File ("contatosTelefone.ser");
        if (arquivo.exists()) {
            contatosTelefone = listarTelefone();
        }

        contatosTelefone.add(t);
        FileOutputStream fluxo = new FileOutputStream(arquivo);
        try (ObjectOutputStream save = new ObjectOutputStream(fluxo)) {
            save.writeObject(contatosTelefone);
        }
    }

    public ArrayList<Telefone> listarTelefone() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Telefone> contatosTelefone = new ArrayList<Telefone>();
        File arquivo = new File("contatosTelefone.ser");
        if (arquivo.exists()) {
            FileInputStream fluxo = new FileInputStream(arquivo);
            ObjectInputStream load = new ObjectInputStream(fluxo);
            contatosTelefone = (ArrayList<Telefone>) load.readObject();
            load.close();
            return contatosTelefone;            
        } else {
            return contatosTelefone;
        }
    }

    public void removerTelefone(Telefone t) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Telefone> contatosTelefone = new ArrayList<Telefone>();
        File arquivo = new File("contatosTelefone.ser");
        if (arquivo.exists()) {
            contatosTelefone = listarTelefone();
        }
        
        for (Telefone telefone : contatosTelefone) {
            if (t.getDdd() == telefone.getDdd() && t.getNumero() == telefone.getNumero()) {
                contatosTelefone.remove(telefone); //remove(contatosTelefone.indexOf(telefone))
                break;
            }
        }

        FileOutputStream fluxo = new FileOutputStream(arquivo);
        try (ObjectOutputStream save = new ObjectOutputStream(fluxo)) {
            save.writeObject(contatosTelefone);
        }
    }


}
