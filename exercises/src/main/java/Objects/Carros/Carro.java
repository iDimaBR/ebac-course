import java.math.BigDecimal;

public class Carro {

    private final String nome;
    private final BigDecimal preco;

    public Carro(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}