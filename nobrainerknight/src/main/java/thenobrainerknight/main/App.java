package thenobrainerknight.main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ImageIcon imageIcon = new ImageIcon("src/images/slime.png");
        ImageIcon image = new ImageIcon("src/images/slime.gif");

        JLabel label = new JLabel(image, JLabel.CENTER);
        label.setAlignmentX(0);
        label.setAlignmentY(0);
        label.setText("hi");
        label.setIcon(image);

        JFrame window = new JFrame("The No-Brainer Knight");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);
        window.setIconImage(imageIcon.getImage());
        window.add(label);

        GamePanel gamepanel = new GamePanel();
        window.add(gamepanel);

        window.pack();

        gamepanel.startGameThread();
    }

}
