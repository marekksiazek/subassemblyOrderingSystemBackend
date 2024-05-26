package pl.marekksiazek.CableManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.marekksiazek.CableManagement.entity.FilteredData;

import java.util.List;

public interface FilteredDataRepository extends JpaRepository<FilteredData, String> {

    @Query(value = "SELECT\n" +
            "  md.*,\n" +
            "  pd.total,\n" +
            "  pd.bom\n" +
            "FROM\n" +
            "  model_database md\n" +
            "JOIN\n" +
            "  production_database pd\n" +
            "ON\n" +
            "  md.model_suffix = pd.model_suffix\n" +
            "WHERE\n" +
            "  pd.total > 0\n" +
            "  AND pd.bom IN ('C', 'N')\n" +
            "  AND\n" +
            "  (\n" +
            "    md.c_bom_model_suffix IS NULL\n" +
            "    OR md.c_bom_model_suffix = ''\n" +
            "  )", nativeQuery = true)
    List<FilteredData> findFilteredData();
}
