package com.dbproject.chicagoincidents.repository;

import com.dbproject.chicagoincidents.domain.Request;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long>{
    @Query("SELECT srn FROM Request WHERE id>2 and id<9")
    List<String> queryAnnotationTest1();

    @Query(value = "SELECT COUNT(id) AS res FROM request GROUP BY type, creation_date HAVING creation_date " +
            "BETWEEN cast(:dayfrom AS timestamp) AND cast(:dayto AS timestamp) ORDER BY res DESC", nativeQuery = true)
    List<Long> query1(@Param("dayfrom") String dayfrom, @Param("dayto") String dayto);

    @Query(value = "SELECT COUNT(id) AS res\n" +
            "FROM request\n" +
            "GROUP BY type, creation_date\n" +
            "HAVING creation_date BETWEEN cast(:dayfrom AS timestamp) AND " +
            "cast(:dayto AS timestamp) AND type = :type", nativeQuery = true)
    List<Long> query2(@Param("dayfrom") String dayfrom, @Param("dayto") String dayto, @Param("type") String type);

}
