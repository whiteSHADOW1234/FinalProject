import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel_PVE extends JPanel implements Runnable {

	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int) (GAME_WIDTH * (0.6));
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;
	static int MP_bar_WIDTH = 0;
	static final int MP_bar_HEIGHT = 20;
	static int white_bar_HEIGHT = 50;
	final int deviation_create_cycle = 120;
	final int deviation_ego = 110; // machine will think it has this volume
	final double machine_use_skill_probality_per_frame = 1.0 / 500;
	final int reverse_probability = (int) (1.0 / machine_use_skill_probality_per_frame);

	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddle1;
	Paddle paddle2;
	Ball ball;
	MP_bar mp_bar_1;
	MP_bar mp_bar_2;
	Score score;

	boolean keep_going = true;
	static boolean beta = false; // only for testing
	long now;
	Random rd;
	int deviation;
	int deviation_waiting_times = 0;

	GamePanel_PVE() {
		if (beta) {
			MP_bar_WIDTH = 500;
			// white_bar_HEIGHT = 100;ddd
		} else {
			MP_bar_WIDTH = 0;
		}
		newPaddles();
		newMP_bar();
		newBall();
		score = new Score(GAME_WIDTH, GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);

		gameThread = new Thread(this);
		gameThread.start();
	}

	public void newBall() {
		random = new Random();
		ball = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2), random.nextInt(GAME_HEIGHT - BALL_DIAMETER),
				BALL_DIAMETER, BALL_DIAMETER);
	}

	public void newPaddles() {
		paddle1 = new Paddle(0, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, white_bar_HEIGHT,
				1);
		paddle2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH,
				PADDLE_HEIGHT, white_bar_HEIGHT, 2);
	}

	public void newMP_bar() {
		mp_bar_1 = new MP_bar(0, 0, MP_bar_WIDTH, MP_bar_HEIGHT, 1);
		mp_bar_2 = new MP_bar((GAME_WIDTH / 2), 0, MP_bar_WIDTH, MP_bar_HEIGHT, 3);
	}

	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}

	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		mp_bar_1.draw(g);
		mp_bar_2.draw(g);
		ball.draw(g);
		score.draw(g);
		Toolkit.getDefaultToolkit().sync(); // I forgot to add this line of code in the video, it helps with the
											// animation

	}

	public void move() {

		paddle1.move();

		if (deviation_waiting_times >= deviation_create_cycle && ball.x >= GAME_WIDTH / 2) {
			rd = new Random();
			deviation = rd.nextInt(deviation_ego);
			deviation_waiting_times = 0;
		}

		if (ball.xVelocity > 0 || ball.x >= GAME_WIDTH / 2) {
			paddle2.move(ball.y, BALL_DIAMETER, ball.xVelocity, deviation / 2);
		}
		ball.move();
		deviation_waiting_times++;
	}

	public void checkCollision() {

		// bounce ball off top & bottom window edges
		int ball_pos = ball.y + (ball.height / 2);
		if (ball.y <= 0) {
			ball.setYDirection(-ball.yVelocity);
		}
		if (ball.y >= GAME_HEIGHT - BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
		}
		// bounce ball off paddles
		if (ball.intersects(paddle1)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; // optional for more difficulty
			if (ball.yVelocity > 0)
				ball.yVelocity++; // optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);

			mp_bar_1.increase(ball_pos <= paddle1.y + paddle1.height / 2 + white_bar_HEIGHT / 2
					&& ball_pos >= paddle1.y + paddle1.height / 2 - white_bar_HEIGHT / 2);
		}
		if (ball.intersects(paddle2)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; // optional for more difficulty
			if (ball.yVelocity > 0)
				ball.yVelocity++; // optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
			mp_bar_2.increase(ball_pos <= paddle2.y + paddle2.height / 2 + white_bar_HEIGHT / 2
					&& ball_pos >= paddle2.y + paddle2.height / 2 - white_bar_HEIGHT / 2);
		}
		// stops paddles at window edges
		if (paddle1.y <= 0)
			paddle1.y = 0;
		if (paddle1.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
			paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;
		if (paddle2.y <= 0)
			paddle2.y = 0;
		if (paddle2.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
			paddle2.y = GAME_HEIGHT - PADDLE_HEIGHT;
		// give a player 1 point and creates new paddles & ball
		if (ball.x <= 0) {
			if (!beta) {
				score.player2++;
			}
			newPaddles();
			newBall();
			System.out.println("Player 2: " + score.player2);
		}
		if (ball.x >= GAME_WIDTH - BALL_DIAMETER) {
			score.player1++;
			newPaddles();
			newBall();
			System.out.println("Player 1: " + score.player1);
		}
	}

	public int GG() {
		if (score.player1 == 11) {
			keep_going = false;
			return 1;
		} else if (score.player2 == 11) {
			keep_going = false;
			return 2;
		} else
			return 0;
	}

	// input the id of the player who is trying to use skill_smash
	// it will change the ball's speed or direction, depending on the ball's
	// original velocity
	public void skill_smash(int id) {
		switch (id) {
			case 1:
				if (mp_bar_1.width >= 500) {
					if (ball.xVelocity > 0) {
						ball.xVelocity += 10;
						if (ball.yVelocity > 0)
							ball.yVelocity += 10;
						else
							ball.yVelocity -= 10;
					} else {
						ball.xVelocity *= -1;
						ball.yVelocity /= 10;
					}

					mp_bar_1.width -= 500;
				}
				break;
			case 2:
				if (mp_bar_2.width >= 500) {
					if (ball.xVelocity < 0) {
						ball.xVelocity -= 10;
						if (ball.yVelocity > 0)
							ball.yVelocity += 10;
						else
							ball.yVelocity -= 10;
					} else {
						ball.xVelocity *= -1;
						ball.yVelocity /= 10;
					}

					mp_bar_2.width -= 500;
				}

		}
		if (beta) {
			mp_bar_2.width += 500;
			mp_bar_1.width += 500;
		}

	}

	public void machine_skill() {
		if (mp_bar_2.width >= 500 && ball.x >= GAME_WIDTH / 2 && ball.xVelocity < 0) {
			rd = new Random();
			int chance = rd.nextInt(reverse_probability);
			if (chance == 0) {
				skill_smash(2);
			}
		}
	}

	public void run() {
		// game loop

		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while (keep_going) {
			now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				move();
				machine_skill();
				checkCollision();
				repaint();
				delta--;
			}

		}

	}

	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			if (e.getKeyCode() == KeyEvent.VK_D) {
				skill_smash(1);
			}
		}

		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
		}
	}
}