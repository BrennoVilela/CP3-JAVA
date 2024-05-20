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

    @Override
    public double Desconto(String cupom) {
        double precoOriginal = getPreco();
        double precoDesconto;

        if (cupom.equalsIgnoreCase("NERD")) {
            precoDesconto = getPreco() * 0.20;
            return precoDesconto;
        } else {
            return precoOriginal;
        }
    }
}
