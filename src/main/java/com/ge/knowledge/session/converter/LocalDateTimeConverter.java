package com.ge.knowledge.session.converter;

import javax.persistence.AttributeConverter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
        if(attribute != null){
            return Timestamp.valueOf(attribute);
        }else{
            return null;
        }
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
        if(dbData != null){
        return dbData.toLocalDateTime();
        }else{
            return null;
        }
    }
}