package br.insper.ecommerce;

import br.insper.ecommerce.cliente.ClienteService;
import br.insper.ecommerce.produto.ProdutoService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String opcao = "0";

        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();
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
                System.out.println("Digite o nome do produto que você quer cadastrar:");
                String nome = scanner.nextLine();
                System.out.println("Digite o preço do produto que você quer cadastrar ex: 100.00:");
                double preco = Double.parseDouble(scanner.nextLine());

                produtoService.cadastrarProduto(nome, preco);
            }
            if (opcao.equalsIgnoreCase("5")) {
                produtoService.listarProdutos();
            }
            if (opcao.equalsIgnoreCase("6")) {
                System.out.println("Digite o nome do produto que você quer remover:");
                String nome = scanner.nextLine();
                boolean removeu = produtoService.excluirProduto(nome);

                if (removeu) {
                    System.out.println("Produto removido com sucesso");
                }else{
                    System.out.println("Produto não encontrado");
                }
            }
            if (opcao.equalsIgnoreCase("7")) {

            }
            if (opcao.equalsIgnoreCase("8")) {

            }

        }


    }

}