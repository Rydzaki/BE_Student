package ait.cohort34.student.dao;

import ait.cohort34.student.model.Student;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class StudentRepositoryImpl implements StudentRepository {

    private Map<Integer, Student> students = new HashMap<>();

    @Override
    public Student save(Student student) {
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public Optional<Student> findByIdc(int id) {
        return Optional.ofNullable(students.get(id));
    }

    @Override
    public Collection<Student> findAll() {
        return students.values();
    }
}
