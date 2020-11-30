package com.dbproject.chicagoincidents.repository;

import com.dbproject.chicagoincidents.domain.Request;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long>{
    @Query("SELECT srn FROM Request WHERE id>2 and id<9")
    List<String> queryAnnotationTest1();

}
