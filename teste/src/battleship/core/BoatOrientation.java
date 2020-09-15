package battleship.core;

/**
 * BoatOrientation is from which direction the points of the boat will be placed
 * 
 * @author Gustavo Reis Bauer
 * @since 1.0
 * @access public
 * 
 * */
public enum BoatOrientation {
	//VERTICAL will be used if the boat is going to be placed in a vertical line
	VERTICAL,
	
	//HORIZONTAL will be used if the boat is going to be placed in a horizontal line
	HORIZONTAL,
	
	//NONE will be used if the boat is of type small because it only occupies one position
	NONE
}
