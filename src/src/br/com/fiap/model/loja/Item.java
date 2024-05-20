package br.com.fiap.model.loja;

public class Item {
    private Produto produto;
    private int quantidade;

    public Item(Produto produto) {
        this.produto = produto;
        this.quantidade = 1; // Inicializa a quantidade como 1 quando o item é adicionado ao carrinho
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void incrementarQuantidade() {
        quantidade++;
    }

    public void decrementarQuantidade() {
        if (quantidade > 0) {
            quantidade--;
        }
    }

    public double getPrecoTotal() {
        return produto.getPreco() * quantidade;
    }
}
