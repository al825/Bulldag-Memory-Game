import java.awt.Color;
import java.awt.Font;

/**
 *  This class provides actions of the game

 */

public class Level{
  private Figure[] figure;
  private int click;
  private int remainPicNum;
  private Setup set;
  private int attemptRemain;  
  private int n;
  
  
  public Level(int n, int Xcenter, int Ycenter, int offset){
    this.set = new Setup(n, Xcenter, Ycenter, offset);
    this.figure = set.returnFigs();
    this.remainPicNum = figure.length;
    this.n=n;
    this.click  = 0;
    if (n==4) this.attemptRemain = 20;
    if (n==6) this.attemptRemain = 50;
    if (n==8) this.attemptRemain = 100;
    /*
    swith(n){
      case 4: this.attemptRemain = 20; break;
      case 6: this.attemptRemain = 50; break;
      case 8: this.attemptRemain = 100; break;
    //this.attemptRemain = 4*n*n;
    }*/
    //this.nextRound = false;
    
  }
  
  // initialize the game: show all images, after 1 second, turn all images to its back
  public void start(){
    set.layout(true);
    StdDraw.show(n*1000);
    set.layout(false);
    StdDraw.show();
  }
  
  // each click: change the remaining attemp times
  public void play(){
    StdDraw.setFont(new Font("Arial", Font.BOLD, 20));
    StdDraw.setPenColor(Color.BLACK);
    StdDraw.text(850,700,"Attempts Remain: ");
    
    while(remainPicNum>0 & !(attemptRemain<0)) {
      
      StdDraw.picture(990,700,"white.jpg");
      if (attemptRemain<=10){StdDraw.setPenColor(Color.RED);}
      StdDraw.text(970,700,""+attemptRemain);
      if(attemptRemain==0) break;
      
      twoClicks();
      attemptRemain--;
    }
    //if(remainPicNum>0 & attemptRemain==0)
      //this.nextRound = true;
  } 
  
  
  
  
  // each Click: show the image
  public int oneClick(int lastClickIndex){
    int ind=-1;
    while(true){
      if(StdDraw.mousePressed()){
        double xClick = StdDraw.mouseX();
        double yClick = StdDraw.mouseY();
        for(int i = 0; i<figure.length; i++){
          if(figure[i].isClicked(xClick,yClick)  & figure[i].isAvailable()){
            ind = i;// figure[i].getIndex();
            //figure[ind].drawPic();
            break;
          }
        }
        if(!StdDraw.mousePressed() & ind!=lastClickIndex & ind!=-1) break;
      }
    }
    figure[ind].drawPic();
    return ind;
    
  }
  
  
  // two clicks in a row: if the 2 clicks find the same image, make the 2 images disappear, else, turn the images back
  public void twoClicks(){
    int lastClickIndexInitial = -1;
    int index1 = oneClick( lastClickIndexInitial);
    int index2 = oneClick( index1);
    
    try {
      Thread.sleep(500);
    } catch (Exception e){System.out.println(e);}
    
    // check if clicekd are the same image
    if (figure[index1].getName().equals(figure[index2].getName())){ 
      remainPicNum -=2;
      figure[index1].disappear();
      figure[index2].disappear();
    }
    
    else{
      figure[index1].drawBack();
      figure[index2].drawBack();
    }
  }
  
  public int getAttemptRemain(){
    return this.attemptRemain;
  }
  
  /*
  public boolean isRound(){
    return this.nextRound;
  }*/
  
  // 
  
  
  
  
  
  
  public static void main(String[] args){
    /*******write below in BulldogPlay*******/  
    int width = 1000;
    int height = 750;
    int Xcenter = 500;
    int Ycenter = 300;
    int offset = 4;
    int n=4;
    
    
    StdDraw.setCanvasSize(width, height);
    StdDraw.setXscale(0, width);
    StdDraw.setYscale(0, height);
    
    
    

      
    while(true){
      if(StdDraw.mousePressed()){
        
        double x = StdDraw.mouseX();
        double y = StdDraw.mouseY();
        
        System.out.print(""+x+" "+y);
        
          
      
    }
    }
  }
}