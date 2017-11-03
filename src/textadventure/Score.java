package textadventure;

/**
 * Score class used to manage high scores
 * 
 * @author thomasfritzboger
 */
public class Score
{

  private String name;
  private int score;
/**
 * 
 * 
 * @param name
 * @param score 
 */
    public Score(String name, int score)
    {
        this.name = name;
        this.score = score;
    }
/**
 * Returns name of player
 * 
 * @return 
 */
    public String getName()
    {
        return name;
    }
/**
 * Returns player score
 * 
 * @return 
 */
    public int getScore()
    {
        return score;
    }
    
    
    
}