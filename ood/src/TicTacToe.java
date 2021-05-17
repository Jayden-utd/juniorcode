import java.util.Scanner;

enum Seed {
    EMPTY, SYMBOL_X, SYMBOL_O // Possible Slot values
}
enum GameState {
    PLAYING, TIE, X_WON, O_WON // Game states
}


/** Player Interface */
interface Player {
    public void move(Board board);
}
class IntelligentComputerPlayer implements Player{

    /** Intelligent Computer Move */
    @Override
    public void move(Board board) {
        // TODO Auto-generated method stub
        if(!bestMove(Seed.SYMBOL_O, board)) { // Check if computer could win
            if(!bestMove(Seed.SYMBOL_X, board)) { //Prevent Player X from wining
                nextMove(board.currentRow,board.currentCol, board); //Make potential move
            }
        }
    }

    public boolean bestMove(Seed seedContent, Board board) {
        //Check if row could be formed with same values on one move
        for(int i=0;i<Board.ROWS;i++) {
            for(int j=0;j<Board.COLS-2;j++) {
                if(board.slots[i][j].content == Seed.EMPTY && board.slots[i][j+1].content == seedContent && board.slots[i][j+2].content == seedContent) {
                    board.slots[i][j].content = Seed.SYMBOL_O;
                    return true;
                }
                else if(board.slots[i][j+1].content == Seed.EMPTY && board.slots[i][j].content == seedContent && board.slots[i][j+2].content == seedContent) {
                    board.slots[i][j+1].content = Seed.SYMBOL_O;
                    return true;
                }
                else if(board.slots[i][j+2].content == Seed.EMPTY && board.slots[i][j+1].content == seedContent && board.slots[i][j].content == seedContent ) {
                    board.slots[i][j+2].content = Seed.SYMBOL_O;
                    return true;
                }
            }
        }

        // Check if columns could be formed with same values on one move
        for(int j=0;j<Board.COLS;j++) {
            for(int i=0;i<Board.ROWS-2;i++) {
                if(board.slots[i][j].content == seedContent && board.slots[i+1][j].content == seedContent && board.slots[i+2][j].content == Seed.EMPTY) {
                    board.slots[i+2][j].content = Seed.SYMBOL_O;
                    return true;
                }else if(board.slots[i+1][j].content == seedContent && board.slots[i+2][j].content == seedContent && board.slots[i][j].content == Seed.EMPTY) {
                    board.slots[i][j].content = Seed.SYMBOL_O;
                    return true;
                }else if(board.slots[i][j].content == seedContent && board.slots[i+2][j].content == seedContent && board.slots[i+1][j].content == Seed.EMPTY) {
                    board.slots[i+1][j].content = Seed.SYMBOL_O;
                    return true;
                }
            }
        }

        if(checkDiagonal(seedContent, board))
            return true;
        return false;
    }

    public boolean checkDiagonal(Seed seedContent, Board board) {
        //check diagonal from left to bottom
        if(board.slots[0][0].content == Seed.EMPTY && board.slots[1][1].content == seedContent && board.slots[2][2].content == seedContent) {
            board.slots[0][0].content = Seed.SYMBOL_O;
            return true;
        }
        else if(board.slots[1][1].content == Seed.EMPTY && board.slots[0][0].content == seedContent && board.slots[2][2].content == seedContent) {
            board.slots[1][1].content = Seed.SYMBOL_O;
            return true;
        }
        else if(board.slots[2][2].content == Seed.EMPTY && board.slots[0][0].content == seedContent && board.slots[1][1].content == seedContent) {
            board.slots[2][2].content = Seed.SYMBOL_O;
            return true;
        }

        //check diagonal from right to bottom
        if(board.slots[0][2].content == Seed.EMPTY && board.slots[1][1].content == seedContent && board.slots[2][0].content == seedContent) {
            board.slots[0][2].content = Seed.SYMBOL_O;
            return true;
        }
        else if(board.slots[1][1].content == Seed.EMPTY && board.slots[0][2].content == seedContent && board.slots[2][0].content == seedContent) {
            board.slots[1][1].content = Seed.SYMBOL_O;
            return true;
        }
        else if(board.slots[2][0].content == Seed.EMPTY && board.slots[0][2].content == seedContent && board.slots[1][1].content == seedContent) {
            board.slots[2][0].content = Seed.SYMBOL_O;
            return true;
        }
        return false;
    }


