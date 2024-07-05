package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> conversao = new HashMap<>();
        conversao.put("Dolar", "USD");
        conversao.put("Real", "BRL");
        conversao.put("PesoArg", "ARS");
        conversao.put("PesoCol", "COP");
        conversao.put("sair","sair");

        Scanner leitura = new Scanner(System.in);
        var exit = true;

        while(exit){
            System.out.println("1. Dolar >>>>>>>> Peso Argentino\n 2. Peso Argentino >>>>>>>> dolar\n 3. Dolar>>>>>>>> Real Brasileiro\n 4. Real Brasileiro >>>>>>>> Dolar\n 5. Dolar >>>>>>>> Peso Colombiano\n 6. Peso Colombiano >>>>>>>> Dolar\n 7. Sair\n");
            System.out.println("Qual moeda deseja usar?");

            String siglaPrimeiraMoeda = conversao.get(leitura.nextLine());

            if(siglaPrimeiraMoeda.equalsIgnoreCase("sair")){
                exit = false;
            }else{
                System.out.println("Em qual moeda deseja converter?");
                var siglaSegundaMoeda = conversao.get(leitura.nextLine());
                System.out.println("Qual valor deseja converter?");
                double valor = Double.parseDouble(leitura.nextLine());
                    BuscaCotacao buscaCotacao = new BuscaCotacao();
                    Cotacao cotacao =  buscaCotacao.minhaBusca(siglaPrimeiraMoeda, siglaSegundaMoeda);
                CalculoConversao calculoConversao = new CalculoConversao(valor, cotacao);
                    System.out.println("O valor convertido é "+ calculoConversao.Calcula());
            }
        }
    }
}