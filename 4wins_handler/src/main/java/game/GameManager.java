package game;

import handler.HTTPhandler;
import handler.Sockethandler;
import kong.unirest.json.JSONObject;

public class GameManager {
    public String id;
    public String status;
    public String playerID;
    public long timestamp;
    public int[][] field = new int[7][5];
    public HTTPhandler http = new HTTPhandler();
    public Sockethandler socket = new Sockethandler();

    public GameManager(String playerID) {
        this.playerID = playerID;
        http.launch();
        socket.launch();
    }

    public void printGame() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(this.field[i][j]);
            }
            System.out.println("");
        }
    }


    public void createGame() {
        //create game on server
        this.id = http.createGame(playerID);
    }

    public void startGame() {
        try {
            http.startGame(this.id, this.playerID);
            logger("Successfully started game!");
            field = http.getGame(this.id);
            verfifyPlayer();
        } catch (FailedServerQuery f) {
            logger("Failed to start game: " + f.getMessage());
        }

    }


    public void acceptGame(String gameID) {
        try {
            http.acceptGame(gameID, this.playerID);
            logger("Successfully accepted game");
        } catch (FailedServerQuery f) {
            logger("Failed to accept game: " + f.getMessage());
        }
    }

    public void makeMove(int colIndex) {
        JSONObject json = new JSONObject().put("gameEvent", "move").put("eventData", new JSONObject().put("colIndex", colIndex));
        this.socket.gameEvent(json);
    }

    private void verfifyPlayer() {
        socket.gameVerification(this.id, this.playerID);
    }


    private void logger(String s) {
        System.out.println("[GM] " + s);
    }

    public void setId(String id) {
        this.id = id;
    }
}
