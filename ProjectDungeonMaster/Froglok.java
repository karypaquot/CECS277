/**
  * Froglok is a base class that represents a type of enemy you encounter which extends the Enemy class
  */

public class Froglok extends Enemy {

  /**
  * This is the constructor for the Froglok class
  */

  public Froglok() {
    super("Froglok", 3);

  }

  /**
  * This method is for overriding the attack() method. This is for the entity to 
  * do random damage to another entity
  * @param Entity e is the entity the hero is doing damage to
  * @return String is returned showing the user who has done damage to what
  */

  @Override
  public String attack(Entity e) {
    int damage = (int) (Math.random() * 3) + 1;
    e.takeDamage(damage);
    return super.getName() + " attacks " + e.getName() + " for " + damage + " damage.";
  }

}
