package com.chein.task8;

import com.chein.task8.entity.StudentEntity;
import com.chein.task8.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final StudentService studentService;

    @Override
    public void run(String[] args) {
        StudentEntity newStudent = studentService.addNewStudent("Иван Иванов", "Математика");
        System.out.println("Добавлен новый студент с ID: " + newStudent.getStudent_id());

        studentService.updateStudent(UUID.fromString("8eaaa877-5af8-428e-9f2c-423cb3498792"), "Петр Петров", "Физика");
        System.out.println("Обновили информацию о студенте");

        studentService.delStudentById(UUID.fromString("350f8402-ce8c-486f-a06b-74e029c19036"));
        System.out.println("Удалили студента");
    }
}