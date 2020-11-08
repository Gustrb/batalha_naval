package battleship.core;

/**
 * InvalidPosition is thrown when a given point is not valid
 * 
 * @author Gustavo Reis Bauer
 * @since 1.0
 * @access public
 * 
 * */
public class InvalidPosition extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * InvalidPosition is the constructor of the class
	 * 
	 * @since 1.0
	 * @access public
	 * 
	 * @param p is the invalid point
	 * 
	 * */
    public InvalidPosition(final Point p){
    	super("Posição Inválida: " + p.toString());
    }
}
