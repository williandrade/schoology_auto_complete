package com.schoology.willautocomplete.student;

import com.schoology.willautocomplete.entity.Student;
import com.schoology.willautocomplete.repository.StudentRepository;
import com.schoology.willautocomplete.service.StudentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentServiceUnitTest {

    @MockBean
    private StudentRepository studentRepository;
    private StudentService studentService;

    @BeforeEach
    void setup() {
        studentService = new StudentService(studentRepository);
    }

    @Test
    void shouldReturnEmptyWithoutQuery() {
        when(studentRepository.search("")).thenReturn(new ArrayList<>());

        List<Student> result = this.studentService.search("");
        Assertions.assertThat(result).hasSize(0);
    }

    @Test
    void shouldReturnMatchedUsers() {
        when(studentRepository.search("(*will* ) (\"will\")")).thenReturn(Arrays.asList(new Student(0L, "William"), new Student(0L, "Wilson")));

        List<Student> result = this.studentService.search("will");
        Assertions.assertThat(result).hasSize(2);
    }

}
