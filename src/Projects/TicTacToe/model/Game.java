package Projects.TicTacToe.model;

import Projects.TicTacToe.exception.DuplicateSymbolException;
import Projects.TicTacToe.model.constants.GameStatus;

import java.util.HashSet;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private List<Move> moves;
    private List<Board> boardStates;
    private int numberOfMaps;

    private Game(Board board, List<Player> players, Player currentPlayer, GameStatus gameStatus, List<Move> moves, List<Board> boardStates, int numberOfMaps) {
        this.board = board;
        this.players = players;
        this.currentPlayer = currentPlayer;
        this.gameStatus = gameStatus;
        this.moves = moves;
        this.boardStates = boardStates;
        this.numberOfMaps = numberOfMaps;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<Board> getBoardStates() {
        return boardStates;
    }

    public void setBoardStates(List<Board> boardStates) {
        this.boardStates = boardStates;
    }

    public int getNumberOfMaps() {
        return numberOfMaps;
    }

    public void setNumberOfMaps(int numberOfMaps) {
        this.numberOfMaps = numberOfMaps;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private Board board;
        private List<Player> players;
        private Player currentPlayer;
        private GameStatus gameStatus;
        private List<Move> moves;
        private List<Board> boardStates;
        private int numberOfMaps;

        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setCurrentPlayer(Player currentPlayer) {
            this.currentPlayer = currentPlayer;
            return this;
        }

        public Builder setGameStatus(GameStatus gameStatus) {
            this.gameStatus = gameStatus;
            return this;
        }

        public Builder setMoves(List<Move> moves) {
            this.moves = moves;
            return this;
        }

        public Builder setBoardStates(List<Board> boardStates) {
            this.boardStates = boardStates;
            return this;
        }

        public Builder setNumberOfMaps(int numberOfMaps) {
            this.numberOfMaps = numberOfMaps;
            return this;
        }

        private void validateUniqueSymbols(){
            HashSet<Character> symbols = new HashSet<>();
            for(Player player : players){
                symbols.add(player.getSymbol());
            }
            if(symbols.size() != players.size()){
                throw new DuplicateSymbolException("There are duplicate symbols");
            }
        }

        private void validate(){
            validateUniqueSymbols();
            //TODO: validate the number of players = dimension - 1
            //TODO: validate there is only 1 BOT in the game
        }

        public Game build(){
            validate();
            return new Game(board, players, currentPlayer, gameStatus, moves, boardStates, numberOfMaps);
        }
    }
}
