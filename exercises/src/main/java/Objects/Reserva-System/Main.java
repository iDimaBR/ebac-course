import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LeitorConsole leitor = new LeitorConsole(scanner);
            ReservaService service = new ReservaService(new ReservaRepository());

            new MenuPrincipal(leitor, service).executar();
        }
    }
}