package br.insper.ecommerce.compra;

import java.util.ArrayList;

public class CompraService {

    ArrayList<Compra> compras = new ArrayList<>();
    
    public void cadastrarProduto(Compra compra){
        compras.add(compra);
    }

    public void listarProdutos(){
        for (Compra compra : compras){
            System.out.println("Nome do cliente: " + compra.getCliente());
            System.out.println("Data da compra: " + compra.getDataCompra());
            System.out.println("Preço total: R$" + compra.getPrecoTotal());
            System.out.println("Meio de pagamento:" + compra.getMeioPagamento());
        }
    }
 
}
