package service.serviceImpl;

import entity.Board;
import entity.Match;
import entity.Player;
import service.Game;

import java.util.List;
import java.util.Scanner;

public class MatchImpl implements Game {

    Scanner sc = new Scanner(System.in);
    @Override
    public void start(Match match) {
        Board matchBoard = match.getBoard();
        List<List<Character>>board  = matchBoard.getBoard();
        List<Player> players= match.getPlayers();
        int noOfPlayers = players.size();

        int moves = board.size()* board.size();

        for(int i=0;i<moves;i++){
            Player player = players.get(i%noOfPlayers);

            int x = sc.nextInt();
            int y = sc.nextInt();

            if(!validateCoordinate(x,y,board.size(),board)) {
                System.out.println("Invalid Move");
                i--;
                continue;
            }

            // updating the board
            char symbol = player.getSymbol().getSymbol();
            board.get(x-1).set(y-1,symbol);
            printBoard(board);
            if(checkWin(board,player)){
                break;
            }
        }
    }

    public boolean checkWin(List<List<Character>>board,Player player){
        char symbol = player.getSymbol().getSymbol();
        int size = board.size();

        for (int i = 0; i < size; i++) {
            boolean rowWin = true;
            boolean colWil = true;

            // Check rows win
            for (int j = 0; j < size; j++) {
                if (board.get(i).get(j) != symbol) {
                    rowWin = false;
                    break;
                }
            }
            if (rowWin) {
                System.out.println("Player " + player.getName() + " wins");
                return true;
            }

            // Check rows win
            for (int j = 0; j < size; j++) {
                if (board.get(j).get(i) != symbol) {
                    colWil = false;
                    break;
                }
            }

            if (colWil) {
                System.out.println("Player " + player.getName() + " wins");
                return true;
            }
        }

        // check right diagonal win
        boolean rightDiagonal = true;
        for(int i=0;i<size;i++){
            if (board.get(i).get(i) != symbol) {
                rightDiagonal = false;
                break;
            }
        }

        if (rightDiagonal) {
            System.out.println("Player " + player.getName() + " wins");
            return true;
        }

        boolean leftDiagonal = true;
        for(int i=size-1,k=0;i>=0;i--,k++){
            if (board.get(k).get(i) != symbol) {
                leftDiagonal = false;
                break;
            }
        }

        if (leftDiagonal) {
            System.out.println("Player " + player.getName() + " wins");
            return true;
        }

        return  false;

    }

    public boolean validateCoordinate(int x,int y, int boardSize,List<List<Character>>board){
        if(x<1 || y<1 || x>boardSize || y>boardSize)
            return false;

        return board.get(x-1).get(y-1) == '-';
    }

    public  void printBoard(List<List<Character>>board){
        int n = board.size();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
