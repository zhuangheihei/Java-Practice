import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // always remember to do im
        if(matrix.length == 0 || matrix[0].length == 0) return res;
        int row = matrix.length, col = matrix[0].length;
        if(row == 0 || col == 0) return res;
        int rowBegin = 0, rowEnd = row-1, colBegin = 0, colEnd=col-1;
        // 如果不加'='就不会traverse到全部的元素
        while(rowBegin<=rowEnd && colBegin<=colEnd){
            // Traverse right
            for(int j=colBegin; j<=colEnd; j++){
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            // traverse down
            for(int i=rowBegin;i<=rowEnd; i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            // need to check if the column is still valid, or duplicates can happen
            if(rowBegin<=rowEnd){
                // traverse left
                for(int j=colEnd; j>=colBegin; j--){
                    res.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }
            // need to check if the row is still valid, or duplicates may happen
            if(colBegin<=colEnd){
                // traverse up
                for(int i=rowEnd;i>=rowBegin; i--){
                    res.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
            
        }
        return res;
    }
}



/*
    I traverse right and increment rowBegin, then traverse down and decrement colEnd, 
    then I traverse left and decrement rowEnd, and finally I traverse up and increment 
    colBegin.

    The only tricky part is that when I traverse left or up I have to check whether the row 
    or col still exists to prevent duplicates. If anyone can do the same thing without that check, 
    please let me know!

    总结：用四个变量来分别规定row和col的起始点和终点，并在遍历完这一个row或者col之后将相应的变量缩减或增加来规定
    下一个traverse的边界。
*/