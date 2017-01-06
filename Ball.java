import java.awt.Graphics;
import acm.graphics.*;// Adding acm library
import acm.program.*;
import acm.util.*;
/**
 * 
 * @author QuadraPong
 * class to control ball
 * @period 4
 */
public class Ball extends PongObject{
	//instance variables to control speed of ball and position of ball
	private GOval ball;
	private double speedX;
	private double speedY;

	/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 15;
	/**
	 * Creates new ball
	 * @param x major axis of ball
	 * @param y minor axis of ball
	 */
	public Ball(int x, int y) {
		ball = new GOval(x - BALL_RADIUS/2, y - BALL_RADIUS/2, BALL_RADIUS, BALL_RADIUS);
		ball.setFilled(true);
		speedX = Math.random()*2 + .5;
		speedY = Math.random()*2 + .5;
	}
	/**
	 * moves ball a certain speed
	 */

	public void move(){
		ball.move(speedX, speedY);
	}
	/**
	 * getter to get paddle bounds
	 * @return paddle bounds
	 */
	public GRectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
/**
 * inhereted from class
 * not neccesary
 * @param arg0
 */
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * returns x velocity of ball
	 * @return x velocity
	 */
	public double getSpeedX(){
		return speedX;
	}
	/**
	 * returns y velocity of ball
	 * @return y velocity
	 */
	public double getSpeedY(){
		return speedY;
	}
	/**
	 * sets x velocity
	 * @param x x velocity
	 */
	public void setSpeedX(double x){
		speedX = x;
	}
	/**
	 * sets y velocity
	 * @param y y velocity
	 */
	public void setSpeedY(double y){
		speedY = y;
	}
	/**
	 * G objects are treated like instance variables
	 * this is means they need getters
	 * @return 
	 */
	public double getX(){
		return ball.getX();
	}
	/**
	 * G objects are treated like instance variables
	 * this is means they need getters
	 * @return 
	 */
	
	public double getY(){
		return ball.getY();
	}
	/**
	 * checks 4 sides of the ball
	 * @param corner - which corner of the ball you want to check
	 * @return r  - point of the ball theat's ctouching the paddle
	 */
	public GPoint getSide(int corner){
		switch(corner){
		case 1: return new GPoint(ball.getX() + BALL_RADIUS/2, ball.getY());
		case 2: return new GPoint(ball.getX() + BALL_RADIUS, ball.getY() + BALL_RADIUS/2);
		case 3: return new GPoint(ball.getX() + BALL_RADIUS/2, ball.getY() + BALL_RADIUS);
		case 4: return new GPoint(ball.getX(), ball.getY() + BALL_RADIUS/2);
		default: return null;
		}
	}


	@Override
	/**
	 * returns the ball
	 * this way the ball could be used
	 * @return the ball
	 */
	public GOval get() {
		return ball;
	}
	
	


}






