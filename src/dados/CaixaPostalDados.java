package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.CaixaPostal;

public class CaixaPostalDados {

    public void cadastrarCaixaPostal(CaixaPostal cx) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<CaixaPostal> contatosCxPostal = new ArrayList<CaixaPostal>();
        File arquivo = new File ("contatosCxPostal.ser");
        if (arquivo.exists()) {
            contatosCxPostal = listarCaixaPostal();
        }

        contatosCxPostal.add(cx);
        FileOutputStream fluxo = new FileOutputStream(arquivo);
        try (ObjectOutputStream save = new ObjectOutputStream(fluxo)) {
            save.writeObject(contatosCxPostal);
        }
    }

    public ArrayList<CaixaPostal> listarCaixaPostal() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<CaixaPostal> contatosCxPostal = new ArrayList<CaixaPostal>();
        File arquivo = new File("contatosCxPostal.ser");
        if (arquivo.exists()) {
            FileInputStream fluxo = new FileInputStream(arquivo);
            ObjectInputStream load = new ObjectInputStream(fluxo);
            contatosCxPostal = (ArrayList<CaixaPostal>) load.readObject();
            load.close();
            return contatosCxPostal;           
        } else {
            return contatosCxPostal;
        }
    }

    public void removerCaixaPostal(CaixaPostal cx) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<CaixaPostal> contatosCxPostal = new ArrayList<CaixaPostal>();
        File arquivo = new File("contatosCxPostal.ser");
        if (arquivo.exists()) {
            contatosCxPostal = listarCaixaPostal();
        }

        for (CaixaPostal caixaPostal : contatosCxPostal) {
            if (cx.getNome().equalsIgnoreCase(caixaPostal.getNome()) && cx.getEndereco().equalsIgnoreCase(caixaPostal.getEndereco())) {
                contatosCxPostal.remove(caixaPostal); //remove(contatosCxPostal.indexOf(caixaPostal))
                break;
            }
        }

        FileOutputStream fluxo = new FileOutputStream(arquivo);
        try (ObjectOutputStream save = new ObjectOutputStream(fluxo)) {
            save.writeObject(contatosCxPostal);
        }
    }
}
