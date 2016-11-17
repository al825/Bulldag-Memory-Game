import java.util.Random;

/**
 *  This class provides methods for setting up the playboard.
 *  	1) select images to show on the board
 *  	2) perumute images
 *  	3) show images on the board

 */

public class Setup{
  
  private int n;
  private String[] names = {"dan1.jpg", "dan2.jpg", "dan3.jpg","dan4.jpg","dan5.jpg","dan6.jpg","dan7.jpg","dan8.jpg",
                            "dan9.jpg","dan10.jpg","dan11.jpg","dan12.jpg","dan13.jpg","dan14.jpg","dan15.jpg","dan16.jpg"};
  private String[] namesUsed;
  private Figure[] f;  //= new Figure[n*n]
  
  
  
  
  // constructor
  public Setup(int n, int Xcenter, int Ycenter, int offset){
    this.n = n;
    this.namesUsed =   getNameUsed();
    this.f = getFigs(Xcenter, Ycenter, offset);
  }
  
  
  // get the names of picture used for the game
  public String[] getNameUsed(){
    String[] chosen = new String[this.n*this.n];
    
    int demo = (this.n==4)? 2:4;
    int i = 0;
    while(i<this.n*this.n){
      for (int j = 0; j<this.n*this.n/demo; j++){
        chosen[i] = this.names[j];
        i++;
      }
    } 
    return chosen;      // return a string of figure names used for the game
  } 
  
  
  
  // swap: action method, directly swap the indeicated position in nameUsed
  public void swap (int i, int j){
    String temp = this.namesUsed[i];
    this.namesUsed[i] = this.namesUsed[j];
    this.namesUsed[j] = temp;
  }
  
   // permutation: action method, directly produce a random sequence of chosen names
  public void permutation(){
    for (int iter = 0; iter<5; iter++){
      for (int i = 0; i<this.namesUsed.length; i++){
        Random a = new Random();
        swap(i, a.nextInt(this.n*this.n));
      }
    }
  }
  
  // get selected Figure Array AFTER permutation
  public Figure[] getFigs(int Xcenter, int Ycenter, int offset){
    
    Figure[] fig = new Figure[this.n*this.n];
    permutation();
    for (int i=0; i<this.n*this.n;i++){
      fig[i] = new Figure(i, this.namesUsed[i], this.n, Xcenter, Ycenter, offset);
    }
    return fig;
    
  }
  
  
  public Figure[] returnFigs(){
    return this.f;
  }
  
    // layout everything:
  public void layout(boolean faceup){

    for (int i=0; i<this.n*this.n;i++){
      if (faceup) {f[i].drawPic();}
      else {f[i].drawBack();}
    }
    
  }
  
  
    
  
  
  
  
  
  public static void main(String[] args){
  /*******write below in BulldogPlay*******/  
    int width = 1000;
    int height = 750;
    int Xcenter = 500;
    int Ycenter = 300;
    int offset = 4;
    int n=8;
    
    
    StdDraw.setCanvasSize(width, height);
    StdDraw.setXscale(0, width);
    StdDraw.setYscale(0, height);
    
   /************************************/ 
    
    Setup s = new Setup(n, Xcenter, Ycenter, offset);
    s.layout(true);
    //StdDraw.show(2000);
    //s.layout(false);
    //StdDraw.show();
    
    Figure[] ff = new Figure[64];
    ff = s.getFigs(Xcenter, Ycenter, offset);
   
  }
}








