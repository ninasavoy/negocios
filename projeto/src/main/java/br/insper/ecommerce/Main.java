package br.insper.ecommerce;

import br.insper.ecommerce.cliente.Cliente;
import br.insper.ecommerce.cliente.ClienteService;
import br.insper.ecommerce.pagamento.Boleto;
import br.insper.ecommerce.pagamento.MeioPagamento;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String opcao = "0";

        ClienteService clienteService = new ClienteService();
        while(!opcao.equalsIgnoreCase("4")) {

            System.out.println("""
                    1 - Cadastrar Cliente
                    2 - Listar Clientes
                    3 - Excluir Cliente
                    4 - Cadastrar Produto
                    5 - Listar Produtos
                    6 - Excluir Produto
                    7 - Cadastrar Compra
                    8 - Listar Compras
                    9 - Sair
                    """);
            opcao = scanner.nextLine();
            if (opcao.equalsIgnoreCase("1")) {
                System.out.println("Digite o nome do cliente:");
                String nome = scanner.nextLine();
                System.out.println("Digite o CPF do cliente;");
                String cpf = scanner.nextLine();

                clienteService.cadastrarCliente(nome,cpf);
            }

            if (opcao.equalsIgnoreCase("2")) {
                clienteService.listarClientes();
            }

            if (opcao.equalsIgnoreCase("3")) {
                System.out.println("Digite o nome do cliente para deletar:");
                String cpf = scanner.nextLine();
                clienteService.excluirClientes(cpf);
            }
            if (opcao.equalsIgnoreCase("4")) {

            }
            if (opcao.equalsIgnoreCase("5")) {

            }
            if (opcao.equalsIgnoreCase("6")) {

            }
            if (opcao.equalsIgnoreCase("7")) {

            }
            if (opcao.equalsIgnoreCase("8")) {

            }

        }


    }

}