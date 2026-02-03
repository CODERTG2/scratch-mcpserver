package com.tanmay;

import java.util.HashMap;
import java.io.BufferedReader;
import org.json.JSONObject;

public class JSONRPC {
    private BufferedReader reader;
    private int id;
    private Constants.Type type;
    private String method;
    private Object[] params;
    private Object result;
    private HashMap<String, Object> error;
    private String notification;

    // json object
    public JSONRPC(BufferedReader reader) {
        this.reader = reader;
    }

    public JSONRPC() {
        this.reader = null;
    }

    public int getId() {
        return id;
    }

    public Constants.Type getType() {
        return type;
    }

    public String getMethod() {
        return method;
    }

    public Object[] getParams() {
        return params;
    }

    public Object getResult() {
        return result;
    }

    public HashMap<String, Object> getError() {
        return error;
    }

    public String getNotification() {
        return notification;
    }

    public void parse() {
        try {
            String line = reader.readLine();
            JSONObject json = new JSONObject(line);
            id = json.getInt("id");
            type = Constants.Type.valueOf(json.getString("type"));
            method = json.getString("method");
            params = json.getJSONArray("params").toArray();
            result = json.get("result");
            error = json.getJSONObject("error");
            notification = json.getString("notification");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
