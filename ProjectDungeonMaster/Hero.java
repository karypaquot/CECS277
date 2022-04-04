/**
* Class Hero is the hero Object, it extends the Entity super class and implements 
* the Magical interface. It allows the hero to move about the map and fight.
*/
import java.awt.*;



public class Hero extends Entity implements Magical {

  /* Map object to delegate to
    Point object to delegate to
  */

  //public char map;
  //private Map map;
  private Point loc;
  private int level;
  private int gold;
  private int key;
  
  /**
  * Initializes/ constrcuts a Hero
  * @param hero name, maxHP
  */

  public Hero ( String n, int mHp ) {
    super(n, mHp);
    //map = new Map();
    //map.loadMap(1);
    loc = Map.getInstance().findStart();
    level = 1;
    gold = 50;
    key = 0;

  }

  /**
  * This method is overriding the string method for the level of the hero and map.
  * @return String of the level and map is returned to be printed for the user
  */

  @Override
  public String toString() {
    return super.toString() + "\nLevel: " + level + "\nGold:" + gold + "\nKeys:" + key + "\n" + Map.getInstance().mapToString(loc);
  }

  /**
  * This method is used for when the player exits the map and proceeds to the next one.
  * The location of the character is checked to see if they are on 'f' so they 
  * may move on to the next map if they have a key to use.
  */

  public void levelUp() {
    if(Map.getInstance().getCharAtLoc(loc) == 'f'){
      // add checker for key
      if (this.hasKey()) {
        level++;
        this.useKey();
        if (level%3 == 1) {
          Map.getInstance().loadMap(1);
          loc = Map.getInstance().findStart();
        } else if (level%3 ==2) {
          Map.getInstance().loadMap(2);
          loc = Map.getInstance().findStart();
        } else if (level%3 == 0) {
          Map.getInstance().loadMap(3);
          loc = Map.getInstance().findStart();
        }
      }
    }
  }

  public int getLevel() {
    return level;
  }

  /**
  * This method is for overriding the attack() method. This is for the entity to 
  * do random damage to another entity
  * @param Entity e is the entity the hero is doing damage to
  * @return String is returned showing the user who has done damage to what
  */

  @Override
  public String attack( Entity e ) {
    int randomAttack = (int)(Math.random() * 7) + 1;
    e.takeDamage(randomAttack);
    return this.getName() + " hits " + e.getName() + " for " + randomAttack + " damage.";
  }

  /**
  * This method is for the hero to move north on the map as well as revealing
  * the location and removing the character
  * @return character is then returned
  */

  public char goNorth() {
    if(loc.getY() != 0) {
      loc.translate(0, -1);
      //map.reveal(loc.getLocation()); //need to remove
      char removed = Map.getInstance().getCharAtLoc(loc);
      //map.removeCharAtLoc(loc.getLocation()); //need to remove
      return removed;
    }
    return 'x';
  }

  /**
  * This method is for the hero to move south on the map as well as revealing
  * the location and removing the character
  * @return character is then returned
  */

  public char goSouth() {
    if(loc.getY() != 4) {
      loc.translate(0, 1);
      //map.reveal(loc.getLocation()); //need to remove
      char removed = Map.getInstance().getCharAtLoc(loc);
      //map.removeCharAtLoc(loc.getLocation()); //need to remove
      return removed;
    }
    return 'x';
  }

  /**
  * This method is for the hero to move east on the map as well as revealing
  * the location and removing the character
  * @return character is then returned
  */

  public char goEast() {
    if(loc.getX() != 4) {
      loc.translate(1, 0);
      //map.reveal(loc.getLocation()); //need to remove
      char removed = Map.getInstance().getCharAtLoc(loc);
      //map.removeCharAtLoc(loc.getLocation()); //need to remove
      return removed;
    }
    return 'x';
  }
  
  /**
  * This method is for the hero to move west on the map as well as revealing
  * the location and removing the character
  * @return character is then returned
  */

  public char goWest() {
    if(loc.getX() != 0) {
      loc.translate(-1, 0);
      //map.reveal(loc.getLocation()); //need to remove
      char removed = Map.getInstance().getCharAtLoc(loc);
      //map.removeCharAtLoc(loc.getLocation()); //need to remove
      return removed;
    }
    return 'x';
  }

  public Point getLoc() {
    return loc;
  }

  /**
  * This is the magicMissile() method that is overidden. A random number for damage is 
  * generated to entity.
  * @param Entity e is passed in as what damage is dealt to
  * @return returns a string formatted to let the enemy know who did damage to who
  */

  @Override
  public String magicMissile (Entity e) {
    int damage = (int) ((Math.random() * ((6-1) + 1)) +1);
    e.takeDamage(damage);
    return this.getName() + " hits " + e.getName() + " for " + damage + " damage.";
  }

  /**
  * This is the fireball() method that is overidden. A random number for damage is 
  * generated to entity.
  * @param Entity e is passed in as what damage is dealt to
  * @return returns a string formatted to let the enemy know who did damage to who
  */

  @Override
  public String fireball (Entity e) {
    int damage = (int) ((Math.random() * ((6-1) + 1)) +1);
    e.takeDamage(damage);
    return this.getName() + " hits " + e.getName() + " for " + damage + " damage.";
  }
  
  /**
  * This is the thunderclap() method that is overidden. A random number for damage is 
  * generated to entity.
  * @param Entity e is passed in as what damage is dealt to
  * @return returns a string formatted to let the enemy know who did damage to who
  */

  @Override
  public String thunderclap (Entity e) {
    int damage = (int) ((Math.random() * ((6-1) + 1)) +1);
    e.takeDamage(damage);
    return this.getName() + " hits " + e.getName() + " for " + damage + " damage.";
  }

  public int getGold() {
    return gold;
  }

  public void collectGold( int g ) {
    gold += g;
  }

  public void spendGold( int g ) {
    gold -= g;
  } 

  public boolean hasKey() {
    boolean hasKey;
    if (key > 0) {
      hasKey = true;
    }else {
      hasKey = false;
    }
    return hasKey;
  }

  public void pickUpKey() {
    key += 1;
  }

  public boolean useKey(){
    boolean useKey = true;
    key -= 1;
    return useKey;
  }
}
