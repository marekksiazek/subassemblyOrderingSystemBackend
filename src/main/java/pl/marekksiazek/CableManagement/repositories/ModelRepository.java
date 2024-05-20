package pl.marekksiazek.CableManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.marekksiazek.CableManagement.entity.Model;

import java.util.List;
import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, String> {

    @Query(value = "SELECT * FROM model_database WHERE ? IN (part_1, part_2, part_3, part_4) AND status=1",
            nativeQuery = true)
    List<Model> findModelByPartNumber(String partId);

    @Query(value = "SELECT * FROM model_database WHERE model_suffix=?", nativeQuery = true)
    Optional<Model> findModelByModelSuffix(String modelSuffix);
}