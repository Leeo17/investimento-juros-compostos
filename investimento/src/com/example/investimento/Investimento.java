package com.example.investimento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Investimento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o capital a ser investido (em reais): ");
        double capital = scanner.nextDouble();

        System.out.println("Informe o prazo do investimento (em meses): ");
        int prazo = scanner.nextInt();

        System.out.println("Informe a taxa de juros da aplicação (mensal): ");
        double juros = scanner.nextDouble();

        double montanteFinal = calcularJurosCompostos(capital, prazo, juros);

        System.out.println("\n--- Resultados mes a mes ---");
        for (int mes = 1; mes <= prazo; mes++) {
            double montanteMes = calcularJurosCompostos(capital, mes, juros);
            double montanteJuros = montanteMes - capital;
            System.out.println("Mes " + mes + ": R$ " + montanteMes + " | Juros: R$ " + formatarMontante(montanteJuros));
        }

        System.out.println("\nO montante final sera de R$ " + montanteFinal);
    }

    public static double calcularJurosCompostos(double capital, int prazo, double juros) {
        double montante = capital * Math.pow((1 + (juros/100)), prazo);

        return formatarMontante(montante);
    }

    public static double formatarMontante(double montante) {
        return BigDecimal.valueOf(montante)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
