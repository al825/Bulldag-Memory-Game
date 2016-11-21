import java.awt.Color;
import java.awt.Font;

/**
 *  This is final screen
 *  	Different annimations for winning and losing.
 
 */

public class FinalScreen {
  
  
  
  public void drawPic(String name, int Xcenter,int Ycenter, boolean win){
    StdDraw.picture(Xcenter-350,Ycenter+100,name);
    Font font = new Font("Serif", Font.BOLD, 60);
    StdDraw.setFont(font);
    if (win) StdDraw.text(Xcenter+100, Ycenter+100,"YEAH! YOU WON!");
    else StdDraw.text(Xcenter+100, Ycenter+100,"SORRY, YOU LOST!");
    StdDraw.show(500); 
  }
  
  
  
  
  
  public void drawFinalScreen(int Xcenter,int Ycenter, boolean win){
    String[] picName;
    if (win) picName=new String[] {"thumb1.png","thumb2.png","thumb3.png"};
    else picName=new String[] {"sorry1.png","sorry2.png","sorry3.png"};
    
    while(true) { 
      drawPic(picName[0],Xcenter,Ycenter,win);
      drawPic(picName[1],Xcenter,Ycenter,win);
      drawPic(picName[2],Xcenter,Ycenter,win);
      drawPic(picName[1],Xcenter,Ycenter,win);
      drawPic(picName[0],Xcenter,Ycenter,win);
      
      
    } 
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub  
    int width = 1000;
    int height = 750;
    int Xcenter = 500;
    int Ycenter = 300;
    StdDraw.setCanvasSize(width, height);
    StdDraw.setXscale(0, width);
    StdDraw.setYscale(0, height);
    //drawFinalScreen(Xcenter,Ycenter, true);
    
    
    
  }
  
  
}
