/**
  * Warrior is a decorator class upgrades the enemy by giving them two more HP, making their attack
  * vary from 1-3, and giving them a new title of Warrior added to their name
  */
public class Warrior extends EnemyDecorator {

  /**
  * This is the constructor for Warlock that takes the name of the enemy and adds
  * two HP to its original max getMaxHP
  * @param The enemy object is entered into the constructor to know which enemy gets
  * more HP
  */

  public Warrior(Enemy e) {
    super(e, e.getName(), e.getMaxHP() + 2);
  }

  /**
  * This method is for overriding the attack() method. This is for the entity to 
  * do random damage to another entity
  * @param Entity e is the entity the hero is doing damage to
  * @return String is returned showing the user who has done damage to what
  */

  @Override
  public String attack(Entity e){
    int damage = (int) (Math.random() * 3) + 1;
    e.takeDamage(damage);
    return getName() + " attacks" + e.getName() + " for " + damage + " damage.";
  }

  /**
  * This method takes the name of the original enemy and adds on the title Warrior to it
  */

  @Override
  public String getName() {
    return super.getName() + " Warrior";
  }

  /**
  * This method is used for getting the HP of the new Warrior that is created
  */

  @Override
  public int getHP(){
    return super.getHP();
  }
}
