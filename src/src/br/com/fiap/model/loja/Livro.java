package br.com.fiap.model.loja;

public class Livro extends Produto {

    private String autor;
    private String editora;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Livro(String nome, String descricao, double preco, String autor, String editora, int estoque) {
        super(nome, descricao, preco, estoque);
        this.autor = autor;
        this.editora = editora;
    }

    public double Desconto() {
        double precoOriginal = getPreco();
        double precoDesconto;
        if (getEstoque() >= 50) {
            precoDesconto = precoOriginal * 0.90; // Aplica 10% de desconto
            return precoDesconto;
        } else {
            return precoOriginal;
        }
    }
}
