import java.util.HashMap;
import java.io.BufferedReader;

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
        String line;
        while ((line = reader.readLine()) != null) {

        }
    }
}
