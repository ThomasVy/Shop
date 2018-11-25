package DomainLayer;

import javax.swing.*;
import java.awt.*;

public class CoverPanel extends JPanel {

    Artwork art;

    public CoverPanel() {
        art = new Cover("C:\\seriousbook.jpg",60, 80);
    }

    public void paintComponent(Graphics g) {

        art = new CoverBorderDecorator(new ColourLayerDecorator(art, 30, 30, 400, 600, 10)
        , 25,25,410,610);

        art.draw(g);
    }
}
