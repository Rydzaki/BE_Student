package ait.cohort34.student.dao;

import ait.cohort34.student.model.Student;

import java.util.Collection;
import java.util.Optional;

public interface StudentRepository {
    Student save(Student student);
    Optional<Student> findByIdc(int id);
    Collection<Student> findAll();

}
