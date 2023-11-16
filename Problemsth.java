import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Problemsth extends GraphicsProgram {

/** Width and height of application window in pixels. 
 *  Dimensions of game board (usually the same) */
	public void init() {
		setSize(WIDTH, HEIGHT);
	}
	private static final int WIDTH = 250;
	private static final int HEIGHT = 400;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 40;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 35;

/** Number of turns */
	private static final int NTURNS = 3;
	
/** Pause interval between the ball's movement every successive step */
	private static final int PAUSE_TIME = 11;
	
/** Velocity of ball in X axis */
	private static final double Y_VEL = 3;
	
/** Number of bounces after which to increase the velocity of the 
 *  ball in y direction.
 */
	private static final int PADDLE_BOUNCES = 7;
	
/** Runs the Breakout program. */
	public void run() {
		addBricks();
		numOfBricksRemaining = NBRICK_ROWS * NBRICKS_PER_ROW;
		
		for(int i = 0; i < NTURNS; i++) {
			
			addPaddle();
			addBall();
			
			vy = 3.0;
			vx = rgen.nextDouble(1.0, 3.0);
			if (rgen.nextBoolean(0.5)) vx = -vx;
			
			while(gameStillGoing()) {
			collisionWithWall();
			collisionWithPaddleOrBrick();
			ball.move(vx, vy);
			pause(20);
			}
			
			remove(paddle);
			remove(ball);
			
			if(numOfBricksRemaining == 0) showWin();
			if(numOfBricksRemaining != 0 && i == NTURNS - 1) showLose();
			
		}
		
	}

	
	private void showWin() {
		GLabel win = new GLabel("YOU HAVE WON");
		add(win, (WIDTH - win.getWidth()) / 2, (HEIGHT - win.getAscent()) / 2);
	}
	
	private void showLose() {
		GLabel win = new GLabel("YOU HAVE lost");
		add(win, (WIDTH - win.getWidth()) / 2, (HEIGHT - win.getAscent()) / 2);
	}
	
	private void addBricks() {
		for(int i = 0; i < NBRICK_ROWS; i++) {
			for(int j = 0; j < NBRICKS_PER_ROW; j ++) {
				GRect rect = new GRect(BRICK_WIDTH,BRICK_HEIGHT);
				rect.setFilled(true);
				if(i < 2) {
					rect.setColor(Color.RED);
				} else if(i < 4) {
					rect.setColor(Color.ORANGE);
				} else if(i < 6) {
					rect.setColor(Color.YELLOW);
				} else if(i < 8) {
					rect.setColor(Color.GREEN);
				} else if(i < 10) {
					rect.setColor(Color.CYAN);
				}
				
				add(rect,(double) (APPLICATION_WIDTH - BRICK_WIDTH * NBRICKS_PER_ROW - BRICK_SEP * (NBRICKS_PER_ROW - 1)) / 2 + j * (BRICK_WIDTH + BRICK_SEP)
						, BRICK_Y_OFFSET + i * (BRICK_HEIGHT + BRICK_SEP));
			}
		}
	}
	
	private void addPaddle() {
		paddle = new GRect(PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle,(double) (APPLICATION_WIDTH - PADDLE_WIDTH) / 2, HEIGHT - PADDLE_Y_OFFSET);
		addMouseListeners();
	}
	 
	public void mouseDragged(MouseEvent e) {
		
		int xCoordinate = e.getX() - PADDLE_WIDTH / 2;
		
		if(e.getX() > WIDTH - PADDLE_WIDTH / 2) xCoordinate = WIDTH - PADDLE_WIDTH; 
		if(e.getX() < PADDLE_WIDTH / 2) xCoordinate = 0;
		
		paddle.setLocation(xCoordinate , HEIGHT - PADDLE_Y_OFFSET );
	}
	
	private void addBall() {
		ball = new GOval(2 * BALL_RADIUS, 2 * BALL_RADIUS);
		ball.setFilled(true);
		add(ball, WIDTH / 2 - BALL_RADIUS, HEIGHT / 2 - BALL_RADIUS);	
	}
	
	private void collisionWithWall() {
		if(ball.getX() <= 0 || ball.getX() >= WIDTH - 2 * BALL_RADIUS) vx = - vx;
		if(ball.getY() <= 0 || ball.getY() >= HEIGHT) vy = -vy;
	}
	
	private GObject getCollidingObject() {
		if(getElementAt(ball.getX(), ball.getY()) != null) return getElementAt(ball.getX(), ball.getY());
		if(getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY()) != null) return getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY());
		if(getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS) != null) return getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS);
		if(getElementAt(ball.getX(), ball.getY() + 2 * BALL_RADIUS) != null) return getElementAt(ball.getX(), ball.getY() + 2 * BALL_RADIUS);
		 
		return null;
	}
	
	private void collisionWithPaddleOrBrick() {
		GObject collider = getCollidingObject();
		
		if(collider == paddle) {
			vy = -vy;	
		} else {
			vy = -vy;
			remove(collider);
			numOfBricksRemaining--;
		}
	}

	private boolean gameStillGoing() {
		return (ball.getY() < HEIGHT && numOfBricksRemaining != 0);
	}
	
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private GRect paddle;
	private GOval ball;
	private double vx, vy;
	private int numOfBricksRemaining;
}