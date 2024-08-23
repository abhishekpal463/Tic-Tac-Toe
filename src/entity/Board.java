package entity;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    List<List<Character>>board=new ArrayList<>();
    List<Player>players;

    public Board(int size, List<List<Character>> board) {
        this.size = size;
        this.board = board;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Character>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Character>> board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
