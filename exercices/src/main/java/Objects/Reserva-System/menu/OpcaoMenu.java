import java.util.Optional;

public enum OpcaoMenu {

    NOVA_RESERVA(1, "Nova reserva"),
    LISTAR_RESERVAS(2, "Listar reservas"),
    BUSCAR_RESERVA(3, "Buscar reserva por nome do hóspede"),
    ORDENAR_RESERVAS(4, "Ordenar reservas por número de dias (decrescente)"),
    SAIR(5, "Sair");

    private final int codigo;
    private final String descricao;

    OpcaoMenu(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Optional<OpcaoMenu> porCodigo(int codigo) {
        for (OpcaoMenu opcao : values()) {
            if (opcao.codigo == codigo) {
                return Optional.of(opcao);
            }
        }
        return Optional.empty();
    }
}