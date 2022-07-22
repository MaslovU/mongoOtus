package com.maslov.mongohomework.config.dbmigrations;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.maslov.mongohomework.domain.Author;
import com.maslov.mongohomework.domain.Book;
import com.maslov.mongohomework.domain.Comment;
import com.maslov.mongohomework.domain.Genre;
import com.maslov.mongohomework.domain.YearOfPublish;
import com.maslov.mongohomework.repository.AuthorRepo;
import com.maslov.mongohomework.repository.BookRepo;
import com.maslov.mongohomework.repository.CommentRepo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

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

    @ChangeSet(order = "002", id = "insertSome", author = "maslov")
    public void insertSome(MongoDatabase db) {
        MongoCollection<Document> myCollection = db.getCollection("authors");
        var doc = new Document();
        doc.put("name", "lafore");
        myCollection.insertOne(doc);
    }

    @ChangeSet(order = "003", id = "insertBooks", author = "maslov")
    public void insertBooks(BookRepo repo, CommentRepo commentRepo, AuthorRepo authorRepo) {

        Book book = new Book( "java");
        book.setGenre(new Genre("study"));
        book.setYear(new YearOfPublish("2022"));
        book.setAuthors(new ArrayList<>());
        Author lafore = authorRepo.save(new Author("lafore"));
        Author future = authorRepo.save(new Author("future"));
        book.getAuthors().add(lafore);
        book.getAuthors().add(future);
        book.setListOfComment(new ArrayList<>());
        Comment first = commentRepo.save(new Comment("first comment"));
        Comment second = commentRepo.save(new Comment("second comment"));
        book.getListOfComment().add(first);
        book.getListOfComment().add(second);

        repo.save( book );
    }
}
