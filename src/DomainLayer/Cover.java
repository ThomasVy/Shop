package DomainLayer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//TODO
public class Cover implements Artwork {

    String coverImagePath;

    BufferedImage coverArt;

    int x;

    int y;

    public Cover(String coverImagePath, int x, int y){
        this.coverImagePath = coverImagePath;
        try {
            this.coverArt = ImageIO.read(new File(coverImagePath));
        } catch(IOException ex){
            System.out.println("file cannot be found!");
        }

        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(coverArt, x,y, null);
    }

}
