# Java Cyber Zoeira 2026 ☕🔒💀

Repositório pessoal de estudos em **cybersecurity** usando **Java**.  
Aqui eu aprendo conceitos reais de segurança (senhas, hashing, brute-force teórico) enquanto mantenho o hábito de commit diário, adiciono zoeira, memes e auto-humilhação para não desistir.

Objetivo principal:  
- Praticar Java + segurança de forma prática e divertida  
- Manter streak de commits todo dia (mesmo que pequeno)  
- Criar algo que eu mesmo usaria no futuro  
- Mostrar evolução real (do checker simples até ferramentas mais completas)

Status: Em construção – último update: 13/01/2026

![Java](https://img.shields.io/badge/Java-%23ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Cybersecurity](https://img.shields.io/badge/Cybersecurity-Learning-red?style=for-the-badge)
![Progress](https://img.shields.io/badge/Day-Active-brightgreen?style=for-the-badge)

## Por que esse projeto?

- Queria estudar cyber sem depender de Kali Linux ou ferramentas pesadas logo de cara  
- Java porque é a linguagem que mais uso no dia a dia e queria praticar OO + segurança nela  
- Zoeira porque estudar sério dói na alma — memes e mensagens engraçadas tornam tudo suportável  
- Compromisso público: commit todo dia para criar hábito e mostrar consistência

## Ferramentas / Classes disponíveis

### 1. PasswordStrengthChecker.java
**O que faz**: Avalia a força de uma senha digitada com critérios reais + mensagens de zoeira.

**Decisões de design**:
- Regex simples com `Pattern.compile` para checar maiúsculas/minúsculas/números/especiais (flexível e comum em validações)  
- Pontuação arbitrária (score) inspirada em OWASP/NIST, mas simplificada para aprendizado  
- Lista hardcoded de senhas comuns para simular HaveIBeenPwned básico  
- Bônus XKCD para senhas ≥ 20 caracteres (porque senhas longas e memoráveis são melhores que curtas e cheias de símbolos)  
- Gerador de senha embutido usando `SecureRandom` + garantia de variedade + embaralhamento final

**Como rodar**:
```bash
javac PasswordStrengthChecker.java
java PasswordStrengthChecker


2. PasswordGenerator.java (em construção / opcional)
O que faz: Gera senhas fortes aleatórias com comprimento configurável.
Decisões:

SecureRandom em vez de Random (mais seguro criptograficamente)
Garante pelo menos 1 caractere de cada tipo (maiúscula, minúscula, número, especial)
Embaralhamento final para evitar padrões previsíveis
Mensagem lembrando do XKCD

3. HashCalculator.java
O que faz: Calcula hash (MD5/SHA-256) de uma string.
Decisões:

Implementação manual de conversão para hex (compatível com Java 11+, sem dependência de javax.xml.bind)
Suporte a argumentos de linha de comando
Foco educacional: mostrar como senhas reais são armazenadas em sistemas (hash não é reversível)

Como rodar:
Bashjavac HashCalculator.java
java HashCalculator minhaSenha123 SHA-256
4. PasswordTester.java (em construção)
O que faz: Simulador educacional de brute-force para senhas curtas (até 4–5 chars).
Decisões:

Apenas letras minúsculas no alfabeto inicial (para rodar rápido)
Recursão simples para demonstrar conceito
Aviso claro: só para aprendizado, nunca use em produção ou contra senhas reais

Lições aprendidas até agora

Senhas longas > senhas complexas (XKCD 936 é lei)
Hashing não é criptografia reversível — brute-force real é exponencial
Documentar decisões é tão importante quanto codar
Commit diário pequeno > perfeccionismo que paralisa
Regex dói, mas é útil

Roadmap / ideias futuras

 Menu console unificando todas as ferramentas
 Estimador teórico de tempo de brute-force
 Suporte a hash salgado (simulação simples de bcrypt)
 Mais memes na pasta memes/
 Talvez migrar para Maven quando crescer

Feito com café, sofrimento com regex e vontade de não ser o elo fraco da cadeia.
Se quiser contribuir: abra issue com memes novos, sugestões ou pull request com melhorias. 😂🔥