/* Gregory Fox
 * Software Development One
 * 1/30/14 */

import java.util.Scanner;

public class Game {

  // Global
  public static int currentLocale = 0;  // Player starts in The Lab.
  public static String command;
  public static boolean stillPlaying = true;
  
  public static String[] locations;  // Declare an array of type String. This is uninitialized. See init() for that.
         
  public static void main(String[] args) {
     init();
     updateDisplay();
     
     // Game Loop
     while (stillPlaying) {
        getCommand();
        navigate();
        updateDisplay();
     }  
     System.out.println("Thank you for playing.");
  }
  
  

  private static void init() {
     command = new String();
     stillPlaying = true;
     
     // NEW
	 // Set up the location list.
	 locations = new String[3];
	 locations[0] = "The Lab";
	 locations[1] = "Dungeon";
	 locations[2] = "TARDIS";
  }

  private static void updateDisplay() {
     String msg = new String();
     msg = "";
     switch (currentLocale) {
        case 0: msg = "North America";
                break;
        case 1: msg = "South America";
                break;
        case 2: msg = "Antarctica";
                break;
        
        default: msg = "currentLocale " + currentLocale + " does not compute.";
     }
     System.out.println(msg);
  } 

  private static void getCommand() {
     Scanner inputReader = new Scanner(System.in);
     // command is global.
     command = inputReader.nextLine();     
  }

  private static void navigate() {
     if ( command.equals("north") || command.equals("n") || command.equals("N") || command.equals("North") ){
        // We are going NORTH. But from where...?
        if (currentLocale == 1) {
           currentLocale = 0;           
        } else if (currentLocale == 0) {
           currentLocale = 2;       
        }

     } else if ( command.equals("south") || command.equals("s") || command.equals("S") || command.equals("South") ) {
        // We are going SOUTH. But from where...?
        if (currentLocale == 2) {
           currentLocale = 0;           
        } else if (currentLocale == 0) {
           currentLocale = 1;       
        }

        
     } else if ( command.equals("quit") || ( command.equals("Quit") || ( command.equals("end") || ( command.equals("End") || ( command.equals("finish") || ( command.equals("Finish") ) {
        stillPlaying = false;
     }
  }

}
