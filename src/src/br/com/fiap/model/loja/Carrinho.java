package br.com.fiap.model.loja;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Item> itens;
    private double descontoTotal;

    public Carrinho() {
        this.itens = new ArrayList<>();
        this.descontoTotal = 0.0;
    }

    public void adicionarItem(Produto produto) {
        // Verifica se o produto já está no carrinho
        for (Item item : itens) {
            if (item.getProduto().equals(produto)) {
                item.incrementarQuantidade();
                return;
            }
        }
        itens.add(new Item(produto));
    }

    public void removerItem(String nomeProduto) {
        // Verifica se o produto está no carrinho e remove
        for (Item item : itens) {
            if (item.getProduto().getNome().equals(nomeProduto)) {
                itens.remove(item);
                return;
            }
        }
    }

    public void limparCarrinho() {
        itens.clear();
        descontoTotal = 0.0;
    }

    public double calcularPrecoTotal() {
        double precoTotal = 0.0;
        for (Item item : itens) {
            precoTotal += item.getPrecoTotal();
        }
        return precoTotal;
    }

    public void aplicarCupom(String cupom) {
        for (Item item : itens) {
            double desconto = item.getProduto().calcularDesconto(cupom);
            descontoTotal += desconto;
        }
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getDescontoTotal() {
        return descontoTotal;
    }

    public double getPrecoFinal() {
        return calcularPrecoTotal() - descontoTotal;
    }
}
