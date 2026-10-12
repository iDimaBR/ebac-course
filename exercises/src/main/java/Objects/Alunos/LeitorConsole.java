import java.util.Scanner;

public class LeitorConsole {

    public static final double NOTA_MINIMA = 0;
    public static final double NOTA_MAXIMA = 10;

    private final Scanner scanner;

    public LeitorConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public int lerInteiroPositivo(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            int valor = converterInteiro(scanner.nextLine());
            if (valor > 0) {
                return valor;
            }
            System.out.println("Informe um número inteiro maior que zero.");
        }
    }

    public String lerTexto(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("O valor não pode ser vazio.");
        }
    }

    public double lerNota(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            double nota = converterDecimal(scanner.nextLine());
            if (notaValida(nota)) {
                return nota;
            }
            System.out.printf("Nota inválida. Digite um valor entre %.0f e %.0f.%n", NOTA_MINIMA, NOTA_MAXIMA);
        }
    }

    private boolean notaValida(double nota) {
        return nota >= NOTA_MINIMA && nota <= NOTA_MAXIMA;
    }

    private int converterInteiro(String entrada) {
        try {
            return Integer.parseInt(entrada.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private double converterDecimal(String entrada) {
        try {
            return Double.parseDouble(entrada.trim().replace(',', '.'));
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }
}