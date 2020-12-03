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

    @Query(value ="SELECT nextval('request_id_seq')", nativeQuery = true)
    Long getNextSeriesId();

    @Query(value = "SELECT COUNT(id) AS res FROM request GROUP BY type, creation_date HAVING creation_date " +
            "BETWEEN cast(:dayfrom AS timestamp) AND cast(:dayto AS timestamp) ORDER BY res DESC", nativeQuery = true)
    List<Long> query1(@Param("dayfrom") String dayfrom, @Param("dayto") String dayto);

    @Query(value = "SELECT COUNT(id) AS res\n" +
            "FROM request\n" +
            "GROUP BY type, creation_date\n" +
            "HAVING creation_date BETWEEN cast(:dayfrom AS timestamp) AND " +
            "cast(:dayto AS timestamp) AND type = :type", nativeQuery = true)
    List<Long> query2(@Param("dayfrom") String dayfrom, @Param("dayto") String dayto, @Param("type") String type);

    @Query(value = "SELECT license_plate \n" +
            "FROM vehicle\n" +
            "WHERE license_plate IS NOT null\n" +
            "GROUP BY license_plate \n" +
            "HAVING COUNT(id) > 1\n", nativeQuery = true)
    List<String> query7();

    @Query(value = "SELECT color FROM (SELECT color, \n" +
            "RANK () OVER (ORDER BY COUNT(id) DESC) AS color_rank\n" +
            "FROM vehicle GROUP BY color) temp\n" +
            "WHERE temp.color_rank = 2", nativeQuery = true)
    String query8();

    @Query(value = "SELECT request.id\n" +
            "FROM request, has_quantitative\n" +
            "WHERE request.id = has_quantitative.id AND has_quantitative.quantity_type = 'Number of Premises Baited' AND has_quantitative.quantity < :num", nativeQuery = true)
    List<Long> query9(@Param("num") Integer num);

    @Query(value = "SELECT request.id\n" +
            "FROM request, has_quantitative\n" +
            "WHERE request.id = has_quantitative.id AND has_quantitative.quantity_type = 'Number of Premises with Garbage' AND has_quantitative.quantity < :num", nativeQuery = true)
    List<Long> query10(@Param("num") Integer num);

    @Query(value = "SELECT request.id\n" +
            "FROM request, has_quantitative\n" +
            "WHERE request.id = has_quantitative.id AND has_quantitative.quantity_type = 'Number of Premises with Rats' AND has_quantitative.quantity < :num", nativeQuery = true)
    List<Long> query11(@Param("num") Integer num);

    @Query(value = "SELECT DISTINCT police_distinct \n" +
            "FROM request\n" +
            "WHERE police_distinct IS NOT null AND \n" +
            "\trequest.completion_date IS NOT null AND \n" +
            "\trequest.completion_date IN \n" +
            "\t(SELECT completion_date FROM request, has_quantitative WHERE request.id = has_quantitative.id AND \n" +
            "\t has_quantitative.quantity_type = 'Number of Premises Baited' AND has_quantitative.quantity > 1 ) AND \n" +
            "\t request.completion_date IN \n" +
            "\t(SELECT completion_date FROM request, has_quantitative WHERE request.id = has_quantitative.id  AND \n" +
            "\thas_quantitative.quantity_type = 'Potholes filled on block' AND \n" +
            "\thas_quantitative.quantity > 1)", nativeQuery = true)
    List<Integer> query12();
}
