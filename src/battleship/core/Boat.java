package battleship.core;

/**
 * Class meant to have all the methods and properties associated with a boat in the game
 * 
 * @author Gustavo Reis Bauer
 * @since 1.0
 * @access public
 *
 * */
public class Boat {
	
	/**
	 * type is the boat type, its an enumeration of all the boat types according to its size
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access private
	 *
	 * */
	private final BoatType type;
	
	/**
	 * orientation is the direction where subsequent points will be placed on the board
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access private
	 *
	 * */
	private final BoatOrientation orientation;
	
	/**
	 * initialPoint is the first point where the boat will be placed(according to its size and direction)
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access private
	 * 
	 * */
	private final Point initialPoint;

	/**
	 * Main constructor to Boat class
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access public
	 * 
	 * @param type is the type of the boat(its size)
	 * @param orientation is which direction the boat points are going to(horizontally or vertically)
	 * @param initialPoint is the first point which the boat will placed into the board(Acording to its orientation)
	 * 
	 * */
	public Boat(final BoatType type, final BoatOrientation orientation, final Point initialPoint) {
		this.type 	       	  = type;
		this.orientation   	  = orientation;
		this.initialPoint  	  = initialPoint;
	}
	
	/**
	 * Alternative constructor method to boat, it's meant to be used only when the boat is of type small
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access public
	 * 
	 * @param type is the type of the boat(its size)
	 * @param initialPoint is the first point which the boat shall be placed into the board
	 * 
	 * */
	public Boat(final BoatType type, final Point initialPoint) {
		this.type 		  = type;
		this.initialPoint = initialPoint;
		this.orientation  = BoatOrientation.NONE;
	}
	
	/**
	 * Returns the type of the boat
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access public
	 * 
	 * @return the value of the type property
	 * 
	 * */
	public BoatType getType() { 
		return this.type; 
	}
	
	/**
	 * Returns the orientation of the boat
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access public
	 * 
	 * @return the value of the orientation property
	 * 
	 * */
	public BoatOrientation getOrientation() {
		return this.orientation;
	}
	
	/**
	 * Returns the first point of the boat
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access public
	 * 
	 * @return the value of the initialPoint property
	 * 
	 * */
	public Point getInitialPoint() {
		return this.initialPoint;
	}
}
