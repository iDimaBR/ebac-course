import java.util.Scanner;

public class Exercises_Order {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho do vetor: ");
        int n = scanner.nextInt();

        int[] numeros = new int[n];
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int auxiliar = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = auxiliar;
                }
            }
        }

        System.out.println("\nVetor ordenado:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        scanner.nextLine();

        System.out.print("\n\nDigite seu nome: ");
        String nome = scanner.nextLine();

        char[] letras = nome.toLowerCase().toCharArray();

        int quantidadeVogais = 0;
        for (char letra : letras) {

            if (letra == 'a' ||
                letra == 'e' ||
                letra == 'i' ||
                letra == 'o' ||
                letra == 'u') {

                quantidadeVogais++;
            }
        }

        System.out.println("Quantidade de vogais: " + quantidadeVogais);
        scanner.close();
    }
}