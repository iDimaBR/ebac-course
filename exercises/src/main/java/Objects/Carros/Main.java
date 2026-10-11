import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static final NumberFormat MOEDA = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LeitorConsole leitor = new LeitorConsole(scanner);
            CadastroCarros cadastro = new CadastroCarros();

            cadastrarCarros(leitor, cadastro);
            exibirResumo(cadastro);
        }
    }

    private static void cadastrarCarros(LeitorConsole leitor, CadastroCarros cadastro) {
        int quantidade = leitor.lerQuantidade(1, CadastroCarros.LIMITE_MAXIMO);

        for (int i = 1; i <= quantidade; i++) {
            System.out.printf("%n--- Carro %d ---%n", i);
            cadastro.adicionar(lerCarro(leitor));
        }
    }

    private static Carro lerCarro(LeitorConsole leitor) {
        String nome = leitor.lerTexto("Nome do modelo: ");
        BigDecimal preco = leitor.lerPreco("Preço: ");
        return new Carro(nome, preco);
    }

    private static void exibirResumo(CadastroCarros cadastro) {
        System.out.println("\n===== RESUMO =====\n\n");

        for (String nome : cadastro.listarNomes()) {
            System.out.println("- " + nome);
        }

        System.out.println("\n\nTotal de carros: " + cadastro.getQuantidade());
        System.out.println("Soma dos preços: " + MOEDA.format(cadastro.somarPrecos()));
    }
}