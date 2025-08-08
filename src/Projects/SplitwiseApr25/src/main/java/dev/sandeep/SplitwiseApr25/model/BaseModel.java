package dev.sandeep.SplitwiseApr25.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Temporal(value = TemporalType.TIMESTAMP)
    @CreatedDate
    private LocalDateTime createdDate;
    @Temporal(value = TemporalType.TIMESTAMP)
    @LastModifiedDate
    private LocalDateTime updatedDate;
}
