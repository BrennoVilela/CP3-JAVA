package br.com.fiap.model.loja;

import java.util.ArrayList;
import java.util.Iterator;
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
        Iterator<Item> iterator = itens.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getProduto().getNome().equals(nomeProduto)) {
                iterator.remove();
                return;
            }
        }
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getDescontoTotal() {
        return descontoTotal;
    }

    public void aplicarCupom(String cupom) {
        descontoTotal = 0.0;
        for (Item item : itens) {
            descontoTotal += item.getProduto().Desconto(cupom) * item.getQuantidade();
        }
    }

    public double getPrecoFinal() {
        double precoTotal = 0.0;
        for (Item item : itens) {
            precoTotal += item.getPrecoTotal();
        }
        return precoTotal - descontoTotal;
    }
}
