package pl.marekksiazek.CableManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.marekksiazek.CableManagement.entity.PolishRnD;

import java.util.List;

public interface PolishRnDRepository extends JpaRepository <PolishRnD, String> {

    @Query(value = "SELECT \n" +
            "md.*,\n" +
            "pd.TOTAL,\n" +
            "pd.BOM \n" +
            "FROM MODEL_DATABASE md\n" +
            "JOIN PRODUCTION_DATABASE pd\n" +
            "ON md.MODEL_SUFFIX  = pd.MODEL_SUFFIX\n" +
            "WHERE pd.TOTAL > 0" +
            "AND pd.BOM IN ('C', 'N') AND status=2", nativeQuery = true)
    List<PolishRnD> findAllRnDModels();
}
