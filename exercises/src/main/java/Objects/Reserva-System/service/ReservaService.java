import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class ReservaService {

    private static final Comparator<Reserva> POR_DIAS_DECRESCENTE =
            Comparator.comparingInt(Reserva::getNumeroDias).reversed();

    private final ReservaRepository repository;

    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }

    public boolean possuiVaga() {
        return !repository.estaCheio();
    }

    public void cadastrar(Reserva reserva) {
        repository.salvar(reserva);
    }

    public Reserva[] listar() {
        return repository.buscarTodas();
    }

    public Reserva[] buscarPorNome(String termo) {
        String filtro = normalizar(termo);
        Reserva[] todas = repository.buscarTodas();
        Reserva[] encontradas = new Reserva[todas.length];
        int total = 0;

        for (Reserva reserva : todas) {
            if (normalizar(reserva.getNomeHospede()).contains(filtro)) {
                encontradas[total++] = reserva;
            }
        }
        return Arrays.copyOf(encontradas, total);
    }

    public void ordenarPorDiasDecrescente() {
        repository.ordenar(POR_DIAS_DECRESCENTE);
    }

    private String normalizar(String texto) {
        return texto.trim().toLowerCase(Locale.ROOT);
    }
}