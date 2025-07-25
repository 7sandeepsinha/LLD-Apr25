package Projects.TicTacToe.service.winnerDrawCheckStrategy;

import Projects.TicTacToe.model.Board;
import Projects.TicTacToe.model.Move;
import Projects.TicTacToe.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinnerCheckStrategy implements WinningCheckStrategy{
    private static OrderOneWinnerCheckStrategy instance;
    private int dimension;
    private int eligibleMapsForWinning;
    private List<HashMap<Character, Integer>> rowMapList;
    private List<HashMap<Character, Integer>> colMapList;
    private HashMap<Character, Integer> leftDiagonalMap;
    private HashMap<Character, Integer> rightDiagonalMap;
    private HashMap<Character, Integer> cornerMap;

    private OrderOneWinnerCheckStrategy(int dimension) {
        this.dimension = dimension;
        this.eligibleMapsForWinning = ( 2 * dimension + 3);
        this.rowMapList = new ArrayList<>();
        this.colMapList = new ArrayList<>();
        this.leftDiagonalMap = new HashMap<>(); // 1
        this.rightDiagonalMap = new HashMap<>(); // 1
        this.cornerMap = new HashMap<>(); // 1
        for(int i = 0; i < dimension; i++) {
            rowMapList.add(new HashMap<>());  // N maps
            colMapList.add(new HashMap<>()); // N maps
        }
    }

    public static OrderOneWinnerCheckStrategy getInstance(int dimension) {
        if(instance == null) {
            instance = new OrderOneWinnerCheckStrategy(dimension);
        }
        return instance;
    }

    @Override
    public Player checkWinner(Board board, Move lastMove) {
        Player player = lastMove.getPlayer();
        char symbol = player.getSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();

        boolean winnerResult = checkAndUpdateRowMap(row, symbol)
                                || checkAndUpdateColMap(col, symbol)
                                || (checkLeftDiagonal(row, col) && checkAndUpdateLeftDiagonalMap(symbol))
                                || (checkRightDiagonal(row, col) && checkAndUpdateRightDiagonalMap(symbol))
                                || (checkCorner(row, col) && checkAndUpdateCornerMap(symbol));
        if(winnerResult) {
            return player;
        } else {
            checkForDraw(); // if draw throw exception // TODO: update all methods for draw condition check
            return null;
        }
    }

    private boolean checkLeftDiagonal(int row, int col){
        return row == col;
    }

    private boolean checkRightDiagonal(int row, int col){
        return (row + col) == (dimension - 1);
    }

    private boolean checkCorner(int row, int col){
        return (row == 0 && col ==0)
                || (row == dimension - 1 && col == dimension - 1)
                || (row == 0 && col == dimension - 1)
                || (row == dimension - 1 && col == 0);
    }

    private boolean checkAndUpdateRowMap(int row, char symbol){
        HashMap<Character, Integer> rowMap = rowMapList.get(row);
        if(rowMap.containsKey(symbol)){
            rowMap.put(symbol, rowMap.get(symbol) + 1);
            if(rowMap.keySet().size() > 1){ // map is not eligible for creating winner, as it contains more than 1 symbol, so symbol freq would never become == dimension
                eligibleMapsForWinning--;
            }
            return rowMap.get(symbol) == dimension;
        } else {
            rowMap.put(symbol, 1);
        }
        return false;
    }

    private boolean checkAndUpdateColMap(int col, char symbol){
        HashMap<Character, Integer> colMap = colMapList.get(col);
        if(colMap.containsKey(symbol)){
            colMap.put(symbol, colMap.get(symbol) + 1);
            return colMap.get(symbol) == dimension;
        } else {
            colMap.put(symbol, 1);
        }
        return false;
    }

    private boolean checkAndUpdateLeftDiagonalMap(char symbol){
        if(leftDiagonalMap.containsKey(symbol)){
            leftDiagonalMap.put(symbol, leftDiagonalMap.get(symbol) + 1);
            return leftDiagonalMap.get(symbol) == dimension;
        } else {
            leftDiagonalMap.put(symbol, 1);
        }
        return false;
    }

    private boolean checkAndUpdateRightDiagonalMap(char symbol){
        if(rightDiagonalMap.containsKey(symbol)){
            rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol) + 1);
            return rightDiagonalMap.get(symbol) == dimension;
        } else {
            rightDiagonalMap.put(symbol, 1);
        }
        return false;
    }

    private boolean checkAndUpdateCornerMap(char symbol){
        if(cornerMap.containsKey(symbol)){
            cornerMap.put(symbol, cornerMap.get(symbol) + 1);
            return cornerMap.get(symbol) == 4;
        } else {
            cornerMap.put(symbol, 1);
        }
        return false;
    }

    private boolean checkForDraw(){
        return eligibleMapsForWinning == 0;
    }
}

/*  Algorithm

    Steps for checking winner -
        1. Create N hashmaps for rows
        2. Create N hashmaps for cols
        3. Create 2 hashmaps for diagonals
        Basis on the last move played by the player
        4. Go to respective hashmaps, and update the frequency of that symbol,
        5. If the updated frequency becomes equal to N, then declare winner
        6. Also check for all 4 corners.
 */

/*
           [
            0 -> X    _   _ H[0]
            1 -> X    X   Z H[1] < <X,3>>
            2 -> _    _   _ H[2]
               H[0] H[1] H[2]
           ]

        List<List<Cell>

        Cell -> 1,1 -> update -> rowMap, colMap, leftDaigMap, rightDaigMap
        Cell -> 1,2 -> update -> rowMap, colMap
        Cell -> 0,0 -> update -> rowMap, colMap, leftDaigMap, CornerMap

        right Diagonal -> 0,2 -> 0+2  = 3-1
                          1,1 -> 1+1 = 3-1
                          2,0 -> 2+0 = 3-1
                          i + j = dimension - 1
        Short Circuit -> X && Y
                           if X and Y both are true -> then X && Y -> true
                           if X is false, then definitely -> X && Y -> false -> no need to check for Y
        if first value is false, second is not even evaluated

        checkLeftDiagonal(row, col) && checkAndUpdateLeftDiagonalMap(symbol)

        if row = 1, col = 2
        checkLeftDiagonal(row, col) -> returns false
        checkAndUpdateLeftDiagonalMap(symbol) -> wont even be evaluated

        checkLeftDiagonal(row, col) && checkAndUpdateLeftDiagonalMap(symbol)
        if row = 0, col = 0
        checkLeftDiagonal(row, col) -> returns true
        checkAndUpdateLeftDiagonalMap(symbol) -> this is evaluated -> if this is true
        overall return true


 */