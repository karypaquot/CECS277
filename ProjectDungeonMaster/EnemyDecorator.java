/**
 * EnemyDecorator is an abstract class that extends from the parent Enemy abstract class. It uses a structural design pattern to extend the Enemy abstract class.  This is done so that it can utilize inheritance from the super class. 
 */
public abstract class EnemyDecorator extends Enemy {
  private Enemy enemy;

/**
  * This method constructs an instance of the Enemy 
  * @param Enemy e passes enemy object
  * @param String n passes enemy name
  * @param int hp passes enemies hp
  */
  public EnemyDecorator(Enemy e, String n, int hp){
    super(n, hp);
  }

/**
  * This method Overrides the abstract class methods to modify the behavior of the object
  * @param Entity e passes Entity object
  * @return String is returned showing the user the enemies attack on the entity
  */
  @Override
  public String attack(Entity e){
    return enemy.attack(e);
  }
}
