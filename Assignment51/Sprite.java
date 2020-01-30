

////////////////////////////////////////////
///////////   ASSIGNMENT 5       ///////////
////////// LAMBERT LONGNANG     ///////////
/////////     10-19-2019        //////////
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
            System.out.println("Unable to load image file. ");
        }
    }
    public Image getImage() { return this.image; }

    public void updateImage(Graphics g) {

        g.drawImage(this.getImage(), this.getX(), this.getY(), 60, 60, null);
    }

    public void updateState(int width, int height){

    }
    public boolean overlaps(Sprite s){
        if (locationX >= s.getX() - 60 && locationX <= s.getX() + 60)
        {
            if (locationY >= s.getY() - 60 && locationY <= s.getY() + 60)
            {

                return true;
            }
        }
        return false;
    }

}