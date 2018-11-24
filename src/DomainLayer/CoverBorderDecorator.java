package DomainLayer;


import java.awt.*;

//TODO
public class CoverBorderDecorator extends Decorator{

    public CoverBorderDecorator(Artwork art, int x, int y, int width, int height) {
        super(art,x,y,width, height);
    }

    @Override
    public void draw(Graphics g) {
        art.draw(g);
        Graphics2D g2d = (Graphics2D) g;
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.drawRect(x,y,width, height);
        g2d.setStroke(dashed);
    }
}
