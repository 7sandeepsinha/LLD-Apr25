package Projects.TicTacToe.controller;

import Projects.TicTacToe.model.Board;
import Projects.TicTacToe.model.Game;
import Projects.TicTacToe.model.Move;
import Projects.TicTacToe.model.Player;
import Projects.TicTacToe.model.constants.GameStatus;
import Projects.TicTacToe.service.GameService;
import Projects.TicTacToe.service.winnerDrawCheckStrategy.WinnerCehckStrategyFactory;
import Projects.TicTacToe.service.winnerDrawCheckStrategy.WinningCheckStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    public Game createGame(Board board, List<Player> players) {
        int dimension = board.getDimension();
        return Game.builder()
                .setGameStatus(GameStatus.IN_PROGRESS)
                .setPlayers(players)
                .setBoard(board)
                .setCurrentPlayer(players.get(0))
                .setMoves(new ArrayList<>())
                .setBoardStates(new ArrayList<>())
                .setNumberOfMaps((2 * dimension) + 3)
                .build();
    }

    public void displayBoard(Game game){
        game.getBoard().displayBoard();
    }

    public Move executeMove(Game game, Player player){
        return gameService.executeMove(game, player);
    }

    public Player checkWinner(Game game, Move lastPlayedMove){
        WinningCheckStrategy strategy = WinnerCehckStrategyFactory.getWinnerCheckStrategy(game.getBoard().getDimension());
        return strategy.checkWinner(game.getBoard(), lastPlayedMove);
    }

    public Board undo(Game game, Player player){
        //1. 1 Player can do undo only 1 time
        //2. Player can undo X number of moves in the game. X<=3. X is cumulative moves, not just player's individual move
        //3. We are storing list of moves and list of board states
        //4. Make the current board as boardStates.get(totalMoves-X);
        //5. Delete all moves from current till last X in moves list
        //6. Re-shuffle player list
        return null;
    }

    public void playReplay(Game game){
        List<Board> boardStates = game.getBoardStates();
        for (Board board : boardStates) {
            board.displayBoard();
        }
    }
}
