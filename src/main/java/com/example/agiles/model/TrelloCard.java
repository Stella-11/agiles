package com.example.agiles.model;

import jakarta.persistence.*;

@Entity
@Table(name = "trello_card")
public class TrelloCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "column_id", nullable = false)
    private TrelloColumn column;

    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story;  // Optional, hence no nullable = false
}
