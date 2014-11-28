package com.nodexy.genome.session;

import java.util.HashMap;
import java.util.Map;

public class SessionTokenStore {

    // FIXME  OOM here maybe !!! 
    private final static Map<String, SessionToken> store = new HashMap<String, SessionToken>();

    public static void add(String sessionId, SessionToken st) {
        store.put(sessionId, st);
    }

    // XXX  when to remove  ???????? 
    public static void remove(String sessionId) {
        store.remove(sessionId);
    }
    
    public static SessionToken get(String sessionId) {
        return store.get(sessionId);
    }
}
