package pl.marekksiazek.CableManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.marekksiazek.CableManagement.entity.FilteredData;
import pl.marekksiazek.CableManagement.repositories.FilteredDataRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FilteredDataController {

    @Autowired
    FilteredDataRepository filteredDataRepository;

    @GetMapping("/filteredData")
    public ResponseEntity<List<FilteredData>> getFilteredData(){
        List<FilteredData> filteredDatas = filteredDataRepository.findFilteredData();

        return ResponseEntity.ok(filteredDatas);
    }
}
