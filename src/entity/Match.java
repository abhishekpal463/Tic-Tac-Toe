package entity;

import java.util.List;

public class Match {
    Board board;
    List<Player>players;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Match(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
    }
}
