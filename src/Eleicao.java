import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Eleicao {
    private Map<String, Integer> candidatos;
    private Map<String, Integer> votos;

    public Eleicao() {
        this.candidatos = new HashMap<>();
        this.votos = new HashMap<>();
    }

    public void adicionarCandidato(String nomeCandidato) {
        this.candidatos.put(nomeCandidato, 0);
    }

    public void votar(String nomeCandidato) {
        if (this.candidatos.containsKey(nomeCandidato)) {
            int votosAtuais = this.votos.getOrDefault(nomeCandidato, 0);
            this.votos.put(nomeCandidato, votosAtuais + 1);
        } else {
            System.out.println("Candidato não encontrado!");
        }
    }

    public void exibirResultado() {
        System.out.println("Resultado da Eleição:");
        for (Map.Entry<String, Integer> entry : this.votos.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votos");
        }
    }

    public static void main(String[] args) {
        Eleicao eleicao = new Eleicao();

        // Adicionar candidatos
        eleicao.adicionarCandidato("João");
        eleicao.adicionarCandidato("Maria");
        eleicao.adicionarCandidato("José");

        // Simular votos
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Digite o nome do candidato para votar (ou 'sair' para encerrar): ");
            String nomeCandidato = scanner.nextLine();
            if (nomeCandidato.equalsIgnoreCase("sair")) {
                break;
            }
            eleicao.votar(nomeCandidato);
        }

        // Exibir resultado
        eleicao.exibirResultado();
    }
}