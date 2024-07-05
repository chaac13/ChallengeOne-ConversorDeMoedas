package org.example;

public class CalculoConversao {

    private double valor1;
    private double valor2;

    public CalculoConversao(double valor1, Cotacao cotacao) {
        this.valor1 = valor1;
        this.valor2 = cotacao.conversion_rate();
    }
    public double Calcula(){
        return valor1 *valor2;
    }
}
