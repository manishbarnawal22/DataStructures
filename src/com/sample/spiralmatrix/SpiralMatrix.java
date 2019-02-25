package com.sample.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix
{
    public static void main( String[] args )
    {
        int[][] lMatrix = craeteMatrix();
        spiralPrintMatrix(lMatrix);
        
    }

    private static void spiralPrintMatrix( int[][] matrix )
    {
        List<Integer> result =  new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        
        System.out.println( "m:"+m+",n:"+n );
        int x=0;
        int y=0;
        
        while(m>0 && n>0){
            
            //if one row/column left, no circle can be formed
            if(m==1){
                for(int i=0; i<n; i++){
                    result.add(matrix[x][y++]);
                }
                break;
            }else if(n==1){
                for(int i=0; i<m; i++){
                    result.add(matrix[x++][y]);
                }
                break;
            }
 
            //below, process a circle
 
            //top - move right
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y++]);
            }
 
            //right - move down
            for(int i=0;i<m-1;i++){
                result.add(matrix[x++][y]);
            }
 
            //bottom - move left
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y--]);
            }
 
            //left - move up
            for(int i=0;i<m-1;i++){
                result.add(matrix[x--][y]);
            }
 
            x++;
            y++;
            //because every time two rows gets printed from top and bottom
            m=m-2;
            n=n-2;
        }
        System.out.println( result );
    }

    private static int [][] craeteMatrix()
    {
        int [][] arr = {
                        {1,2,3,4,5,6},
                        {7,8,9,10,11,12},
                        {13,14,15,16,17,18},
                        {19,20,21,22,23,24},
                        {25,26,27,28,29,30}
                        };
        return arr;
    }
 
}
