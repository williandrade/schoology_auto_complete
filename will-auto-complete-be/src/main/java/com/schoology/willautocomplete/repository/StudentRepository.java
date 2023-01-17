package com.schoology.willautocomplete.repository;


import com.schoology.willautocomplete.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = " SELECT" +
            " main_tb.*" +
            " FROM" +
            " (" +
            "     SELECT  " +
            "        MATCH (s.full_name) AGAINST (:query IN BOOLEAN MODE) as points_of_relevancy,  " +
            "        s.*  " +
            "     FROM  " +
            "        student s  " +
            "     WHERE  " +
            "        MATCH (s.full_name) AGAINST (:query IN BOOLEAN MODE) > 0  " +
            " ) main_tb" +
            " order by main_tb.points_of_relevancy DESC", nativeQuery = true)
    List<Student> search(@Param("query") String query);
}
