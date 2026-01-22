import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Server {
    public static void main(String[] args) {
        // System.out.println("Hello World");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        JSONRPC jsonrpc = new JSONRPC(reader);
        jsonrpc.parse();
    }
}
