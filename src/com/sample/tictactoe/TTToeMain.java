package com.sample.tictactoe;

public class TTToeMain
{
    public static void main( String[] args )
    {
//        TTToe lToe = new TTToe(3);
        TTToeNew lToe = new TTToeNew(3);
        lToe.move( 0, 0, 1 );
        
        lToe.move( 0,2,2 );
        
        lToe.move( 2, 2, 1 );
        
        lToe.move( 1, 1, 2 );
        
        lToe.move( 2, 0, 1 );
        
        lToe.move( 1, 0, 2 );
        
        lToe.move( 2, 1, 1 );
        System.out.println( "Player 1 wins." );
    }
    
}
