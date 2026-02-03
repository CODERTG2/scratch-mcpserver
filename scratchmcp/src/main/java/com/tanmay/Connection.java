package com.tanmay;

public class Connection {
    // the connection to the server and clients.
    enum State {
        DISCONNECTED,
        CONNECTING,
        INITIALIZING,
        READY,
        SHUTTING_DOWN
    }

    private State state = State.DISCONNECTED;

    public Connection() {

    }
}
