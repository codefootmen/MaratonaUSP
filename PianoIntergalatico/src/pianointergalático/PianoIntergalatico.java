/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pianointergalático;

import java.util.Scanner;
import static java.lang.System.*;

public class PianoIntergalatico {

    private static int[] notas;

    public static void main(String[] args) {
        int[][] teclas = entrada();

        for (int i = 0; i < teclas.length; i++) {
            atualizaFrequencia(teclas[i][0], teclas[i][1]);
        }

        imprimeResultado();

    }

    public static int[][] entrada() {
        Scanner scanf = new Scanner(in);

        String firstLine = scanf.nextLine();

        String[] inputData = firstLine.split(" ");

        notas = new int[Integer.parseInt(inputData[0])];

        for (int i = 0; i < notas.length; i++) {
            notas[i] = 1;
        }

        int qtdAcordes = Integer.parseInt(inputData[1]);
        int[][] teclas = new int[qtdAcordes][2];

        for (int i = 0; i < qtdAcordes; i++) {
            String[] acorde = scanf.nextLine().split(" ");
            teclas[i][0] = Integer.parseInt(acorde[0]);
            teclas[i][1] = Integer.parseInt(acorde[1]);
        }

        return teclas;
    }

    public static void atualizaFrequencia(int a, int b) {

        int[][] frequencia = new int[b - a + 1][2];

        System.out.println("Teclas: " + a + ", " + b);

        //preenche primeira linha
        for (int i = 0; i < frequencia.length; i++) {
            frequencia[i][0] = notas[i + a];
        }

        //faz contagem de frequencia
        for (int i = a; i <= b; i++) {
            for (int j = 0; j < frequencia.length; j++) {
                if (frequencia[j][0] == notas[i]) {
                    frequencia[j][1]++;
                    break;
                }
            }
        }

        int notaMaisRepetida = 0;
        int maiorNumero = 0;
        
        for (int i = 0; i < frequencia.length; i++) {
            if (frequencia[i][1] > maiorNumero) {
                maiorNumero = frequencia[i][1];
                notaMaisRepetida = frequencia[i][0];
            }
        }
        System.out.println("Nota mais repetida = " + notaMaisRepetida);
        atualizaIntervalo(a, b, notaMaisRepetida);

    }

    public static void atualizaIntervalo(int a, int b, int k) {
        for (int i = a; i <= b; i++) {
            notas[i] = (notas[i] + k) % 9;
        }
    }

    public static void imprimeResultado() {
        for (int i = 0; i < notas.length; i++) {
            System.out.println(notas[i]);
        }
    }
}
