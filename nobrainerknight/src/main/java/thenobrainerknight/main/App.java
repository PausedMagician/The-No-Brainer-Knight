package thenobrainerknight.main;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ImageIcon imageIcon = new ImageIcon("src/images/slime.png");

        JFrame window = new JFrame("The No-Brainer Knight");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);
        window.setIconImage(imageIcon.getImage());

        GamePanel gamepanel = new GamePanel();
        window.add(gamepanel);

        window.pack();

        gamepanel.startGameThread();
    }

    static void printstuff() {
        System.out.println("hi");
    }

}
