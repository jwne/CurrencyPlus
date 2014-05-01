package com.devro.currency.utils;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * Programmed by: DevRo_ (Erik Rosemberg)
 * Creation Date: 03, 01, 2014
 * Programmed for the Currency+ project.
 */
public class DatabaseManager {
    private static MongoClient mongoClient;
    private static DB db;
    private static DBCollection players;

    public static void connect(String host, int port) {
        try {
            mongoClient = new MongoClient(host, port);
        } catch (Exception e) {
            System.out.println("Couldn't connect to database!.");
        }
        db = getMongoClient().getDB("Framework");
        players = getMongoDB().getCollection("Players");
    }

    public static void createNewData() {
        if (mongoClient != null) {
            mongoClient.close();
        }

        mongoClient = null;
        db = null;

        players = null;
    }


    public static MongoClient getMongoClient() {
        return (mongoClient);
    }

    public static DB getMongoDB() {
        return (db);
    }

    public static DBCollection getPlayers() {
        return (players);
    }

}
