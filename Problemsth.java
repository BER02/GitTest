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
		/* Start screen for the game. Player must click to enter
		 * the game.
		 */
		displayWelcomeMsg();
		waitForClick();
		removeAll();
		
		// Setup the bricks for all the turns
		setupBricks();
		
		/* For loop to have NTURNS for the game */
		for(int i = 0; i < NTURNS; i++) {
			// Resetting the score for each turn
			currentP = 0;
			
			// Setup the stage for the game.
			setup();
			
			// Player must click to start the game at the setup screen
			clickStartLabel();
			
			/* Randomly set the start x velocity of the ball at
			 * the start of each turn.
			 */
			xVel = rgen.nextDouble(1.0, 2.0);
			if(rgen.nextBoolean()) xVel = -xVel;
			
			// Setting value to total num of bricks at start of turn
			numBricks = NBRICKS_PER_ROW * NBRICK_ROWS;
			
			// Setting num of paddle bounces to default at start of turn
			paddleBounce = 1;
			
			// Setting y velocity of ball at start of turn to default
			yVel = Y_VEL;
			
			// One round of the game.
			while(notGameOver()) {
				ball.move(xVel, yVel);
				checkForCollision();
				displayScore();
				pause(PAUSE_TIME);
				
				/* Increase velocity of ball ie. difficulty of game
				 * after a certain interval of time dependent on 
				 * PADDLE_BOUNCES constant.
				 */
				increaseVel();
			}
			
			// Remove the ball and paddle at the end of each turn
			remove(paddle);
			remove(ball);
			
			// Check for win condition.
			if(numBricks == 0) {
				displayWinMsg();
				i = NTURNS;
			} else {
				displayTurnMsg(i);
			}
		}
		
		/* Check if player has not won the game then display
		 * the game over msg.
		 */
		if(numBricks != 0) displayGameOverMsg();
	}
	
/** Setup for the game that defines the start state of each turn */
	private void setup() {
		setupPaddle();
		setupBall();
	}
	
/** Setup and add the colored bricks to the canvas */
	private void setupBricks() {
		// Variable to store total width of the block of bricks.
		int totalWidthBricks =
				(NBRICKS_PER_ROW * BRICK_WIDTH) + ((NBRICKS_PER_ROW - 1) * BRICK_SEP);
		
		// For loop to iterate through each row.
		for(int i = 0; i < NBRICK_ROWS; i++) {
			int y = BRICK_Y_OFFSET + (i * (BRICK_HEIGHT + BRICK_SEP));
			
			// For loop to fill the current row with bricks.
			for(int j = 0; j < NBRICKS_PER_ROW; j++) {
				int x = 
					(j * (BRICK_SEP + BRICK_WIDTH)) + ((WIDTH - totalWidthBricks) / 2);
				brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
				brick.setFilled(true);
				brick.setColor(brickColor(i));
				add(brick);
			}
		}
	}
	
/** Fill the color of the brick according to the row number it
 *  belongs to.
 *  @param rowNum The row number to which the brick belongs
 *  @result color The color to be filled in the brick
 */
	private Color brickColor(int numRow) {
		if(numRow < 2) return Color.RED;
		if(1 < numRow && numRow < 4) return Color.orange;
		if(3 < numRow && numRow < 6) return Color.YELLOW;
		if(5 < numRow && numRow < 8) return Color.GREEN;
		else return Color.CYAN;
	}
	
