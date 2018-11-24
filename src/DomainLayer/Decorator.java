package DomainLayer;
//TODO
import java.awt.*;

public abstract class Decorator implements Artwork {

    Artwork art;

    int x;

    int y;

    int width;

    int height;

    public Decorator(Artwork art, int x, int y, int width, int height) {
        this.art = art;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void draw(Graphics g);
}
