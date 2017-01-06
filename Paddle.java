import java.awt.Graphics;
import java.awt.event.*;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class Paddle extends PongObject {

	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60; // width of the paddles
	private static final int PADDLE_HEIGHT = 10; // height of the paddles

	/** Offset of the paddle up from the bottom */
	private static final int PADDLE_OFFSET = 30; // distance of the paddle from the bottom of the applet

	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400; // width of the application window
	public static final int APPLICATION_HEIGHT = 400; // height of the application window

	private GRect paddle; // paddle object for GRect
	private char orientation; // orientation 

	/**
	 * Constructor that sets the position and orientation of the paddle
	 * on the x and y axes. 
	 * 
	 * @param o - character that represents the axis of the paddle
	 * @param x - the start location of the paddle on the x axis
	 * @param y - the start location of the paddle on the y axis
	 */
	public Paddle(char o, int x, int y) {
		orientation = o;
		if (orientation == 'X') {
			paddle = new GRect(x - PADDLE_WIDTH / 2, y - PADDLE_HEIGHT / 2,
					PADDLE_WIDTH, PADDLE_HEIGHT);
		} else {
			paddle = new GRect(x - PADDLE_HEIGHT / 2, y - PADDLE_WIDTH / 2,
					PADDLE_HEIGHT, PADDLE_WIDTH);
		}
		paddle.setVisible(true);
		paddle.setFilled(true);

	}

	@Override
	/**
	 * Method that returns null
	 * @return - null
	 */
	public GRectangle getBounds() {
		int x = 0;
		if(x == 0){
			return null;
		} else {
			return getBounds();
		}
	}

	@Override
	/**
	 * Method that draws the passed parameter
	 * @param arg0 - graphics object to be drawn
	 */
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * Method that returns the paddle 
	 * @return - the paddle object
	 */
	public GRect get() {
		return paddle;
	}

	/**
	 * Method that returns the orientation of the paddle
	 * @return - the orientation of the paddle
	 */
	public char getOrientation() {
		return orientation;
	}

	/**
	 * Method that moves the paddle in relation to the location of the mouse
	 * @param x - location of the mouse on the x axis
	 * @param y - location of the mouse on the y axis
	 */
	public void set(double x, double y) {
		if (orientation == 'X') {
			if (x >= 0 + PADDLE_OFFSET + PADDLE_WIDTH / 2
					&& x <= APPLICATION_WIDTH - PADDLE_OFFSET - PADDLE_WIDTH
							/ 2) {
				// if(Math.abs(x - paddle.getX()) < 10)
				paddle.setLocation(x - PADDLE_WIDTH / 2, paddle.getY());
			}

		} else {
			if (y >= 0 + PADDLE_OFFSET + PADDLE_WIDTH / 2
					&& y <= APPLICATION_HEIGHT - PADDLE_OFFSET - PADDLE_WIDTH
							/ 2) {
				// if(Math.abs(y - paddle.getY()) < 10)
				paddle.setLocation(paddle.getX(), y - PADDLE_WIDTH / 2);
			}

		}

	}

	/**
	 * Method that moves the computer controlled paddle in relation to the location 
	 * of the ball
	 * @param x - location of the ball on the x axis
	 * @param y - location of the ball on the y axis
	 */
	public void setCPU(double x, double y) {
		if (orientation == 'X') {
			if (x >= 0 + PADDLE_OFFSET + PADDLE_WIDTH / 2
					&& x <= APPLICATION_WIDTH - PADDLE_OFFSET - PADDLE_WIDTH
							/ 2) {
				if (Math.abs(y - paddle.getY()) < (APPLICATION_HEIGHT / 6))
					paddle.setLocation(x - PADDLE_WIDTH / 2, paddle.getY());
			}

		} else {
			if (y >= 0 + PADDLE_OFFSET + PADDLE_WIDTH / 2
					&& y <= APPLICATION_HEIGHT - PADDLE_OFFSET - PADDLE_WIDTH
							/ 2) {
				if (Math.abs(x - paddle.getX()) < (APPLICATION_WIDTH / 6))
					paddle.setLocation(paddle.getX(), y - PADDLE_WIDTH / 2);
			}

		}

	}

	@Override
	/**
	 * Method that returns the location of the center depending on the orientation
	 * @return - location of the center
	 */
	public double getX() {
		if (orientation == 'X')
			return paddle.getX() + PADDLE_WIDTH / 2;
		else
			return paddle.getX() + PADDLE_HEIGHT / 2;
	}

	@Override
	/**
	 * Method that returns the location of the center depending on the orientation
	 * @return - location of the center
	 */
	public double getY() {
		if (orientation == 'Y')
			return paddle.getY() + PADDLE_WIDTH / 2;
		else
			return paddle.getY() + PADDLE_HEIGHT / 2;
	}

}

