package com.chein.task8.service;

import com.chein.task8.entity.StudentEntity;
import com.chein.task8.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional
    public StudentEntity updateStudent(UUID student_id, String student_name, String major) {
        Optional<StudentEntity> studentOpt = studentRepository.findById(student_id);

        StudentEntity student = studentOpt.orElse(null);
        if (student != null) {
            student.setStudent_name(student_name);
            student.setMajor(major);
        }

        return studentRepository.save(student);
    }

    @Transactional
    public StudentEntity addNewStudent(String student_name, String major) {
        StudentEntity student = new StudentEntity();
        student.setStudent_id(UUID.randomUUID());
        student.setStudent_name(student_name);
        student.setMajor(major);

        return studentRepository.save(student);
    }

    @Transactional
    public void delStudentById(UUID student_id) {
        studentRepository.deleteById(student_id);
    }
}
