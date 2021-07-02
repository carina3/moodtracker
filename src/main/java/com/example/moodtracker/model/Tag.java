package com.example.moodtracker.model;

import javax.persistence.*;

@Entity
public class Tag {
    @Id
    @GeneratedValue
    private Long id;

    private String keyword;

    public Tag() {
    }

    public Tag(String tag) {
        this.keyword = tag;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String tag) {
        this.keyword = tag;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
