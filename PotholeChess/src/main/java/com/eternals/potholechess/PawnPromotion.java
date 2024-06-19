package com.eternals.potholechess;

public class PawnPromotion {
    
    public void promotePawn(GameState gs, GameState.Move move, Piece newPiece) {
        int endRow = move.endRow;
        int endCol = move.endCol;
        String[][] board = gs.getBoard();
        String color = Character.isUpperCase(board[endRow][endCol].charAt(0)) ? "w" : "b";
      
        String newPieceType = color + newPiece.get_image_file();
      
        // Update the board in the game state
        gs.insertPiece(endRow, endCol, newPiece);
    }
}