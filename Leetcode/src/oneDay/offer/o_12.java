package oneDay.offer;

public class o_12 {

	public static void main(String[] args) {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}};
		String word = "ABCCED";
		System.out.println(new Solution121().exist(board, word));
	}

}
//DFSªÿÀ›(µ›πÈ)+ºÙ÷¶
class Solution121 {
    public boolean exist(char[][] board, String word) {
    	char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (getWord(board, words, i, j, 0)) {
        			return true;
        		}
        	}
        }
        return false;
    }
    
    public boolean getWord(char[][] board, char[] words, int i , int j, int k) {
    	if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||  words[k] != board[i][j]) {
    		return false;
    	}
    	
    	if (k == words.length - 1) {
    		return true;
    	}
    	
    	board[i][j] = ' ';
    	boolean res = getWord(board, words, i + 1, j, k + 1) ||
    			getWord(board, words, i, j + 1, k + 1) || 
    			getWord(board, words, i - 1, j, k + 1) || 
    			getWord(board, words, i, j - 1, k + 1);
    	board[i][j] = words[k];
    	return res;
    }
}