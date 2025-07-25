package Projects.TicTacToe.service.winnerDrawCheckStrategy;

public class WinnerCehckStrategyFactory {
    public static WinningCheckStrategy getWinnerCheckStrategy(int dimension) {
        //TODO: add enum for different strategy names, and apply switch case here
        return OrderOneWinnerCheckStrategy.getInstance(dimension);
    }
}
