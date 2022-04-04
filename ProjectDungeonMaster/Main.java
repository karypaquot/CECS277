/**
* Authors: Ari Montes, Karina Hernandez, Amanda Ramirez
* CECS277 
* 5/4/2021
* Project 2 - Dungeon Master 
* Dungeon master game allows a Hero to move through 3 different maps where they run across Enemies. 
* The hero may choose to fight or run from Enemy, with the goal being to escape.
* When locating the exit of each map the Hero may escape with a key to level up and move on to the next map. 
* Game ends when Hero quits or dies.
*/
import java.util.Scanner;
class Main {
  
  /**
  * This method is for the player to play the game by asking for their name 
  * of choice, which direction they choose to go in as well as if
  * they land on the space 'm' for attacking
  */

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("What is your name, traveler? ");
    String tempName = in.nextLine();
    Hero hero = new Hero(tempName, 25);
    int choice = 0;
    boolean heroHealth = true;
    //Plays the game until the user quits
    while (choice != 5) {
      System.out.print(hero);
      int pick;
      if (Map.getInstance().getCharAtLoc(hero.getLoc()) == 's'){ 
        System.out.println("1. Go North \n2. Go South \n3. Go East \n4. Go West \n5. Quit \n6. Visit Store");
        pick = CheckInput.getIntRange(1, 6);
      } else{
        System.out.println("1. Go North \n2. Go South \n3. Go East \n4. Go West \n5. Quit");
        pick = CheckInput.getIntRange(1, 5);
      }
      //System.out.println("1. Go North \n2. Go South \n3. Go East \n4. Go West \n5. Quit");
      //int pick = CheckInput.getIntRange(1, 5);
      char dir;
      
      //Hero moves north on map
      if (pick == 1) {
        hero.goNorth();
        dir = Map.getInstance().getCharAtLoc(hero.getLoc());
        Map.getInstance().reveal(hero.getLoc());
        if (dir == 'x') {
          System.out.println("You can't go that way.");
        } else if (dir == 'n') {
          Map.getInstance().removeCharAtLoc(hero.getLoc());
          System.out.println("There was nothing here.");
        } else if (dir == 'f') {
          // It is determined whether the hero has the required key to move on or not
          if (hero.hasKey()) {
            System.out.println("You found the exit. Proceeding to the next level.");
          }
          else {
            System.out.println("You do not have a key!");
          }
        } else if (dir == 's') {
          System.out.println("You're back at the start.");
        } else if (dir == 'i') {
          Map.getInstance().removeCharAtLoc(hero.getLoc());
          // A random number between 1-2 is chosen in order to determine 
          // whether the hero recieves a key or heatlh potion
          double rand_num = Math.floor((Math.random() * 2) + 1);
          if (rand_num == 1.0) {
          System.out.println("You found a health potion! \nYou drink to restore your health");
          hero.heal(25); }
          else {
            hero.pickUpKey();
            System.out.println("You have found a key!");
          }
        } else if (dir == 'm') {
          EnemyGenerator gen = new EnemyGenerator();
          Enemy enemy = gen.generateEnemy(hero.getLevel()); //Creates enemy 
          heroHealth = monsterRoom(hero, enemy); //Calls monsterRoom()
        }
        hero.levelUp();
      }
      //Hero moves South on map
      else if(pick == 2) {
        hero.goSouth();
        dir = Map.getInstance().getCharAtLoc(hero.getLoc());
        Map.getInstance().reveal(hero.getLoc());
        if (dir == 'x') {
          System.out.println("You can't go that way.");
        } else if (dir == 'n') {
          Map.getInstance().removeCharAtLoc(hero.getLoc());
          System.out.println("There was nothing here.");
        } else if (dir == 'f') {
          if (hero.hasKey()) {
            System.out.println("You found the exit. Proceeding to the next level.");
          }
          else {
            System.out.println("You must have a key to go to the next level.");
          }
        } else if (dir == 's') {
          System.out.println("You're back at the start.");
        } else if (dir == 'i') {
          Map.getInstance().removeCharAtLoc(hero.getLoc());
          double rand_num = Math.floor((Math.random() * 2) + 1);
          if (rand_num == 1.0) {
          System.out.println("You found a health potion! \nYou drink to restore your health");
          hero.heal(25); }
          else {
            hero.pickUpKey();
            System.out.println("You have found a key!");
          }
        } else if (dir == 'm') {
          EnemyGenerator gen = new EnemyGenerator();
          Enemy enemy = gen.generateEnemy(hero.getLevel()); //Creates enemy
          heroHealth = monsterRoom(hero, enemy); //Calls monsterRoom()
        }
        hero.levelUp();
      }
      //Hero moves East on map
      else if(pick == 3) {
        hero.goEast();
        dir = Map.getInstance().getCharAtLoc(hero.getLoc());
        Map.getInstance().reveal(hero.getLoc());
        if (dir == 'x') {
          System.out.println("You can't go that way.");
        } else if (dir == 'n') {
          Map.getInstance().removeCharAtLoc(hero.getLoc());
          System.out.println("There was nothing here.");
        } else if (dir == 'f') {
          if (hero.hasKey()) {
            System.out.println("You found the exit. Proceeding to the next level.");
          }
          else {
            System.out.println("You do not have a key!");
          }
        } else if (dir == 's') {
          System.out.println("You're back at the start.");
        } else if (dir == 'i') {
          Map.getInstance().removeCharAtLoc(hero.getLoc());
          double rand_num = Math.floor((Math.random() * 2) + 1);
          if (rand_num == 1.0) {
          System.out.println("You found a health potion! \nYou drink to restore your health");
          hero.heal(25); }
          else {
            hero.pickUpKey();
            System.out.println("You have found a key!");
          }
        } else if (dir == 'm') {
          EnemyGenerator gen = new EnemyGenerator();
          Enemy enemy = gen.generateEnemy(hero.getLevel()); //Creates enemy
          heroHealth = monsterRoom(hero, enemy); //Calls monsterRoom()
        }
        hero.levelUp();
      }
      //Hero moves west on map
      else if(pick == 4) {
        hero.goWest();
        dir = Map.getInstance().getCharAtLoc(hero.getLoc());
        Map.getInstance().reveal(hero.getLoc());
        if (dir == 'x') {
          System.out.println("You can't go that way.");
        } else if (dir == 'n') {
          Map.getInstance().removeCharAtLoc(hero.getLoc());
          System.out.println("There was nothing here.");
        } else if (dir == 'f') {
          if (hero.hasKey()) {
            System.out.println("You found the exit. Proceeding to the next level.");
          }
          else {
            System.out.println("You do not have a key!");
          }
        } else if (dir == 's') {
          System.out.println("You're back at the start.");
        } else if (dir == 'i') {
          Map.getInstance().removeCharAtLoc(hero.getLoc());
          double rand_num = Math.floor((Math.random() * 2) + 1);
          if (rand_num == 1.0) {
          System.out.println("You found a health potion! \nYou drink to restore your health");
          hero.heal(25); }
          else {
            hero.pickUpKey();
            System.out.println("You have found a key!");
          }
        } else if (dir == 'm') {
          EnemyGenerator gen = new EnemyGenerator();
          Enemy enemy = gen.generateEnemy(hero.getLevel()); //Creates enemy
          heroHealth = monsterRoom(hero, enemy); //Calls monsterRoom()
        }
        hero.levelUp();
      }
      else if(pick == 5) {
        choice = 5;
      }
      else if (pick == 6){
        store(hero);
      }
        if(!heroHealth) {
          System.out.println("You died.");
          break;
        }
      
    }
    System.out.println("Game Over");
  }

  /**
  * This method is for when the hero encounters an enemy. It displays for 
  * them enemy name and HP. They will either be able to run or fight which
  * will not stop until either the hero is dead or the enemy
  * @param Enemy e is the enemy that is chosen when landing on the space
  * @param Hero h is hero object
  * @return boolean on whether the hero is alive or not
  */
  
  public static boolean monsterRoom(Hero h, Enemy e) {
    System.out.println("You've encountered a " + e.toString());
    boolean alive = true;
    while(e.getHP() != 0) {
      System.out.println("1. Fight \n2. Run Away");
      int choice = CheckInput.getIntRange(1, 2);
      if (choice == 1) {
        alive = fight(h,e);
        if (alive) {
          System.out.println(e);
          continue;
        }
        else {
          return alive;
        }
      }if (choice == 2) {
        int runChoice = (int)((Math.random() *4) +1);
        if (runChoice == 1) {
          h.goNorth();
        } else if (runChoice == 2) {
          h.goSouth();
        } else if (runChoice == 3) {
          h.goEast();
        }
        else if (runChoice == 4) {
          h.goWest();
        }
        break;
      } 
    }
    if(!(h.getHP() > 0)) {
      alive = false;
      return alive;
    }
    if (e.getHP() == 0) {
      Map.getInstance().removeCharAtLoc(h.getLoc());
      int rand = (int)((Math.random() * 8)+3);
      h.collectGold(rand);
      System.out.println("You defeated the " + e.getName() + "!");
      System.out.println("You have collected " + rand + " gold!");
      return alive;
    }
    return alive;
  }
  /**
  * This method is to fight an enemy with with either a physical attack or magical attack.
  * enemy returns an attack if they are still alive. 
  * @param Hero h passes hero object
  * @param Enemy e is the enemy that is chosen when landing on the space
  * @return String is returned showing the user who has done damage to what
  */
  
  public static boolean fight(Hero h, Enemy e) {
    Scanner in = new Scanner(System.in);
    System.out.println("1. Physical Attack \n2. Magic Attack");
    boolean alive = true;
    int choice = CheckInput.getIntRange(1, 2);
    //Hero prompts a physical attack with choice 1
    if (choice == 1) {
      System.out.println(h.attack(e));
      //Hero prompts magical attack with choice 2
    } else if (choice == 2) {
      System.out.println(Magical.MAGIC_MENU);
      int magicAttack = in.nextInt();
      if (magicAttack == 1) {
        System.out.println(h.magicMissile(e)); // calls magicMissle()
      } else if (magicAttack == 2) {
        System.out.println(h.fireball(e)); // calls fireball()
      } else if (magicAttack == 3) {
        System.out.println(h.thunderclap(e)); // calls thunderclap()
      }
    }
    if (e.getHP() > 0) {
      System.out.println(e.attack(h));
    }
    if(h.getHP() > 0) {
      return alive;
    }
    else {
      alive = false;
      return alive;
    }
  }

