/**
* Class Map represents the map object which loads up and creates the map to  
* an array
*/
import java.awt.Point;
import java.util.Scanner;
import java.io.*;



class Map {

  private char[][] map ;
  private boolean[][] revealed;
  private static Map instance = null;

  /**
  * This method is the constructor for map, creating a 5x5 array for the characters
  * as well as the spots the character has visited in the boolean.
  *
  */
  private Map() {
    map = new char[5][5];
    revealed = new boolean[5][5];
    loadMap(1);
  }
  /**
  * This method returns the one instance of Map.
  * @return The one instance of Map is returned
  */
  public static Map getInstance() {
    if ( instance == null) {
      instance = new Map();
    }
    return instance;
  }

  /**
  * This method chooses the map that will be played on. The map will then be read 
  * from a text file and put into an array.
  * @param mapNum integer that correlates with map that will be selected
  */

  public void loadMap(int mapNum){
    String mapText = "";
    //Need to add random for chosing map
    //mapNum = 1;
    if (mapNum == 1) {
      mapText = "Map1.txt";
    } 
    else if (mapNum == 2) {
      mapText = "Map2.txt";
    }
    else {
      mapText = "Map3.txt";
    }
  

  try {
    Scanner read = new Scanner (new File(mapText));

    String line = read.nextLine();
    line = line.replaceAll("\\s", "");
    map[0] = line.toCharArray();

    String line1 = read.nextLine();
    line1 = line1.replaceAll("\\s", "");
    map[1] = line1.toCharArray();

    String line2 = read.nextLine();
    line2 = line2.replaceAll("\\s", "");
    map[2] = line2.toCharArray();

    String line3 = read.nextLine();
    line3 = line3.replaceAll("\\s", "");
    map[3] = line3.toCharArray();

    String line4 = read.nextLine();
    line4 = line4.replaceAll("\\s", "");
    map[4] = line4.toCharArray();
                
    read.close();

    
    read.close();
  } catch (FileNotFoundException fnf) {
      System.out.println("File was not found");
  }
  
  }

  /**
  * This method return the location of a specific character on the map.
  * @param p Point object used to find the character location
  * @return The character on the map of the specified point is returned
  */

  public char getCharAtLoc(Point p) {
    for(int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (p.getX() == j && p.getY() == i) {
                    return map[i][j];
                }
            }
        }
        return 0;
  }


  /**
  * This method displays the map for the character showing 'n' for revealed locations, 
  * 'x' for locations not revealed, and '*' showing the current location of the hero.
  * @param Point p is for the location of the hero
  * @return String s is returned showing the formatted map for the player
  */

  public String mapToString(Point p){
        String s = "";
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                //To represent the location
                if(i == p.getY() && j == p.getX()){
                    s+= '*';
                } else if(!revealed[i][j]){ //To represent unrevealed locations
                    s += 'x';
                } else if(revealed[i][j] || map[i][j] != 's'){ //To represent the map
                    s+= map[i][j];
                }
                s += " ";
            }
            s+= "\n";
        }
        return s;
    }

  /**
  * This method is used the find the starting location on the map
  * @return Point num is returned giving the location of 's' from the map
  */

  public Point findStart() {
    int x = 0;
    int y = 0;
    for (int i = 0; i <5; i++) {
      for (int j =0; j<5; j++) {
        if (map[i][j] == 's') {
          x = j;
          y = i;
        }
      }
    }
    Point num = new Point(x,y);
    revealed = new boolean[5][5];
    reveal(num);
    return num;
  }
  
  /**
  * This method uses the boolean array to keep track of what spaces have been visited.
  * @param Point p is compared to every index of boolean and turns the correct 
  * coordinates to true.
  */

  public void reveal(Point p) {
    for(int i = 0; i < revealed.length; i++){
            for (int j = 0; j < revealed[0].length; j++){
                if(i == p.getY() && j == p.getX()){
                    revealed[i][j] = true;
                }
            }
        }
  }

  /**
  * This method removes the character at location p and replaces it with 'n'.
  * @param Point p is passed in as the point that is getting replaced with 'n', 
  * this is excluding 's'
  */

  public void removeCharAtLoc(Point p){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(i == p.getY() && j == p.getX() && map[i][j] != 's'){
                    map[i][j] = 'n';
                }
            }
        }
    }
}

