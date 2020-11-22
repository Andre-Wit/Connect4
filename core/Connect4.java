package core;

public class Connect4 {

    private int[][] board;
    private int curP;
    private int gameOver;

    public Connect4(){
        curP = 1;
        gameOver = 0;
        board = new int[6][7];
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                board[i][j] = 0; //fills in board with 0's
            }
        }
    }

    public boolean validMove(int col) {
        if(col < 0 || col > 7){
            return false;
        }
        if (board[0][col] == 0) { return true; }  //only checks for first row if filled
        else{ return false; }
    }

    public void setDrop(int col, int p){
        for(int i = 0; i < 6; i++){
            if(board[i][col] != 0){
                board[i-1][col] = p; //sets the position of player X(1) or O(2)
                changePlayer();
                return;
            }else if(i == 5){
                board[i][col] = p;
                changePlayer();
            }
        }
    }

    private void changePlayer(){
        if (curP == 1) { curP = 2; }
        else if(curP == 2) {curP = 1;}
        else{ System.out.println("Error");}
    }

    public int getBoard(int row, int col){
        return board[row][col]; //returns the number in that row and column
    }

    public int getCurP(){
        return curP;
    }

    public int getStatus(){
        if(gameOver == 0) { gameOver = checkStatus(1); }
        if(gameOver == 0){ gameOver = checkStatus(2); }

        return gameOver;
    }

    public int checkStatus(int player){
        // horizontalCheck
        for (int j = 0; j<7-3 ; j++ ){
            for (int i = 0; i<6; i++){
                if (this.board[i][j] == player && this.board[i][j+1] == player &&
                        this.board[i][j+2] == player && this.board[i][j+3] == player){
                    return player;
                }
            }
        }
        // verticalCheck
        for (int i = 0; i<6-3 ; i++ ){
            for (int j = 0; j<7; j++){
                if (this.board[i][j] == player && this.board[i+1][j] == player &&
                        this.board[i+2][j] == player && this.board[i+3][j] == player){
                    return player;
                }
            }
        }
        // ascendingDiagonalCheck 
        for (int i=3; i<6; i++){
            for (int j=0; j<7-3; j++) {
                if (this.board[i][j] == player && this.board[i - 1][j + 1] == player &&
                        this.board[i - 2][j + 2] == player && this.board[i - 3][j + 3] == player) {
                    return player;
                }
            }
        }
        // descendingDiagonalCheck
        for (int i=3; i<6; i++){
            for (int j=3; j<7; j++){
                if (this.board[i][j] == player && this.board[i-1][j-1] == player &&
                        this.board[i-2][j-2] == player && this.board[i-3][j-3] == player){
                    return player;
                }
            }
        }
        return 0;
    }

    public void printBoard(){
        String tempS = "";
        int tempI;
        for(int i = 0; i < 6; i++){
            System.out.print("\n");
            for(int j = 0; j < 7; j++){
                tempI = getBoard(i,j);
                if(tempI == 0){ tempS = " "; }
                else if(tempI == 1){ tempS = "X"; }
                else if(tempI == 2){ tempS = "O"; }
                else{ System.out.println("Error reading Board."); }
                System.out.print("|" + tempS);
            }
            System.out.print("|");
        }
        System.out.println();
        if(getStatus() == 1){
            System.out.println("Player X Won!");
        }else if(getStatus() == 2){
            System.out.println("Player O Won!");
        }
    }
}
