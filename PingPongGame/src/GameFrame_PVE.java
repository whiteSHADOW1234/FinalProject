import java.awt.*;
import javax.swing.*;

public class GameFrame_PVE extends JFrame {

	GamePanel_PVE panel;

	GameFrame_PVE() {
		panel = new GamePanel_PVE();
		this.add(panel);
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack(); // pack the items in the panel window.
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	public int check_if_GG() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 30.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int gameend;
		while (true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				// System.out.println("stuck");
				gameend = panel.GG();
				if (gameend == 1 || gameend == 2) {
					break;
				}
				delta--;
			}
		}
		System.out.println("GG");
		this.dispose();
		return gameend;
	}

}