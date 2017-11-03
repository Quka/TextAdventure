package textadventure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Players having the highest number of rounds left when game is won
 *
 * @author thomasfritzboger
 */
public class HighScore {

    // private Player[] highScorePlayerName = new Player[5];
    private List<Score> scores = new ArrayList<Score>();
    private String path = "highScore.txt";

    /**
     * Contrucsts a high score by loading it from a txt file
     *
     */
    public HighScore() {
        loadHighScoresFromFile();
    }

    /**
     * Adds player score to an ArrayList of scores
     *
     * @param score
     */
    public void addScore(Score score) {
        scores.add(score);
    }

    /**
     *
     *
     * @return
     */
    public Score[] getScores() {
        Score[] scores = new Score[this.scores.size()];
        this.scores.toArray(scores);
        return scores;
    }

    /**
     * Loads high scores from txt file (only in the beginning of the program)
     *
     */
    public void loadHighScoresFromFile() {

        try (BufferedReader inputStream = new BufferedReader(new FileReader(path))) {
            int i = 0;
            String str;
            while ((str = inputStream.readLine()) != null) {
                try {
                    String[] parts = str.split(",");
                    if (parts.length != 2) {
                        throw new IllegalStateException();
                    }
                    String name = parts[0];
                    int t = Integer.parseInt(parts[1]);
                    scores.add(new Score(name, t));

                } catch (NumberFormatException e) {
                    throw new IllegalStateException(e);
                }
                i++;
            }
        } catch (FileNotFoundException ex) {
            //saveHighScoresToFile();
        } catch (IOException e) {
            throw new IllegalStateException();
        }

    }

    /**
     * Saves high scores to txt file
     *
     * @param number
     */
    public void saveHighScoresToFile(int number) {

        scores.sort((a, b) -> Integer.compare(b.getScore(), a.getScore()));

        File file = new File(path);
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            for (int x = 0; x < number && x < scores.size(); x++) {
                Score score = scores.get(x);
                pw.println(String.format("%s,%d", score.getName(), score.getScore()));
            }
            pw.flush();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    /**
     * Returns a string of the high scores
     * 
     * @return 
     */
    public String printScores() {
        String str = "";
        for (int i = 0; i < scores.size(); i++) {
            str += "\n" + scores.get(i).getScore() + "\t" + scores.get(i).getName();
        }
        str += "\n";
        return str;
    }

    @Override
    public String toString() {
        return "HighScore{\n" + "scores=" + scores + '}';
    }

}
