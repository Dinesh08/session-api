package com.ge.knowledge.session.domain;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ge.knowledge.session.converter.LocalDateTimeConverter;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tentative_dates", updatable = true)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime tentativeDates;

    @Column(name = "account")
    private String account;
    
    @Column(name = "topic_name")
    private String topicName;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "author")
    private String author;
    
    @Column(name = "reference_url")
    private String referenceUrl;
 
}
