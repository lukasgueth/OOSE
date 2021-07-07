package game;

import kong.unirest.json.JSONObject;

/**
 * A custom unchecked Exception for reading the possible Errors coming from talking
 * to the node.js server
 */
public class FailedServerQuery extends RuntimeException{
    public FailedServerQuery(JSONObject json) {
        super(json.getString("message"));
    }
}
