package com.example.cafe.entity;
import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
public class Users {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    private String userName;
    @NonNull
    private String password;

    private List<String> roles;

    @DBRef
    private List<JournalEntry> journalEntries = new ArrayList<>();
}
