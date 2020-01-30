

    ////////////////////////////////////////////
    ///////////   ASSIGNMENT 4       ///////////
    ////////// LAMBERT LONGNANG     ///////////
    /////////     10-10-2019        //////////
    //////////////////////////////////////////

import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


class Sprite
{
    private String jpgName;
    private int locationX;
    private int locationY;
    private Image image;

    public Sprite(String jpgName)
    {
        //setImage(jpgName);
        this.setImage(jpgName);
        this.locationX = 0;
        this.locationY = 0;
    }

    public int getX() {	return locationX; }
    public int getY() {	return locationY; }
    public void setX(int x) { locationX = x; }
    public void setY(int y) { locationY = y; }

    public void setImage(String imagePath) {
        try {
            this.image = ImageIO.read(new File(imagePath));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file. " + imagePath);
        }
    }
    public Image getImage() { return this.image; }

    public void update(Graphics g) {

        g.drawImage(this.getImage(), this.getX(), this.getY(), 60, 60, null);
    }
}