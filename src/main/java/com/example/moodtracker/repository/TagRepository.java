package com.example.moodtracker.repository;

import com.example.moodtracker.model.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Set;

public interface TagRepository extends JpaRepository<Tag, Long> {

    public Tag findByKeywordIgnoreCase(String keyword);
}
