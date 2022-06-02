package ng.storageapp.backend.service;

import ng.storageapp.backend.dto.StorageTypeDTO;
import ng.storageapp.backend.model.Storage;
import ng.storageapp.backend.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StorageService {

    @Autowired
    StorageRepository storageRepository;

    public List<StorageTypeDTO> getAllStoragesTypes(){
        return storageRepository.findAll()
                .stream()
                .map(this::convertEntToDTO)
                .collect(Collectors.toList());
    }

    public StorageTypeDTO convertEntToDTO(Storage storage){
        StorageTypeDTO storageTypeDTO = new StorageTypeDTO();
        storageTypeDTO.setStorageID(storage.getId());
        storageTypeDTO.setType(storage.getStorageType().getType());
        storageTypeDTO.setTypeName(storage.getStorageType().getTypeName());
        return storageTypeDTO;
    }
}
