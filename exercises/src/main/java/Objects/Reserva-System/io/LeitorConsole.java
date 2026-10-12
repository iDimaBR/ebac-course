import java.util.Scanner;

public class LeitorConsole {

    private final Scanner scanner;

    public LeitorConsole(Scanner scanner) {
        this.scanner = scanner;
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

    public int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    public int lerInteiroMinimo(String mensagem, int minimo) {
        while (true) {
            int valor = lerInteiro(mensagem);
            if (valor >= minimo) {
                return valor;
            }
            System.out.println("O valor deve ser no mínimo " + minimo + ".");
        }
    }

    public double lerDecimalPositivo(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            Double valor = converterDecimal(scanner.nextLine());
            if (valor != null && valor > 0) {
                return valor;
            }
            System.out.println("Digite um valor numérico maior que zero.");
        }
    }

    private Double converterDecimal(String entrada) {
        try {
            return Double.parseDouble(entrada.trim().replace(',', '.'));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}