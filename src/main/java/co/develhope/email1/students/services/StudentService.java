package co.develhope.email1.students.services;

import org.springframework.stereotype.Service;
import co.develhope.email1.students.entities.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    static List<Student> students = Arrays.asList(
            new Student("1", "John", "Walker", "john@walker.com"),
            new Student("2", "Stella", "Romeo", "stellaromeo21@gmail.com"),
            new Student("3", "Samuel", "Dungeon", "samuel@dangeon.com"),
            new Student("4", "Ursula", "Von Der Leyen", "ursula@boss.eu")
            );

    public Student getStudentById(String studentId) throws NullPointerException{
        Optional<Student> studentFromList = students.stream().filter(student -> student.getId().equals(studentId)).findAny();
        if (students.isEmpty()){
            throw new NullPointerException("Cannot find student by id " + studentId);
        }else{
            return studentFromList.get();
        }
    }
}
