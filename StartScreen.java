import java.awt.Color;
import java.awt.Font;

/**
 *  This is the start screen class
 *  	Annimation on the start screen: bulldogs moving forward and backward (required class: Dan)
 *  	Buttons: start -> starts the game
 *               help -> shows the introduction page
 *  	

 */


public class StartScreen {
  
  public void showStartScreen(int width, int height, int Xcenter, int Ycenter) {
    // TODO Auto-generated method stub
    int nbulldog = 8;
    Dan[] dans = new Dan[nbulldog];
    int v = 50;
    boolean isRight = true;
    double ytemp = 80;
    for (int i = 0; i < nbulldog; i++) {
      
      dans[i] = new Dan(ytemp, v, width, height, isRight);
      ytemp += 80;
      isRight = !isRight;
    }
    
    outerloop: while (true) {
      StdDraw.clear();
      for (int i = 0; i < nbulldog; i++) {
        dans[i].move();
        dans[i].draw();
        StdDraw.setPenColor(Color.blue);
        Font font = new Font("Jokerman", Font.BOLD, 60);
        StdDraw.setFont(font);
        StdDraw.text(Xcenter, (Ycenter + 100), "BULLDOG Memory Game");
        StdDraw.picture(Xcenter, Ycenter, "startbutton.png");
        StdDraw.picture(Xcenter, Ycenter-100, "helpbutton.png");
        
      }
      for (int i=0; i<5; i++){
        StdDraw.show(100); 
        //StdDraw.picture(Xcenter, Ycenter, "start.png");
        //StdDraw.setPenColor(Color.blue);
        //Font font = new Font("Jokerman", Font.BOLD, 60);
        
        if (StdDraw.mousePressed()) {
          double posx = StdDraw.mouseX();
          double posy = StdDraw.mouseY();
          System.out.println(""+posx+posy);
          if(posx > Xcenter - 75 & posx < Xcenter + 75 & posy < Ycenter + 37.5
               & posy > Ycenter - 37.5)  {
            System.out.println("yes");
            StdDraw.clear();
            StdDraw.show();
            break outerloop;    
          }
          if(posx > Xcenter - 75 & posx < Xcenter + 75 & posy < Ycenter -100 + 37.5
               & posy > Ycenter-100 - 37.5)  {
            //System.out.println("yes");
            StdDraw.clear();
            StdDraw.show();
            IntroScreen introscreen=new IntroScreen();
            introscreen.drawIntro(Xcenter,Ycenter);
            StdDraw.show();
            break outerloop;    
          }
          //if (!StdDraw.mousePressed() & ) break;
          
        }
      }
      //StdDraw.show(1000); 
      
      
      
    }
    
  }
  public static void main(String[] args) {
    int width = 1000;
    int height = 750;
    int Xcenter = 500;
    int Ycenter = 300;
    int offset = 4;
    StdDraw.setCanvasSize(width, height);
    StdDraw.setXscale(0, width);
    StdDraw.setYscale(0, height);
    StartScreen startscreen=new StartScreen();
    
    
    startscreen.showStartScreen(width, height,  Xcenter,Ycenter);
    
  }
  
}