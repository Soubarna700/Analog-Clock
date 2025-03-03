/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clock;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class CenteredFrame extends JFrame
{

    public CenteredFrame(String title)
    {
        
        super();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int wd = d.width;
        int ht = d.height;
        
        this.setSize(wd/2 , ht/2);
        int x = ( wd-this.getWidth())/2;
        int y = (ht - this.getHeight())/2;
        this.setLocation(x, y);
//        this.setTitle(title);
//        this.add(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("Centered frame running");
    }
    
}
