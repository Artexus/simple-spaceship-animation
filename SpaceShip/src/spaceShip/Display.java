package spaceShip;
import javax.swing.*;

public class Display 
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("SpaceShip");
		Gameplay gameplay = new Gameplay();
		Thread thread = new Thread(gameplay);
		thread.start();
		frame.setSize(400,500);
		frame.add(gameplay);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

