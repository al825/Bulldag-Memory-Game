import java.awt.Font;
import java.awt.Color;

public class Dan {
	boolean isRight;
	double x;
	double y;
	int v;
	int width;
	int height;
	String name;
	
	public Dan (double y, int v, int width, int height, boolean isRight){
		this.y =y;

		this.width=width;
		this.height=height;
		this.isRight=isRight;
		if (isRight){
			x=width;
			this.v=-v;
			name="danleft.png";
		}
		else {
			x=0;
			this.v=v;
			name="danright.png";
		}
	}
	
    private boolean isInBound() {
        return 0 < x && x < width;

    }
    
	
    public void move() {
         x +=  v;
        if (!isInBound())
            v = -v;
        	if (name.equals("danleft.png")) name="danright.png";
        	else name="danleft.png";
    }

    public void draw() {
        //StdDraw.setPenColor(c);
        //StdDraw.filledCircle(rx, ry, radius);
    	
        if (isRight) StdDraw.picture(x,y,name);
        else StdDraw.picture(x,y,name);
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
		int nbulldog=8;
		Dan[] dans=new Dan[nbulldog];
		int v=50;
		boolean isRight=true;
		double ytemp=80; 
		for (int i=0; i<nbulldog; i++){

			dans[i]= new Dan(ytemp,v,width,height, isRight);
			ytemp+=80;  
			isRight=!isRight;
		}
		
	      while(true) { 
	          StdDraw.clear(); 
	          for (int i=0; i<nbulldog; i++) { 
	             dans[i].move(); 
	             dans[i].draw(); 
	             StdDraw.setPenColor(Color.blue);
	      	   	 Font font = new Font("Jokerman", Font.BOLD, 60);
	    	     StdDraw.setFont(font);
	    	     StdDraw.text(Xcenter, (Ycenter+100), "BULLDOG Memory Game");
	    	     StdDraw.picture(Xcenter,Ycenter,"start.png");
	          } 
	          StdDraw.show(500); 
	       } 
		
		

	}

}
