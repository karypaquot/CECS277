/**
* Class Magical is an interface that is going to be implemented
* by other classes when fighting
*/

public interface Magical {
  
  /**
  * This variable is printed for when the user must choose bewtween the different
  * magic moves
  */

  public static final String MAGIC_MENU = "1. Magic Missile\n2. Fireball\n3. Thunderclap";

  /**
  * This method is to be overidden by other classes.
  * @param Entity e is the entity the move is being used.
  */

  public String magicMissile( Entity e );

  /**
  * This method is to be overidden by other classes.
  * @param Entity e is the entity the move is being used.
  */
  
  public String fireball( Entity e );

  /**
  * This method is to be overidden by other classes.
  * @param Entity e is the entity the move is being used.
  */
  
  public String thunderclap( Entity e );
}
