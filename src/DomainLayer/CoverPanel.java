package DomainLayer;

import javax.swing.*;
import java.awt.*;

public class CoverPanel extends JPanel {

    Artwork art;

    public CoverPanel() {
        art = new Cover("J:\\School\\softengyear3\\ENSF480\\ENSF480Project\\src\\seriousbook.jpg",60, 80);
    }

    public void paintComponent(Graphics g) {

        art = new CoverBorderDecorator(new ColourLayerDecorator(art, 30, 30, 400, 600, 10)
        , 25,25,410,610);

        art.draw(g);
    }

    public static void main(String[] args) {
        CoverPanel panel = new CoverPanel();
        JFrame frame = new JFrame("Learning ExAB.Decorator Pattern");
        frame.getContentPane().add(panel);
        frame.setSize(520,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
