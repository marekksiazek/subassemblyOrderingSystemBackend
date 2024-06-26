package pl.marekksiazek.CableManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.marekksiazek.CableManagement.entity.Model;
import pl.marekksiazek.CableManagement.entity.ModelWithAllData;
import pl.marekksiazek.CableManagement.repositories.ModelRepository;
import pl.marekksiazek.CableManagement.repositories.ModelWithAllDataRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ModelWithAllDataController {

    @Autowired
    ModelWithAllDataRepository modelAllRepository;
    @Autowired
    ModelRepository modelRepository;

    @GetMapping("/modelWithAllData")
    public ResponseEntity<List<ModelWithAllData>> findModelWithAllData(){
        List<ModelWithAllData> modelsWithAllData = modelAllRepository.findAllModels();

        return ResponseEntity.ok(modelsWithAllData);
    }

    @PutMapping("/modelWithAllData/toPolishRnd/{modelSuffix}")
    @Transactional
    public ResponseEntity<Model> sendToPolishRnD(@PathVariable String modelSuffix, @RequestBody Model updatedModel){
        boolean oldModel = modelRepository.findModelByModelSuffix(modelSuffix)
                .map(model -> {
                    model.setStatus(2);
                    modelRepository.save(model);
                    return ResponseEntity.ok(model).equals(HttpStatus.CREATED);
                })
                .orElseGet(() -> {
                    modelRepository.save(updatedModel);
                    return ResponseEntity.ok(updatedModel).equals(HttpStatus.CREATED);
                });
        return ResponseEntity.ok().build();
    }

    @PutMapping("/modelWithAllData/toKoreaRnd/{modelSuffix}")
    @Transactional
    public ResponseEntity<Model> sendToKoreaRnD(@PathVariable String modelSuffix, @RequestBody Model updatedModel){
        boolean oldModel = modelRepository.findModelByModelSuffix(modelSuffix)
                .map(model -> {
                    model.setStatus(3);
                    modelRepository.save(model);
                    return ResponseEntity.ok(model).equals(HttpStatus.CREATED);
                })
                .orElseGet(() -> {
                    modelRepository.save(updatedModel);
                    return ResponseEntity.ok(updatedModel).equals(HttpStatus.CREATED);
                });
        return ResponseEntity.ok().build();
    }

}
