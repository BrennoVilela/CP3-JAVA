package br.com.fiap.model.loja;

public class Produto {
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;

    public Produto(String nome, String descricao, double preco, int estoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double Desconto(String cupom) {
        double precoOriginal = getPreco();
        double precoDesconto;

        if (cupom.equalsIgnoreCase("BEMVINDO")) {
            precoDesconto = getPreco() * 0.40;
            return precoDesconto;
        } else {
            return precoOriginal;
        }
    }

    public double Desconto(int estoque) {
        double precoOriginal = getPreco();
        double precoDesconto;
        if (estoque >= 10) {
            precoDesconto = getPreco() * 0.05;
            return precoDesconto;
        } else {
            return precoOriginal;
        }
    }
}
