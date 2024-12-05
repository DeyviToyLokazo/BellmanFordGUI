/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bellmanfordgui;

import java.util.Scanner;

/**
 *
 * @author Deyvi
 */
public class BellmanFord1 {

    private int D[];
    private int n;
    public static final int MAX_VALUE = 999;

    public BellmanFord1(int n) {
        this.n = n;
        D = new int[n + 1];
    }

    public void CaminoMasCorto(int s, int A[][]) {
        for (int i = 1; i <= n; i++) {
            D[i] = MAX_VALUE;
        }
        D[s] = 0;
        for (int k = 1; k <= n - 1; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (A[i][j] != MAX_VALUE) {
                        if (D[j] > D[i] + A[i][j]) {
                            D[j] = D[i] + A[i][j];
                        }
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println("Distancia de la fuente " + s + " to " + i + " es " + D[i]);
        }
    }

    public static void main(String[] args) {
        int n = 0, s;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de vertice: ");
        n = sc.nextInt();
        int A[][] = new int[n + 1][n + 1];

        System.out.println("Ingrese la matriz ponderada: ");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                A[i][j] = sc.nextInt();
                if (i == j) {
                    A[i][j] = 0;
                    continue;
                }
                if (A[i][j] == 0) {
                    A[i][j] = MAX_VALUE;
                }
            }
        }

        System.out.println("Introduzca el vertice de origen: ");
        s = sc.nextInt();
        BellmanFord1 b = new BellmanFord1(n);
        b.CaminoMasCorto(s, A);
        sc.close();
    }

}


