class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] newimage = image;
        if(newimage[sr][sc]==newColor) return newimage;
        dfs(newimage, sr, sc, image[sr][sc], newColor);
        return newimage;
    }

    private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor){
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        dfs(image, sr-1, sc, oldColor, newColor);
        dfs(image, sr+1, sc, oldColor, newColor);
        dfs(image, sr, sc-1, oldColor, newColor);
        dfs(image, sr, sc+1, oldColor, newColor);
    }
}


/*
    这个题目和number of island有点相似，进行dfs搜索即可。
    注意要判断当前的newColor是否和oldColor一样。如果一样就不要运算，否则会死循环 stack overflow
    注意在递归的dfs中先判断当前的情况要不要进行运算。
*/