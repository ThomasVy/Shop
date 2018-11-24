package DomainLayer;

import java.awt.*;

//TODO
public class ColourLayerDecorator extends Decorator {

    private int thiccness;

    public ColourLayerDecorator(Artwork art, int x, int y, int width, int height, int thiccness) {
        super(art,x,y,width,height);
        this.thiccness = thiccness;

    }

    @Override
    public void draw(Graphics g) {
        art.draw(g);
        Graphics2D g2d = (Graphics2D) g;
        Stroke oldStroke = g2d.getStroke();
        Color oldColor = g2d.getColor();
        g2d.setStroke(new BasicStroke(thiccness));
        g2d.setColor(Color.red);
        g2d.drawRect(x,y,width,height);
        g2d.setStroke(oldStroke);
        g2d.setColor(oldColor);
    }
}
