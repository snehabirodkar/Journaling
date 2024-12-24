package com.example.cafe.controller;

import com.example.cafe.entity.JournalEntry;
import com.example.cafe.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/journal")
public class JournalControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return true;
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId) {

        return journalEntryService.findById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId myId) {

        journalEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("id/{myId}")
    public JournalEntry updateJournalEntry(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryService.findById(myId).orElse(null);
        if(old != null){
            old.setTitle(newEntry.getTitle()!= null && !newEntry.getTitle().equals("")? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent()!= null && !newEntry.getTitle().equals("")? newEntry.getContent() : old.getContent());
        }
        journalEntryService.saveEntry(old);
        return old;

    }
}


