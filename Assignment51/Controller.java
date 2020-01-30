

////////////////////////////////////////////
///////////   ASSIGNMENT 5       ///////////
////////// LAMBERT LONGNANG     ///////////
/////////     19-10-2019        //////////
//////////////////////////////////////////


import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

class Controller implements MouseListener, KeyListener
{
    Model model;
    View view;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
       // new Timer(50, view).start();
    }

    public void update(Graphics g) {
        model.update(g);
    }

    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            model.addSprite(e.getX(),e.getY());
            view.repaint();
            // Gets here is left mouse button was clicked
        } else if (SwingUtilities.isRightMouseButton(e))  {
            model.updateScene(view.getWidth(),view.getHeight());
            view.repaint();
            //this.model.fillUp();
            // Gets here if right mouse button was clicked
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {    }
    @Override
    public void mouseEntered(MouseEvent e) {    }
    @Override
    public void mouseExited(MouseEvent e) {    }
    @Override
    public void mouseClicked(MouseEvent e) {    }

    //@Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar()=='h'){
            System.out.println("Hello world");
        }
        if (e.getKeyChar() == 'n')
        {
            System.out.println("robbers captured : " + RobberAuto.captured + "\nrobbers escaped : " + RobberAuto.escaped);
        }

        if (e.getKeyChar() == 'r')
        {
            model.initalize();
            view.repaint();
        }

        if (e.getKeyChar() == 's')
        {

            Thread thread = new Thread (new SpriteMover (model, view));
            thread.start();

        }


    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public static void main(String[] args) throws Exception {
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));
        new Controller();
    }
}

