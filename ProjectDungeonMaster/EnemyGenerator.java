/**
  * The EnemyGenerator uses a decorator structural design pattern to create enemy type base classes. Each enemy is generated at random.  
  */
public class EnemyGenerator {
/**
  * This method constructs a new type of enemy at random. 
  * After the first level it'll decorate each enemy type. 
  * @param int level passes in the heros current level
  * @return a new constructed enemy 
  */
  public Enemy generateEnemy(int level) {
    int rand = (int) (Math.random() * 4) + 1;
    Enemy enemy = null;

    if (rand == 1) {
      enemy = new Froglok();
    } else if (rand == 2) {
      enemy = new Goblin();
    } else if (rand == 3) {
      enemy = new Troll();
    } else if (rand == 4) {
      enemy = new Orc();
    }

    if (level > 1) {
      rand = (int) (Math.random() * 2) + 1;
      if (rand == 1) {
        for (int i = 0; i < level; i++) {
          enemy = new Warlock(enemy);
          enemy.getHP();
        }
      } else if (rand == 2) {
        for (int i = 0; i < level; i++) {
          enemy = new Warrior(enemy);
          enemy.getHP();
        }
      }
    }
    return enemy;
  }
}
