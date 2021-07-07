package handler;

import com.google.gson.JsonObject;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import kong.unirest.json.JSONObject;
import org.json.JSONException;

import java.net.URI;

public class Sockethandler {
    private Socket socket;

    public void launch() {
        this.socket = IO.socket(URI.create("ws://fourwins.herokuapp.com"));
        this.socket.connect();
        gameVerification("2c9fIZk6NsVubyU4GGcU","DavidDavidDavid12345");
    }

    public void gameVerification(String gameID, String playerID) {
        JSONObject json =new JSONObject().put("gameID",gameID).put("playerID",playerID);
        this.socket.emit("gameVerification", json);
    }

    public void gameEvent(JSONObject json){
        socket.emit("gameEvent",json);
        socket.once("gameEvent", new Emitter.Listener() {
            @Override
            public void call(Object... objects) {
                System.out.println("test");
            }
        });
    }


}