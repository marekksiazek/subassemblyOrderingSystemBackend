package pl.marekksiazek.CableManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.marekksiazek.CableManagement.entity.Model;
import pl.marekksiazek.CableManagement.entity.PolishRnD;
import pl.marekksiazek.CableManagement.repositories.ModelRepository;
import pl.marekksiazek.CableManagement.repositories.PolishRnDRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PolishRnDController {

    @Autowired
    private PolishRnDRepository polishRnDRepository;

    @Autowired
    private ModelRepository modelRepository;

    @GetMapping("/polishRnD")
    public ResponseEntity<List<PolishRnD>> getPolishRnDModels(){
        List<PolishRnD> listOfPolishRnD = polishRnDRepository.findAllRnDModels();
        return ResponseEntity.ok(listOfPolishRnD);
    }

    @PutMapping("polishRnD/{modelSuffix}")
    public ResponseEntity<Model> statusUpdate(@PathVariable String modelSuffix, @RequestBody Model updatedModel){
        boolean oldModel = modelRepository.findModelByModelSuffix(modelSuffix)
                .map(model -> {
                    model.setStatus(4);
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
