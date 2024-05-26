package pl.marekksiazek.CableManagement.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.marekksiazek.CableManagement.entity.FinalData;
import pl.marekksiazek.CableManagement.repositories.FinalDataRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FinalDataController {

    @Autowired
    FinalDataRepository finalDataRepository;

    @GetMapping("/finalData")
    public ResponseEntity<List<FinalData>> getAllFinalData(){
        List<FinalData> finalDataList = finalDataRepository.findAllFinalData();
        return ResponseEntity.ok(finalDataList);
    }
}
