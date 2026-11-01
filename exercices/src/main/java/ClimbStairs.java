public class ClimbStairs {

    public static int climbStairs(int n) {
        // com 1 degrau só existe 1 maneira
        if (n == 1) {
            return 1;
        }
        // com 2 degraus existem 2 maneiras
        if (n == 2) {
            return 2;
        }

        // soma dos subproblemas menores
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        testar(1, 1);
        testar(2, 2);
        testar(3, 3);
        testar(4, 5);
        testar(5, 8);
        testar(6, 13);
        testar(10, 89);
    }

    private static void testar(int n, int esperado) {
        int resultado = climbStairs(n);
        String status = (resultado == esperado) ? "OK" : "FALHOU";
        System.out.printf("n = %d -> obtido: %d | esperado: %d [%s]%n", n, resultado, esperado, status);
    }
}