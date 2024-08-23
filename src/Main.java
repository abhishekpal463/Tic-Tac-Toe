import entity.Board;
import entity.Match;
import entity.Player;
import entity.Symbol;
import service.Game;
import service.serviceImpl.MatchImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int playersCount = sc.nextInt();
        List<Player> players = new ArrayList<>();

        for(int i=0;i<playersCount;i++){
            char symbol = sc.next().charAt(0);
            Symbol playerSymbol = new Symbol(symbol);
            String playerName = sc.next();
            Player player = new Player(playerName,playerSymbol);
            players.add(player);
        }

        List<List<Character>> board = new ArrayList<>();
        for(int i = 0;i<size;i++){
            List<Character>row = new ArrayList<>();
            for(int j=0;j<size;j++){
                row.add('-');
            }
            board.add(row);
        }

        Board gameBoard = new Board(size,board);
        Match match = new Match(gameBoard,players);

        Game game=new MatchImpl();
        game.start(match);


    }
}