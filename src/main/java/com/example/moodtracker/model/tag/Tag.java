package com.example.moodtracker.model.tag;

import javax.persistence.*;

@Entity
public class Tag {
    @Id
    @GeneratedValue
    private Long id;

    private String keyword;

    public Tag() {
    }

    public Tag(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

    @PrePersist
    public void prePersistLowercase() {
        keyword = keyword.toLowerCase();
    }
}
