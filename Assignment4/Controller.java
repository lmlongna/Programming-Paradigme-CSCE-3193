

            ////////////////////////////////////////////
            ///////////   ASSIGNMENT 4       ///////////
            ////////// LAMBERT LONGNANG     ///////////
            /////////     10-10-2019        //////////
            //////////////////////////////////////////


import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

class Controller implements MouseListener
{
    Model model;
    View view;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
        new Timer(50, view).start();
    }

    public void update(Graphics g) {
        model.update(g);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            this.model.addSprite(e.getX(),e.getY());
            // Gets here is left mouse button was clicked
        } else if (SwingUtilities.isRightMouseButton(e))  {
            this.model.fillUp();
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

    public static void main(String[] args) throws Exception {
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));
        new Controller();
    }
}

