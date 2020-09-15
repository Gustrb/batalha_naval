package battleship.core;

/**
 * Board is the class that handles all the operations in the board
 * 
 * @author Gustavo Reis Bauer
 * @since 1.0
 * @access public
 * 
 * */
public class Board {
	
	/**
	 * COLS is a constant which holds the number of columns in the board
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access private
	 *
	 * */
	private static final int COLS = 10;
	
	/**
	 * ROWS is a constant which holds the number of rows in the board
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access private
	 * 
	 * */
	private static final int ROWS = 10;
		
	/**
	 * board is the matrix of Points where the game will be played
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access private
	 * 
	 * */
	private Point[][] board;

	/**
	 * Board is the constructor for the Board class, where the matrix gets started
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access public
	 * 
	 * */
	public Board() {
		this.board = new Point[COLS][ROWS];

		for(int i = 0; i < this.board.length; i++) {
			for(int j = 0; j < this.board[i].length; j++) {
				this.board[i][j] = new Point(i, j);
			}
		}
	}
	
	/**
	 * isValidPosition verify if the given point is in the border of the board matrix
	 * 
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access public
	 * 
	 * @param p is the point to be checked
	 * 
	 * @return if the Point p is within the matrix borders
	 * 
	 * */
	public static boolean isValidPosition(final Point p) {
		return p.getX() < COLS && p.getY() < ROWS && p.getX() >= 0 && p.getY() >= 0;
	}
	
	/**
	 * placeBoat places a boat in the board if the given boat is valid
	 *
	 * @author Diógenes Dietrich de Morais
	 * @author Gustavo Reis Bauer
	 * @since 1.0
	 * @access public
	 *
	 * @throws InvalidPosition if any of the boat given positions are invalid
	 * @throws AlreadyHaveBoat if any of the positions provided for the boat are occupied
	 * @throws ArrayIndexOutOfBoundsException if any of the positions provided for the boat exceeds the limit of the array
	 *
	 * @param boat the boat to be placed
	 * 
	 * @return if the boat was properly placed and none of its positions were occupied
	 *
	 * */
	public boolean placeBoat(final Boat boat) throws InvalidPosition, AlreadyHaveBoat, ArrayIndexOutOfBoundsException {
		final int boatSize 				    = boat.getType().getSize();
		final BoatOrientation orientation   = boat.getOrientation();
		final Point initialPoint			= boat.getInitialPoint();
		
		if(!isValidPosition(initialPoint)) 
			throw new InvalidPosition(initialPoint);

		switch(orientation) {
			case HORIZONTAL:
				for(int i = initialPoint.getX(); i < boatSize+initialPoint.getX(); i++) {
					if(this.board[initialPoint.getY()][i].isOccupied())
						throw new AlreadyHaveBoat(this.board[initialPoint.getY()][i]);

				}

				for(int i = initialPoint.getX(); i < boatSize+initialPoint.getX(); i++) {
					if(!isValidPosition(this.board[initialPoint.getY()][i]) || boatSize+initialPoint.getX()>ROWS)
						throw new InvalidPosition(this.board[initialPoint.getY()][i]);

					this.board[initialPoint.getY()][i].occupy();
					this.board[initialPoint.getY()][i].setOrientation(BoatOrientation.HORIZONTAL);

					if(i == boatSize+initialPoint.getX()-1 || i == initialPoint.getX()){
						this.board[initialPoint.getY()][i].setEdge();
					}

					if(i == initialPoint.getX()){
						this.board[initialPoint.getY()][i].setFirst();
					}
				}

				return true;

			case VERTICAL:
				for(int i = initialPoint.getY(); i < boatSize+initialPoint.getY(); i++) {
					if(this.board[i][initialPoint.getX()].isOccupied())
						throw new AlreadyHaveBoat(this.board[initialPoint.getY()][i]);

				}

				for(int i = initialPoint.getY(); i < boatSize+initialPoint.getY(); i++) {
					if(!isValidPosition(this.board[i][initialPoint.getX()]) || boatSize+initialPoint.getY()>COLS)
						throw new InvalidPosition(this.board[i][initialPoint.getX()]);

					this.board[i][initialPoint.getX()].occupy();
					this.board[i][initialPoint.getX()].setOrientation(BoatOrientation.VERTICAL);

					if(i == boatSize+initialPoint.getY()-1 || i == initialPoint.getY()){
						this.board[i][initialPoint.getX()].setEdge();
					}

					if(i == initialPoint.getY()){
						this.board[i][initialPoint.getX()].setFirst();
					}


				}

				return true;
				
			case NONE:
				if(!isValidPosition(initialPoint)) 
					throw new InvalidPosition(initialPoint);

				if(this.board[initialPoint.getY()][initialPoint.getX()].isOccupied())
					throw new AlreadyHaveBoat(this.board[initialPoint.getY()][initialPoint.getX()]);
				
				this.board[initialPoint.getY()][initialPoint.getX()].occupy();
				this.board[initialPoint.getY()][initialPoint.getX()].setOrientation(BoatOrientation.NONE);

				return true;
				
		}
		
		return false;
	}
	

	
	/**
	 * shoot shoots a point of a player board
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access public
	 * 
	 * @throws InvalidPosition if the given position if not on the board
	 * @throws ShootedPoint if the given position has been shot
	 *
	 * @param point is the point to be shooted
	 * 
	 * @return true if has boat on point and false if not
	 *
	 * */
	public boolean shot(final Point point) throws InvalidPosition, ShootedPoint {
		if(!isValidPosition(point))
			throw new InvalidPosition(point);

		if(this.board[point.getY()][point.getX()].isShot()){
			throw new ShootedPoint(point);
		}

		this.board[point.getY()][point.getX()].shot();

		return this.board[point.getY()][point.getX()].isOccupied();
	}