/**
  * This method is to visit the store to buy items like health potions or keys.
  * In order to buy items the hero must have sufficient amount of gold.
  * @param Hero h passes hero object
  */
  public static void store( Hero h ) {
    int healthPotions = 25;
    int keys = 50;
    System.out.println("Welcome to the store!");
    int selection = 0;
    while (selection != 3){
      System.out.println("1. Buy Health Potions (25 gold) \n2. Buy Keys (50 gold) \n3. Exit Store");
      int choice = CheckInput.getIntRange(1, 3);
      if (choice == 1) {
        if (h.getGold() >= healthPotions){
          h.heal(healthPotions);
          h.spendGold(healthPotions); 
          System.out.println("You purchased a health Potion! Your HP has increased to " + h.getHP() + " and you're left with " + h.getGold() + " gold.");
          System.out.println("Would you like to buy anything else?");
        }
        else if (h.getGold() < healthPotions) {
          System.out.println("You cannot afford this item. You currently have " + h.getGold() + " gold.");
        }
      }
      else if (choice == 2){
        if(h.getGold() >= keys) {
          h.pickUpKey();
          h.spendGold(keys);
          System.out.println("You bought a key! Now you are left with " + h.getGold() + " gold.");
        }
        else if(h.getGold() < keys) {
          System.out.println("You cannot afford this item. You currently have " + h.getGold() + " gold.");          
        }
      }
      else if (choice == 3){
        System.out.println("Leaving the store.");
        selection = choice;
      }
    }    
  }
}
