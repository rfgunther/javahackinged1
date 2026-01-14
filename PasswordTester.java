import java.util.concurrent.TimeUnit;

public class PasswordTester {
    public static void main(String[] args) {
        System.out.println("=== Testador Educacional de Senhas (Brute-Force Simples) - 2026 ☕💀 ===\n");
        System.out.println("Aviso: Isso é só pra aprendizado. Senhas reais são hashadas e não quebram assim!");

        String senhaAlvo = "abcd"; // Teste com senha curta (mude pra testar)
        int maxComprimento = 4; // Comece com 4, suba pra 5 se quiser ver crescer
        char[] alfabeto = "abcdefghijklmnopqrstuvwxyz".toCharArray(); // Só letras minúsculas pra simplicidade

        long startTime = System.nanoTime();
        String encontrada = bruteForce(senhaAlvo, maxComprimento, alfabeto);
        long endTime = System.nanoTime();

        if (encontrada != null) {
            System.out.println("Senha encontrada: " + encontrada);
        } else {
            System.out.println("Senha não encontrada (ou muito longa).");
        }

        long tempoGasto = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("Tempo gasto: " + tempoGasto + " ms");
        System.out.println("\nLição: Com 4 letras, ~456k tentativas. Com 8, leva anos! Use senhas longas.");
    }

    private static String bruteForce(String alvo, int maxLen, char[] alfabeto) {
        // Gera combinações de comprimento 1 a maxLen
        for (int len = 1; len <= maxLen; len++) {
            if (gerarCombinacoes(new char[len], 0, alfabeto, alvo)) {
                return new String(alvo);
            }
        }
        return null;
    }

    private static boolean gerarCombinacoes(char[] tentativa, int pos, char[] alfabeto, String alvo) {
        if (pos == tentativa.length) {
            String candidato = new String(tentativa);
            if (candidato.equals(alvo)) {
                return true;
            }
            return false;
        }

        for (char c : alfabeto) {
            tentativa[pos] = c;
            if (gerarCombinacoes(tentativa, pos + 1, alfabeto, alvo)) {
                return true;
            }
        }
        return false;
    }
}