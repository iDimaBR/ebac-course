import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LeitorConsole leitor = new LeitorConsole(scanner);

            Aluno[] alunos = cadastrarAlunos(leitor);
            exibirResumo(alunos);
        }
    }

    private static Aluno[] cadastrarAlunos(LeitorConsole leitor) {
        int quantidade = leitor.lerInteiroPositivo("Quantos alunos deseja cadastrar? ");
        Aluno[] alunos = new Aluno[quantidade];

        for (int i = 0; i < alunos.length; i++) {
            System.out.printf("%n--- Aluno %d ---%n", i + 1);
            alunos[i] = lerAluno(leitor);
        }
        return alunos;
    }

    private static Aluno lerAluno(LeitorConsole leitor) {
        String nome = leitor.lerTexto("Nome: ");
        int quantidadeNotas = leitor.lerInteiroPositivo("Quantidade de notas: ");
        return new Aluno(nome, lerNotas(leitor, quantidadeNotas));
    }

    private static double[] lerNotas(LeitorConsole leitor, int quantidade) {
        double[] notas = new double[quantidade];

        for (int i = 0; i < notas.length; i++) {
            notas[i] = leitor.lerNota("Nota " + (i + 1) + ": ");
        }
        return notas;
    }

    private static void exibirResumo(Aluno[] alunos) {
        System.out.println("\n===== RESUMO =====");

        for (Aluno aluno : alunos) {
            exibirAluno(aluno);
        }
    }

    private static void exibirAluno(Aluno aluno) {
        System.out.println("\nAluno: " + aluno.getNome());
        System.out.println("Notas: " + formatarNotas(aluno.getNotas()));
        System.out.printf("Média: %.2f%n", aluno.calcularMedia());
    }

    private static String formatarNotas(double[] notas) {
        StringBuilder saida = new StringBuilder();

        for (int i = 0; i < notas.length; i++) {
            if (i > 0) {
                saida.append(" | ");
            }
            saida.append(String.format("%.1f", notas[i]));
        }
        return saida.toString();
    }
}