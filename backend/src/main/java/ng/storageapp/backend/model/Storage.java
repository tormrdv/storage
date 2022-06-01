package ng.storageapp.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Storage {

    @Id
    @SequenceGenerator(
            name = "storage_sequence",
            sequenceName = "storage_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "storage_sequence"
    )
    @Column(name = "id")
    private long id;
    private String name;

    //StorageType reference
    @ManyToOne
    @JoinColumn(name = "storage_type_id", nullable = false)
    private StorageType storageType;

    //Item reference
    @OneToMany(mappedBy = "id")
    private Set<Item> items;

    //self reference
    @Nullable
    @OneToMany(mappedBy = "id")
    private Set<Storage> storage;
    @ManyToOne
    @JoinColumn(name = "storage_storage_id")
    private Storage storage_storage;

    private int code;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private User user;
}
