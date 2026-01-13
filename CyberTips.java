
public class CyberTips {
    public static void main(String[] args) {
        System.out.println("=== Dicas Cyber Zoeira 2026 ===\n");
        printRandomTip();
    }

    private static void printRandomTip() {
        String[] tips = {
            "Nunca reuse senhas. Nunca. Sério.",
            "MFA salva vidas (e contas bancárias).",
            "Senhas longas > senhas cheias de símbolos malucos (obrigado XKCD).",
            "Phishing é o esporte favorito dos hackers em 2026.",
            "Atualize tudo. Tudo mesmo. Até o firmware da torradeira.",
            "Se sua senha for '123456', o universo inteiro te julga."
        };

        int index = (int) (Math.random() * tips.length);
        System.out.println(tips[index]);
        System.out.println("\nDica extra: rode isso todo dia pra lembrar de não ser o elo fraco.");
    }
}
