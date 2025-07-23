package Projects.TicTacToe.service.botPlayingStrategy;

import Projects.TicTacToe.model.Board;
import Projects.TicTacToe.model.Move;
import Projects.TicTacToe.model.Player;

public interface BotPlayingStrategy {
    Move makeMove(Board board, Player player);
}
