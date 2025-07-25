package Projects.TicTacToe.service;

import Projects.TicTacToe.model.Cell;
import Projects.TicTacToe.model.Game;
import Projects.TicTacToe.model.Move;
import Projects.TicTacToe.model.Player;
import Projects.TicTacToe.model.constants.BotDifficultyLevel;
import Projects.TicTacToe.model.constants.CellState;
import Projects.TicTacToe.model.constants.PlayerType;
import Projects.TicTacToe.service.botPlayingStrategy.BotPlayingStrategy;
import Projects.TicTacToe.service.botPlayingStrategy.BotPlayingStrategyFactory;

import java.util.Scanner;

public class GameService {

    public Move executeMove(Game game, Player player){
        if(player.getPlayerType().equals(PlayerType.HUMAN)){
            return executeMoveHumanPlayer(game, player);
        } else{
            return executeMoveBotPlayer(game, player);
        }
    }

    private Move executeMoveHumanPlayer(Game game, Player player){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row for the target cell : " + player.getName());
        int row = sc.nextInt();
        System.out.println("Enter the col for the target cell : " + player.getName());
        int col = sc.nextInt();

        Cell playedMoveCell = game.getBoard().getMatrix().get(row).get(col);
        playedMoveCell.setPlayer(player);
        playedMoveCell.setCellState(CellState.FILLED);

        return new Move(player, playedMoveCell);
    }

    private Move executeMoveBotPlayer(Game game, Player botPlayer){
        BotPlayingStrategy strategy = BotPlayingStrategyFactory.getBotPlayingStrategy(BotDifficultyLevel.MEDIUM);
        return strategy.makeMove(game.getBoard(), botPlayer);
    }
}
