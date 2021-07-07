package handler;

import game.FailedServerQuery;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Gruß
 * @version 1.0
 */
public class HTTPhandler {

    /**
     * Setting default URL and has been abused for testing  purposes
     */
    public void launch() {
        Unirest.config().defaultBaseUrl("https://fourwins.herokuapp.com");
//        int[][] field = getGame("SVKZP6GOKFw96GP5RHSV");
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 7; j++) {
//                System.out.print(field[i][j]);
//            }
//            System.out.println("");
//        }
//        System.out.println(createGame("David1"));
//        System.out.println(acceptGame(new BufferedReader(new InputStreamReader(System.in)).readLine(), "David2"));
//        System.out.println(startGame(new BufferedReader(new InputStreamReader(System.in)).readLine(), "David1"));
    }

    /**
     * Sends a Json with  the  {@code playerID} to the Server in order to create a new DB-entry
     *
     * @param playerID The ID of the player creating a new game.Game for someone to join
     * @return The gameID of the game created by {@code PlayerID}
     */
    public String createGame(String playerID) {
        JSONObject json = new JSONObject().put("playerID", playerID);//building json from params
        json = postJson(json, "/game/create"); //sending built json to server and receive answer to read in json-format
        return json.getJSONObject("data").getString("gameID");  //returning the gameID of the game created
    }

    /**
     * Sends a Json to the server to register an Opponent to a game.Game
     *
     * @param gameID   The ID of the game, that {@code  playerID} tries to join
     * @param playerID The ID of the game.Player, who is trying to join the game with {@code gameID}
     * @return The gameID of the game.Game joined by {@code playerID}
     */

    public String acceptGame(String gameID, String playerID) {
        JSONObject json = new JSONObject().put("gameID", gameID).put("playerID", playerID);//building json from params
        json = postJson(json, "/game/accept"); //sending built json to server and receive answer to read in json-format
        return json.getJSONObject("data").getString("gameID");
    }

    public String startGame(String gameID, String playerID) {
        JSONObject json = new JSONObject().put("gameID", gameID).put("playerID", playerID);//building json from params
        json = postJson(json, "/game/start"); //sending built json to server and receive answer to read in json-format
        return json.getJSONObject("data").getString("gameID");
    }

    public int[][] getGame(String gameID) {
        JSONObject json = Unirest.get("/game/")
                .queryString("gameID", gameID)
                .asJson()
                .getBody()
                .getObject();
        checkSuccess(json);
        json = json.getJSONObject("data").getJSONObject("game");
        int[][] field = new int[5][7];
        JSONArray jsonArray = (kong.unirest.json.JSONArray) json.get("field");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (!jsonArray.getJSONArray(j).isNull(i)) {
                    if ((int) jsonArray.getJSONArray(j).get(i) == 0)
                        field[i][j] = 1;
                    else
                        field[i][j] = 2;
                }
//                    field[i][j] = (int) jsonArray.getJSONArray(j).get(i);
            }
        }
        return field;
    }


    /**
     * Handles the act of sending a json to the server via POST
     *
     * @param json the JSONObject which is  being sent
     * @param url  the sub-url of the predefined default url, to send the json to
     * @return the JSONObject which is received from the server as an answer to the request
     */
    private JSONObject postJson(JSONObject json, String url) {
        json = Unirest.post(url)
                .header("Content-Type", "application/json")//informing server its sending a json
                .body(json)//various casting
                .asJson()
                .getBody()
                .getObject();
        checkSuccess(json);
        return json;
    }

    /**
     * checks a json for an success key to be false, if so it throws an {@code game.FailedServerQuery}-Exception
     *
     * @param json the JSONObject which is getting checked
     */
    @NotNull
    private void checkSuccess(JSONObject json) {
        if (json.getString("success").equals("false"))
            throw new FailedServerQuery(json);
        System.out.println("[HTTPhandler] " + json.getString("message"));
    }

}
