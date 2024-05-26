package pl.marekksiazek.CableManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.marekksiazek.CableManagement.entity.PolishRnD;

import java.util.List;

public interface PolishRnDRepository extends JpaRepository <PolishRnD, String> {

    @Query(value = "SELECT \n" +
            "md.*,\n" +
            "pd.total,\n" +
            "pd.bom \n" +
            "FROM model_database md\n" +
            "JOIN production_database pd\n" +
            "ON md.model_suffix  = pd.model_suffix\n" +
            "WHERE pd.total > 0 " +
            "AND pd.bom IN ('C', 'N') AND status=2", nativeQuery = true)
    List<PolishRnD> findAllRnDModels();
}
