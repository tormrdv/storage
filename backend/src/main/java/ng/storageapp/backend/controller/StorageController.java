package ng.storageapp.backend.controller;

import lombok.RequiredArgsConstructor;
import ng.storageapp.backend.dto.StorageTypeDTO;
import ng.storageapp.backend.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/storage")
public class StorageController {

    private final StorageService storageService;

    @GetMapping("all")
    public List<StorageTypeDTO> getAllStoragesTypes() { return storageService.getAllStoragesTypes(); }


}