	/**
	 * printBoard renders the board on screen with the boats has hit
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access public
	 *
	 * */
	public void printBoard() {
		System.out.println("      |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |");
		for(int i = 0; i < this.board.length; i++) {
			for(int j = 0; j < this.board[i].length; j++) {
				if(j==0){
					System.out.print("|  "+i+"  ");
				}

				if(!this.board[i][j].isShot()){
					System.out.printf("|  ~  ");
					continue;
				}

				if(this.board[i][j].isShot() && !this.board[i][j].isOccupied()){
					System.out.printf("|  ~  ");
					continue;

				}

				if(this.board[i][j].isOccupied() && this.board[i][j].isShot()){
					if(this.board[i][j].getOrientation()==BoatOrientation.NONE){
						System.out.printf("|  ◙  ");
						continue;
					}
					if(!this.board[i][j].isEdge()){
						System.out.printf("|  █  ");
						continue;
					}

					if(this.board[i][j].isEdge()){
						switch(this.board[i][j].getOrientation()){
							case HORIZONTAL:
								if(this.board[i][j].isFirst()){
									System.out.printf("|  ◄  ");
								}
								else{
									System.out.printf("|  ►  ");
								}
								break;
							case VERTICAL:
								if(this.board[i][j].isFirst()){
									System.out.printf("|  ▲  ");
								}
								else{
									System.out.printf("|  ▼  ");
								}
								break;
						}

					}

				}

			}
			System.out.print("|");
			System.out.println();
		}
	}

	/**
	 * printBoard renders the board on screen with all boats of the player
	 *
	 * @author Diógenes Dietrich de Morais
	 * @since 1.0
	 * @access public
	 *
	 * */
	public void printBoardWithBoats() {
		System.out.println("      |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |");
		for(int i = 0; i < this.board.length; i++) {
			for(int j = 0; j < this.board[i].length; j++) {
				if(j==0){
					System.out.print("|  "+i+"  ");
				}

				if(!this.board[i][j].isOccupied()){
					System.out.printf("|  ~  ");
					continue;
				}

				if(this.board[i][j].isOccupied()){
					if(this.board[i][j].getOrientation()==BoatOrientation.NONE){
						System.out.printf("|  ◙  ");
						continue;
					}
					if(!this.board[i][j].isEdge()){
						System.out.printf("|  █  ");
						continue;
					}

					if(this.board[i][j].isEdge()){
						switch(this.board[i][j].getOrientation()){
							case HORIZONTAL:
								if(this.board[i][j].isFirst()){
									System.out.printf("|  ◄  ");
								}
								else{
									System.out.printf("|  ►  ");
								}
								break;
							case VERTICAL:
								if(this.board[i][j].isFirst()){
									System.out.printf("|  ▲  ");
								}
								else{
									System.out.printf("|  ▼  ");
								}
								break;
						}

					}

				}

			}
			System.out.print("|");
			System.out.println();
		}
	}
	
}
