package Vaihtoraha;

import java.awt.TextArea;
import java.util.Scanner;

/**
 *
 * @author Kari Piukka
 */
public class Vaihtoraha {

    // Seteleiden ja kolikoiden arvot euroina
    static double[] rahanArvot = {0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 20, 50, 100, 200, 500};

    private static String btLaskeActionPerformed(String syote) {
        String tulos = "";
        double summa;
        try {
            if (syote.contains(",")) {
                syote = syote.replace(',', '.');
            }
            summa = Double.parseDouble(syote);
            if (summa < 0) {
                summa *= -1;
            }
            for (int i = rahanArvot.length - 1; i >= 0; i--) {
                System.out.println(rahanArvot[i]);
                if ((int) (summa / rahanArvot[i]) > 0) { // jos seteliä / kolikkoa ei tarvita, niin sitä ei tulosteta
                    if (rahanArvot[i] < 1) {
                        tulos += String.format("%d kpl %.2f euron seteliä/kolikkoa\n", (int) (summa / rahanArvot[i]), rahanArvot[i]);
                    } else {
                        tulos += String.format("%d kpl %.0f euron seteliä/kolikkoa\n", (int) (summa / rahanArvot[i]), rahanArvot[i]);
                    }
                    summa = summa % rahanArvot[i]; // laitetaan ylijäämä uudeksi summaksi
                }
            }

            // jos summasta jäi jotain yli, niin tulostetaan ruudulle
            if (summa != 0) {
                tulos += String.format("Yli jäi %.2f euroa\n", summa);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return tulos;
    }

    public static void main(String[] args) {
        GUIVaihtoraha ikkuna = new GUIVaihtoraha();
        ikkuna.setVisible(true);

        ikkuna.btLaske.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ikkuna.taTulos.setText(btLaskeActionPerformed(ikkuna.tfSumma.getText()));
            }
        });
    }
}
