/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.torresdehanoi;

/**
 *
 * @author Estudos
 */


import java.util.Scanner;

public class TorresDeHanoi{

    public static void resolverHanoi(int n, char origem, char destino, char auxiliar) {
        // Dentro da função Discos = n
        // origem = 'A'
        // destino = 'C'
        // auxiliar = 'B'
        // Valores acima válidos somente quando a função é chamada pela primeira vez

        if (n <= 0) {
            System.out.println("Número de discos inválido. O número de discos deve ser maior que 0.");
            return; // Interrompe a execução se o número de discos for invalido
        }

        if (n == 1) {
            System.out.println("Mover disco 1 de " + origem + " para " + destino);
            return;
        }
        //Quando chamar a linha debaixo os valores das variaveis no inicio da função é alterado mediante a ordem
        // de chamada abaixo.
        // origem = 'A'
        // destino = 'B'
        // auxiliar = 'C'


        //passo 1 > resolver
        resolverHanoi(n - 1, origem, auxiliar, destino);

        //passo 2 mover os discos da origem para destino
        System.out.println("Mover disco " + n + " de " + origem + " para " + destino);

        //passo 3 mover os n-1 discos do auxiliar para o destino
        resolverHanoi(n - 1, auxiliar, destino, origem);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a quantidade de discos: ");
        int discos = scanner.nextInt(); //recebe o numero de discos

        long inicio = System.nanoTime(); //começa a contar o tempo
        resolverHanoi(discos, 'A', 'C', 'B'); //puxa o metodo para resolver
        long fim = System.nanoTime(); // para de contar o tempo

        //calcula o tempo em segundo e milisegundo
        long tempoTotal = fim - inicio;
        long segundos = tempoTotal / 1_000_000_000;
        long milissegundos = (tempoTotal / 1_000_000) % 1000;

        System.out.println("\nNúmero de movimentos: " + (int) (Math.pow(2, discos) - 1));
        System.out.println("Tempo total: " + String.format("%02d:%03d (s:ms)", segundos, milissegundos));
    }
}
