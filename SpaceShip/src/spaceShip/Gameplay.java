package spaceShip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gameplay extends JPanel implements MouseMotionListener,MouseListener,Runnable
{
	private int planeCoorX = 185;
	private int planeCoorY = 420;
	Rectangle bullets[] = new Rectangle[100];
	private int bulletsCoorX;
	private boolean readyToFire;
	private int bulletsCoorY;
	public int count = 0;
	public int totalShot = 0;
	public Gameplay()
	{
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	public void paint(Graphics g)
	{
		System.out.println(count);
		//background
		g.setColor(Color.black);
		g.fillRect(1, 1, 384, 461);
		//ammo text
		g.setColor(Color.white);
		g.drawString("Total Shot: "+totalShot, 300,20);

			
		//border
		g.setColor(Color.blue);
		g.fillRect(0, 0, 385, 2);
		g.fillRect(0, 0, 2, 462);
		g.fillRect(384, 0, 2, 461);
		g.fillRect(0, 461, 386, 2);
		//plane
		g.setColor(Color.red);
		g.fillRect(planeCoorX - 15, planeCoorY - 15, 30, 30);
		//bullet

		for(int i = 0 ; i < count ; i ++)
		{
			g.setColor(Color.yellow);
			g.fillRect(bullets[i].x, bullets[i].y, bullets[i].width, bullets[i].height);
		}
	
		repaint();
		
	}
	public void shoot()
	{
		for(int i = 0 ; i < count ; i ++)
		{
			if(bullets[i].y <= 0) 
			{
				bullets[i] = new Rectangle(0,0,0,0);
			}
			else
				bullets[i].y --;
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) 
	{
		planeCoorX = e.getX();
		planeCoorY = e.getY();
		System.out.println(+planeCoorX + "," +planeCoorY);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		planeCoorX = e.getX();
		planeCoorY = e.getY();
	}
	@Override
	public void mouseClicked(MouseEvent e) 
	{	
		int mouse = e.getButton();
		if(mouse == MouseEvent.BUTTON1)
		{
			if(count < 100)
			{
				bulletsCoorX = planeCoorX - 2;
				bulletsCoorY = planeCoorY - 15;
				bullets[count++] = new Rectangle(bulletsCoorX,bulletsCoorY,5,10);	
			}
			else
				count = 0;
			totalShot++;
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void run() {
		try {
			while(true) {
				shoot();
				Thread.sleep(5);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