    public boolean nextMove(int row, int col, Board board) {
        // Prevent Player Win
        if(row-1>0) {
            if(board.slots[row-1][col].content == Seed.EMPTY) {
                board.slots[row-1][col].content = Seed.SYMBOL_O;
                return true;
            }
        }else if(col-1>0) {
            if(board.slots[row][col-1].content == Seed.EMPTY) {
                board.slots[row][col-1].content = Seed.SYMBOL_O;
                return true;
            }
        }else if(row+1<board.ROWS) {
            if(board.slots[row+1][col].content == Seed.EMPTY) {
                board.slots[row+1][col].content = Seed.SYMBOL_O;
                return true;
            }
        }else if(col+1 <board.COLS) {
            if(board.slots[row][col+1].content == Seed.EMPTY) {
                board.slots[row][col+1].content = Seed.SYMBOL_O;
                return true;
            }
        }

        //Potential move
        for(int i=0;i<board.ROWS;i++) {
            for(int j=0;j<board.COLS;i++) {
                if(board.slots[i][j].content == Seed.EMPTY) {
                    board.slots[i][j].content = Seed.SYMBOL_O;
                    return true;
                }
            }
        }
        return false;
    }

}
class HumanPlayer implements Player{

    /** Human move */
    @Override
    public void move(Board board) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        boolean validInput = false;
        do {
            System.out.print("Player 'X', enter the cell you want to move (First row: 1-3, Second row: 4-6, Third row: 7-9) ");
            int cell = in.nextInt() - 1;
            int row = board.index[cell][0];
            int col = board.index[cell][1];
            if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS
                    && board.slots[row][col].content == Seed.EMPTY) {
                board.slots[row][col].content = Seed.SYMBOL_X;
                board.currentRow = row;
                board.currentCol = col;
                validInput = true;
            } else {
                System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                        + ") is not valid. Try again...");
            }
        } while (!validInput);
    }

}
/**
 * The Board class models the game-board.
 */
class Board {
    //Board dimensions
    public static final int ROWS = 3; // Number of rows in the board
    public static final int COLS = 3; // Number of columns in the board

    public int[][] index = {{0,0}, {0,1}, {0,2},  // Maps the cell number to the rows and columns
            {1,0}, {1,1}, {1,2},
            {2,0}, {2,1}, {2,2}};

    //Board is made up of slots
    Slot[][] slots;
    int currentRow, currentCol;  // the current row and column

    /** Constructor to initialize the game board */
    public Board() {
        slots = new Slot[ROWS][COLS];
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                slots[row][col] = new Slot(row, col); // allocate element of the array
            }
        }
    }

    /** Initialize the board */
    public void init() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                slots[row][col].clear();
            }
        }
    }

    /** Check if game is a tie */
    public boolean isTied() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (slots[row][col].content == Seed.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    /**Check win */
    public boolean hasWon(Seed theSeed) {
        //Check if rows is formed with same values
        for(int i=0;i<ROWS;i++) {
            if(slots[i][0].content == theSeed && slots[i][0].content == slots[i][1].content && slots[i][1].content == slots[i][2].content)
                return true;
        }
        //Check if column is formed with same values
        for(int j=0;j<COLS;j++) {
            for(int i=0;i<ROWS-2;i++) {
                if(slots[i][j].content == theSeed && slots[i][j].content == slots[i+1][j].content && slots[i+1][j].content == slots[i+2][j].content) {
                    return true;
                }
            }
        }
        return (currentRow == currentCol            // 3-in-the-diagonal
                && slots[0][0].content == theSeed
                && slots[1][1].content == theSeed
                && slots[2][2].content == theSeed
                || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
                && slots[0][2].content == theSeed
                && slots[1][1].content == theSeed
                && slots[2][0].content == theSeed);
    }

    /** Display Board */
    public void displayBoard() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                slots[row][col].paint();
                if (col < COLS - 1) System.out.print("|");
            }
            System.out.println();
            if (row < ROWS - 1) {
                System.out.println("-----------");
            }
        }
    }
}
/**
 * The Slot class models each individual slot of the game board.
 */
class Slot {
    Seed content;

    int row, col;

    public Slot(int row, int col) {
        this.row = row;
        this.col = col;
        clear();
    }

    public void clear() {
        content = Seed.EMPTY;
    }

    public void paint() {
        switch (content) {
            case SYMBOL_X:  System.out.print(" X "); break;
            case SYMBOL_O: System.out.print(" O "); break;
            case EMPTY:  System.out.print("   "); break;
        }
    }
}

