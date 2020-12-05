package com.dbproject.chicagoincidents.repository;

import com.dbproject.chicagoincidents.domain.Request;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long>{
    @Query("SELECT srn FROM Request WHERE id>2 and id<9")
    List<String> queryAnnotationTest1();

    @Query(value ="SELECT nextval('request_id_seq')", nativeQuery = true)
    Long getNextSeriesId();

    @Query(value ="SELECT nextval('has_quantitative_quantitative_id_seq')", nativeQuery = true)
    Long getNextSeriesQuantitativeId();

    @Query(value = "SELECT concat(tmp.type, ': ', tmp.res)\n" +
            "FROM (SELECT type, COUNT(id) AS res\n" +
            "FROM request\n" +
            "GROUP BY type, creation_date \n" +
            "HAVING creation_date BETWEEN cast(:dayfrom AS timestamp) AND cast(:dayto AS timestamp)\n" +
            "ORDER BY res DESC) tmp", nativeQuery = true)
    List<String> query1(@Param("dayfrom") String dayfrom, @Param("dayto") String dayto);

    @Query(value = "SELECT concat(creation_date, ': ', res) FROM (SELECT creation_date, COUNT(id) AS res\n" +
            "FROM request\n" +
            "GROUP BY type, creation_date\n" +
            "HAVING creation_date BETWEEN cast(:dayfrom AS timestamp) AND " +
            "cast(:dayto AS timestamp) AND type = :type) tmp", nativeQuery = true)
    List<String> query2(@Param("dayfrom") String dayfrom, @Param("dayto") String dayto, @Param("type") String type);

    @Query(value = "SELECT concat(tmp.zip_codes, ': ',MAX(tmp.res))\n" +
            "FROM \n" +
            "(\n" +
            "SELECT  zip_codes, type, COUNT(id) AS res\n" +
            "FROM request\n" +
            "WHERE creation_date = cast(:day AS timestamp)" +
            "GROUP BY type, zip_codes) tmp GROUP BY tmp.zip_codes", nativeQuery = true)
    List<String> query3(@Param("day") String day);

    @Query(value = "SELECT concat(type,': ',date_part('day', AVG(AGE(completion_date,creation_date))), ' days')  \n \n" +
            "FROM request\n" +
            "WHERE completion_date IS NOT null AND completion_date BETWEEN cast(:dayfrom AS timestamp) AND cast(:dayto AS timestamp)" +
            "AND creation_date BETWEEN cast(:dayfrom AS timestamp) AND cast(:dayto AS timestamp)" +
            "GROUP BY type", nativeQuery = true)
    List<String> query4(@Param("dayfrom") String dayfrom, @Param("dayto") String dayto);

    @Query(value = "SELECT concat(temp.mxtype, ': ', temp.mx) FROM (SELECT  occ.type as mxtype, MAX(occ.res) mx,\n" +
            "ROW_NUMBER () OVER (ORDER BY  MAX(occ.res) DESC) AS row_num\n" +
            "FROM (Select type, count(location.id) as res\n" +
            "\t\tfrom request, location\n" +
            "\t   where location.x_coordinate BETWEEN :xlow AND :xhigh AND location.y_coordinate BETWEEN :ylow AND :yhigh AND creation_date = cast(:day AS timestamp)\n" +
            "\t   group by request.type) occ\n" +
            "group by occ.type) temp\n" +
            "WHERE temp.row_num <= 1\n", nativeQuery = true)
    List<String> query5(@Param("day") String day, @Param("xlow") Double xlow, @Param("ylow") Double ylow, @Param("xhigh") Double xhigh, @Param("yhigh") Double yhigh);

    @Query(value = "SELECT temp.ssa_value FROM (SELECT  ssa_value,\n" +
            "ROW_NUMBER () OVER (ORDER BY COUNT(has_ssa.id) DESC) AS row_num\n" +
            "FROM has_ssa, request \n" +
            "\t\t\t   where ssa_value is not null AND \n" +
            "\t\t\t   has_ssa.id = request.id AND \n" +
            "\t\t\t   request.creation_date BETWEEN cast(:dayfrom AS timestamp) AND cast(:dayto AS timestamp)\n" +
            "\t\t\t   GROUP BY ssa_value) temp\n" +
            "WHERE temp.row_num <= 5", nativeQuery = true)
    List<Integer> query6(@Param("dayfrom") String dayfrom, @Param("dayto") String dayto);

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
