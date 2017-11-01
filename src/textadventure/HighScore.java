/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

import java.io.*;

/**
 *
 * @author thomasfritzboger
 */
public class HighScore
{
//    public static void main(String[] args)
//    {
//        HighScore h = new HighScore();
//        
//        Player p = new Player("Thomas", null);
//        Player p2 = new Player("Alexander", null);
//
//        p.setRoundsLeft(75);
//        p2.setRoundsLeft(90);
//        h.highScorePlayerName[0]=p;
//        
//        h.sortHighScorePlayerName(p2);
//        h.saveHighScoresToFile2();
//        h.getHighScores();
//    }

   // private Player[] highScorePlayerName = new Player[5];
    private int[] highScore = new int[5];
    private String path = "highScore.txt";

    // Run in the start of the game only //
    public void loadHighScoresFromFile()
    {

        try (BufferedReader inputStream = new BufferedReader(new FileReader(path)))
        {
            int i = 0;
            String str;
            while ((str = inputStream.readLine()) != null)
            {
                try
                {
                    int t = Integer.parseInt(str);
                    highScore[i] = t;

                } catch (NumberFormatException e)
                {
                }
                i++;
            }
        } catch (FileNotFoundException ex)
        {
            saveHighScoresToFile();
        } catch (IOException e)
        {
        }
    }

    public void saveHighScoresToFile()
    {
        File file = new File(path);
        try (PrintWriter pw = new PrintWriter(new FileWriter(file)))
        {
            for (int i = 0; i < highScore.length; i++)
            {
                pw.println(highScore[i]);
            }
            pw.flush();
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }

    //slight namechange to clarify that only latest score gets sorted into existing list?
    public void sortHighScores(int score)
    {
        for (int i = 0; i < highScore.length; i++)
        {
            if (score > highScore[i])
            {
                int temp = highScore[i];
                highScore[i] = score;
                score = temp;  

            }
        }
    }

//    public void sortHighScorePlayerName(Player p)
//    {
//       
//            for (int i = 0; i < highScorePlayerName.length; i++)
//            {
//                if (highScorePlayerName[i]!=null && p.getRoundsLeft() > highScorePlayerName[i].getRoundsLeft())
//                {
//                    Player temp = highScorePlayerName[i];
//                    highScorePlayerName[i] = p;
//                   highScorePlayerName[i+1] = temp;
//
//                }
//            }
//        
//    }

//    public void saveHighScoresToFile2()
//    {
//        File file = new File(path);
//        try (PrintWriter pw = new PrintWriter(new FileWriter(file)))
//        {
//            for (int i = 0; i < highScorePlayerName.length; i++)
//            {
//                pw.println(highScorePlayerName[i]);
//            }
//            pw.flush();
//        } catch (IOException ex)
//        {
//            System.out.println(ex);
//        }
//    }
//    
//    public void loadHighScoresFromFile2()
//    {
//
//        try (BufferedReader inputStream = new BufferedReader(new FileReader(path)))
//        {
//            int i = 0;
//            String str;
//            while ((str = inputStream.readLine()) != null)
//            {
//                try
//                {
//                    
//                  //  highScorePlayerName[i] = str;
//
//                } catch (NumberFormatException e)
//                {
//                }
//                i++;
//            }
//        } catch (FileNotFoundException ex)
//        {
//            saveHighScoresToFile();
//        } catch (IOException e)
//        {
//        }
//    }

    public String getHighScores()
    {
        String str = "\nHigh Scores:\n";
        for (int i = 0; i < highScore.length; i++)
        {
            str += highScore[i] + "\n";
        }
        str += "\n";
        return str;
    }
}
