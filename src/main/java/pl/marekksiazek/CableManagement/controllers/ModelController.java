package pl.marekksiazek.CableManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.marekksiazek.CableManagement.entity.Model;
import pl.marekksiazek.CableManagement.repositories.ModelRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ModelController {

    @Autowired
    ModelRepository modelRepository;


    @GetMapping("/models")
    public ResponseEntity<List<Model>> getAllModels(){
        List<Model> models = modelRepository.findAll();

        return ResponseEntity.ok(models);
    }

    @GetMapping("/models/{modelSuffix}")
    public ResponseEntity<Model> getModelById(@PathVariable String modelSuffix){
        Optional<Model> modelOptional = modelRepository.findModelByModelSuffix(modelSuffix);

        return modelOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/models/part/{partId}")
    public ResponseEntity <List<Model>> getModelByPartId(@PathVariable String partId){
        List<Model> modelsOptional = modelRepository.findModelByPartNumber(partId);

        return ResponseEntity.ok(modelsOptional);
    }

    @PostMapping("/createModels")
    @Transactional
    public ResponseEntity<Model> createNewModel(@RequestBody Model newModel) {
        Model modelToSave = modelRepository.save(newModel);

        return ResponseEntity.created(URI.create("/models/" + modelToSave.getModelSuffix())).build();
    }

    @PutMapping("/updateModel/{modelSuffix}")
    @Transactional
    public ResponseEntity<Model> updateModel(@RequestBody Model updateModel, @PathVariable String modelSuffix){
        boolean oldModel = modelRepository.findModelByModelSuffix(modelSuffix)
                .map(model -> {
                    model.setModelSuffix(updateModel.getModelSuffix());
                    model.setSuffix(updateModel.getSuffix());
                    model.setPart1(updateModel.getPart1());
                    model.setPart2(updateModel.getPart2());
                    model.setPart3(updateModel.getPart3());
                    model.setPart4(updateModel.getPart4());
                    model.setCBomModelSuffix(updateModel.getCBomModelSuffix());
                    model.setBomSuffix(updateModel.getBomSuffix());
                    model.setBomPart1(updateModel.getBomPart1());
                    model.setBomPart2(updateModel.getBomPart2());
                    model.setBomPart3(updateModel.getBomPart3());
                    model.setBomPart4(updateModel.getBomPart4());
                    modelRepository.save(model);
                    return ResponseEntity.ok(model).equals(HttpStatus.CREATED);
                })
                .orElseGet(() -> {
                    modelRepository.save(updateModel);
                    return ResponseEntity.ok(updateModel).equals(HttpStatus.CREATED);
                });

            return ResponseEntity.ok().build();
    }
}
