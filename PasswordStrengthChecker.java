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
        
        // Sugestão de senha forte se for fraca ou média
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

        // Define a força base
        String strength;
        if (score >= 6) {
            strength = "Forte pra caramba! Pode usar (mas nunca reuse)";
        } else if (score >= 4) {
            strength = "Média – dá pra viver... mas não em produção";
        } else if (score >= 2) {
            strength = "Fraca pra caramba! Nem tente logar em nada";
        } else {
            strength = "Muito fraca – tipo '123456' nível 2026";
        }

        // Bônus XKCD: senhas longas são melhores que complexas!
        if (pwd.length() >= 20) {
            strength += " + Bônus XKCD: senhas longas são melhores que complexas!";
        }

        return strength;
    }

    // Gera senha forte aleatória com garantia de variedade
    private static String generateStrongPassword(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*()_+-=[]{}|;:,.<>?";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // Garante pelo menos 1 de cada tipo
        sb.append(upper.charAt(random.nextInt(upper.length())));
        sb.append(lower.charAt(random.nextInt(lower.length())));
        sb.append(digits.charAt(random.nextInt(digits.length())));
        sb.append(special.charAt(random.nextInt(special.length())));

        // Preenche o resto aleatoriamente
        String all = upper + lower + digits + special;
        for (int i = 4; i < length; i++) {
            sb.append(all.charAt(random.nextInt(all.length())));
        }

        // Embaralha para não ficar previsível
        char[] chars = sb.toString().toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        return new String(chars);
    }
}