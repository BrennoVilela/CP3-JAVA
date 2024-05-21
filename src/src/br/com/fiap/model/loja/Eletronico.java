package br.com.fiap.model.loja;

public class Eletronico extends Produto {
    private String categoria;
    private String fabricante;

    public Eletronico(String nome, String descricao, double preco, String categoria, String fabricante, int estoque) {
        super(nome, descricao, preco, estoque);
        this.categoria = categoria;
        this.fabricante = fabricante;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public double desconto(String cupom) {
        // Obter o preço original do produto
        double precoOriginal = getPreco();
        // Inicializar variável para armazenar o preço com desconto
        double precoDesconto = precoOriginal;

        // Verificar se o cupom é "NERD" e se o produto é um eletrônico
        if (cupom.equalsIgnoreCase("NERD")) {
            // Se sim, aplicar um desconto de 20%
            precoDesconto = precoOriginal * 0.8; // 20% de desconto (100% - 20% = 80% do preço original)
        }

        // Retornar o preço com desconto
        return precoDesconto;
    }
}
