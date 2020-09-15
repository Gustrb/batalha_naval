package battleship.core;

/**
 * AlreadyHaveBoat is thrown when a given point has a boat
 * 
 * @author Diógenes Dietrich de Morais
 * @since 1.0
 * @access public
 * 
 * */
public class AlreadyHaveBoat extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * AlreadyHaveBoat is the constructor of the class
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access public
	 *
	 * @param p is the invalid point
	 *
	 * */
    public AlreadyHaveBoat(final Point p){
    	super("Já existe um barco em: " + p.toString());
    }
}
