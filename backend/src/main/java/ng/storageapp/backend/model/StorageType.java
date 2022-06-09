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
@Table(name = StorageType.TYPE_TABLE_NAME)
public class StorageType {
    public static final String TYPE_TABLE_NAME = "storage_type";
    public static final String TYPENAME = "type_name";
    @Id
    @SequenceGenerator(
            name = "type_seq",
            sequenceName = "type_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id")
    private Long id;
    private String type;

    @Column(name = TYPENAME)
    private String typeName;

    //export PK to storage
    @OneToMany(mappedBy = "id")
    private Set<Storage> storages;
}
