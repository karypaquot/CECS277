/**
  * Warlock is a decorator class that upgrades the enemy and increases their health by one, turn their 
  * attacks into magical attack, and are given a new title of Warlock added to their name
  */

public class Warlock extends EnemyDecorator implements Magical {
  
  /**
  * This is the constructor for Warlock that takes the name of the enemy and adds
  * one HP to its original max getMaxHP
  * @param The enemy object is entered into the constructor to know which enemy gets
  * more HP
  */

  public Warlock(Enemy e) {
    super(e, e.getName(), e.getMaxHP() + 1);
  }

  /**
  * This method is for overriding the attack() method. This is for the entity to 
  * do random damage to another entity
  * @param Entity e is the entity the hero is doing damage to
  * @return String is returned showing the user who has done damage to what
  */

  @Override
  public String attack( Entity e ) {
    int select = (int)(Math.random() * 3) + 1;
    if (select == 1) {
      return magicMissile(e);
    }
    else if (select == 2) {
      return fireball(e);
    }
    else if (select == 3) {
      return thunderclap(e);
    }
    return null;
  }

  /**
  * This method takes the name of the original enemy and adds on the title Warlock to it
  */

  @Override
  public String getName() {
    return super.getName() + " Warlock";
  }

  /**
  * This is the magicMissile() method that is overidden. A random number for damage is 
  * generated to entity.
  * @param Entity e is passed in as what damage is dealt to
  * @return returns a string formatted to let the enemy know who did damage to who
  */

  @Override
  public String magicMissile(Entity e) {
    int randAttack = (int) (Math.random() * 3);
    e.takeDamage(randAttack);
    return getName() + " hits " + e.getName() + " with Thunderclap for " + randAttack + " damage.";
  }

  /**
  * This is the fireball() method that is overidden. A random number for damage is 
  * generated to entity.
  * @param Entity e is passed in as what damage is dealt to
  * @return returns a string formatted to let the enemy know who did damage to who
  */

  @Override
  public String fireball(Entity e) {
    int randAttack = (int) (Math.random() * 4);
    e.takeDamage(randAttack);
    return getName() + " hits " + e.getName() + " with Fireball for " + randAttack + " damage.";
  }

  /**
  * This is the thunderclap() method that is overidden. A random number for damage is 
  * generated to entity.
  * @param Entity e is passed in as what damage is dealt to
  * @return returns a string formatted to let the enemy know who did damage to who
  */

  @Override
  public String thunderclap(Entity e) {
    int randAttack = (int) (Math.random() * 3) + 1;
    e.takeDamage(randAttack);
    return getName() + " hits " + e.getName() + " with Thunderclap for " + randAttack + " damage.";
  }

}
