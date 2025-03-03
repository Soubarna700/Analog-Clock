/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clock;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class SquaredPanel extends JPanel
{
    public int x;
    public int y;
    public int side;

//    public SquaredPanel()
//    {
//        
//    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.red);
        side = Math.min(getWidth(), getHeight());
        final int BORDER = 10;
        side-=2*BORDER;
         x = (getWidth()-side)/2;
         y = (getHeight()-side)/2;
    }
    
}
