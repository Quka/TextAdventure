package textadventure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thomasfritzboger
 */
public class HighScore
{

    // private Player[] highScorePlayerName = new Player[5];
    private List<Score> scores = new ArrayList<Score>();
    private String path = "highScore.txt";

    public HighScore()
    {
        loadHighScoresFromFile();
    }

    public void addScore(Score score)
    {
        scores.add(score);
    }

    public Score[] getScores()
    {
        Score[] scores = new Score[this.scores.size()];
        this.scores.toArray(scores);
        return scores;
    }

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
                    String[] parts = str.split(",");
                    if (parts.length != 2)
                    {
                        throw new IllegalStateException();
                    }
                    String name = parts[0];
                    int t = Integer.parseInt(parts[1]);
                    scores.add(new Score(name, t));

                } catch (NumberFormatException e)
                {
                    throw new IllegalStateException(e);
                }
                i++;
            }
        } catch (FileNotFoundException ex)
        {
            //saveHighScoresToFile();
        } catch (IOException e)
        {
            throw new IllegalStateException();
        }

    }

    public void saveHighScoresToFile(int number)
    {

        scores.sort((a, b) -> Integer.compare(b.getScore(), a.getScore()));

        File file = new File(path);
        try (PrintWriter pw = new PrintWriter(new FileWriter(file)))
        {
            for (int x = 0; x < number && x < scores.size(); x++)
            {
                Score score = scores.get(x);
                pw.println(String.format("%s,%d", score.getName(), score.getScore()));
            }
            pw.flush();
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }
    
    public String printScores()
    {
        String str = "";
        for (int i = 0; i < scores.size(); i++)
        {
            str += "\n" + scores.get(i).getScore() + "\t" + scores.get(i).getName();
        }
        str += "\n\n";
        return str;
    }

    @Override
    public String toString()
    {
        return "HighScore{\n" + "scores=" + scores + '}';
    }
    
    
}