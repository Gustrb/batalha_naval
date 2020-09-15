package battleship.core;

/**
 * Point is the atomic part of the board
 * 
 * @author Gustavo Reis Bauer
 * @since 1.0
 * @access public
 * 
 * */
public class Point {
	
	/**
	 * the x position of the point in the board
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access private
	 * 
	 * */
	private int x;
	
	/**
	 * the y position of the point in the board
	 * 
	 * @author Gustavo Reis Baeur
	 * @since 1.0
	 * @access private
	 * 
	 * */
	private int y;
	
	/**
	 * isOccupied is true if the point was occupied by a boat
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access private
	 * 
	 * */
	private boolean isOccupied;

	/**
	 * isShot is true if the point was shot
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access private
	 *
	 * */
	private boolean isShot;

	/**
	 * isEdge is true if the point was an edge
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access private
	 *
	 * */
	private boolean isEdge;

	/**
	 * isFirst is true if the point was the first edge
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access private
	 *
	 * */
	private boolean isFirst;

	/**
	 * orientation is the orientation of the boat to which the point belongs
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access private
	 *
	 * */
	private BoatOrientation orientation;

	/**
	 * Point is the constructor of the class
	 * 
	 * @author Diógenes Dietrich de Morais
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access public
	 *
	 * @param x is the x position of the point
	 * @param y is the y position of the point
	 * 
	 * */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.isOccupied = false;
		this.isShot = false;
		this.isEdge = false;
		this.isFirst = false;
		this.orientation = null;
	}

	/**
	 * Point is the empty constructor of the class
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access public
	 *
	 * */
	public Point(){
		this.x = 0;
		this.y = 0;
		this.isOccupied = false;
		this.isShot = false;
		this.isEdge = false;
		this.isFirst = false;
		this.orientation = null;
	}

	/**
	 * setX sets the value of the x property
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access public
	 * @param x is the value of the x property
	 *
	 * */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * setY sets the value of the y property
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access public
	 * @param y is the value of the y property
	 *
	 * */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * getX returns the x position of the point
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access public
	 * 
	 * @return the value of the x property
	 * */
	public int getX() {
		return this.x; 
	}
	
	/**
	 * getY returns the y position of the point
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access public
	 * 
	 * @return the value of the y property
	 * */
	public int getY() {
		return this.y; 
	}
	
	/**
	 * occupy is used to occupy a point in the board
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access public
	 * 
	 * */
	public void occupy() { 
		this.isOccupied = true;
	}

	/**
	 * shot is used to shot a point in the board
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access public
	 *
	 * */
	public void shot() { this.isShot = true; }

	/**
	 * setEdge is used to set edge property on point in the board
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access public
	 *
	 * */
	public void setEdge() { this.isEdge = true; }

	/**
	 * setFirst is used to set first property on point in the board
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access public
	 *
	 * */
	public void setFirst() { this.isFirst = true; }

	/**
	 * setOrientation is used to set orientation property on point in the board
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access public
	 *
	 * */
	public void setOrientation(final BoatOrientation orientation) { this.orientation = orientation;}

	/**
	 * isOccupied returns if the Point is occupied
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access public
	 * 
	 * @return the value of the isOccupied property
	 * 
	 * */
	public boolean isOccupied() { 
		return this.isOccupied;
	}

	/**
	 * isEdge returns if the Point is an edge
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access public
	 *
	 * @return the value of the isEdge property
	 *
	 * */
	public boolean isEdge() { return this.isEdge; }

	/**
	 * isFirst returns if the Point is the first edge
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access public
	 *
	 * @return the value of the isFirst property
	 *
	 * */
	public boolean isFirst() { return this.isFirst; }

	/**
	 * isShot returns if the Point was shot
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access public
	 *
	 * @return the value of the isShot property
	 *
	 * */
	public boolean isShot() { return this.isShot; }

	/**
	 * getOrientation returns the value of orientation variable
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access public
	 *
	 * @return the value of the orientation variable
	 *
	 * */
	 public BoatOrientation getOrientation(){ return this.orientation; }
	
	/**
	 * toString parses the values of the class to a more appealing form
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access public
	 * 
	 * @return the point in a form like (0, 0)
	 * 
	 * */
	@Override 
	public String toString() { 
		return "(" + this.x + ", " + this.y + ")";
	}
}