/** Setup and add the paddle to the bottom of the screen */
	private void setupPaddle() {
		paddle = new GRect(PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		int px = (WIDTH - PADDLE_WIDTH) / 2;
		int py = HEIGHT - PADDLE_Y_OFFSET;
		add(paddle, px, py);
		addMouseListeners();
	}
	
/** Move the paddle as the mouse moves over the canvas */
	public void mouseMoved(MouseEvent e) {
		int x = (int) e.getX() - (PADDLE_WIDTH / 2);
		
		// Condition to not let it move past the edges
		if(e.getX() > (WIDTH - (PADDLE_WIDTH / 2)))
			x = WIDTH - PADDLE_WIDTH;
		else if(e.getX() < (PADDLE_WIDTH / 2))
			x = 0;
		
		paddle.setLocation(x, (HEIGHT - PADDLE_Y_OFFSET));
	}
	
/** Setup the ball and add it to the center of the canvas */
	private void setupBall() {
		ball = new GOval(BALL_RADIUS * 2, BALL_RADIUS * 2);
		ball.setFilled(true);
		int bx = WIDTH / 2 - BALL_RADIUS;
		int by = HEIGHT / 2 - BALL_RADIUS;
		add(ball, bx, by);
	}
	
/** Predicate method for the game over conditions which can be
 *  a) Ball crosses the paddle in the y direction. Player loses the turn.
 *  b) All bricks are destroyed. Player Wins the game.
 */
	private boolean notGameOver() {
		return ((ball.getY() < HEIGHT) && (numBricks != 0)); 
	}
	
/** Check for collision with the walls of the canvas, the paddle 
 *  and the bricks
 */
	private void checkForCollision() {
		checkWallCollision();
		checkPaddleBrickCollision();
	}
	
/** Check for collision with the top, left and right walls of 
 *  the canvas and bounce the ball of that wall.
 */
	private void checkWallCollision() {
		if((ball.getX() <= 0) || (ball.getX() >= (WIDTH - (2 * BALL_RADIUS))))
			xVel = -xVel;
		if(ball.getY() <= 0) yVel = -yVel;
	}
	
/** Check for collision with the paddle and the bricks. If
 *  collided with paddle, the ball bounces in the opposite 
 *  direction. If collided with any brick, the ball bounces in
 *  opposite direction and removes that brick from the canvas
 */
	private void checkPaddleBrickCollision() {
		GObject collider = getCollidingObject();
		
		// Check if ball collided with the paddle
		if(collider == paddle) {
			// Add bounce sound
			//bounceClip.play();
			
			yVel = -yVel;
			
			// Increment the number of bounces off the paddle
			paddleBounce++;
			
			/* Bounce the ball upward as much as it has gone below
			 * the paddle.
			 */
			if(((int) ball.getY() + (BALL_RADIUS * 2)) > (HEIGHT - PADDLE_Y_OFFSET)) {
				int bounce = ((int) (ball.getY() + (BALL_RADIUS * 2))) - (HEIGHT - PADDLE_Y_OFFSET);
				ball.move(0, -bounce);
			}
		}
		
		/* Else check if the ball collided with the brick and
		 * not any other GObject on the canvas.
		 */
		else if((collider != null)  && (collider != totalScore) && (collider != currentScore)) {
			// Add bounce sound
			//bounceClip.play();
			
			yVel = -yVel;
			remove(collider);
			
			// Add to the score
			addScore(collider.getColor());
			
			// Decrement the number of bricks on the canvas
			numBricks--;
		}
		
	}
	
/** Adds to the total score of the player when a brick is destroyed */
	private void addScore(Color col) {
		if(col == Color.RED) {
			totalP += redP;
			currentP += redP;
		}
		else if(col == Color.ORANGE) {
			totalP += orangeP;
			currentP += orangeP;
		}
		else if(col == Color.YELLOW) {
			totalP += yellowP;
			currentP += yellowP;
		}
		else if(col == Color.GREEN) {
			totalP += greenP;
			currentP += greenP;
		}
		else if(col == Color.CYAN) {
			totalP += cyanP;
			currentP += cyanP;
		}
	}
	
/** To get any GObject that might be at one of the four 
 *  corners of the GOval ball. Or return null if no GObject is
 *  present.
 *  @result obj The GObject at any of ball's corners or Null
 */
	private GObject getCollidingObject() {
		int x = (int) ball.getX();
		int y = (int) ball.getY();
		
		// Checking all four corners of the ball for an obj
		for(int i = 0; i < 4; i++) {
			switch(i) {
			case 0 : obj = getElementAt(x, y + (2 * BALL_RADIUS)); break;
			case 1 : obj = getElementAt(x + (2 * BALL_RADIUS), y + (2 * BALL_RADIUS)); break;
			case 2 : obj = getElementAt(x, y); break;
			case 3 : obj = getElementAt(x + (2 * BALL_RADIUS), y); break;
			}
			
			if(obj != null) return obj;
		}
		return null;
	}
	
/** Display the welcome screen for the game at the very 
 *  start of the application.
 */
	private void displayWelcomeMsg() {
		setBackground(Color.GRAY);
		
		GLabel welcome = new GLabel("BREAKOUT");
		welcome.setFont("Times New Roman-36");
		welcome.setColor(Color.GREEN);
		double w = welcome.getWidth();
		double h = welcome.getAscent();
		add(welcome, (WIDTH - w) / 2, (HEIGHT - h) / 2);
		
		GLabel click = new GLabel("Click to Play Game");
		click.setFont("-BOLD-16");
		double w2 = click.getWidth();
		double h2 = click.getAscent();
		add(click, (WIDTH - w2) / 2, ((HEIGHT - h2) / 2) + (HEIGHT / 4));
	}
	
/** Display click to start game message at the setup 
 *  screen. Then remove it when the player clicks and we
 *  start the game.
 */
	private void clickStartLabel() {
		GLabel start = new GLabel("Click to Start Game");
		start.setFont("Times New Roman-BOLD-16");
		double w = start.getWidth();
		double h = start.getAscent();
		add(start, (WIDTH - w) / 2, ((HEIGHT - h) / 2) + (HEIGHT / 4));
		
		waitForClick();
		remove(start);
	}
	
/** Displays message after each turn is over regarding the 
 *  number of turns/lives left for the player to attempt
 *  @param i Number of the current turn that has ended
 */
	private void displayTurnMsg(int i) {
		int lives = NTURNS - (i + 1);
		GLabel turn = new GLabel("You have " + lives + " lives left!");
		turn.setFont("Times New Roman-22");
		turn.setColor(Color.GREEN);
		double w = turn.getWidth();
		double h = turn.getAscent();
		add(turn, (WIDTH - w) / 2, (HEIGHT - h) / 2);
		
		GLabel click = new GLabel("Click to Continue");
		click.setFont("-BOLD-16");
		double w2 = click.getWidth();
		double h2 = click.getAscent();
		add(click, (WIDTH - w2) / 2, ((HEIGHT - h2) / 2) + (HEIGHT / 4));
		
		waitForClick();
		remove(turn);
		remove(click);
	}
	
/** Displays the win message */
	private void displayWinMsg() {
		GLabel win = new GLabel("CONGRATS!! You Won!");
		win.setFont("Times New Roman-22");
		win.setColor(Color.GREEN);
		double w = win.getWidth();
		double h = win.getAscent();
		add(win, (WIDTH - w) / 2, (HEIGHT - h) / 2);
		
		GLabel score = new GLabel("Total Score: " + totalP);
		score.setFont("-BOLD-16");
		double w2 = score.getWidth();
		double h2 = score.getAscent();
		add(score, (WIDTH - w2) / 2, ((HEIGHT - h2) / 2) + (HEIGHT / 4));
		
		waitForClick();
		removeAll();
	}
	
/** Displays the game over message */
	private void displayGameOverMsg() {
		removeAll();
		GLabel over = new GLabel("Sorry, Game Over!");
		over.setFont("Times New Roman-22");
		over.setColor(Color.RED);
		double w = over.getWidth();
		double h = over.getAscent();
		add(over, (WIDTH - w) / 2, (HEIGHT - h) / 2);
		
		GLabel score = new GLabel("Total Score: " + totalP);
		score.setFont("-BOLD-16");
		double w2 = score.getWidth();
		double h2 = score.getAscent();
		add(score, (WIDTH - w2) / 2, ((HEIGHT - h2) / 2) + (HEIGHT / 4));
		
		waitForClick();
		removeAll();
	}
	
/** Displays the score */
	private void displayScore() {
		totalScore.setFont("Times New Roman-BOLD-16");
		totalScore.setColor(Color.BLUE);
		double w = totalScore.getWidth();
		double h = totalScore.getAscent();
		totalScore.setLabel("Total Score: " + totalP);
		remove(totalScore);
		add(totalScore, (WIDTH - w) - (w/16), (HEIGHT - h/2));
		
		currentScore.setFont("Times New Roman-BOLD-16");
		currentScore.setColor(Color.BLUE);
		double w2 = currentScore.getWidth();
		double h2 = currentScore.getAscent();
		currentScore.setLabel("Score: " + currentP);
		remove(currentScore);
		add(currentScore, w2/8, (HEIGHT - h2/2));
	}
	
/** Increase the difficulty of the game after the ball has bounced
 *  (PADDLE_BOUNCES-1) number of times off the paddle, by increasing the
 *  velocity of the ball in the y direction.
 */
	private void increaseVel() {
		if(paddleBounce % PADDLE_BOUNCES == 0) {
			double incYVel = rgen.nextDouble(0.1, 0.8);
			if(yVel > 0) yVel += incYVel;
			else if(yVel < 0) yVel -= incYVel;
			paddleBounce++;
		}
	}
	
/** Declaring variables for the ball, the paddle and the bricks */
	private GOval ball;
	private GRect paddle;
	private GRect brick;
	
/** Instance variables for the velocities in x and y direction 
 *  of the ball.
 */
	private double xVel;
	private double yVel;
	
/** Declaring variable to keep track of number of bricks on the canvas */
	private int numBricks;
	
/** Declaring variable for a GObject that will be used to get the
 *  particular element at a point.
 */
	private GObject obj;
	
/** Random Generator instance variable */
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
/** Initializing variables for the score */
	private int currentP;
	private int totalP = 0;
	private int redP = 10;
	private int orangeP = 8;
	private int yellowP = 5;
	private int greenP = 3;
	private int cyanP = 1;
	
/** Initializing variable for the bounce sound clip */
	//private AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");
	
/** Initializing variable for labels of the current and total score */
	private GLabel totalScore = new GLabel("");
	private GLabel currentScore = new GLabel("");
	
/** Initializing variable to keep track of number of bounces off the paddle */
	private int paddleBounce;
}