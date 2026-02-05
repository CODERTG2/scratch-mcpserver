package com.tanmay;

import java.util.HashMap;
import java.io.BufferedReader;
import org.json.JSONObject;

public class JSONRPC {
    private BufferedReader reader;
    private int id;
    private Constants.Type type;
    private String method;
    private Object[][] params;
    private Object result;
    private HashMap<Integer, String> error;
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

    public HashMap<Integer, String> getError() {
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
            // "params": "param1,datatype;param2,datatype;param3,datatype"
            String[] param_string = json.getString("params").split(";");
            params = new Object[param_string.length][2];
            for (int i = 0; i < param_string.length; i++) {
                String[] param = param_string[i].split(",");
                params[i][0] = param[0];
                params[i][1] = param[1];
            }
            result = json.get("result");
            // "error": "code: error_message"
            error.put(Integer.parseInt(json.getString("error").split(": ")[0]), json.getString("error").split(": ")[1]);
            notification = json.getString("notification");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send() {
        try {
            JSONObject json = new JSONObject();
            json.put("id", id);
            json.put("type", type.toString());
            json.put("method", method);
            // "params": "param1,datatype;param2,datatype;param3,datatype"
            StringBuilder param_string = new StringBuilder();
            for (int i = 0; i < params.length; i++) {
                param_string.append(params[i][0]).append(",").append(params[i][1]).append(";");
            }
            json.put("params", param_string.toString());
            json.put("result", result);
            json.put("error", error.get(id) + ": " + error.get(id));
            json.put("notification", notification);
            System.out.println(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
