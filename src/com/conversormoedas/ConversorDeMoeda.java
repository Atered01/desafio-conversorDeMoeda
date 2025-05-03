package com.conversormoedas;

import com.conversormoedas.api.CurrencyConverterService;

import java.util.Scanner;

public class ConversorDeMoeda {
    public static void conversorDeMoedaInicio() {
        Scanner sc = new Scanner(System.in);
        int opcao;
        System.out.println("================================================\n");
        System.out.println("Seja bem vindo ao conversor de moedas!\n");
        System.out.println("1) Dólar -> Real");
        System.out.println("2) Real -> Dólar");
        System.out.println("3) Euro -> Real");
        System.out.println("4) Real -> Euro");
        System.out.println("5) Peso Argentino -> para Real");
        System.out.println("6) Real -> Peso Argentino");
        System.out.println("7) Sair");
        opcao = sc.nextInt();
        System.out.println("================================================\n");

        do {
            switch (opcao) {
                case 1:
                    try {
                        Double currency = CurrencyConverterService.curencyApi("BRL", "USD");
                        System.out.println("Informe a quantidade a ser convertido: ");
                        sc.nextLine();
                        String moedaString = sc.nextLine().replace(",", ".");

                        double moeda = Double.parseDouble(moedaString);

                        String texto = String.format("O valor de R$: %.2f para $: é %.2f", moeda, (moeda * currency));

                        System.out.println(texto);
                        System.out.println("Voltando para o inicio...\n");

                        ConversorDeMoeda.conversorDeMoedaInicio();
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: valor digitado é invalido!");
                    }
                    break;

                case 2:
                    try {
                        Double currency = CurrencyConverterService.curencyApi("USD", "BRL");
                        System.out.println("Informe a quantidade a ser convertido: ");
                        sc.nextLine();
                        String moedaString = sc.nextLine().replace(",", ".");

                        double moeda = Double.parseDouble(moedaString);

                        String texto = String.format("O valor de $: %.2f para R$: é %.2f", moeda, (moeda * currency));

                        System.out.println(texto);
                        System.out.println("Voltando para o inicio...\n");

                        ConversorDeMoeda.conversorDeMoedaInicio();
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: valor digitado é invalido!");
                    }
                    break;

                case 3:
                    try {
                        Double currency = CurrencyConverterService.curencyApi("EUR", "BRL");
                        System.out.println("Informe a quantidade a ser convertido: ");
                        sc.nextLine();
                        String moedaString = sc.nextLine().replace(",", ".");

                        double moeda = Double.parseDouble(moedaString);

                        String texto = String.format("O valor de €: %.2f para R$: %.2f", moeda, (moeda * currency));

                        System.out.println(texto);
                        System.out.println("Voltando para o inicio...\n");

                        ConversorDeMoeda.conversorDeMoedaInicio();
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: valor digitado é invalido!");
                    }
                    break;

                case 4:
                    try {
                        Double currency = CurrencyConverterService.curencyApi("BRL", "EUR");
                        System.out.println("Informe a quantidade a ser convertido: ");
                        sc.nextLine();
                        String moedaString = sc.nextLine().replace(",", ".");

                        double moeda = Double.parseDouble(moedaString);

                        String texto = String.format("O valor de R$: %.2f para €: %.2f", moeda, (moeda * currency));

                        System.out.println(texto);
                        System.out.println("Voltando para o inicio...\n");

                        ConversorDeMoeda.conversorDeMoedaInicio();
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: valor digitado é invalido!");
                    }
                    break;

                case 5:
                    try {
                        Double currency = CurrencyConverterService.curencyApi("ARS", "BRL");
                        System.out.println("Informe a quantidade a ser convertido: ");
                        sc.nextLine();
                        String moedaString = sc.nextLine().replace(",", ".");

                        double moeda = Double.parseDouble(moedaString);

                        String texto = String.format("O valor de ARS: %.2f para R$: é %.2f", moeda, (moeda * currency));

                        System.out.println(texto);
                        System.out.println("Voltando para o inicio...\n");

                        ConversorDeMoeda.conversorDeMoedaInicio();
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: valor digitado é invalido!");
                    }
                    break;

                case 6:
                    try {
                        Double currency = CurrencyConverterService.curencyApi("BRL", "ARS");
                        System.out.println("Informe a quantidade a ser convertido: ");
                        sc.nextLine();
                        String moedaString = sc.nextLine().replace(",", ".");

                        double moeda = Double.parseDouble(moedaString);

                        String texto = String.format("O valor de R$: %.2f para ARS: é %.2f", moeda, (moeda * currency));

                        System.out.println(texto);
                        System.out.println("Voltando para o inicio...\n");

                        ConversorDeMoeda.conversorDeMoedaInicio();
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: valor digitado é invalido!");
                    }
                    break;

            }

        } while (opcao != 7);
    }
}

