public class Handler {
    enum Type {
        REQUEST,
        RESPONSE,
        NOTIFICATION,
        ERROR
    }

    // converts between the JSON-RPC.
    public static Call convert_to_call(JSONRPC jsonrpc) {
        // code to convert jsonrpc into a call object
        return;
    }

    public static JSONRPC convert_to_jsonrpc(Call call) {
        // code to convert call object to jsonrpc
        return new JSONRPC();
    }

}
