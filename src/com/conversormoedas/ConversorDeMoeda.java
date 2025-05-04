package com.conversormoedas;

import com.conversormoedas.api.CurrencyConverterService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorDeMoeda {

    public static void conversorDeMoedaInicio() {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("================================================\n");
            System.out.println("Seja bem vindo ao conversor de moedas!\n");
            System.out.println("""
                    1) Dólar -> Real
                    2) Real -> Dólar
                    3) Euro -> Real
                    4) Real -> Euro
                    5) Peso Argentino -> Real
                    6) Real -> Peso Argentino
                    7) Sair

            Escolha uma opção:\s""");

            try {
                opcao = sc.nextInt();
                sc.nextLine();
                System.out.println("================================================\n");

                if (opcao != 7) {
                    processarOpcao(opcao, sc);
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite um número válido para a opção.");
                sc.nextLine();
                opcao = 0;
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
                opcao = 0;
            }

            if (opcao != 7) {
                System.out.println("\nPressione Enter para continuar...");
                sc.nextLine();
            }

        }

        System.out.println("Programa finalizado.");
        sc.close();
    }

    private static void processarOpcao(int opcao, Scanner sc) {
        String moedaOrigem = "";
        String moedaDestino = "";
        String simboloOrigem = "";
        String simboloDestino = "";

        switch (opcao) {
            case 1:
                moedaOrigem = "USD"; moedaDestino = "BRL"; simboloOrigem = "$"; simboloDestino = "R$";
                break;
            case 2:
                moedaOrigem = "BRL"; moedaDestino = "USD"; simboloOrigem = "R$"; simboloDestino = "$";
                break;
            case 3:
                moedaOrigem = "EUR"; moedaDestino = "BRL"; simboloOrigem = "€"; simboloDestino = "R$";
                break;
            case 4:
                moedaOrigem = "BRL"; moedaDestino = "EUR"; simboloOrigem = "R$"; simboloDestino = "€";
                break;
            case 5:
                moedaOrigem = "ARS"; moedaDestino = "BRL"; simboloOrigem = "ARS"; simboloDestino = "R$";
                break;
            case 6:
                moedaOrigem = "BRL"; moedaDestino = "ARS"; simboloOrigem = "R$"; simboloDestino = "ARS";
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        try {
            System.out.printf("Informe a quantidade em %s a ser convertida: ", simboloOrigem);
            String valorString = sc.nextLine().replace(",", ".");
            double valorConverter = Double.parseDouble(valorString);

            Double taxaCambio = CurrencyConverterService.curencyApi(moedaOrigem, moedaDestino);

            if (taxaCambio != null) {
                double valorConvertido = valorConverter * taxaCambio;
                String texto = String.format("O valor de %s %.2f para %s é %.2f",
                        simboloOrigem, valorConverter, simboloDestino, valorConvertido);
                System.out.println(texto);
            } else {
                System.out.println("Não foi possível obter a taxa de câmbio.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Erro: Valor digitado para conversão é inválido!");
        } catch (Exception e) {
            System.out.println("Erro ao processar a conversão: " + e.getMessage());
        }
    }
}