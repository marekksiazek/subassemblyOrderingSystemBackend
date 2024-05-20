package pl.marekksiazek.CableManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.marekksiazek.CableManagement.entity.Model;
import pl.marekksiazek.CableManagement.entity.ProdData;
import pl.marekksiazek.CableManagement.repositories.ProdDataRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProdDataController {

    @Autowired
    ProdDataRepository prodDataRepository;

    @GetMapping("/prodData")
    public ResponseEntity<List<ProdData>> getAllProdData(){
        List<ProdData> prodDatas = prodDataRepository.findAll();
        return ResponseEntity.ok(prodDatas);
    }

    @GetMapping("/prodData/{workorder}")
    public ResponseEntity<ProdData> getProdDataByWorkorder(@PathVariable String workorder){
        Optional<ProdData> oneProdData = prodDataRepository.findById(workorder);

        return oneProdData.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/prodData/suffix/{shortSuffix}")
    public ResponseEntity<List<ProdData>> getProdDataByShortSuffix(@PathVariable String shortSuffix){
        List<ProdData> prodDatasByShortSuffix = prodDataRepository.findProdDataByShortSuffix(shortSuffix);
        return ResponseEntity.ok(prodDatasByShortSuffix);
    }

    @GetMapping("/prodData/filtered")
    public ResponseEntity<List<ProdData>> getFilteredModel() {
        List<ProdData> filteredModel = prodDataRepository.findFilteredProdData();

        return ResponseEntity.ok(filteredModel);
    }


}
