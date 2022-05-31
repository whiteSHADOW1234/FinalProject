import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle {

	int id;
	int yVelocity;
	static int speed = 10;
	static int machine_speed = 10;
	int white_bar_HEIGHT;

	Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int WHITE_BAR_HEIGHT, int id) {
		super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
		white_bar_HEIGHT = WHITE_BAR_HEIGHT;
		this.id = id;
	}

	public void keyPressed(KeyEvent e) {
		switch (id) {
			case 1:
				if (e.getKeyCode() == KeyEvent.VK_W) {
					setYDirection(-speed);
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					setYDirection(speed);
				}
				break;
			case 2:
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					setYDirection(-speed);
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					setYDirection(speed);
				}
				break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (id) {
			case 1:
				if (e.getKeyCode() == KeyEvent.VK_W) {
					setYDirection(0);
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					setYDirection(0);
				}
				break;
			case 2:
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					setYDirection(0);
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					setYDirection(0);
				}
				break;
		}
	}

	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}

	public void move() {
		y = y + yVelocity;
	}

	// machine's move
	public void move(int ball_y, int ball_diameter, int ball_velocity, int deviation) {
		deviation -= deviation / 2;
		if (ball_velocity < 0) {
			ball_velocity *= -1;
		}
		if (ball_velocity >= machine_speed) {
			ball_velocity = machine_speed;
		}

		if (ball_y + ball_diameter / 2 >= y + height / 2 + deviation) {
			setYDirection(ball_velocity);
		} else if (ball_y + ball_diameter / 2 <= y + height / 2 - deviation) {
			setYDirection(-ball_velocity);
		} else {
			setYDirection(0);
		}
		move();
	}

	public void draw(Graphics g) {
		if (id == 1)
			g.setColor(Color.blue);
		else
			g.setColor(Color.red);
		g.fillRect(x, y, width, height);
		// white
		g.setColor(Color.white);
		g.fillRect(x, y + height / 2 - white_bar_HEIGHT / 2, width, white_bar_HEIGHT);
	}
}