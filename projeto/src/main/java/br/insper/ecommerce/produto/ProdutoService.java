package br.insper.ecommerce.produto;

import java.util.ArrayList;

public class ProdutoService {

    ArrayList<Produto> produtos = new ArrayList<>();
    
    public void cadastrarProduto(String nome, double preco){
        produtos.add(new Produto(nome, preco));
    }

    public void listarProdutos(){
        for (Produto produto : produtos){
            System.out.println("Nome: "+produto.getNome());
            System.out.println("Preço: R$"+produto.getPreco());
            System.out.println("");
        }
    }

    public boolean excluirProduto(String nome){
        for (Produto produto : produtos){
            if(produto.getNome().equals(nome)){
                produtos.remove(produto);
                return true;
            }
        }
        return false;
    }

    public Produto buscarProduto(String nome){
        for (Produto produto : produtos){
            if(produto.getNome().equals(nome)){
                return produto;
            }
        }

        return null;
    }   
}
