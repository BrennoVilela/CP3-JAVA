package br.com.fiap.model.loja;

public abstract class Produto {
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

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public double calcularDesconto(int estoque) {
        if (estoque > 50) {
            return preco * 0.10; // Desconto de 10% se o estoque for maior que 50
        } else if (estoque > 10) {
            return preco * 0.05; // Desconto de 5% se o estoque for maior que 10
        }
        return 0.0;
    }

    public double calcularDesconto(String cupom) {
        if (cupom.equalsIgnoreCase("BEMVINDO")){
            return preco * 0.40; //Desconto de 40% se o cupom BEMVINDO for aplicado
        } else{
            return 0.0;
        }
    }
}
