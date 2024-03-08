package br.insper.ecommerce;

import br.insper.ecommerce.cliente.Cliente;
import br.insper.ecommerce.cliente.ClienteService;
import br.insper.ecommerce.compra.Compra;
import br.insper.ecommerce.compra.CompraService;
import br.insper.ecommerce.compra.Item;
import br.insper.ecommerce.pagamento.Boleto;
import br.insper.ecommerce.pagamento.CartaoCredito;
import br.insper.ecommerce.pagamento.CartaoDebito;
import br.insper.ecommerce.pagamento.MeioPagamento;
import br.insper.ecommerce.pagamento.Pix;
import br.insper.ecommerce.produto.Produto;
import br.insper.ecommerce.produto.ProdutoService;

import java.time.LocalDateTime;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String opcao = "0";

        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();
        CompraService compraService = new CompraService();

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
                Compra compra = new Compra();

                System.out.println("Digite o cpf do cliente:");
                String cpf = scanner.nextLine();
                Cliente cliente = clienteService.buscarCliente(cpf);
                compra.setCliente(cliente);
                LocalDateTime data = LocalDateTime.now();
                compra.setDataCompra(data);
                
                boolean ambicioso = true;
                while (ambicioso) {
                    System.out.println("Digite o nome do produto:");
                    String nome = scanner.nextLine();
                    Produto produto = produtoService.buscarProduto(nome);
                    System.out.println("Digite a quantidade que você deseja comprar:");
                    int quantidade = scanner.nextInt();
                    Item item = new Item(quantidade, produto);
                    compra.adicionarItem(item);
                    System.out.println("Você deseja adicionar mais um item?");
                    String resposta = scanner.nextLine();
                    if (!resposta.toLowerCase().equals("sim")) {
                        ambicioso = false;
                    }
                }
                System.out.println("Qual será o método de pagamento");
                System.out.println("""
                    1 - Cartão de Crédito
                    2 - Cartão de Débito
                    3 - Boleto
                    4 - Pix
                    """);
                String metodo = scanner.nextLine();
                MeioPagamento dindin = null;
                if (metodo.equalsIgnoreCase("1")) {
                    dindin = new CartaoCredito();
                }
                if (metodo.equalsIgnoreCase("2")) {
                    dindin = new CartaoDebito();
                }
                if (metodo.equalsIgnoreCase("3")) {
                    dindin = new Boleto();
                }
                if (metodo.equalsIgnoreCase("4")) {
                    dindin = new Pix();
                }
                compra.setMeioPagamento(dindin);
                compra.calculaPrecoTotal();
                compraService.cadastrarProduto(compra);
    
            }
            if (opcao.equalsIgnoreCase("8")) {
                compraService.listarProdutos();
            }

        }
    }

}