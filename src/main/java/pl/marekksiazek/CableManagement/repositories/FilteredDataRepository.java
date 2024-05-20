package pl.marekksiazek.CableManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.marekksiazek.CableManagement.entity.FilteredData;

import java.util.List;

public interface FilteredDataRepository extends JpaRepository<FilteredData, String> {

    @Query(value = "SELECT\n" +
            "  md.*,\n" +
            "  pd.TOTAL,\n" +
            "  pd.BOM\n" +
            "FROM\n" +
            "  MODEL_DATABASE md\n" +
            "JOIN\n" +
            "  PRODUCTION_DATABASE pd\n" +
            "ON\n" +
            "  md.MODEL_SUFFIX = pd.MODEL_SUFFIX\n" +
            "WHERE\n" +
            "  pd.TOTAL > 0\n" +
            "  AND pd.BOM IN ('C', 'N')\n" +
            "  AND\n" +
            "  (\n" +
            "    md.C_BOM_MODEL_SUFFIX IS NULL\n" +
            "    OR md.C_BOM_MODEL_SUFFIX = ''\n" +
            "  )", nativeQuery = true)
    List<FilteredData> findFilteredData();
}
