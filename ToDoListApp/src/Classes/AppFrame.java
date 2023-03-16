package Classes;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppFrame extends JFrame {
    private TitleBar title;
    private List list;
    private JButton NewTask;
    private JButton clear;
    private ButtonPanel btnPanel;
    AppFrame() {
        this.setSize(400, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        title = new TitleBar();
        list = new List();
        btnPanel = new ButtonPanel();

        this.add(title, BorderLayout.NORTH);
        this.add(btnPanel, BorderLayout.SOUTH);
        this.add(list, BorderLayout.CENTER);

        NewTask = btnPanel.getAddTask();
        clear = btnPanel.getClear();
        addListeners();

    }
    //Listens the mouse and do changes on the list according to click
    public void addListeners()
    {
        NewTask.addMouseListener(new MouseAdapter()
        {
            //Creates new task and increases a number of tasks
            @Override
            public void mousePressed(MouseEvent e)
            {
                Task task = new Task();
                list.add(task);
                list.updateNumbers();

                //If press on done button
                task.getDone().addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mousePressed(MouseEvent e)
                    {

                        task.changeState();
                        list.updateNumbers();
                        revalidate();

                    }
                });
            }
        });

        //Removes completed tasks
        clear.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                list.removeCompletedTasks();
                repaint();
            }
        });
    }
}