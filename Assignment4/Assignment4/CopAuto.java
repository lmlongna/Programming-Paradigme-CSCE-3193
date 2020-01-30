

        ////////////////////////////////////////////
        ///////////   ASSIGNMENT 4       ///////////
        ////////// LAMBERT LONGNANG     ///////////
        /////////     10-10-2019        //////////
        //////////////////////////////////////////

import java.awt.*;
import java.util.Random;

public class CopAuto extends Auto
{
    private static int xRatio;
    private static int yRatio;

    public CopAuto()
    {
        super("CopAuto", 30, new Engine("V6", 30, 100), "cop-auto.jpg");
        Random rand = new Random();
        CopAuto.xRatio = 0;
        CopAuto.yRatio = 0;

        while (CopAuto.xRatio == 0 && CopAuto.yRatio == 0 )
        {
            CopAuto.xRatio = rand.nextInt(11) - 5;
            CopAuto.yRatio = rand.nextInt(11) - 5;
        }

//        for (yRatio = 0; xRatio == 0 && yRatio == 0; yRatio = rand.nextInt(11) - 5)
//            xRatio = rand.nextInt(11) - 5;

        this.fillUp();
    }
    @Override
    public void update (Graphics g)
    {
        drive(20, (double)xRatio, (double)yRatio);
        super.update(g);
    }
}
