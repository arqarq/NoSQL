package pl.sda.nosql;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

class MongoDB {
    private final MongoClient mongoClient = new MongoClient("localhost", 27017);
    private MongoCollection<Document> collection;
    private MongoDatabase database;

    MongoDB(String database, String collection) {
        this.database = getDB(database);
        this.collection = getCollection(collection);
    }

    private MongoDatabase getDB(String databaseName) {
        try {
            database = mongoClient.getDatabase(databaseName);
        } catch (Exception e) {
            System.out.println("Nie ma takiej bazy");
        }
        return database;
    }

    private MongoCollection<Document> getCollection(String mongoCollection) {
        try {
            collection = database.getCollection(mongoCollection);
        } catch (Exception e) {
            System.out.println("Nie ma takiej kolekcji");
        }
        return collection;
    }

    void executeA() {

    }

    void executeC() {
        FindIterable<Document> documents = collection.find();
//        MongoCursor<Document> documentsIterator = documents.iterator();
        for (Document document : documents) {
            System.out.println(document);
        }
    }
}
