import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCalculator {
    public static void main(String[] args) {
        System.out.println("=== Calculadora de Hash Educacional - 2026 ☕🔒 ===\n");
        System.out.println("Uso: java HashCalculator <senha> [algoritmo]");
        System.out.println("Algoritmos disponíveis: MD5, SHA-256 (padrão)\n");

        if (args.length == 0) {
            System.out.println("Exemplo: java HashCalculator minhaSenha123 SHA-256");
            return;
        }

        String senha = args[0];
        String algoritmo = args.length > 1 ? args[1].toUpperCase() : "SHA-256";

        try {
            String hash = calcularHash(senha, algoritmo);
            System.out.println("Senha original (não armazene!): " + senha);
            System.out.println(algoritmo + " hash: " + hash);
            System.out.println("\nLição: Mesmo 'senha' vira algo impossível de reverter sem brute-force ou dicionário.");
            System.out.println("Nunca armazene senhas em texto plano!");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Algoritmo inválido: " + algoritmo);
        }
    }

    private static String calcularHash(String input, String algoritmo) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algoritmo);
        byte[] digest = md.digest(input.getBytes(java.nio.charset.StandardCharsets.UTF_8));

        // Conversão manual para hex (substitui DatatypeConverter)
        StringBuilder hexString = new StringBuilder();
        for (byte b : digest) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}