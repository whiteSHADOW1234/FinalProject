import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel_infinity extends JPanel implements Runnable {

	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int) (GAME_WIDTH * (0.5555));
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 150;
	static int MP_bar_WIDTH = 0;
	static final int MP_bar_HEIGHT = 20;
	static int white_bar_HEIGHT = 50;
	static int fire_rate_per_second = 1;
	double all_time_always;

	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddle1;
	Paddle paddle2;
	Ball_infinity ball;
	MP_bar mp_bar_1;
	MP_bar mp_bar_2;
	Score score;
	Vector<Ball_infinity> balls_above_all = new Vector<Ball_infinity>();

	boolean keep_going = true;
	static boolean beta = false; // only for testing
	long now;

	GamePanel_infinity() {
		if (beta) {
			MP_bar_WIDTH = 500;
			white_bar_HEIGHT = 100;
		}
		newPaddles();
		newBall();
		newMP_bar();
		score = new Score(GAME_WIDTH, GAME_HEIGHT);
		if (!beta) {
			score.player2 = 60;
		} else {
			score.player2 = 10;
		}
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);

		gameThread = new Thread(this);
		gameThread.start();
	}

	public void newBall() {
		random = new Random();
		ball = new Ball_infinity((GAME_WIDTH - BALL_DIAMETER - 1) - (BALL_DIAMETER / 2),
				random.nextInt(GAME_HEIGHT - BALL_DIAMETER), BALL_DIAMETER, BALL_DIAMETER);
		balls_above_all.add(ball);
	}

	public void newPaddles() {
		paddle1 = new Paddle(0, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, white_bar_HEIGHT,
				1);
		Paddle.speed = 30;
	}

	public void newMP_bar() {
		mp_bar_1 = new MP_bar(0, 0, MP_bar_WIDTH, MP_bar_HEIGHT, 1);
	}

	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}

	public void draw(Graphics g) {
		paddle1.draw(g);
		mp_bar_1.draw(g);
		for (Ball_infinity currentball : balls_above_all) {
			currentball.draw(g);
		}
		score.draw(g);
		Toolkit.getDefaultToolkit().sync(); // I forgot to add this line of code in the video, it helps with the
											// animation

	}

	public void move() {
		paddle1.move();
		for (Ball_infinity currentball : balls_above_all) {
			currentball.move();
		}
	}

	public void checkCollision() {
		int delete_index_correction = 0;
		Vector<Ball_infinity> ball_infinities_copy = (Vector<Ball_infinity>) balls_above_all.clone();

		for (int i = 0; i < ball_infinities_copy.size(); i++) {
			Ball_infinity CurrentBall = ball_infinities_copy.get(i);
			// bounce ball off top & bottom window edges
			int ball_pos = CurrentBall.y + (CurrentBall.height / 2);
			if (CurrentBall.y <= 0) {
				CurrentBall.setYDirection(-CurrentBall.yVelocity);
			}
			if (CurrentBall.y >= GAME_HEIGHT - BALL_DIAMETER) {
				CurrentBall.setYDirection(-CurrentBall.yVelocity);
			}
			// bounce ball off paddles
			if (CurrentBall.intersects(paddle1)) {
				CurrentBall.xVelocity = Math.abs(CurrentBall.xVelocity);

				CurrentBall.setXDirection(CurrentBall.xVelocity);

				mp_bar_1.increase(ball_pos <= paddle1.y + paddle1.height / 2 + white_bar_HEIGHT / 2
						&& ball_pos >= paddle1.y + paddle1.height / 2 - white_bar_HEIGHT / 2);
			}
			// stops paddles at window edges
			if (paddle1.y <= 0)
				paddle1.y = 0;
			if (paddle1.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
				paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;

			// give a player 1 point and creates new paddles & ball
			if (CurrentBall.x <= 0) {
				balls_above_all.remove(i - delete_index_correction);
				delete_index_correction++;
				System.out.println("Miss a ball!");

			} else if (CurrentBall.x >= GAME_WIDTH - BALL_DIAMETER) {
				score.player1++;
				balls_above_all.remove(i - delete_index_correction);
				delete_index_correction++;
				System.out.println("Player 1: " + score.player1);
			}
		}
	}

	public int GG() {
		if (keep_going == false) {
			if (score.player1 != 0)
				return score.player1;
			else
				return 426;
		} else
			return 0;
	}

	public void skill_smash(int id) {
		for (Ball_infinity currentball : balls_above_all) {

			switch (id) {
				case 1:
					if (mp_bar_1.width >= 500) {
						if (currentball.xVelocity > 0) {
							currentball.xVelocity += 10;
							if (currentball.yVelocity > 0)
								currentball.yVelocity += 10;
							else
								currentball.yVelocity -= 10;
						} else {
							currentball.xVelocity *= -1;
							currentball.yVelocity /= 10;
						}

					}
					break;
				case 2:
					if (mp_bar_2.width >= 500) {
						if (currentball.xVelocity < 0) {
							currentball.xVelocity -= 10;
							if (currentball.yVelocity > 0)
								currentball.yVelocity += 10;
							else
								currentball.yVelocity -= 10;
						} else {
							currentball.xVelocity *= -1;
							currentball.yVelocity /= 10;
						}

						mp_bar_2.width -= 500;
					}

			}
			if (beta) {
				currentball.xVelocity *= -1000;
				mp_bar_1.width = 500;
			}
		}
		if (!beta)
			mp_bar_1.width -= 500;

	}

	public void run() {
		// game loop

		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		all_time_always = 0;
		double fire_newball_time = 0;
		double per_sec = 0;
		while (keep_going) {
			now = System.nanoTime();
			delta += (now - lastTime) / ns;
			all_time_always += (now - lastTime) / ns;
			fire_newball_time += (now - lastTime) / ns;
			per_sec += (now - lastTime) / ns;
			lastTime = now;
			if (fire_newball_time >= amountOfTicks / (double) fire_rate_per_second) {
				newBall();
				fire_newball_time = 0;
			}
			if (per_sec >= amountOfTicks) {
				score.player2--;
				per_sec = 0;
			}
			if (delta >= 1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}
			if (all_time_always >= 60 * 10 && beta) {
				keep_going = false;
			} else if (all_time_always >= 60 * 60 && !beta) {
				keep_going = false;
			}

		}
		Paddle.speed = 10;

	}

	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			if (!beta && e.getKeyCode() == KeyEvent.VK_D && all_time_always <= 60 * 55) {
				skill_smash(1);
			} else if (beta && e.getKeyCode() == KeyEvent.VK_D && all_time_always <= 60 * 5) {
				skill_smash(1);
			}
		}

		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
		}
	}
}