package Classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Task extends JPanel {
    JLabel index;
    JTextField taskName;
    JButton done;
    private boolean checked;

    //Creates task
    Task() {
        this.setPreferredSize(new Dimension(40, 20));
        this.setBackground(Color.white);

        this.setLayout(new BorderLayout());

        checked = false;
        index = new JLabel("");
        index.setPreferredSize(new Dimension(20, 20));
        index.setHorizontalAlignment(JLabel.CENTER);
        this.add(index, BorderLayout.WEST);

        taskName = new JTextField("Enter Your Task Here");
        taskName.setBorder(BorderFactory.createEmptyBorder());
        taskName.setBackground(Color.white);

        this.add(taskName, BorderLayout.CENTER);

        done = new JButton("Done");
        done.setPreferredSize(new Dimension(40, 20));
        done.setBorder(BorderFactory.createEmptyBorder());
        done.setFocusPainted(false);

        this.add(done, BorderLayout.EAST);
    }

    public JButton getDone() {
        return done;
    }


    public boolean getState() {
        return checked;
    }

    //Increase a number of tasks
    public void changeIndex(int num) {
        this.index.setText(num + "");
        this.revalidate();
    }

    //Turns done tasks to green
    public void changeState() {
        this.setBackground(Color.GREEN);
        taskName.setBackground(Color.GREEN);
        checked = true;
        revalidate();

    }
}