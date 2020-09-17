package battleship;

import battleship.core.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Game is the class that handles the main operations of the game
 *
 * @author Diógenes Dietrich de Morais
 * @since 1.0
 * @access public
 *
 * */
public class Game {
    /**
     * CLEANING_LINES is a constant which holds the number of lines necessary to clear the screen
     *
     * @author Diógenes Dietrich de Morais
     * @since 1.0
     * @access private
     *
     * */
    private static final int CLEANING_LINES = 200;

    /**
     * SHIP_MODEL_PATH is a constant which holds the path of model art of a ship
     *
     * @author Diógenes Dietrich de Morais
     * @since 1.0
     * @access private
     *
     * */
    private static final String SHIP_MODEL_PATH = "./models/ShipModel.txt";

    /**
     * instantiatedPlayers is a variable that contains the number of instantiated players
     *
     * @author Diógenes Dietrich de Morais
     * @since 1.0
     * @access private
     *
     * */
    private int instantiatedPlayers = 0;

    /**
     * input is the Scanner instance that will be used through all the class
     *
     * @author Gustavo Reis Bauer
     * @since 1.0
     * @access private
     *
     */
    private final Scanner input = new Scanner(System.in);

    /**
     * printModel is responsible for rendering a model on the screen
     *
     * @author Diógenes Dietrich de Morais
     * @since 1.0
     * @access private
     *
     * @param path is the path of model
     *
     * */
    private void printModel(String path) throws Exception {
        final BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String line;

        while ((line = buffRead.readLine()) != null)
            System.out.println(line);

        buffRead.close();
        System.out.println();
    }

    /**
     * okInput is responsible for pausing the code flow
     *
     * @author Diógenes Dietrich de Morais
     * @since 1.0
     * @access private
     *
     * */
    private void okInput() {
        System.out.println("Pressione Enter para continuar.");
        this.input.nextLine();

        this.clearScreen();
    }

    /**
     * verifyIntInput is responsible for checking the input value for integers
     *
     * @author Diógenes Dietrich de Morais
     * @since 1.0
     * @access private
     *
     * @return the input value
     * */
    private int verifyIntInput(){
        boolean done  = false;
        int retValue  = 0;

        while(!done) {
            try {
                retValue = input.nextInt();
                done = true;

            } catch (InputMismatchException e) {
                System.out.println("Você precisa digitar um número!");
                this.input.nextLine();
            }
        }

        return retValue;
    }

    /**
     * swapBothTurns is responsible for swap both players turns
     *
     * @author Diógenes Dietrich de Morais
     * @since 1.0
     * @access private
     *
     * @param players is an array that contain the players
     *
     * */
    private void swapBothTurns(final Player[] players){
        for (final Player player : players) {
            player.swapTurn();
        }
    }

    /**
     * clearScreen is responsible for clear the screen
     *
     * @author Diógenes Dietrich de Morais
     * @since 1.0
     * @access public
     * */
    public void clearScreen(){
        for(int i = 0; i < CLEANING_LINES; i++){
            System.out.println();
        }
    }

