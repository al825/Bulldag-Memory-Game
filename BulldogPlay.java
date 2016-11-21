import java.awt.Color;
import java.awt.Font;

/**
 *  This class provides a BulldogPlay class which is the entire game 

 */

public class BulldogPlay{
  
  public static final int width = 1000;
  public static final int height = 750;
  public static final int offset = 4;
  public static final int Xcenter = 500;
  public static final int Ycenter = 300;
  public static int n = 4;
  public static int level = 1;
  public static final int levelMax = 3;
  public static int round;
  public static final int roundMax = 3;
  
  
  
  public static void message(int width, int height, Level lev){
    StdDraw.setPenColor(Color.GREEN);
    Font font = new Font("Arial", Font.BOLD, 60);
    StdDraw.setFont(font);
    FinalScreen finalScreen ;
    
      
    if(nextLevel(lev)){
      StdDraw.text(width/2, height/2, "Level "+  level + " Passed !");
      level++;
      if (level>levelMax){
        //StdDraw.text(width/2, height/2-100, "All Levels Passed!");
        try {
          Thread.sleep(1000);
        } catch (Exception e){System.out.println(e);}
        StdDraw.clear();
        StdDraw.setPenColor(Color.BLACK);
        finalScreen = new FinalScreen();
        finalScreen.drawFinalScreen(Xcenter,Ycenter, true);
      }
      
    }
    
    if (nextRound(lev)){
      StdDraw.text(width/2, height/2, "Level "+  level + " Round " + round + " Failed...");
      StdDraw.text(width/2, height/2-100, "Prepare to play the next round!");
      round++;
    }
    
    else if (gameOver(lev)){
      //StdDraw.text(width/2, height/2+100, "GAME OVER");
      StdDraw.clear();
      StdDraw.setPenColor(Color.BLACK);
      finalScreen = new FinalScreen();
      finalScreen.drawFinalScreen(Xcenter,Ycenter, false);

      try {
        Thread.sleep(5000);
      } catch (Exception e){System.out.println(e);}
      System.exit(0);
    }
    
    StdDraw.show(2000);
    StdDraw.clear();

  }
  
  public static boolean nextLevel(Level lev){
    return (lev.getAttemptRemain()>0 & level<=levelMax & round<=roundMax);
  }
  
  public static boolean nextRound(Level lev){
    return (lev.getAttemptRemain()==0 & round<roundMax);
  }
  
  public static boolean gameOver(Level lev){
    return (lev.getAttemptRemain()==0 & round==roundMax);
  }
  
  
  
  
  public static void main(String[] args){
    
    //int n = Integer.parseInt(args[0]);

    
    
    // Set up the canvas, change scale from the default of [0 - 1.0].
    StdDraw.setCanvasSize(width, height);
    StdDraw.setXscale(0, width);
    StdDraw.setYscale(0, height);
    
    StartScreen startscreen=new StartScreen();
    startscreen.showStartScreen(width, height,  Xcenter,Ycenter);
    Level levelToPlay;
    
    try {
        Thread.sleep(1000);
      } catch (Exception e){System.out.println(e);}

    
    while(level<=levelMax){
      round = 1;
      do{
        
        levelToPlay = new Level(n, Xcenter, Ycenter, offset);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setFont(new Font("Serif", Font.BOLD, 40));
        StdDraw.picture(250,700,"danright.png");
        StdDraw.text(width/2, 700, "Level: "+level +"  Round: "+ round);
        levelToPlay.start();
        levelToPlay.play();
        message(width, height, levelToPlay);
        
      } while(levelToPlay.getAttemptRemain()==0 & round<=roundMax);
      
      n = 2*level+2;
    }
  } 
}
