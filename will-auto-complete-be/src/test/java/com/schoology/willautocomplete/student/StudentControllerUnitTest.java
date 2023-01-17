package com.schoology.willautocomplete.student;

import com.schoology.willautocomplete.controller.StudentController;
import com.schoology.willautocomplete.entity.Student;
import com.schoology.willautocomplete.service.StudentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentControllerUnitTest {

    @MockBean
    private StudentService studentService;
    @Autowired
    private StudentController studentController;

    @Test
    void shouldReturnEmptyWithoutQuery() {
        when(studentService.search("")).thenReturn(new ArrayList<>());

        List<Student> result = this.studentController.search("");
        Assertions.assertThat(result).hasSize(0);
    }

    @Test
    void shouldReturnMatchedUsers() {
        when(studentService.search("will")).thenReturn(Arrays.asList(new Student(0L, "William"), new Student(0L, "Wilson")));

        List<Student> result = this.studentController.search("will");
        Assertions.assertThat(result).hasSize(2);
    }
}
