import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {

	GamePanel panel;

	GameFrame() {
		panel = new GamePanel();
		this.add(panel);
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack(); // pack the items in the panel window.
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	public int check_if_GG() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 30.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while (true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				// System.out.println("stuck");
				if(panel.GG() == 1 || panel.GG() == 2) 
				{
					break;
				}
				delta--;
			}
		}
		System.out.println("GG");
		this.dispose();
		return panel.GG();
	}

}