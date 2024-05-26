package pl.marekksiazek.CableManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.marekksiazek.CableManagement.entity.ModelWithAllData;

import java.util.List;

public interface ModelWithAllDataRepository extends JpaRepository<ModelWithAllData, String> {

    @Query(value = "SELECT \n" +
            "md.*, " +
            "pd.total, " +
            "pd.bom " +
            "FROM model_database md " +
            "JOIN production_database pd " +
            "ON md.model_suffix  = pd.model_suffix " +
            "WHERE pd.total > 0 " +
            "AND pd.bom IN ('C', 'N') " +
            "AND md.status=1", nativeQuery = true)
    List<ModelWithAllData> findAllModels();
}
