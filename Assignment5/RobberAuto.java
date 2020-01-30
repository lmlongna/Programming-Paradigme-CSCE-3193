

////////////////////////////////////////////
///////////   ASSIGNMENT 5       ///////////
////////// LAMBERT LONGNANG     ///////////
/////////     10-19-2019        //////////
//////////////////////////////////////////

import java.awt.*;
import java.util.Random;

public class RobberAuto extends Auto
{

    private int xRatio;
    private int yRatio;
    private boolean escape =false;
    private boolean capture = false;
    static int captured=0;
    static int escaped=0;

    public RobberAuto()
    {
        super("RobberAuto", 5000, new Engine("V8", 20, 200), "red-auto.jpg");
        this.fillUp();
        Random rand = new Random();
        this.xRatio = 0;
        this.yRatio = 0;

        while (this.xRatio == 0 && this.yRatio == 0 )
        {
            this.xRatio = rand.nextInt(11) - 5;
            this.yRatio = rand.nextInt(11) - 5;

        }


    }


    public void updateState(int width, int height){


        if (!this.capture) {
            this.drive(4, (double)this.xRatio, (double)this.yRatio);
            if (super.getX() > width || super.getY() > height || super.getX() <= -1 || super.getY() <= -1) {
                hasEscaped();
                escape=true;
                this.escaped++;
            }
        }
    }

    
    public void updateImage(Graphics g){
        super.updateImage(g);

    }
    public void captured(){
        if (!this.isCaptured()) {
            this.capture = true;
            super.setImage("jail.jpg");
            int x = super.getX();
            int y = super.getY();
            super.setX(x);
            super.setY(y);
            this.captured++;
            System.out.println("captured:"+ captured);
        }
    }
    public boolean isCaptured() {
        if (this.capture) {
            
            return true;
        }
        return false;
    }
    public boolean hasEscaped() {
        if (this.escape) {
            

            return true;
        }
        return false;
    }
}
