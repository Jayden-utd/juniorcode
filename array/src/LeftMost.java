/**
 * @Description:
 * @author: Jayden
 * @date:7/22/21 7:12 PM
 */
public class LeftMost {
    //O(rows + cols)
    public static int leftMostIndex(int[][] binaryMatrix, int rows, int cols){
        if(binaryMatrix == null || binaryMatrix.length == 0) return -1;
        int row = rows - 1;
        int col = cols - 1;
        while(row >= 0 && col >= 0) {
            if(binaryMatrix[row][col] == 0) {
                row--;
            } else{
                col--;
            }
        }
        return col == cols - 1 ? -1 : col + 1;
    }
}

/*
left most indx of 1 present in matrixc
[
	[0,0,1,1],
	[0,0,1,1],
	[0,1,1,1],
	[0,0,1,1] 1

    [1,1,1,1],
	[0,0,1,1],
	[0,1,1,1],
	[0,1,1,1] 0
]

[
	[0,0,1,1],
	[0,0,1,1],
	[0,0,0,1],
	[0,0,0,0]
]
full 1
return 2
*/