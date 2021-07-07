import game.GameManager;
import handler.HTTPhandler;
import handler.Sockethandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
//        HTTPhandler HTTPhandler = new HTTPhandler();
//        HTTPhandler.launch();
//        Sockethandler sockethandler = new Sockethandler();
//        sockethandler.launch();
        GameManager game = new GameManager("DavidDavidDavid12345");
        game.createGame();
        System.out.println(game.id);
        game.startGame();
        game.printGame();
        game.makeMove(1);
        game.printGame();
    }
}
