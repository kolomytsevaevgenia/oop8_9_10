package com.chein.task8.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "student")
@Accessors(chain = true)
public class StudentEntity {

    @Id
    @Column(nullable = false, unique = true, name = "student_id")
    private UUID student_id;

    @Column(nullable = false, name = "student_name")
    private String student_name;

    @Column(nullable = true, name = "major")
    private String major;
}