    /**
     * mainMenu is responsible for shows the main menu
     *
     * @author Diógenes Dietrich de Morais
     * @since 1.0
     * @access public
     *
     * @return if the user wants to continue or leave
     * */
    public boolean mainMenu() {
        char op;
        System.out.println("Bem vindo à Batalha Naval\n");

        try {
            printModel(SHIP_MODEL_PATH);

        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("INICIAR(1)                SAIR(0)");

        do {
            try {
                op = this.input.nextLine().charAt(0);

            } catch (StringIndexOutOfBoundsException e) {
                op = '0';
            }

            if(op != '0' && op != '1')
                System.out.println("Opção Inválida");

        } while(op != '0' && op != '1');

        return op == '1';
    }

    /**
     * getPlayerName is responsible for gets the player's name
     *
     * @author Diógenes Dietrich de Morais
     * @since 1.0
     * @access public
     *
     * @return is the player's name
     *
     * */
    public String getPlayerName() {
        this.instantiatedPlayers++;

        System.out.println("Informe o nome do Jogador " + this.instantiatedPlayers);
        System.out.print("--> ");

        return this.input.next();
    }

    /**
     * createBoat is responsible for creating a player's boats when boat is not the first
     *
     * @author Diógenes Dietrich de Morais
     * @since 1.0
     * @access public
     *
     * @param player is the player who will receive the boat
     * @param type is the type of boat that will be created
     *
     * */
    public void createBoat(final Player player, final BoatType type){
        this.createBoat(player, type, false);
    }

    /**
     * createBoat is responsible for creating the boats of a player
     *
     * @author Diógenes Dietrich de Morais
     * @since 1.0
     * @access public
     *
     * @param player is the player who will receive the boat
     * @param type is the type of boat that will be created
     * @param isFirstBoat is checking whether the boat will be the first
     *
     * */
    public void createBoat(final Player player, final BoatType type, boolean isFirstBoat) {
        if(!isFirstBoat) this.clearScreen();

        final Point point = new Point();
        Boat boat         = null;

        char orientation   = '\0';
        boolean verifyBoat = false;

        do {
            System.out.printf("Escolha a coordenada X para o barco de %d espaços:\n", type.getSize());
            point.setX(this.verifyIntInput());

            System.out.printf("Escolha a coordenada Y para o barco de %d espaços:\n", type.getSize());
            point.setY(this.verifyIntInput());

            if(type.getSize() != 1) {
                System.out.printf("Escolha a orientação para o barco de %d espaços:\n", type.getSize());
                System.out.println("H = Horizontal\nV = Vertical");

                do {
                    try {
                        orientation = this.input.nextLine().toLowerCase().charAt(0);

                    } catch (StringIndexOutOfBoundsException e){
                        orientation = 'e';
                    }

                    switch (orientation) {
                        case 'h':
                            boat = new Boat(type, BoatOrientation.HORIZONTAL, point);
                            break;

                        case 'v':
                            boat = new Boat(type, BoatOrientation.VERTICAL, point);
                            break;

                        default:
                            System.out.println("Opção Inválida");
                    }


                } while (orientation != 'h' && orientation != 'v');

            } else {
                boat = new Boat(type, point);
            }

            try {
                verifyBoat = player.addBoat(boat);

            } catch (InvalidPosition | ArrayIndexOutOfBoundsException e) {
                System.out.println("Posição inválida para o barco!");
                verifyBoat = false;

            } catch (AlreadyHaveBoat e) {
                System.out.println("Já existe um barco nessa posição!");
                verifyBoat = false;
            }

        } while(!verifyBoat);

        player.getBoard().printBoard(true);
        this.okInput();
    }

    /**
     * createAllBoats is responsible for call the method who creates the boats
     *
     * @author Diógenes Dietrich de Morais
     * @since 1.0
     * @access public
     *
     * @param player is the player who will receive the boats
     *
     * */
    public void createAllBoats(final Player player){
        this.createBoat(player, BoatType.LARGE, true);

        for(int i = 0; i < 2; i++)
            this.createBoat(player, BoatType.BIG);

        for(int i = 0; i < 3; i++)
            this.createBoat(player, BoatType.MEDIUM);

        for(int i = 0; i < 4; i++)
            this.createBoat(player, BoatType.SMALL);

        this.showBoardWithBoats(player);
    }

    /**
     * showBoardWithBoats is responsible for renders the board with boats on screen
     *
     * @author Diógenes Dietrich de Morais
     * @since 1.0
     * @access public
     *
     * @param player is the player owner of the board
     *
     * */
    public void showBoardWithBoats(final Player player){
        this.clearScreen();

        System.out.printf("Este é o seu tabuleiro %s:\n", player.getName());

        player.getBoard().printBoard(true);
        this.okInput();
    }

    /**
     * shoot is responsible for receiving the points and making the shots on the board
     *
     * @author Diógenes Dietrich de Morais
     * @since 1.0
     * @access public
     *
     * @param shoot is the player who is shooting
     * @param beShot is the player who will be shot
     *
     * @return if the player shot a boat
     * */
    public void shoot(final Player shoot, final Player beShot){
        final Point point      = new Point();
        final Player[] players = { shoot, beShot };

        boolean verifyShot = false;
        boolean isBoat     = false;

        this.clearScreen();

        do {
            verifyShot = false;
            beShot.getBoard().printBoard(false);

            System.out.printf("Vez de %s atirar!\n", shoot.getName());
            System.out.println("Informe a coordenada de X para o tiro:");
            point.setX(this.verifyIntInput());

            System.out.println("Informe a coordenada de Y para o tiro:");
            point.setY(this.verifyIntInput());

            try {
                isBoat = shoot.shotPlayer(point, beShot);
                verifyShot = true;

            } catch (InvalidPosition e) {
                System.out.println("Posição inválida para o tiro!");

            } catch (ShootedPoint e) {
                System.out.println("Você já atirou nesse ponto!");
            }

            if(!isBoat && verifyShot){
                System.out.println("Você acertou água!");

                beShot.getBoard().printBoard(false);
                shoot.incrementWrongAttempts();

                this.swapBothTurns(players);
                this.okInput();

                return;
            }

            if(isBoat && verifyShot){
                System.out.println("Você atingiu um barco!");

                beShot.getBoard().printBoard(false);
                beShot.incrementHitBoatsPoints();
                shoot.incrementScore();

                shoot.resetWrongAttempts();
                this.okInput();

                if(beShot.getHitBoatsPoints() == beShot.getBoatsPoints()) return;

                verifyShot = false;
            }
        } while(!verifyShot);
    }
}
