import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número para calcular a tabuada: ");
        int numero = scanner.nextInt();

        int contador = 1;
        while (contador <= 10) {
            System.out.println(numero + " x " + contador + " = " + (numero * contador));
            contador++;
        }

        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Continuar");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Digite uma palavra ou frase: ");
                String frase = scanner.nextLine();

                System.out.println("Você digitou: " + frase);

            } else if (opcao == 2) {
                System.out.println("Obrigado por utilizar o nosso sistema!");

            } else {
                System.out.println("Opção inválida!");
            }

        } while (opcao != 2);

        scanner.close();
    }
}