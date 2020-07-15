package com.ge.knowledge.session.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import lombok.Data;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ge.knowledge.session.converter.LocalDateTimeConverter;

@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class Auditable implements Serializable {

    @JsonIgnore
    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createdBy;
    
    @JsonIgnore
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime createdDate;
    
    @JsonIgnore
    @LastModifiedBy
    @Column(name = "updated_by", updatable = true)
    private String updatedBy;
   
    @JsonIgnore
    @LastModifiedDate
    @Column(name = "updated_date", updatable = true)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime updatedDate;
}
