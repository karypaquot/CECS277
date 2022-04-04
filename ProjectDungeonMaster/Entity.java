/**
 * The Entity class creates the methods that an entity, such as a Enemy or Hero, would need to be distinguished from each other, such as a name, and be able to fight, such as having hp or and attack method.
*/
public abstract class Entity {
  private String name;
  private int maxHp;
  private int hp;

  /**
  * This method is the constructor for entity passing in the name and the maximum
  * HP of the entity
  */
  public Entity( String n, int mHp ) {
    name = n;
    maxHp = mHp;
    hp = mHp;
  }

  /**
  * This method is an abstract that is going to be overriden
  */
  public abstract String attack( Entity e );

  /**
  * This method is an accessor to return the name
  * @return String is returned for the name
  */

  public String getName(){
    return name;
  }
  
  /**
  * This method is an accessor to return the value of Hp
  * @return String returns the value of the hp
  */

  public int getHP() {
    return hp;
  }

  /**
  * This method is an accessor to return the value of maximum Hp
  * @return String returns the value of the hp
  */

  public int getMaxHP() {
    return maxHp;
  }

  /**
  * This method is for healing the player
  * @param int h is passed in as the hero being healed
  */

  public void heal( int h ) {
    hp += h;
    if ( hp > maxHp ) {
      hp = maxHp;
    }
    else if (hp <= maxHp) {
      hp += 0;
    }
  }

  /**
  * This method is for dealing damage to the entity
  * @param int d is the amount of damage that will taken from Hp
  */

  public void takeDamage( int d ) {
    hp -= d;
    if (hp < 0) {
      hp = 0;
    }
    else if (hp > 0) {
      hp += 0;
    }
  }

  /**
  * This method is overriding the string method for the level of the hero and map.
  * @return String of the level and map is returned to be printed for the user
  */
  
  @Override
  public String toString() {
    return name + "\n" + "HP: " + hp + "/" + maxHp;
  }
}
