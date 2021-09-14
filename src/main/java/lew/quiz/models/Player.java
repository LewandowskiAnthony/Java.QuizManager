package lew.quiz.models;

public class Player {

    private static int _playerID = 0;
    private String _playerName;

    public Player(String _playerName) {
        _playerID++;
        this._playerName = _playerName;
    }

}
