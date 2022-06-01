package ng.storageapp.backend.repository;

import ng.storageapp.backend.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<Storage, Long> {
}
