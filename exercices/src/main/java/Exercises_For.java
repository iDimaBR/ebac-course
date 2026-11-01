import java.util.Scanner;

public class Exercises_For {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite um número positivo: ");
        int numero = scanner.nextInt();

        System.out.println("\nContagem crescente:");

        for (int i = 0; i <= numero; i++) {
            System.out.println(i);
        }

        System.out.println("\nContagem decrescente:");

        for (int i = numero; i >= 0; i--) {
            System.out.println(i);
        }

        System.out.println("\nNome:");

        if (nome.length() > 6) {
            for (int i = 0; i < numero; i++) {
                System.out.println(nome);
            }
        } else {
            System.out.println(nome);
        }

        scanner.close();
    }
}