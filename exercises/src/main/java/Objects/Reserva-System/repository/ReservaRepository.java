import java.util.Arrays;
import java.util.Comparator;

public class ReservaRepository {

    public static final int CAPACIDADE = 10;

    private final Reserva[] reservas = new Reserva[CAPACIDADE];
    private int quantidade;

    public boolean estaCheio() {
        return quantidade >= CAPACIDADE;
    }

    public void salvar(Reserva reserva) {
        if (estaCheio()) {
            throw new IllegalStateException("Capacidade máxima de " + CAPACIDADE + " reservas atingida.");
        }
        reservas[quantidade++] = reserva;
    }

    public Reserva[] buscarTodas() {
        return Arrays.copyOf(reservas, quantidade);
    }

    public void ordenar(Comparator<Reserva> criterio) {
        Arrays.sort(reservas, 0, quantidade, criterio);
    }
}