/**
 * The Enemy class is abstract and extends the abstract Entity class which gives an enemy instance a name, hp, and an attack method
 *
*/
public abstract class Enemy extends Entity {

  /**
  * This method is the constructor for enemy with String name and int mHP as
  * parameters
  * @param String n is for the enemy name
  * @param int mHp is for the maximum Hp of the enemy
  */

  public Enemy(String n, int mHp){
    super(n, mHp);
  }

  /**
  * This method is for overriding the attack() method. This is for the entity to 
  * do random damage to another entity
  * @param Entity e is the entity the hero is doing damage to
  * @return String is returned showing the user who has done damage to what
  */

  @Override
  public String attack(Entity e) {
    int randAttack = (int)(Math.random() * 10) + 1;
    e.takeDamage(randAttack);
    return this.getName() + " attacks " + e.getName() + " for " + randAttack + " damage.";
  }
}
