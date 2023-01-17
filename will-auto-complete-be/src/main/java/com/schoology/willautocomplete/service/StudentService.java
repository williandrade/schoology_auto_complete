package com.schoology.willautocomplete.service;

import com.schoology.willautocomplete.entity.Student;
import com.schoology.willautocomplete.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public List<Student> search(String query) {
        if (query.isEmpty()) {
            return new ArrayList<>();
        }

        StringBuilder fullQuery = new StringBuilder();
        String[] words = query.split(" ");
        if (words.length == 0) {
            words[0] = query;
        }
        fullQuery.append("(");
        for (String word : words) {
            fullQuery.append("*").append(word).append("*").append(" ");
        }
        fullQuery.append(") (\"").append(query).append("\")");

        return studentRepository.search(fullQuery.toString());
    }
}
