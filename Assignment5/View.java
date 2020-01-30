
////////////////////////////////////////////
///////////   ASSIGNMENT 5       ///////////
////////// LAMBERT LONGNANG     ///////////
/////////     10-19-2019        //////////
//////////////////////////////////////////

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.event.*;

public class View extends JFrame implements ActionListener {


    private class MyPanel extends JPanel {
        Controller controller;

        MyPanel(Controller c) {
            controller = c;

            this.addMouseListener(c);
            this.addKeyListener(c);

        }


        public void paintComponent(Graphics g) {
            controller.update(g);
            revalidate();
        }
    }



    public View(Controller c) throws Exception{
        setTitle("Assignment 5");
        setSize(1000, 700);
        getContentPane().add(new MyPanel(c));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.addKeyListener(c);

    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        repaint();
    }
}

