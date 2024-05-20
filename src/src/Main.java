import br.com.fiap.model.loja.Eletronico;
import br.com.fiap.model.loja.Livro;
import br.com.fiap.model.loja.Carrinho;
import br.com.fiap.model.loja.Item;
import br.com.fiap.model.loja.Produto;

import javax.swing.*;
import java.util.Arrays;

public class Main {
    private static Carrinho carrinho = new Carrinho();

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bem vindo ao nosso ecommerce!");

        String opcaoSelecionada;
        do {
            String[] opcoes1 = {"Acessar catálogo de livros", "Acessar opções de eletrônicos", "Acessar seu carrinho", "Encerrar Aplicativo"};
            opcaoSelecionada = mostrarMenu(opcoes1);

            switch (opcaoSelecionada) {
                case "Acessar catálogo de livros":
                    exibirCatalogoLivros(
                            new Livro("Pai Rico Pai Pobre",
                                    "É um livro de finanças pessoais que desafia as crenças tradicionais sobre dinheiro e educação financeira.",
                                    48.25,
                                    "Robert T. Kiyosaki",
                                    "Editora Alta Books",
                                    30),
                            new Livro("A Arte da Guerra",
                                    "A Arte da Guerra é um antigo tratado sobre estratégia militar que oferece lições atemporais sobre liderança, táticas e planejamento.",
                                    10,
                                    "Sun Tzu",
                                    "Editora Martin Claret",
                                    100),
                            new Livro("Outsider",
                                    "Outsider é um romance de suspense e horror escrito por Stephen King. A história começa com o assassinato brutal de um menino em uma pequena cidade.",
                                    80.70,
                                    "Stephen King",
                                    "Scribner",
                                    10)
                    );
                    break;
                case "Acessar opções de eletrônicos":
                    exibirCatalogoEletronicos(
                            new Eletronico("Iphone 14",
                                    "Celular da Apple lançado em 2022",
                                    3888,
                                    "Celular",
                                    "Apple",
                                    50),
                            new Eletronico("Samsung S23",
                                    "Celular da Samsung lançado em 2023",
                                    3087,
                                    "Celular",
                                    "Samsung",
                                    90),
                            new Eletronico("Computador Gamer",
                                    "Processador i9 9900k, 32 de ram e 4090",
                                    30000,
                                    "Computador",
                                    "Intel e Nvidia",
                                    4)
                    );
                    break;
                case "Acessar seu carrinho":
                    exibirCarrinho();
                    break;
                case "Encerrar Aplicativo":
                    JOptionPane.showMessageDialog(null, "Encerrando Aplicativo");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    break;
            }
        } while (!opcaoSelecionada.equals("Encerrar Aplicativo"));
    }

    static String mostrarMenu(String[] opcoes) {
        return (String) JOptionPane.showInputDialog(null,
                "Escolha uma opção:",
                "Selecione uma opção",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);
    }

    static void exibirCatalogoLivros(Livro... livros) {
        exibirCatalogo(livros, "Catálogo de Livros");
    }

    static void exibirCatalogoEletronicos(Eletronico... eletronicos) {
        exibirCatalogo(eletronicos, "Catálogo de Eletrônicos");
    }

    static void exibirCatalogo(Produto[] produtos, String titulo) {
        StringBuilder catalogo = new StringBuilder();
        for (Produto produto : produtos) {
            catalogo.append("Nome: ").append(produto.getNome()).append("\n");
            catalogo.append("Descrição: ").append(produto.getDescricao()).append("\n");
            catalogo.append("Preço: ").append(produto.getPreco()).append("\n");
            catalogo.append("Estoque: ").append(produto.getEstoque()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, catalogo.toString(), titulo, JOptionPane.INFORMATION_MESSAGE);
        adicionarAoCarrinho(produtos);
    }

    static void adicionarAoCarrinho(Produto... produtos) {
        String[] opcoes = Arrays.stream(produtos).map(Produto::getNome).toArray(String[]::new);
        String opcaoSelecionada = (String) JOptionPane.showInputDialog(null,
                "Escolha um produto para adicionar ao carrinho:",
                "Adicionar ao Carrinho",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);

        if (opcaoSelecionada != null) {
            for (Produto produto : produtos) {
                if (produto.getNome().equals(opcaoSelecionada)) {
                    carrinho.adicionarItem(produto);
                    JOptionPane.showMessageDialog(null, produto.getNome() + " foi adicionado ao carrinho.");
                    break;
                }
            }
        }
    }

    static void exibirCarrinho() {
        StringBuilder carrinhoTexto = new StringBuilder("Itens no Carrinho:\n\n");
        for (Item item : carrinho.getItens()) {
            carrinhoTexto.append(item.getProduto().getNome()).append(" - ")
                    .append(item.getQuantidade()).append(" unidade(s) - ")
                    .append("Preço total: ").append(item.getPrecoTotal()).append("\n");
        }

        carrinhoTexto.append("\n");

        String cupom = JOptionPane.showInputDialog("Digite o código do cupom de desconto:");
        if (cupom != null && !cupom.isEmpty()) {
            carrinho.aplicarCupom(cupom);
            carrinhoTexto.append("Cupom aplicado: ").append(cupom).append("\n");
            carrinhoTexto.append("Desconto total: ").append(carrinho.getDescontoTotal()).append("\n");
        }

        carrinhoTexto.append("Preço final: ").append(carrinho.getPrecoFinal()).append("\n");

        String[] itensCarrinho = carrinho.getItens().stream().map(item -> item.getProduto().getNome()).toArray(String[]::new);
        if (itensCarrinho.length > 0) {
            String itemParaRemover = (String) JOptionPane.showInputDialog(null,
                    "Escolha um item para remover do carrinho:",
                    "Remover do Carrinho",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    itensCarrinho,
                    itensCarrinho[0]);

            if (itemParaRemover != null && !itemParaRemover.isEmpty()) {
                carrinho.removerItem(itemParaRemover);
                JOptionPane.showMessageDialog(null, itemParaRemover + " foi removido do carrinho.");
            }
        }

        JOptionPane.showMessageDialog(null, carrinhoTexto.toString(), "Seu Carrinho", JOptionPane.INFORMATION_MESSAGE);
    }
}


