import java.awt.Color;

/**
 *  This class provides methods for rescale images and convert the images into grayscale.
 *  Usage in bulldog memory game: rescale images to fit on the game board

 */
public class InstaPic extends Picture {
    public InstaPic(String fileName) {
        super(fileName);
    }
    
    public InstaPic(int w, int h) {
        super(w, h);
    }
    
    
    public InstaPic gray() {
        InstaPic target = new InstaPic(width(), height());
        for (int tx = 0; tx < width(); tx++) {
            for (int ty = 0; ty < height(); ty++) {
               Color color = get(tx, ty);
               Color gray  = toLumGray(color);
               target.set(tx, ty, gray);
            }
         }
         return target;
    } // end of gray
    
    
    
    public InstaPic scale(int w, int h) {
        InstaPic target = new InstaPic(w, h);
        for (int tx = 0; tx < target.width(); tx++) {
           for (int ty = 0; ty < target.height(); ty++) {
              int sx = tx * width()  / target.width();
              int sy = ty * height() / target.height();
              Color color = get(sx, sy);
              target.set(tx, ty, color);
           }
       }
        return target;
    }
    
    
    private Color toLumGray(Color c) {
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        int gray = (int)Math.round(.299*r + .587*g + .114*b);
        return new Color(gray, gray, gray);

    }
    
    // test client
    public static void main(String[] args) {
       
       InstaPic picOrig = new InstaPic(args[0]);
       picOrig.show();
      
       InstaPic pic2 = picOrig.gray();
       pic2.show();
              
       InstaPic pic3 = picOrig.scale(200, 500);
       pic3.show();
        
    }
}