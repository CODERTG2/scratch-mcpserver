package com.tanmay;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        JSONRPC jsonrpc = new JSONRPC(reader);
        jsonrpc.parse();
    }
}