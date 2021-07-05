package com.example.moodtracker.controller;

import com.example.moodtracker.assembler.MoodEntryModelAssembler;
import com.example.moodtracker.model.BaseMood;
import com.example.moodtracker.model.MoodEntry;
import com.example.moodtracker.service.MoodService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class MoodController implements MoodOperations {
    private final Logger logger = LoggerFactory.getLogger(MoodController.class);

    private final MoodService service;
    private final MoodEntryModelAssembler assembler;

    public MoodController(MoodService service, MoodEntryModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    //TODO: RESTful response for empty entries?
    @Override
    public CollectionModel<EntityModel<MoodEntry>> getAll() {
        List<EntityModel<MoodEntry>> entries =
                service.fetchAllEntries()
                .stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        CollectionModel model = CollectionModel.of(entries,
                linkTo(methodOn(MoodController.class).getAll()).withSelfRel());

        return model;
    }

    //TODO: RESTful response
    @Override
    public MoodEntry addEntry(MoodEntry newMoodEntry) {
        return service.addEntry(newMoodEntry);
    }

    @Override
    public EntityModel<MoodEntry> findById(Long id) {
        MoodEntry entry = service.findById(id);
        return assembler.toModel(entry);
    }

    //TODO: RESTful response
    @Override
    public MoodEntry updateEntry(Long id, MoodEntry newMoodEntry) {
        return service.updateEntry(id, newMoodEntry);
    }

    @Override
    public CollectionModel<EntityModel<MoodEntry>> findByMood(BaseMood moodToFind) {
        List<EntityModel<MoodEntry>> entries =
                service.findByMood(moodToFind)
                .stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        CollectionModel model = CollectionModel.of(entries,
                linkTo(methodOn(MoodController.class).getAll()).withSelfRel());

        return model;
    }

    @Override
    public CollectionModel<EntityModel<MoodEntry>> findByTagsIn(List<String> keywords) {
        List<EntityModel<MoodEntry>> entries =
                service.findByTagsIn(keywords)
                        .stream()
                        .map(assembler::toModel)
                        .collect(Collectors.toList());

        CollectionModel model = CollectionModel.of(entries,
                linkTo(methodOn(MoodController.class).getAll()).withSelfRel());

        return model;
    }
}
