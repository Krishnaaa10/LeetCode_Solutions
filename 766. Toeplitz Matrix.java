class Solution {
    public boolean check(int arr[][],int row,int col){
        int val=arr[row][col];
        while(row!=arr.length && col!=arr[0].length){
            if(val!=arr[row][col]){
                return false;
            }
            else{
                row++;
                col++;
            }
        }
        return true;
    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            if(!check(matrix,i,0)){
                return false;
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            if(!check(matrix,0,i)){
                return false;
            }
        }
        return true;
    }
}