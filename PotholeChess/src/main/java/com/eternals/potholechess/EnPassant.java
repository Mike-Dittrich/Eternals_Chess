package com.eternals.potholechess;

public class EnPassant {

    public void captureEnPassant(GameState gs, GameState.Move move) {
        int startRow = move.getStartRow();
        int startCol = move.getStartCol();
        int endRow = move.getEndRow();
        int endCol = move.getEndCol();
        String[][] board = gs.getBoard();

        // Ensure that en passant conditions are met
        if (Math.abs(startRow - endRow) == 1 && Math.abs(startCol - endCol) == 1 &&
            board[startRow][startCol].toLowerCase().equals("p") && board[endRow][endCol].equals("--")) {

            // Remove the captured pawn
            if (startRow != endRow) {
                board[startRow][endCol] = "--";
            }

            // Move the moving pawn to the target square
            board[endRow][endCol] = board[startRow][startCol];
            board[startRow][startCol] = "--";

            // Update the board in the game state
            gs.setBoard(board);
        } else {
            System.out.println("Invalid en passant move.");
        }
    }
}
