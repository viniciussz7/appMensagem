package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.Email;

public class EmailDados {
    
    public void cadastrarEmail(Email e) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Email> contatosEmail = new ArrayList<Email>();
        File arquivo = new File ("contatosEmail.ser");
        if (arquivo.exists()) {
            contatosEmail = listarEmail();
        }

        contatosEmail.add(e);
        FileOutputStream fluxo = new FileOutputStream(arquivo);
        try (ObjectOutputStream save = new ObjectOutputStream(fluxo)) {
            save.writeObject(contatosEmail);
        }
    }

    public ArrayList<Email> listarEmail() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Email> contatosEmail = new ArrayList<Email>();
        File arquivo = new File("contatosEmail.ser");
        if (arquivo.exists()) {
            FileInputStream fluxo = new FileInputStream(arquivo);
            ObjectInputStream load = new ObjectInputStream(fluxo);
            contatosEmail = (ArrayList<Email>) load.readObject();
            load.close();
            return contatosEmail;            
        } else {
            return contatosEmail;
        }
    }

    public void removerEmail(Email e) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Email> contatosEmail = new ArrayList<Email>();
        File arquivo = new File("contatosEmail.ser");
        if (arquivo.exists()) {
            contatosEmail = listarEmail();
        }
        
        for (Email email : contatosEmail) {
            if (e.getEnderecoEletronico().equals(email.getEnderecoEletronico())) {
                contatosEmail.remove(email); //remove(contatosEmail.indexOf(email))
                break;
            }
        }

        FileOutputStream fluxo = new FileOutputStream(arquivo);
        try (ObjectOutputStream save = new ObjectOutputStream(fluxo)) {
            save.writeObject(contatosEmail);
        }
    }

}
