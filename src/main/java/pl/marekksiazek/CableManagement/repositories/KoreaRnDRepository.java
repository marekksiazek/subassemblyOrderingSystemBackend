package pl.marekksiazek.CableManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.marekksiazek.CableManagement.entity.KoreaRnD;

import java.util.List;

public interface KoreaRnDRepository extends JpaRepository<KoreaRnD, String> {

    @Query(value = "SELECT \n" +
            "md.*,\n" +
            "pd.TOTAL,\n" +
            "pd.BOM \n" +
            "FROM MODEL_DATABASE md\n" +
            "JOIN PRODUCTION_DATABASE pd\n" +
            "ON md.MODEL_SUFFIX  = pd.MODEL_SUFFIX\n" +
            "WHERE pd.TOTAL > 0" +
            "AND pd.BOM IN ('C', 'N') AND status=3", nativeQuery = true)
    List<KoreaRnD> findAllRnDModels();
}
