package com.schoology.willautocomplete.student;

import com.schoology.willautocomplete.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class StudentIntegrationTest {

    @Autowired
    private WebApplicationContext applicationContext;
    @Autowired
    private StudentRepository customerRepository;
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(applicationContext)
                .build();
    }

    @Test
    void shouldReturnEmptyWithoutQuery() throws Exception {
        this.mockMvc.perform(
                        get("/student/search").queryParam("q", ""))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}
