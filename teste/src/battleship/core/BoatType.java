package battleship.core;

/**
 * BoatType determines the size of the boat
 * 
 * @author Gustavo Reis Bauer
 * @since 1.0
 * @access public
 * 
 * */
public enum BoatType {
	
	//LARGE is used when the boat occupies 4 positions
	LARGE(4),
	
	//BIG is used when the boat occupies 3 positions
	BIG(3),
	
	//MEDIUM is used when the boat occupies 2 positions
	MEDIUM(2),
	
	//SMALL is used when the boat occupies 1 position
	SMALL(1);
	
	/**
	 * size is the number of positions the boat will occupy
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access private
	 * 
	 * */
	private int size;
	
	/**
	 * BoatType is the constructor for the enum
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access default
	 * 
	 * @param size is the number of positions the boat will occupy
	 * 
	 * */
	BoatType(int size) {
		this.size = size;
	}
	
	/**
	 * getSize returns the boat size
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access public
	 * 
	 * @returns the value of the size property
	 * 
	 * */
	public int getSize() {
		return this.size;
	}
}
