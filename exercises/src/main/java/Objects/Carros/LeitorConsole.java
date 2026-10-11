import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LeitorConsole {

    private final Scanner scanner;

    public LeitorConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public int lerQuantidade(int minimo, int maximo) {
        while (true) {
            System.out.printf("Quantos carros deseja cadastrar (%d a %d)? ", minimo, maximo);
            int valor = lerInteiro();
            if (valor >= minimo && valor <= maximo) {
                return valor;
            }
            System.out.println("Quantidade inválida.");
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

    public BigDecimal lerPreco(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim().replace(',', '.');
            BigDecimal preco = converterPreco(entrada);
            if (preco != null) {
                return preco;
            }
            System.out.println("Preço inválido. Informe um valor maior que zero.");
        }
    }

    private int lerInteiro() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private BigDecimal converterPreco(String entrada) {
        try {
            BigDecimal preco = new BigDecimal(entrada);
            return preco.signum() > 0 ? preco : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}