package pl.marekksiazek.CableManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.marekksiazek.CableManagement.entity.ModelWithAllData;
import pl.marekksiazek.CableManagement.repositories.ModelWithAllDataRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ModelWithAllDataController {

    @Autowired
    ModelWithAllDataRepository modelAllRepository;

    @GetMapping("/modelWithAllData")
    public ResponseEntity<List<ModelWithAllData>> findModelWithAllData(){
        List<ModelWithAllData> modelsWithAllData = modelAllRepository.findAllModels();

        return ResponseEntity.ok(modelsWithAllData);
    }
}
