package Classes;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;


public class TitleBar extends JPanel {

    //Title text
    TitleBar() {
        this.setPreferredSize(new Dimension(400, 60));

        JLabel titleText = new JLabel("To Do List");
        titleText.setPreferredSize(new Dimension(200, 60));

        titleText.setFont(new Font("Sans-serif", Font.BOLD, 20));
        titleText.setHorizontalAlignment(JLabel.CENTER);

        this.add(titleText);
    }
}