package com.ge.knowledge.session.model;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class SessionModel {

    private Long id;

    private LocalDateTime tentativeDates;
   
    private String account;
    
    private String topicName;
    
    private String status;
    
    private String author;
    
    private String referenceUrl;
    
}
