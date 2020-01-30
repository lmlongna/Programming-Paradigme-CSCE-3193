                ////////////////////////////////////////////
                ///////////   ASSIGNMENT 3       ///////////
                ////////// LAMBERT LONGNANG     ///////////
                /////////     09-27-2018        //////////
                //////////////////////////////////////////
                import javax.swing.*;
                import java.awt.*;
                
                public class DrivenPanel extends JPanel {
                
                    private int x[] ;
                    private int y[] ;
                    private int distance;
                
                    public DrivenPanel(int mX[] , int mY[] , int mDistance)
                    {
                        x = mX;
                        y = mY;
                        distance = mDistance;
                    }
                
                    public void paintComponent(Graphics g)
                    {
                        super.paintComponent(g);
                
                        int height = getHeight();
                        //int width = getWidth();
                
                        g.drawLine(0, height - 0, x[0], height - y[0]);
                        //g.drawString(" ( , )", 10 , height-10);
                
                        for (int i = 0; i < distance-1; i++)
                        {
                            g.drawLine(x[i], height - y[i], x[i + 1],height -  y[i + 1]);
                            //g.drawString("(" + this.x[i ] + ", "+ this.y[i] + ")", x[i ] + 10, height - y[i]);
                        }
                        for (int i = 0; i < distance; i++)
                        {
                
                            g.drawString("(" + this.x[i ] + ", "+ this.y[i] + ")", x[i ] + 10, height - y[i]);
                        }
                    }
                }
                