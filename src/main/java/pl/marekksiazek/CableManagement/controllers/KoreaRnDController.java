package pl.marekksiazek.CableManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.marekksiazek.CableManagement.entity.KoreaRnD;
import pl.marekksiazek.CableManagement.entity.Model;
import pl.marekksiazek.CableManagement.repositories.KoreaRnDRepository;
import pl.marekksiazek.CableManagement.repositories.ModelRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KoreaRnDController {

    @Autowired
    private KoreaRnDRepository koreaRnDRepository;
    @Autowired
    private ModelRepository modelRepository;


    @GetMapping("/koreaRnD")
    public ResponseEntity<List<KoreaRnD>> getPolishRnDModels(){
        List<KoreaRnD> listOfPolishRnD = koreaRnDRepository.findAllRnDModels();
        return ResponseEntity.ok(listOfPolishRnD);
    }

    @PutMapping("koreaRnD/{modelSuffix}")
    @Transactional
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
