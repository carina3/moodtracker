package com.example.moodtracker.service;

import com.example.moodtracker.model.mood.MoodEntry;
import com.example.moodtracker.model.tag.Tag;
import com.example.moodtracker.repository.MoodEntryRepository;
import com.example.moodtracker.repository.TagRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;
@ExtendWith({MockitoExtension.class})
class MoodServiceTest {

    @Mock
    public TagRepository tagRepository;

    @Mock
    public MoodEntryRepository moodEntryRepository;

    public MoodService moodService;

    @BeforeEach
    public void setUp(){
        Mockito.reset(moodEntryRepository, tagRepository);

        moodService = new MoodService(moodEntryRepository, tagRepository);
    }

    @Test
    void testAddEntryWithNewTags(){
        var entry = new MoodEntry();
        var tag1 = new Tag("A");
        var tag2 = new Tag("B");
        entry.setTags(Set.of(tag1, tag2));

        var tag1Entity = new Tag("A");
        tag1Entity.setId(1L);
        var tag2Entity = new Tag("B");
        tag2Entity.setId(2L);

        var entryWithTagEntities = new MoodEntry();
        entryWithTagEntities.setTags(Set.of(tag1Entity, tag2Entity));
        entryWithTagEntities.setCreationTime(entry.getCreationTime());

        when(tagRepository.findByKeywordIgnoreCase(anyString()))
                .thenReturn(null);
        when(tagRepository.save(eq(tag1))).thenReturn(tag1Entity);
        when(tagRepository.save(eq(tag2))).thenReturn(tag2Entity);

        when(moodEntryRepository.save(eq(entry))).thenReturn(entry);

        var actual = moodService.addEntry(entry);

        assertEquals(entry, actual);

        verify(tagRepository)
                .save(eq(tag1));

        verify(tagRepository)
                .save(eq(tag2));

        verify(moodEntryRepository)
                .save(eq(entryWithTagEntities));
    }

    @Test
    void testAddEntryWithoutTags(){
        var entry = new MoodEntry();
        var expectedEntry = new MoodEntry();
        expectedEntry.setTags(Set.of());
        expectedEntry.setCreationTime(entry.getCreationTime());

        when(moodEntryRepository.save(eq(entry))).thenReturn(entry);

        var actual = moodService.addEntry(entry);

        assertEquals(entry, actual);

        verify(moodEntryRepository)
                .save(eq(expectedEntry));
    }
}