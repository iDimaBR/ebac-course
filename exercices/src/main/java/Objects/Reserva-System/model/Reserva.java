import java.util.Locale;

public class Reserva {

    public static final int DIAS_MINIMO = 1;

    private String nomeHospede;
    private String tipoQuarto;
    private int numeroDias;
    private double valorDiaria;

    public Reserva(String nomeHospede, String tipoQuarto, int numeroDias, double valorDiaria) {
        setNomeHospede(nomeHospede);
        setTipoQuarto(tipoQuarto);
        setNumeroDias(numeroDias);
        setValorDiaria(valorDiaria);
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = exigirTexto(nomeHospede, "Nome do hóspede");
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = exigirTexto(tipoQuarto, "Tipo do quarto");
    }

    public int getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(int numeroDias) {
        if (numeroDias < DIAS_MINIMO) {
            throw new IllegalArgumentException("O número de dias deve ser no mínimo " + DIAS_MINIMO + ".");
        }
        this.numeroDias = numeroDias;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        if (valorDiaria <= 0) {
            throw new IllegalArgumentException("O valor da diária deve ser maior que zero.");
        }
        this.valorDiaria = valorDiaria;
    }

    public double calcularValorTotal() {
        return numeroDias * valorDiaria;
    }

    @Override
    public String toString() {
        return String.format(new Locale("pt", "BR"),
                "Hóspede: %s | Quarto: %s | Dias: %d | Diária: R$ %.2f | Total: R$ %.2f",
                nomeHospede, tipoQuarto, numeroDias, valorDiaria, calcularValorTotal());
    }

    private static String exigirTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(campo + " não pode ser vazio.");
        }
        return valor.trim();
    }
}