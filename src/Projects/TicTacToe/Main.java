package Projects.TicTacToe;

import Projects.TicTacToe.controller.GameController;
import Projects.TicTacToe.model.Board;
import Projects.TicTacToe.model.Bot;
import Projects.TicTacToe.model.Player;
import Projects.TicTacToe.model.constants.BotDifficultyLevel;
import Projects.TicTacToe.model.constants.PlayerType;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //fixed objects
        int id = 1;
        Scanner sc = new Scanner(System.in);
        List<Player> players = new ArrayList<>();
        GameController gameController = new GameController();

        //setting an empty board
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Please enter the size of the board");
        int dimension = sc.nextInt();

        //Setting board with bot
        System.out.println("Do you want a bot in the game ? Y for Yes, N for No");
        String botAnswer = sc.next();
        if (botAnswer.equalsIgnoreCase("Y")) {
            Player botPlayer = new Bot(id++, "BOT", 'B', BotDifficultyLevel.MEDIUM);
            players.add(botPlayer);
        }
        // 5 -> 4
        // no bot -> id = 1 -> [1P,2], [2P,3], [3P,4] , [4P, 5]
        // bot -> id = 2 -> 3 players => [1P, 3] [2P, 4] [3P, 5]
        //creating human players
        while (id < dimension){
            System.out.println("Please enter the name of the player");
            String name = sc.next();
            System.out.println("Please enter the symbol for the player");
            char symbol = sc.next().charAt(0);
            Player newPlayer = new Player(id++, name, symbol, PlayerType.HUMAN);
            players.add(newPlayer);
        }
        Collections.shuffle(players); // shuffling the order of players

        Board board = new Board(dimension);
        // adding players and board to build game
        gameController.createGame(board, players);
    }
}
