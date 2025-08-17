class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i  = 0 ; i <board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] != word.charAt(0)) continue;
                boolean res = explore(board,i,j,0,word);
                if(res) return res;
            }
        }
        return false;
    }

    int[] di = {0,0,-1,1};
    int[] dj = {1,-1,0,0};

    boolean explore(char[][] board,int i,int j,int si,String word){
        if(si == word.length()) return true;
        if(i<0 || j<0 || i>=board.length|| j>=board[0].length) return false;
        if(word.charAt(si)!=board[i][j]) return false;
        char ch = board[i][j];
        board[i][j] = '@';
        for(int d = 0 ; d<4 ; d++){
            boolean r = explore(board,i+di[d],j+dj[d],si+1,word);
            if(r){
                board[i][j] = ch;
                return true;
            }
        }
        board[i][j] = ch;
        return false;
    }
}