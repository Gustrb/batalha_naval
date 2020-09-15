package battleship.core;

/**
 * ShootedPoint is thrown when a given point has been shot
 * 
 * @author Diógenes Dietrich de Morais
 * @since 1.0
 * @access public
 * 
 * */
public class ShootedPoint extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * ShootedPoint is the constructor of the class
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access public
	 *
	 * @param p is the invalid point
	 *
	 * */
    public ShootedPoint(final Point p){
    	super("Você já atirou nesse ponto: " + p.toString());
    }
}
