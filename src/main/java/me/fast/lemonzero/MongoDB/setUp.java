package me.fast.lemonzero.MongoDB;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Collections;

public class setUp {

    private static MongoClient mongoClient;
    private static MongoDatabase mongoDatabase;
    private static MongoCollection<Document> serverCollection;

    public static void MongoConnect() {
        MongoCredential mongoCredential = MongoCredential.createCredential("umuppodwa82tkmjd1voh", "bny5breooynsrpx", "ZrcnHxcFI3Tsw5X6c9ro".toCharArray());
        mongoClient = new MongoClient(new ServerAddress("rs0/n1-c2-mongodb-clevercloud-customers.services.clever-cloud.com:27017,n2-c2-mongodb-clevercloud-customers.services.clever-cloud.com:27017"), Collections.singletonList(mongoCredential));
        mongoDatabase = mongoClient.getDatabase("bny5breooynsrpx");
        serverCollection = mongoDatabase.getCollection("Server");
        System.out.println("Connected to MongoDB");



    }


}
