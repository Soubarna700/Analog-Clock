/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clock;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Admin
 */
public class ClockPanel extends SquaredPanel
{
    
    public static void main(String[] args)
    {
        JFrame frm = new CenteredFrame("Analog clock");
        JPanel panel = new ClockPanel();
        frm.add(panel);
        
        Timer timer = new Timer(900, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.repaint();
            }
            
        });
        timer.start();
        frm.setVisible(true);
        
    }
    public static void drawSec(int sec,int min ,int hr , Graphics g , int x , int y , int rad)
    {
//        int startangle = -90;
        int pie = 180;
        
        int sectheta = (sec*6)-90;
        double secangle = Math.toRadians(sectheta);
        int seclength = (rad/10)*9;        //90% of radious
        //back of second 
        int tailSecLength = seclength/5;   // 20% of sec kata
        double tailSecAngle = Math.toRadians(sectheta+pie);
        //left side
        int leftSecSide = (int) (seclength*.1);   //10% off sec kata
        double leftSecAngle=Math.toRadians(sectheta-90);
        //right side
        int rightSecSide = (int) (seclength*.1);
        double rightSecAngle=Math.toRadians(sectheta+90);
        
        int sx2 = (int)(x+seclength*Math.cos(secangle));
        int sy2= (int)(y+seclength*Math.sin(secangle));
        int tsx2 = (int)(x+tailSecLength*Math.cos(tailSecAngle));
        int tsy2 = (int)(y+tailSecLength*Math.sin(tailSecAngle));
        int lsx2 = (int)(x+leftSecSide*Math.cos(leftSecAngle));
        int lsy2 = (int)(y+leftSecSide*Math.sin(leftSecAngle));
        int rsx2 = (int)(x+rightSecSide*Math.cos(rightSecAngle));
        int rsy2 = (int)(y+rightSecSide*Math.sin(rightSecAngle));
        int secx[]={lsx2,tsx2,rsx2,sx2,lsx2,rsx2};
        int secy[]={lsy2,tsy2,rsy2,sy2,lsy2,rsy2};
        
        
        g.setColor(Color.red);
//        g.drawPolygon(secx, secy, secx.length);
        g.drawLine(tsx2, tsy2, sx2, sy2);
//        g.drawLine(x, y, tsx2, tsy2);
        
        int mintheta= (min*6)+(sectheta/60)-90;
        double  minangle = Math.toRadians(mintheta);
        int minLength = (int) (rad*.66);        // 66% of radious
        //back of minute
        int tailMinLength = minLength/5;
        double tailMinAngle = Math.toRadians(mintheta+pie);
        //left side
        int leftMinSide = (int) (minLength*.05);   //10% off min kata
        double leftMinAngle=Math.toRadians(mintheta-90);
        //right side
        int rightMinSide = (int) (minLength*.05);
        double rightMinAngle=Math.toRadians(mintheta+90);
        
        int mx2 = (int)(x+minLength*Math.cos(minangle));
        int my2= (int)(y+minLength*Math.sin(minangle));
        int tmx2 = (int)(x+tailMinLength*Math.cos(tailMinAngle));
        int tmy2= (int)(y+tailMinLength*Math.sin(tailMinAngle));
        int lmx2 = (int)(x+leftMinSide*Math.cos(leftMinAngle));
        int lmy2 = (int)(y+leftMinSide*Math.sin(leftMinAngle));
        int rmx2 = (int)(x+rightMinSide*Math.cos(rightMinAngle));
        int rmy2 = (int)(y+rightMinSide*Math.sin(rightMinAngle));
        int minx[]={lmx2,tmx2,rmx2,mx2,lmx2,rmx2};
        int miny[]={lmy2,tmy2,rmy2,my2,lmy2,rmy2};
        
        g.setColor(Color.red);
        g.fillPolygon(minx, miny, minx.length);
        g.setColor(Color.yellow);
        g.drawPolygon(minx, miny, minx.length);

        g.drawLine(x, y, mx2, my2);
        g.drawLine(x, y, tmx2, tmy2);
        
        
        int hrTheta = (hr*30)+(mintheta/12)-90;
        double  hrangle = Math.toRadians(hrTheta);
        int hrLength = (rad/10)*4;        // 40% of radious
        //back of hr
        int tailHrLength=hrLength/5;
        double tailHrAngle = Math.toRadians(hrTheta+pie);
        //left side
        int leftHrSide = (int) (hrLength*.05);   //10% off min kata
        double leftHrAngle=Math.toRadians(hrTheta-90);
        //right side
        int rightHrSide = (int) (hrLength*.05);
        double rightHrAngle=Math.toRadians(hrTheta+90);

        int hx2 = (int)(x+hrLength*Math.cos(hrangle));
        int hy2= (int)(y+hrLength*Math.sin(hrangle));
        int thx2 = (int)(x+tailHrLength*Math.cos(tailHrAngle));
        int thy2= (int)(y+tailHrLength*Math.sin(tailHrAngle));
        int lhx2 = (int)(x+leftHrSide*Math.cos(leftHrAngle));
        int lhy2 = (int)(y+leftHrSide*Math.sin(leftHrAngle));
        int rhx2 = (int)(x+rightHrSide*Math.cos(rightHrAngle));
        int rhy2 = (int)(y+rightHrSide*Math.sin(rightHrAngle));
        int hrx[]={lhx2,thx2,rhx2,hx2,lhx2,rhx2};
        int hry[]={lhy2,thy2,rhy2,hy2,lhy2,rhy2};

        g.setColor(Color.BLUE);
        g.fillPolygon(hrx, hry, hrx.length);
        
        g.setColor(Color.GREEN);
        g.drawPolygon(hrx, hry, hrx.length);
        g.drawLine(x, y, hx2, hy2);
        g.drawLine(x, y, thx2, thy2);
        
        
    }

    @Override
    public void paintComponent(Graphics h) //throws ArithmeticException
    {
        
        
        Graphics2D g = (Graphics2D)h;
        super.paintComponent(g);
        g.setColor(getBackground());
//        g.fillRect(0, 0, getWidth(), getHeight());
        var time = new GregorianCalendar();
        int hr =time.get(Calendar.HOUR);
        int min=time.get(Calendar.MINUTE);
        int sec= time.get(Calendar.SECOND);
        g.setColor(Color.black);
        
        int dia = side;//diameter
        int radious = side/2;
        int centerx = x+radious;
        int centery = y+radious;
        int midDotDia = 10;
        g.fillOval(x, y, dia, dia); // drawing outer circle
        
        g.setColor(Color.green);
        int nameStrx = (int) (x+(radious*.8));
        int nameStry = (int) (y+(radious*.6));
        Font fnt = new Font("Harlow Solid", Font.ITALIC, (int) (side*.05));
        g.setFont(fnt);
        g.drawString("Soubarna", nameStrx, nameStry);
//        g.drawOval(x, y, dia, dia);
        
        // draw mid dot

//        g.setColor(Color.yellow);
        int urad = (int) (radious*.66);      //under radious length 66% of radious
        g.drawOval(centerx-urad, centery-urad, urad*2, urad*2);    // drawing inner circle
        
        //drawing big dots and small dots
        int theta =-90;
        double angle;
        int len = (urad+radious)/2;     // mid of 2 circle
        int dotdia = 3;
        int kata = 1;
        
        for (int i = 0; i <= 360; i+=6)
        {
        angle = Math.toRadians(theta);
        int x2 = (int)(centerx+len*Math.cos(angle));
        int y2= (int)(centery+len*Math.sin(angle));
        theta +=6;
        
//        Font fnt = new Font("Times new Roman", Font.BOLD, 12);  // ekta fnt banalam
        g.setFont(fnt);
        FontMetrics fm = g.getFontMetrics();
        String s = ""+kata;
        int stringWidth = fm.stringWidth(s);
            System.out.println(stringWidth);
        
        if(i!=0)
        {
            if(i%30==0)                           //(360%i==0)
                {
                g.setColor(Color.yellow);
                   kata++;
                   g.drawString(s, x2-(stringWidth/2), y2+dotdia);
                }
             else
            {
                g.setColor(Color.green);
                g.fillOval(x2-dotdia, y2-dotdia, dotdia, dotdia); //g.drawString(".", x2, y2);

            }
            
        }
        }//end of for loop
        //ekan e user teke input niye kata gulo eke dbo
        // user input
        drawSec(sec, min, hr, g, centerx, centery, radious);
        
        g.setColor(Color.GREEN);
        g.fillOval(centerx-(midDotDia/2), centery-(midDotDia/2), midDotDia, midDotDia);
    }
    
}
