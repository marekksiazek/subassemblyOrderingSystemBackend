package pl.marekksiazek.CableManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.marekksiazek.CableManagement.entity.ProdData;

import java.util.List;

public interface ProdDataRepository extends JpaRepository<ProdData, String> {

    @Query(value = "SELECT * FROM production_database WHERE suffix_short=?",
            nativeQuery = true)
    List<ProdData> findProdDataByShortSuffix(String shortSuffix);

    @Query(value = "SELECT * FROM production_database\n" +
            "WHERE total > 0\n" +
            "AND bom IN ('C', 'N')", nativeQuery = true)
    List<ProdData> findFilteredProdData();


}
