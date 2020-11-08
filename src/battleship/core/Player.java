package battleship.core;

/**
 * Player is the class that have access to each individual players data
 * 
 * @author Gustavo Reis Bauer
 * @since 1.0
 * @access public
 * 
 * */
public class Player {

	/**
	 * BASE_POINTS holds the base value of score
	 *
	 * @since 1.0
	 * @access private
	 *
	 * */
	private static final int BASE_POINTS = 1000;

	/**
	 * name is the name of the player that is playing
	 * 
	 * @since 1.0
	 * @access private
	 * 
	 * */
	private final String name;
	
	/**
	 * score is the player's score
	 * 
	 * @since 1.0
	 * @access private
	 * 
	 * */
	private int score;

	/**
	 * wrongAttempts counts the player's wrong attempts when shooting
	 *
	 * @since 1.0
	 * @access private
	 *
	 * */
	private int wrongAttempts;
	
	/**
	 * myTurn holds the turn value of each player if myTurn is true then the player can play
	 * 
	 * @since 1.0
	 * @access private
	 * 
	 * */
	private boolean myTurn;

	/**
	 * hitBoatsPoints counts how many points that have a boat were shot
	 *
	 * @since 1.0
	 * @access private
	 *
	 * */
	private int hitBoatsPoints;

	/**
	 * hitBoatsPoints counts how many points that have a boat
	 *
	 * @since 1.0
	 * @access private
	 *
	 * */
	private int boatsPoints;

	/**
	 * board is the space where the game will be played
	 * 
	 * @since 1.0
	 * @access private
	 * 
	 * */
	private final Board board;

	/**
	 * Player is the default constructor of the class Player
	 *
	 * @since 1.0
	 * @access public 
	 * 
	 * @param name is the name of the player(cannot be changed later)
	 * 
	 * */
	public Player(final String name) {
		this.board = new Board();
		this.name = name;
		this.myTurn = false;
		this.score = 0;
		this.wrongAttempts = 0;
		this.hitBoatsPoints = 0;
		this.boatsPoints = 0;
	}
	
	/**
	 * incrementScore is the method which increments the score variable
	 * 
	 * @since 1.0
	 * @access public
	 * 
	 * */
	public void incrementScore() {
		if(this.wrongAttempts == 0) {
			this.score += BASE_POINTS;
			return;
		}

		this.score += (BASE_POINTS / this.wrongAttempts);
	}

	/**
	 * incrementWrongAttempts is the method which increments the wrongAttempts variable
	 *
	 * @since 1.0
	 * @access public
	 *
	 * */
	public void incrementWrongAttempts() { this.wrongAttempts ++; }

	/**
	 * resetWrongAttempts is the method which resets the wrongAttempts variable to zero
	 *
	 * @since 1.0
	 * @access public
	 *
	 * */
	public void resetWrongAttempts() { this.wrongAttempts = 0; }

	/**
	 * incrementHitBoatsPoints is the method which increments the hitBoatsPoints variable
	 *
	 * @since 1.0
	 * @access public
	 *
	 * */
	public void incrementHitBoatsPoints(){ this.hitBoatsPoints++; }

	/**
	 * swapTurn swaps the players myTurn variable, its meant to be used when the player makes a play
	 * 
	 * @since 1.0
	 * @access public
	 * 
	 * */
	public void swapTurn() { this.myTurn = !this.myTurn; }
	
	/**
	 * getScore returns the player current score
	 * 
	 * @since 1.0
	 * @access public
	 * 
	 * @return the value of the score variable
	 * 
	 * */
	public int getScore() { return this.score; }
	
	/**
	 * isMyTurn returns if its the player turn
	 * 
	 * @since 1.0
	 * @access public
	 * 
	 * @return the value of the myTurn property
	 * 
	 * */
	public boolean isMyTurn() { return this.myTurn; }
	
	/**
	 * getName returns the player name
	 * 
	 * @since 1.0
	 * @access public
	 * 
	 * return the value of the constant name
	 * 
	 * */
	public String getName() { return this.name; }

	/**
	 * getBoard returns the player board
	 *
	 * @since 1.0
	 * @access public
	 *
	 * return the object board of the player
	 *
	 * */
	public Board getBoard() { return this.board; }

	/**
	 * getBoatsPoints returns the count of boats points
	 *
	 * @since 1.0
	 * @access public
	 *
	 * return the variable boatPoints of player
	 *
	 * */
	public int getBoatsPoints() { return this.boatsPoints; }

	/**
	 * getHitBoatsPoints returns the count of boats points has hit
	 *
	 * @since 1.0
	 * @access public
	 *
	 * return the variable hitBoatsPoints of player
	 *
	 * */
	public int getHitBoatsPoints() { return this.hitBoatsPoints; }

	/**
	 * addBoat add a boat to the boats array and to the player board
	 *
	 * @since 1.0
	 * @access public
	 * 
	 * @throws InvalidPosition if any of the boats positions are not valid
	 * @throws AlreadyHaveBoat if any of the positions provided for the boat are occupied
	 * @throws ArrayIndexOutOfBoundsException if any of the positions provided for the boat exceeds the limit of the array
	 *
	 * @param boat is the boat to be added
	 * 
	 * @return if the boat was successfully added
	 * 
	 * */
	public boolean addBoat(final Boat boat) throws InvalidPosition, AlreadyHaveBoat, ArrayIndexOutOfBoundsException {
		final boolean retValue = this.board.placeBoat(boat);

		this.boatsPoints += boat.getType().getSize();

		return retValue;
	}

	/**
	 * shootPlayer shoots player
	 *
	 * @since 1.0
	 * @access public
	 *
	 * @throws InvalidPosition if any of the boats positions are not valid
	 *
	 * @param point is the point to be shot
	 * @param player is the player which is being shot
	 *
	 * @return if the boat was successfully shot
	 *
	 * */
	public boolean shotPlayer(final Point point, final Player player) throws InvalidPosition, ShootedPoint {
		return player.board.shot(point);
	}
}
