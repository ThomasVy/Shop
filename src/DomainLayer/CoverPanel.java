package DomainLayer;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CoverPanel extends JPanel {

    Artwork art;

    public CoverPanel() {
        String extension = "\\img\\seriousbook.jpg";
        Path path = Paths.get(System.getProperty("user.dir"), extension);
        art = new Cover(path.toString(),60, 80);
    }

    public void paintComponent(Graphics g) {

        art = new CoverBorderDecorator(new ColourLayerDecorator(art, 30, 30, 400, 600, 10)
        , 25,25,410,610);

        art.draw(g);
    }
}
