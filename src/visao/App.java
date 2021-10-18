package visao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import modelo.Contato;
import controle.ControleContato;
import controle.ControleMensagem;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class App {

    public static String menuPrincipal() {
        String title = "****** |APP MENSAGEM| ******\n";
        String menu = "\nDigite:" +
                    "\n1 - Cadastrar contato" +
                    "\n2 - Pesquisar contato" +
                    "\n3 - Exibir lista de contatos" +
                    "\n4 - Remover contato" +
                    "\n5 - Cadastrar mensagem" +
                    "\n6 - Exibir mensagens salvas" +
                    "\n7 - Remover mensagem" +
                    "\n0 - Sair";
        return title + menu;
    }

    public static String menuContatos() {
        return "Escolha o tipo de contato:\n" +
                "1 - Caixa Postal\n" +
                "2 - Email\n" +
                "3 - Telefone";
    }

    public static void main(String[] args) throws Exception {
        ControleContato cc = new ControleContato();
        ControleMensagem cm = new ControleMensagem();

        int key = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal()));

        while (key != 0) {
            switch (key) {
                case 1: { //Cadastrar um contato
                    int op = Integer.parseInt(JOptionPane.showInputDialog(menuContatos()));
                    switch (op) {
                        case 1: { //caixa postal
                            String nome = JOptionPane.showInputDialog("Informe o nome:");
                            String endereco = JOptionPane.showInputDialog("Endereço:\n(Ex: logradouro, nº, bairro, complemento)");
                            String cidade = JOptionPane.showInputDialog("Cidade:");
                            String cep = JOptionPane.showInputDialog("CEP:\n(Ex: 00000-000");
                            try {
                                cc.cadastrarContato(nome, endereco, cidade, cep);
                                JOptionPane.showMessageDialog(null, "Contato cadastrado com sucesso!");
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            } catch (ClassNotFoundException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            break;
                        }

                        case 2: { //email
                            String nome = JOptionPane.showInputDialog("Informe o nome:");
                            String enderecoEletronico = JOptionPane.showInputDialog("Endereço de email");
                            try {
                                if (enderecoEletronico.indexOf("@") != -1) {
                                    cc.cadastrarContato(nome, enderecoEletronico);
                                    JOptionPane.showMessageDialog(null, "Contato cadastrado com sucesso!");    
                                } else {
                                    JOptionPane.showMessageDialog(null, "Utilize um email válido.");
                                }                                
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            } catch (ClassNotFoundException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }                            
                            break;
                        }

                        case 3: { //telefone
                            String nome = JOptionPane.showInputDialog("Informe o nome:");
                            int ddd = Integer.parseInt(JOptionPane.showInputDialog("Informe o DDD:"));
                            long numero = Long.parseLong(JOptionPane.showInputDialog("Informe o número:\n(Ex: 922220000"));
                            String operadora = JOptionPane.showInputDialog("Qual a operadora?");
                            try {
                                cc.cadastrarContato(nome, ddd, numero, operadora);
                                JOptionPane.showMessageDialog(null, "Contato cadastrado com sucesso!");
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            } catch (ClassNotFoundException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            break;
                        }                            
                    
                        default: {
                            break;
                        }
                    }
                    break;
                }

                case 2: { //Pesquisar um contato
                    int op = Integer.parseInt(JOptionPane.showInputDialog(menuContatos()));
                    switch (op) {
                        case 1: { //caixa postal
                            String nome = JOptionPane.showInputDialog("Informe o nome:");
                            String endereco = JOptionPane.showInputDialog("Informe o endereço do contato:\n(Ex: logradouro, nº, bairro, complemento)");
                            try {
                                if (cc.pesquisarContato(nome, endereco) != null) {
                                    JOptionPane.showMessageDialog(null, cc.pesquisarContato(nome, endereco).getContato());
                                } else {
                                    JOptionPane.showMessageDialog(null, "Contato não encontrado.");
                                }
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            } catch (ClassNotFoundException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            break;
                        }

                        case 2: { //email
                            String enderecoEletronico = JOptionPane.showInputDialog("Informe o endereço de email do contato:");
                            try {
                                if (cc.pesquisarContato(enderecoEletronico) != null) {
                                    JOptionPane.showMessageDialog(null, cc.pesquisarContato(enderecoEletronico).getContato());
                                } else {
                                    JOptionPane.showMessageDialog(null, "Contato não encontrado.");
                                }
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            } catch (ClassNotFoundException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            break;
                        }

                        case 3: { //telefone
                            int ddd = Integer.parseInt(JOptionPane.showInputDialog("Informe o DDD:"));
                            long numero = Long.parseLong(JOptionPane.showInputDialog("Informe o número:\n(Ex: 922220000"));
                            try {
                                if (cc.pesquisarContato(ddd, numero) != null) {
                                    JOptionPane.showMessageDialog(null, cc.pesquisarContato(ddd, numero).getContato());
                                } else {
                                    JOptionPane.showMessageDialog(null, "Contato não encontrado.");
                                }
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            } catch (ClassCastException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            break;
                        }                            
                    
                        default: {
                            break;
                        }
                    }
                    break;
                }

                case 3: { //Exibir lista de contatos
                    try {
                        if (cc.getContato() == "") {
                            JOptionPane.showMessageDialog(null, "Não há contatos cadastrados.");
                        } else {
                            JOptionPane.showMessageDialog(null, cc.getContato());                            
                        }
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    } catch (ClassNotFoundException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                }

                case 4: { //Remover um contato
                    int op = Integer.parseInt(JOptionPane.showInputDialog(menuContatos()));
                    switch (op) {
                        case 1: { //caixa postal
                            String nome = JOptionPane.showInputDialog("Informe o nome:");
                            String endereco = JOptionPane.showInputDialog("Informe o endereço do contato:\n(Ex: logradouro, nº, bairro, complemento)");
                            try {
                                if (cc.pesquisarContato(nome, endereco) != null) {
                                    cc.removerContato(nome, endereco);
                                    JOptionPane.showMessageDialog(null, "Contato removido!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Não existe esse contato. Impossível remover!");
                                }
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            } catch (ClassNotFoundException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            break;
                        }

                        case 2: { //email
                            String enderecoEletronico = JOptionPane.showInputDialog("Informe o endereço de email do contato:");
                            try {
                                if (cc.pesquisarContato(enderecoEletronico) != null) {
                                    cc.removerContato(enderecoEletronico);
                                    JOptionPane.showMessageDialog(null, "Contato removido!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Não existe esse contato. Impossível remover!");
                                }
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            } catch (ClassNotFoundException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            break;
                        }

                        case 3: { //telefone
                            int ddd = Integer.parseInt(JOptionPane.showInputDialog("Informe o DDD:"));
                            long numero = Long.parseLong(JOptionPane.showInputDialog("Informe o número do contato:\n(Ex: 922220000"));
                            try {
                                if (cc.pesquisarContato(ddd, numero) != null) {
                                    cc.removerContato(ddd, numero);
                                    JOptionPane.showMessageDialog(null, "Contato removido!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Não existe esse contato. Impossível remover!");
                                }
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            } catch (ClassNotFoundException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            break;
                        }                            
                    
                        default: {
                            break;
                        }
                    }
                    break;
                }

                case 5: { //Cadastrar uma mensagem
                    String id = JOptionPane.showInputDialog("Informe um código de identificação(ID) qualquer para a mensagem:\n(Esse código será usado para pesquisar/remover a mensagem)");
                    String assunto = JOptionPane.showInputDialog("Assunto:");
                    String conteudo = JOptionPane.showInputDialog("Escreva a mensagem:");
                    ArrayList<Contato> contatosDaMensagem = new ArrayList<Contato>();

                    int condition;
                    JOptionPane.showMessageDialog(null, "Informe o(s) contato(s) que vão receber a mensagem:\n");
                    do {
                        int op = Integer.parseInt(JOptionPane.showInputDialog("Informe o(s) contato(s) que vão receber a mensagem:\nEscolha o tipo:\n" + menuContatos()));
                        switch (op) {
                            case 1: {// enviando para uma caixa postal
                                String nome = JOptionPane.showInputDialog("Informe o nome:");
                                String endereco = JOptionPane.showInputDialog("Informe o endereço do contato:\n(Ex: logradouro, nº, bairro, complemento)");
                                try {
                                    if (cc.pesquisarContato(nome, endereco) != null) {
                                        contatosDaMensagem.add(cc.pesquisarContato(nome, endereco));
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Contato não encontrado. Volte ao menu principal e cadastre-o.");
                                    }
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                } catch (ClassNotFoundException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                                break;
                            }
                            
                            case 2: { //enviando para um email
                                String enderecoEletronico = JOptionPane.showInputDialog("Informe o endereço de email do contato:");
                                try {
                                    if (cc.pesquisarContato(enderecoEletronico) != null) {
                                        contatosDaMensagem.add(cc.pesquisarContato(enderecoEletronico));
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Contato não encontrado. Volte ao menu principal e cadastre-o.");
                                    }
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                } catch (ClassNotFoundException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                                break;
                            }

                            case 3: { //enviando para um telefone
                                int ddd = Integer.parseInt(JOptionPane.showInputDialog("Informe o DDD:"));
                                long numero = Long.parseLong(JOptionPane.showInputDialog("Informe o número:\n(Ex: 922220000"));
                                try {
                                    if (cc.pesquisarContato(ddd, numero) != null) {
                                        contatosDaMensagem.add(cc.pesquisarContato(ddd, numero));
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Contato não encontrado. Volte ao menu principal e cadastre-o.");
                                    }
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                } catch (ClassCastException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                                break;
                            }
                        
                            default: {
                                break;
                            }
                        }

                        condition = Integer.parseInt(JOptionPane.showInputDialog("Deseja inserir outro contato? \n1-Sim \n2-Não"));

                    } while (condition == 1);

                    Calendar c = Calendar.getInstance();
                    Date data = c.getTime();
                    DateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String dataFormatada = f.format(data); 

                    try {
                        cm.cadastrarMensagem(id, dataFormatada, assunto, conteudo, contatosDaMensagem);
                        JOptionPane.showMessageDialog(null, "Mensagem cadastrada com sucesso!");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    } catch (ClassNotFoundException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                }

                case 6: { //Exibir as mensagens salvas
                    try {
                        if (cm.imprimirMensagem() == "") {
                            JOptionPane.showMessageDialog(null, "Não há mensagens salvas.");
                        } else {
                            JOptionPane.showMessageDialog(null, cm.imprimirMensagem());                            
                        }
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    } catch (ClassNotFoundException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                }

                case 7: { //Remover uma mensagem
                    String id = JOptionPane.showInputDialog("Informe o código identificador(ID) da mensagem:");
                    try {
                        if (cm.pesquisarMensagem(id) != null) {
                            cm.removerMensagem(id);
                            JOptionPane.showMessageDialog(null, "Mensagem removida.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Essa mensagem não existe. Verifique se o ID está correto.");
                        }
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    } catch (ClassNotFoundException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                }                    
            
                default: {
                    break;
                }
            }
            key = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal()));
        }
    }
}
