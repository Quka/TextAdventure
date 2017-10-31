/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author thomasfritzboger
 */
public class HighScore {

    private int[] highScore = new int[5];
    private String path = "highScore.txt";

    // Run in the start of the game only //
    public void loadHighScoresFromFile() {

        try (BufferedReader inputStream = new BufferedReader(new FileReader(path))) {
            int i = 0;
            String str;
            while ((str = inputStream.readLine()) != null) {
                try {
                    int t = Integer.parseInt(str);
                    highScore[i] = t;

                } catch (NumberFormatException e) {
                }
                i++;
            }
        } catch (FileNotFoundException ex) {
            saveHighScoresToFile();
        } catch (IOException e) {
        }
    }

    public void saveHighScoresToFile() {
        File file = new File(path);
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            for (int i = 0; i < highScore.length; i++) {
                pw.println(highScore[i]);
            }
            pw.flush();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    //slight namechange to clarify that only latest score gets sorted into existing list?
    public void sortHighScores(int score) {
        for (int i = 0; i < highScore.length; i++) {
            if (score > highScore[i]) {
                int temp = highScore[i];
                highScore[i] = score;
                score = temp;

            }
        }
    }

    public String getHighScores() {
                String str = "\nHigh Scores:\n";
        for (int i = 0; i < highScore.length; i++) {
            str += highScore[i] + "\n";
        }
        return str;
    }
}
