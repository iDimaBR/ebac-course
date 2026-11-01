public class MenuPrincipal {

    private final LeitorConsole leitor;
    private final ReservaService service;

    public MenuPrincipal(LeitorConsole leitor, ReservaService service) {
        this.leitor = leitor;
        this.service = service;
    }

    public void executar() {
        OpcaoMenu opcao;

        do {
            exibirOpcoes();
            opcao = lerOpcao();
            processar(opcao);
        } while (opcao != OpcaoMenu.SAIR);
    }

    private void processar(OpcaoMenu opcao) {
        switch (opcao) {
            case NOVA_RESERVA -> novaReserva();
            case LISTAR_RESERVAS -> listarReservas();
            case BUSCAR_RESERVA -> buscarReserva();
            case ORDENAR_RESERVAS -> ordenarReservas();
            case SAIR -> System.out.println("Encerrando o sistema...");
        }
    }

    private void exibirOpcoes() {
        System.out.println("\n===== RESERVAS DO HOTEL =====");
        for (OpcaoMenu opcao : OpcaoMenu.values()) {
            System.out.printf("%d - %s%n", opcao.getCodigo(), opcao.getDescricao());
        }
    }

    private OpcaoMenu lerOpcao() {
        while (true) {
            int codigo = leitor.lerInteiro("Escolha uma opção: ");
            var opcao = OpcaoMenu.porCodigo(codigo);
            if (opcao.isPresent()) {
                return opcao.get();
            }
            System.out.println("Opção inválida.");
        }
    }

    private void novaReserva() {
        if (!service.possuiVaga()) {
            System.out.println("Capacidade máxima de reservas atingida.");
            return;
        }

        String nome = leitor.lerTexto("Nome do hóspede: ");
        String tipoQuarto = leitor.lerTexto("Tipo do quarto (Standard, Luxo, Presidencial): ");
        int dias = leitor.lerInteiroMinimo("Número de dias: ", Reserva.DIAS_MINIMO);
        double diaria = leitor.lerDecimalPositivo("Valor da diária: ");

        service.cadastrar(new Reserva(nome, tipoQuarto, dias, diaria));
        System.out.println("Reserva cadastrada com sucesso!");
    }

    private void listarReservas() {
        exibir(service.listar(), "Nenhuma reserva cadastrada.");
    }

    private void buscarReserva() {
        String termo = leitor.lerTexto("Nome (ou parte) do hóspede: ");
        exibir(service.buscarPorNome(termo), "Nenhuma reserva encontrada.");
    }

    private void ordenarReservas() {
        service.ordenarPorDiasDecrescente();
        System.out.println("Reservas ordenadas por número de dias (decrescente).");
        listarReservas();
    }

    private void exibir(Reserva[] reservas, String mensagemVazia) {
        if (reservas.length == 0) {
            System.out.println(mensagemVazia);
            return;
        }

        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }
}