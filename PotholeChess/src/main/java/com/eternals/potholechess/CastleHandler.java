package com.eternals.potholechess;

public class CastleHandler {

    public void castle(GameState gs, GameState.Move move) {
        int startRow = move.getStartRow();
        int startCol = move.getStartCol();
        int endRow = move.getEndRow();
        int endCol = move.getEndCol();
        String[][] board = gs.getBoard();

        // Check if the king or rook has moved
        String piece = board[startRow][startCol];
        if (piece.equals("wK") && gs.getWhiteKingMoved()) {
            System.out.println("White king has already moved, cannot castle.");
            return;
        } else if (piece.equals("bK") && gs.getBlackKingMoved()) {
            System.out.println("Black king has already moved, cannot castle.");
            return;
        } else if (piece.equals("wR") && startRow == 7 && startCol == 0 && gs.getWhiteQueenRookMoved()) {
            System.out.println("White queen side rook has already moved, cannot castle.");
            return;
        } else if (piece.equals("wR") && startRow == 7 && startCol == 7 && gs.getWhiteKingRookMoved()) {
            System.out.println("White king side rook has already moved, cannot castle.");
            return;
        } else if (piece.equals("bR") && startRow == 0 && startCol == 0 && gs.getBlackQueenRookMoved()) {
            System.out.println("Black queen side rook has already moved, cannot castle.");
            return;
        } else if (piece.equals("bR") && startRow == 0 && startCol == 7 && gs.getBlackKingRookMoved()) {
            System.out.println("Black king side rook has already moved, cannot castle.");
            return;
        }

        // Move the king
        board[endRow][endCol] = board[startRow][startCol];
        board[startRow][startCol] = "--";

        // Move the rook
        if (endCol == 2) { // Queen side castling
            board[startRow][3] = board[startRow][0];
            board[startRow][0] = "--";
        } else if (endCol == 6) { // King side castling
            board[startRow][5] = board[startRow][7];
            board[startRow][7] = "--";
        }

        // Update the board in the game state
        gs.setBoard(board);

        // Update king and rook moved status in game state
        if (piece.equals("wK")) {
            gs.setWhiteKingMoved(true);
        } else if (piece.equals("bK")) {
            gs.setBlackKingMoved(true);
        } else if (piece.equals("wR") && startRow == 7 && startCol == 0) {
            gs.setWhiteQueenRookMoved(true);
        } else if (piece.equals("wR") && startRow == 7 && startCol == 7) {
            gs.setWhiteKingRookMoved(true);
        } else if (piece.equals("bR") && startRow == 0 && startCol == 0) {
            gs.setBlackQueenRookMoved(true);
        } else if (piece.equals("bR") && startRow == 0 && startCol == 7) {
            gs.setBlackKingRookMoved(true);
        }
    }
}
