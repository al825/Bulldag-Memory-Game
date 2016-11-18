
public class IntroScreen {
  public void drawIntro( int Xcenter, int Ycenter){
    int bottonx=900;
    int bottony=70;
    StdDraw.picture(Xcenter-50, Ycenter+70, "BulldogGame_intro.png");
    StdDraw.picture(bottonx, bottony, "enter_button.png");
    while (true){
      if (StdDraw.mousePressed()) {
        double posx = StdDraw.mouseX();
        double posy = StdDraw.mouseY();
        if(posx > bottonx - 75 & posx < bottonx + 75 & posy < bottony+ 37.5
             & posy > bottony- 37.5)  {
          //System.out.println("yes");
          StdDraw.clear();
          StdDraw.show();
          break;    
        }
        
      }
      
    }
  }
  
  
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int width = 1000;
    int height = 750;
    int Xcenter = 500;
    int Ycenter = 300;
    int offset = 4;
    StdDraw.setCanvasSize(width, height);
    StdDraw.setXscale(0, width);
    StdDraw.setYscale(0, height);
    IntroScreen introscreen=new IntroScreen();
    introscreen.drawIntro(Xcenter,Ycenter);
    
    
  }
  
}
