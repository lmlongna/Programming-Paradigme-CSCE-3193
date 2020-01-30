

        ////////////////////////////////////////////
        ///////////   ASSIGNMENT 4       ///////////
        ////////// LAMBERT LONGNANG     ///////////
        /////////     10-10-2019        //////////
        //////////////////////////////////////////

import java.awt.*;
import java.util.Random;

    public class RobberAuto extends Auto
    {
        private int xRatio;
        private int yRatio;

        public RobberAuto()
        {
            super("RobberAuto", 20, new Engine("V8", 20, 200), "red-auto.jpg");
            Random rand = new Random();
            this.xRatio = 0;
            this.yRatio = 0;

            while (this.xRatio == 0 && this.yRatio == 0 )
            {
                this.xRatio = rand.nextInt(11) - 5;
                this.yRatio = rand.nextInt(11) - 5;
            }

            this.fillUp();

        }
        @Override
        public void update(Graphics g)
        {
            this.drive(40, (double) this.xRatio, (double) this.yRatio);
            super.update(g);
        }
    }
