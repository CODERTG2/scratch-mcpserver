package com.tanmay;

public class Handler {
    // converts between the JSON-RPC.
    public static Call convert_to_call(JSONRPC jsonrpc) {
        switch (jsonrpc.getType()) {
            case REQUEST:
                return new Request(jsonrpc.getId());
            case RESPONSE:
                return new Response(jsonrpc.getId());
            case NOTIFICATION:
                return new Notification(jsonrpc.getId());
            case ERROR:
                return new Error(jsonrpc.getId());
            default:
                return new Error(jsonrpc.getId());
        }
    }

    public static JSONRPC convert_to_jsonrpc(Call call) {
        // code to convert call object to jsonrpc
        return new JSONRPC();
    }

}
