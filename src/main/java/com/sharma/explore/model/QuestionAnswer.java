package com.sharma.explore.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

public class QuestionAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bookId;
    private Long userId;
    private String comment;
    private Date createdAt;

    public QuestionAnswer(Long id, Long bookId, Long userId, String comment, Date createdAt) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.comment = comment;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "QuestionAnswer{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", comment='" + comment + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
