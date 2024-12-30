package DOMAIN;

import DAO.ClienteMapDAO;
import DAO.IClienteDao;

import javax.swing.*;

public class App {
    private static IClienteDao iClienteDao;

    public static void main(String[] args) {
        iClienteDao = new ClienteMapDAO();
        /*
         Entrada de dados com JOptionPane:
          Abre uma janela pop-up para que o usuário insira informações.

            JOptionPane.INFORMATION_MESSAGE: Ícone de informação na janela.

         */


        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();

                /*
                Pra entender isso primeiro precisamos entender o metodo isOpcaoValida()
                Basicamente esse metodo vai ver se o usuario botou um numero em String de 1 a 5
                caso bote o programa retornara como true, caso não vai ser false
                por isso o sinal de ! antes do nome, significa que é diferente do metodo
                que irá ativar o sair
                 */


            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção invalida: digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)) {
            if (isOpcaoSair(opcao)) {
                sair();

            } else if (isOpcaoValida(opcao)) {
                if (isOpcaoCadastro(opcao)) {
                    String dados = JOptionPane.showInputDialog(null,
                            "Digite os dados do cliente separados por vígula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                            "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    cadastrar(dados);
                } else if (isOpcaoValida(opcao)) {
                    if (isOpcaoCobsultar(opcao)) {
                        String dados = JOptionPane.showInputDialog(null,
                                "Digite o cpf: ",
                                "Consultar", JOptionPane.INFORMATION_MESSAGE);
                        consultar(dados);

                    }
                    opcao = JOptionPane.showInputDialog(null,
                            "Opção invalida: digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                            "Green dinner", JOptionPane.INFORMATION_MESSAGE);
                
                }
            }
        }
    }

    private static void consultar(String dados) {
        //validar se foi passado somente o cpf
        Cliente cliente = iClienteDao.consultar(Long.parseLong(dados));
        if (cliente != null) {
            JOptionPane.showInputDialog(null,
                    "Cliente encontrado" + cliente.toString(),
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showInputDialog(null,
                    "Cliente não encontrado",
                    "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    private static boolean isOpcaoCobsultar(String opcao) {
        if ("3".equals(opcao)){
            return true;
        }
        return false;
    }
    private static void cadastrar(String dados) {
        String[] separarDados = dados.split(",");
        Cliente cliente = new Cliente(separarDados[0],separarDados[1],separarDados[2],separarDados[3],separarDados[4],separarDados[5],separarDados[6]);
        Boolean isCadastrado = iClienteDao.cadastrar(cliente);
        if (isCadastrado) {
            JOptionPane.showInputDialog(null,
                    "Cliente cadastrado com Sucesso",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showInputDialog(null,
                    "Cliente ja cadastrado",
                    "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isOpcaoCadastro(String opcao) {
        if ("1".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)) {
            return true;
        }
        return false;
    }


    private static void sair() {
        JOptionPane.showInputDialog(null,
                "Até logo: ",
                "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0); //encerra o prigrama
    }

    private static boolean isOpcaoValida(String opcao) {
        if("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) ||
            "4".equals(opcao) || "5".equals(opcao)) {

            return true;
        }
        return false;
    }
}
