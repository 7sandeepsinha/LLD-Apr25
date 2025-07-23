package Projects.TicTacToe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> matrix;
    /*
        dimension = 3
        matrix =
        [
           [_,_,_],
           [_,_,_],
           [_,_,_]
        ]

     */
    //creating a board with NXN cells
    public Board(int dimension) {
        this.dimension = dimension;
        matrix = new ArrayList<>(); // outside list
        for(int i=0;i<dimension;i++) {
            matrix.add(new ArrayList<>()); // inside list
            for(int j=0;j<dimension;j++) {
                matrix.get(i).add(new Cell(i,j)); // adding cells in the inside list
            }
        }
    }

    public void displayBoard() {
        for(int i=0;i<dimension;i++) {
            List<Cell> cells = matrix.get(i);
            for(Cell cell : cells) {
                cell.displayCell();
            }
            System.out.println(); // change line after printing every row
        }
    }

    public Board clone(){
        //TODO : add the logic for deep copy
        return null;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<Cell>> matrix) {
        this.matrix = matrix;
    }
}
