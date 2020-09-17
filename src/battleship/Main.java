package battleship;

import battleship.core.Player;

public class Main {

	public static void main(String[] args) {
		final Game game = new Game();

		//Verifying main menu option
		if(!game.mainMenu()) {
			System.out.println("Saindo...");
			System.exit(0);
		}

		//Defining player names
		final Player player1 = new Player(game.getPlayerName());
		final Player player2 = new Player(game.getPlayerName());

		//Cleaning screen
		game.clearScreen();

		//Creating player's boats
		System.out.printf("É a vez de %s escolher a posição de seus barcos\n", player1.getName());
		game.createAllBoats(player1);

		System.out.printf("É a vez de %s escolher a posição de seus barcos\n", player2.getName());
		game.createAllBoats(player2);

		//Starting the game by player one
		player1.swapTurn();

		//Shooting rounds
		do {
			if(player1.isMyTurn())
				game.shoot(player1, player2);

			else
				game.shoot(player2, player1);

		} while(player1.getHitBoatsPoints() < player1.getBoatsPoints() && player2.getHitBoatsPoints() < player2.getBoatsPoints());

		//Winner message
		if(player1.getHitBoatsPoints() <= player1.getBoatsPoints())
			System.out.printf("O %s venceu! (%d pontos)\n", player1.getName(), player1.getScore());

		else
			System.out.printf("O %s venceu! (%d pontos)\n", player2.getName(), player2.getScore());

	}
}
