import java.math.BigDecimal;

public class CadastroCarros {

    public static final int LIMITE_MAXIMO = 50;

    private final Carro[] carros = new Carro[LIMITE_MAXIMO];
    private int quantidade;

    public void adicionar(Carro carro) {
        if (quantidade >= LIMITE_MAXIMO) {
            throw new IllegalStateException("Limite de " + LIMITE_MAXIMO + " carros atingido.");
        }
        carros[quantidade++] = carro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal somarPrecos() {
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < quantidade; i++) {
            total = total.add(carros[i].getPreco());
        }
        return total;
    }

    public String[] listarNomes() {
        String[] nomes = new String[quantidade];
        for (int i = 0; i < quantidade; i++) {
            nomes[i] = carros[i].getNome();
        }
        return nomes;
    }
}