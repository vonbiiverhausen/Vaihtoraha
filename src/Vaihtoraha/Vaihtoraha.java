/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vaihtoraha;

import java.util.Scanner;

/**
 *
 * @author Kari Piukka
 */
public class Vaihtoraha {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Seteleiden ja kolikoiden arvot euroina
        double[] rahanArvot = {0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 20, 50, 100, 200, 500};
        double summa;

        do {
            System.out.print("Syötä rahasumma euroina: ");
            summa = Double.parseDouble(input.nextLine());
        } while (summa < 0);

        for (int i = rahanArvot.length - 1; i >= 0; i--) {
            if ((int) (summa / rahanArvot[i]) > 0) { // jos seteliä / kolikkoa ei tarvita, niin sitä ei tulosteta
                if (rahanArvot[i] < 1) {
                    System.out.printf("%d kpl %.2f euron seteliä/kolikkoa\n", (int) (summa / rahanArvot[i]), rahanArvot[i]);
                } else {
                    System.out.printf("%d kpl %.0f euron seteliä/kolikkoa\n", (int) (summa / rahanArvot[i]), rahanArvot[i]);
                }
                summa = summa % rahanArvot[i]; // laitetaan ylijäämä uudeksi summaksi
            }
        }

        // jos summasta jäi jotain yli, niin tulostetaan ruudulle
        if (summa != 0) {
            System.out.printf("Yli jäi %.2f euroa\n", summa);
        }
    }
}
