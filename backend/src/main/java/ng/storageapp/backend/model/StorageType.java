package ng.storageapp.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "storage_type")

public class StorageType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;

    @Column(name = "type_name")
    private String typeName;

    //storage reference
    @OneToMany(mappedBy = "id")
    private Set<Storage> storages;
}
