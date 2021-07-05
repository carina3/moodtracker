package com.example.moodtracker.assembler;

import com.example.moodtracker.controller.mood.MoodController;
import com.example.moodtracker.model.mood.MoodEntry;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MoodEntryModelAssembler implements RepresentationModelAssembler<MoodEntry, EntityModel<MoodEntry>> {
    @Override
    public EntityModel<MoodEntry> toModel(MoodEntry entry) {
        return EntityModel.of(
                entry,
                linkTo(methodOn(MoodController.class).findById(entry.getId())).withSelfRel(),
                linkTo(methodOn(MoodController.class).getAll()).withRel("allEntries")
        );
    }

    @Override
    public CollectionModel<EntityModel<MoodEntry>> toCollectionModel(Iterable<? extends MoodEntry> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
