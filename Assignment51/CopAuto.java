

////////////////////////////////////////////
///////////   ASSIGNMENT 5       ///////////
////////// LAMBERT LONGNANG     ///////////
/////////     10-19-2019        //////////
//////////////////////////////////////////

import java.awt.*;
import java.util.Random;

public class CopAuto extends Auto
{
    private static int xRatio;
    private static int yRatio;

    public CopAuto()
    {
        super("CopAuto", 5000, new Engine("V6", 30, 100), "cop-auto.jpg");
        this.fillUp();
        Random rand = new Random();
        CopAuto.xRatio = 0;
        CopAuto.yRatio = 0;

        while (CopAuto.xRatio == 0 && CopAuto.yRatio == 0 )
        {
            CopAuto.xRatio = rand.nextInt(11) - 5;
            CopAuto.yRatio = rand.nextInt(11) - 5;
        }

        //this.fillUp();
    }
//    @Override
//    public void update (Graphics g)
//    {
//        super.drive(20, (double)xRatio, (double)yRatio);
//        super.update(g);
//    }
    @Override
    public void updateState(int width, int height){
        super.drive(2, (double)xRatio, (double)yRatio);
        if (super.getX() > width || super.getX() < 0) {
            CopAuto.xRatio = -CopAuto.xRatio;
        }
        else if (super.getY() > height || super.getY() < 0) {
            CopAuto.yRatio = -CopAuto.yRatio;
        }
    }
    @Override
    public void updateImage(Graphics g){
        super.updateImage(g);
    }
}
