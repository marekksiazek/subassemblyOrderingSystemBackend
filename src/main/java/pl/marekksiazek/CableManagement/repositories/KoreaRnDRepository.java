package pl.marekksiazek.CableManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.marekksiazek.CableManagement.entity.KoreaRnD;

import java.util.List;

public interface KoreaRnDRepository extends JpaRepository<KoreaRnD, String> {

    @Query(value = "SELECT \n" +
            "md.*,\n" +
            "pd.total,\n" +
            "pd.bom \n" +
            "FROM model_database md\n" +
            "JOIN production_database pd\n" +
            "ON md.model_suffix  = pd.model_suffix\n" +
            "WHERE pd.total > 0 " +
            "AND pd.bom IN ('C', 'N') AND status=3", nativeQuery = true)
    List<KoreaRnD> findAllRnDModels();
}
