package ng.storageapp.backend.service;

import ng.storageapp.backend.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageService {

    @Autowired
    StorageRepository storageRepository;

    //DTO's and such
}
