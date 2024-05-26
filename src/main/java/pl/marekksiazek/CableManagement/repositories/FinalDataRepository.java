package pl.marekksiazek.CableManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.marekksiazek.CableManagement.entity.FinalData;

import java.util.List;

public interface FinalDataRepository extends JpaRepository<FinalData, String> {

    @Query(value = "SELECT\n" +
            "p.model_suffix,\n" +
            "m.part_1,\n" +
            "m.part_2,\n" +
            "m.part_3,\n" +
            "m.part_4,\n" +
            "SUM(p.week_1) AS week_1,\n" +
            "SUM(p.week_2) AS week_2,\n" +
            "SUM(p.week_3) AS week_3,\n" +
            "SUM(p.week_4) AS week_4 ,\n" +
            "SUM(p.week_5) AS week_5 ,\n" +
            "SUM(p.week_6) AS week_6 ,\n" +
            "SUM(p.week_7) AS week_7 ,\n" +
            "SUM(p.week_8) AS week_8 ,\n" +
            "SUM(p.week_9) AS week_9 ,\n" +
            "SUM(p.week_10) AS week_10 ,\n" +
            "SUM(p.week_11) AS week_11 ,\n" +
            "SUM(p.week_12) AS week_12 ,\n" +
            "SUM(p.week_13) AS week_13 ,\n" +
            "SUM(p.week_14) AS week_14 ,\n" +
            "SUM(p.week_15) AS week_15 ,\n" +
            "SUM(p.week_16) AS week_16,\n" +
            "SUM(p.total) AS total\n" +
            "FROM production_database AS p\n" +
            "JOIN model_database AS m\n" +
            "ON p.model_suffix = m.model_suffix\n" +
            "WHERE p.total > 0\n" +
            "AND p.bom IN ('C', 'N')\n" +
            "AND m.`status`=5\n" +
            "GROUP BY p.model_suffix, m.part_1, m.part_2, m.part_3, m.part_4", nativeQuery = true)
    List<FinalData> findAllFinalData();
}
