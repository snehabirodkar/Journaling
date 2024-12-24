package com.example.cafe.Repository;

import com.example.cafe.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository  extends MongoRepository<JournalEntry, ObjectId> {
}
