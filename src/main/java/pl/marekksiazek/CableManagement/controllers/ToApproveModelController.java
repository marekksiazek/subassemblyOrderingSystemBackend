package pl.marekksiazek.CableManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.marekksiazek.CableManagement.entity.Model;
import pl.marekksiazek.CableManagement.entity.ToApproveModel;
import pl.marekksiazek.CableManagement.repositories.ModelRepository;
import pl.marekksiazek.CableManagement.repositories.ToApproveModelRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToApproveModelController {

    @Autowired
    ToApproveModelRepository toApproveModelRepository;
    @Autowired
    ModelRepository modelRepository;

    @GetMapping("/toApproveModel")
    public ResponseEntity<List<ToApproveModel>> getAllToApproveModels(){
        List<ToApproveModel> toApproveModelList = toApproveModelRepository.findAllToApproveModel();
        return ResponseEntity.ok(toApproveModelList);
    }

    @PutMapping("/toApproveModel/aprove/{modelSuffix}")
    @Transactional
    public ResponseEntity<Model> statusUpdateAprove(@PathVariable String modelSuffix, @RequestBody Model updatedModel){
        boolean oldModel = modelRepository.findModelByModelSuffix(modelSuffix)
                .map(model -> {
                    model.setStatus(1);
                    modelRepository.save(model);
                    return ResponseEntity.ok(model).equals(HttpStatus.CREATED);
                })
                .orElseGet(() -> {
                    modelRepository.save(updatedModel);
                    return ResponseEntity.ok(updatedModel).equals(HttpStatus.CREATED);
                });
        return ResponseEntity.ok().build();
    }

    @PutMapping("/toApproveModel/rejectToPolishRnD/{modelSuffix}")
    @Transactional
    public ResponseEntity<Model> StatusUpdateRejectToPolishRnD(@PathVariable String modelSuffix, @RequestBody Model updatedModel){
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

    @PutMapping("/toApproveModel/rejectToKoreaRnD/{modelSuffix}")
    @Transactional
    public ResponseEntity<Model> StatusUpdateRejectToKoreaRnD(@PathVariable String modelSuffix, @RequestBody Model updatedModel){
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
