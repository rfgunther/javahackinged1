import java.util.Scanner;
import java.util.regex.Pattern;
import java.security.SecureRandom;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite sua senha (não conta pra ninguém, hein?): ");
        String password = scanner.nextLine();

        String strength = checkStrength(password);
        System.out.println("\nSua senha é: " + strength);

        if (strength.contains("Fraca")) {
            System.out.println("Dica cyber: Isso aí quebra em 0.2 segundos no John the Ripper. Bota MFA e chora menos.");
        } else if (strength.contains("Média")) {
            System.out.println("Tá na média... tipo nota 6. Dá pra melhorar, vai!");
        } else {
            System.out.println("Boa! Parece que você leu o OWASP Cheat Sheet... ou só apertou shift aleatório.");
        }

        // Sugestão de senha forte se a senha for fraca ou média
        if (strength.contains("Fraca") || strength.contains("Média")) {
            System.out.println("\nSugestão de senha forte (use um gerenciador de senhas!): " 
                             + generateStrongPassword(16));
        }

        scanner.close();
    }

    public static String checkStrength(String pwd) {
        if (pwd == null || pwd.isEmpty()) {
            return "Inexistente (você nem tentou)";
        }

        int score = 0;

        // Comprimento
        if (pwd.length() >= 12) score += 3;
        else if (pwd.length() >= 8) score += 2;
        else score += 1;

        // Tem maiúscula
        if (Pattern.compile("[A-Z]").matcher(pwd).find()) score++;

        // Minúscula
        if (Pattern.compile("[a-z]").matcher(pwd).find()) score++;

        // Número
        if (Pattern.compile("\\d").matcher(pwd).find()) score++;

        // Especial
        if (Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(pwd).find()) score++;

        // Check contra senhas comuns
        String[] commonWeakPasswords = {
            "123456", "12345678", "password", "qwerty", "admin", "letmein",
            "welcome", "abc123", "password1", "123456789", "iloveyou", "monkey"
        };

        for (String weak : commonWeakPasswords) {
            if (pwd.equalsIgnoreCase(weak)) {
                return "Fraca nível HaveIBeenPwned! Essa senha tá na lista das 10 mais vazadas do mundo em 2026. TROCA AGORA!";
            }
        }

        // Decisão final
        if (score >= 6) return "Forte pra caramba! Pode usar (mas nunca reuse)";
        if (score >= 4) return "Média – dá pra viver... mas não em produção";
        if (score >= 2) return "Fraca pra caramba! Nem tente logar em nada";
        return "Muito fraca – tipo '123456' nível 2026";
    }

    // Novo método: gera senha forte aleatória
    private static String generateStrongPassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+-=[]{}|;:,.<>?";
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }

        return sb.toString();
    }
}