package Classes;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
public class List extends JPanel {
    //Creates List
    List() {
        GridLayout layout = new GridLayout(10, 1);
        layout.setVgap(5);
        this.setLayout(layout);
        this.setBackground(Color.lightGray);
        this.setPreferredSize(new Dimension(400, 560));

    }

    //Upd the numbers of List
    public void updateNumbers() {
        Component[] listItems = this.getComponents();

        for (int i = 0; i < listItems.length; i++) {
            if (listItems[i] instanceof Task) {
                ((Task) listItems[i]).changeIndex(i + 1);
            }
        }
    }
    //Removes the completed tasks from List
    public void removeCompletedTasks() {

        for (Component c: getComponents()) {
            if (c instanceof Task) {
                if (((Task) c).getState()) {
                    remove(c);
                    updateNumbers();
                }
            }
        }
    }
}