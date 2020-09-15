package battleship;

import battleship.core.Player;

public class Main {

	public static void main(String[] args){
		Game game = new Game();

		//Verifying main menu option
		if(!game.mainMenu()){
			System.out.println("Saindo...");
			System.exit(0);
		}

		//Defining player names
		Player player1 = new Player(game.getPlayerName());
		Player player2 = new Player(game.getPlayerName());

		//Cleaning screen
		game.clearScreen();

		//Creating player's boats
		System.out.println("É a vez de " + player1.getName() + " escolher a posição de seus barcos");
		game.createAllBoats(player1);

		System.out.println("É a vez de " + player2.getName() + " escolher a posição de seus barcos");
		game.createAllBoats(player2);

		//Starting the game by player one
		player1.swapTurn();

		//Shooting rounds
		do{
			if(player1.isMyTurn())
				game.shoot(player1, player2);
			else
				game.shoot(player2, player1);
		}while(player1.getHitBoatsPoints()<player1.getBoatsPoints() && player2.getHitBoatsPoints()<player2.getBoatsPoints());

		//Winner message
		System.out.println(player1.getHitBoatsPoints()<=player1.getBoatsPoints() ? "O "+player1.getName()+" venceu! ("+player1.getScore()+" pontos)" : "O "+player2.getName()+" venceu! ("+player2.getScore()+" pontos)");


	}
}
