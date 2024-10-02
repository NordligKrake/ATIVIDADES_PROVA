import java.util.ArrayList;
import java.util.Scanner;

 class Filme {
    private String titulo;
    private int ano;
    private double avaliacao;

    public Filme(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
        this.avaliacao = 0.0;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }
}

    class CadastroFilmes {
    private ArrayList<Filme> filmes;

    public CadastroFilmes() {
        this.filmes = new ArrayList<>();
    }

    public void cadastrarFilme(String titulo, int ano) {
        Filme filme = new Filme(titulo, ano);
        filmes.add(filme);
    }

    public void avaliarFilme(String titulo, double avaliacao) {
        for (Filme filme : filmes) {
            if (filme.getTitulo().equals(titulo)) {
                filme.setAvaliacao(avaliacao);
                System.out.println("Avaliação do filme '" + titulo + "' atualizada com sucesso!");
                return;
            }
        }
        System.out.println("Filme não encontrado!");
    }

    public void listarFilmes() {
        for (Filme filme : filmes) {
            System.out.println("Título: " + filme.getTitulo() + ", Ano: " + filme.getAno() + ", Avaliação: " + filme.getAvaliacao());
        }
    }

    public static void main(String[] args) {
        CadastroFilmes cadastro = new CadastroFilmes();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opções:");
            System.out.println("1 - Cadastrar filme");
            System.out.println("2 - Avaliar filme");
            System.out.println("3 - Listar filmes");
            System.out.println("4 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do filme: ");
                    String titulo = scanner.next();
                    System.out.print("Digite o ano do filme: ");
                    int ano = scanner.nextInt();
                    cadastro.cadastrarFilme(titulo, ano);
                    break;
                case 2:
                    System.out.print("Digite o título do filme para avaliar: ");
                    String tituloAvaliar = scanner.next();
                    System.out.print("Digite a avaliação do filme (0-10): ");
                    double avaliacao = scanner.nextDouble();
                    cadastro.avaliarFilme(tituloAvaliar, avaliacao);
                    break;
                case 3:
                    cadastro.listarFilmes();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}