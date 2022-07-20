package com.maslov.mongohomework.config.dbmigrations;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.maslov.mongohomework.domain.Author;
import com.maslov.mongohomework.domain.Book;
import com.maslov.mongohomework.domain.Comment;
import com.maslov.mongohomework.domain.Genre;
import com.maslov.mongohomework.domain.YearOfPublish;
import com.maslov.mongohomework.repository.BookRepo;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;

@ChangeLog(order = "001")
public class DatabaseChangelog {

    @ChangeSet(order = "000", id = "dropDb", author = "maslov", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "001", id = "createAuthorsCoolection", author = "maslov")
    public void createCollections(MongoDatabase db) {
        db.createCollection("authors");
        db.createCollection("books");
        db.createCollection("comments");
        db.createCollection("genres");
        db.createCollection("years");
    }

    @ChangeSet(order = "002", id = "insertBooks", author = "maslov")
    public void insertBooks(BookRepo repo) {
        Book book = new Book("java");
        book.setGenre(new Genre("study"));
        book.setYear(new YearOfPublish("2022"));
        book.setAuthors(new ArrayList<>());
        book.getAuthors().add(new Author("lafore"));
        book.setListOfComment(new ArrayList<>());
        book.getListOfComment().add(new Comment("first comment"));

        repo.save( book );
    }

//    @ChangeSet(order = "002", id = "insertBooks", author = "maslov")
//    public void insertBooks(MongoDatabase db) {
//        MongoCollection<Document> myCollection = db.getCollection("books");
//        List<Author> authorsList = Arrays.asList(new Author("lafore"));
//        // The Document class currently supports only List, not native Java array
//        // authorsList.add(new Author("lafore"));
//        List<Comment> commentsList = Arrays.asList(new Comment("first comment"));
////        commentsList.add(new Comment("first comment"));
//        var doc = new Document();
//                doc.put("name", "java");
//                doc.put("genre", new Genre("study"));
//                doc.put("year", "2022");
//                doc.put("authors", authorsList);
//                doc.put("listOfComment", commentsList);
//        myCollection.insertOne(doc);
//    }
}
