package Projects.TicTacToe.model;

public class Move {
    // player made a symbol in a single cell
    // 3 -> player, symbol, cell
    // Player, Cell
    private Player player;
    private Cell cell;

    public Move(Player player, Cell cell) {
        this.player = player;
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
