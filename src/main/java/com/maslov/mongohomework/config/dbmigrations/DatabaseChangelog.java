package com.maslov.mongohomework.config.dbmigrations;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.maslov.mongohomework.domain.Genre;
import com.maslov.mongohomework.repository.GenreRepo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

@ChangeLog(order = "001")
public class DatabaseChangelog {

    @ChangeSet(order = "000", id = "dropDb", author = "maslov", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "001", id = "createAuthorsCoolection", author = "maslov")
    public void createAuthorsCollection(MongoDatabase db) {
        db.createCollection("authors");
        db.createCollection("books");
        db.createCollection("comments");
        db.createCollection("genres");
        db.createCollection("years");
    }

    @ChangeSet(order = "002", id = "insertAuthors", author = "maslov")
    public void insertLermontov(MongoDatabase db) {
        MongoCollection<Document> myCollection = db.getCollection("authors");
        var doc = new Document().append("name", "java");
        myCollection.insertOne(doc);
    }

    @ChangeSet(order = "003", id = "insertGenre", author = "maslov")
    public void insertPushkin(GenreRepo repository) {
        repository.save(new Genre("study"));
        repository.save(new Genre("chill"));
    }
}
