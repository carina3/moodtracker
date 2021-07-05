package com.example.moodtracker.controller.mood;

import com.example.moodtracker.assembler.MoodEntryModelAssembler;
import com.example.moodtracker.model.mood.BaseMood;
import com.example.moodtracker.model.mood.MoodEntry;
import com.example.moodtracker.service.MoodService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.core.EmbeddedWrapper;
import org.springframework.hateoas.server.core.EmbeddedWrappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
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
    public ResponseEntity<?> getAll() {
        List<EntityModel<MoodEntry>> entries =
                service.fetchAllEntries()
                .stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return generateResponseEntityWithSupportForEmptyEmbeddedArray(entries);
    }

    // Support for rendering empty embedded arrays
    // Source: https://stackoverflow.com/questions/30286795/how-to-force-spring-hateoas-resources-to-render-an-empty-embedded-array
    private ResponseEntity<?> generateResponseEntityWithSupportForEmptyEmbeddedArray(List<EntityModel<MoodEntry>> entries) {
        if(entries.isEmpty()) {
            EmbeddedWrappers wrappers = new EmbeddedWrappers(false);
            EmbeddedWrapper wrapper = wrappers.emptyCollectionOf(MoodEntry.class);
            CollectionModel<EmbeddedWrapper> resources = CollectionModel.of(Arrays.asList(wrapper),
                    linkTo(methodOn(MoodController.class).getAll()).withSelfRel()); //FIXME: self rel points to invalid resource?
            return ResponseEntity
                    .ok(resources);
        }

        CollectionModel<EntityModel<MoodEntry>> collectionModel = CollectionModel.of(entries,
                linkTo(methodOn(MoodController.class).getAll()).withSelfRel());

        return ResponseEntity
                .ok(collectionModel);
    }

    @Override
    public ResponseEntity<?> addEntry(MoodEntry newMoodEntry) {
        EntityModel<MoodEntry> model =
                assembler.toModel(service.addEntry(newMoodEntry));

        return ResponseEntity
                .created(model.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(model);
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        EntityModel<MoodEntry> model =
                assembler.toModel(service.findById(id));
        
        return ResponseEntity
                .ok(model);
    }

    @Override
    public ResponseEntity<?> updateEntry(Long id, MoodEntry updatedMoodEntry) {
        EntityModel<MoodEntry> model =
                assembler.toModel(service.updateEntry(id, updatedMoodEntry));

        return ResponseEntity
                .ok(model);
    }

    @Override
    public ResponseEntity<?> findByMood(BaseMood moodToFind) {
        List<EntityModel<MoodEntry>> entries =
                service.findByMood(moodToFind)
                .stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<MoodEntry>> collectionModel = CollectionModel.of(entries,
                linkTo(methodOn(MoodController.class).getAll()).withSelfRel());

        return ResponseEntity
                .ok(collectionModel);
    }

    @Override
    public ResponseEntity<?> findByTagsIn(List<String> keywords) {
        List<EntityModel<MoodEntry>> entries =
                service.findByTagsIn(keywords)
                        .stream()
                        .map(assembler::toModel)
                        .collect(Collectors.toList());

        return generateResponseEntityWithSupportForEmptyEmbeddedArray(entries); //TODO: find more suitable name
    }
}
