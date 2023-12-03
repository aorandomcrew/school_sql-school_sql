package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.hogwarts.school.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByAge(Integer age);

    List<Student> findAllByAgeBetween(int min, int max);

    Optional<Student> findAllByFaculty_Id(Long id);

    @Query(value = "SELECT count(*) FROM student", nativeQuery = true)
    long count();

    @Query(value = "SELECT ROUND(avg(age), 1) FROM student", nativeQuery = true)
    double average();

    @Query(value = "SELECT * FROM student ORDER by id DESC limit :quantity", nativeQuery = true)
    List<Student> findLastFiveStudents(@Param("quantity") int n);
}
