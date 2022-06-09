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
    //private final String ID = "id";
    public static final String STORAGE_TYPE = "storage_type_id";
    public static final String STORAGE_NEST = "storage_nest_id";
    public static final String USER_ID = "user_id";

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
    private Long id;
    private String name;
    private Integer code;

    //StorageType reference
    @ManyToOne
    @JoinColumn(name = STORAGE_TYPE, nullable = false)
    private StorageType storageType;

    //export primary key to storagenest
    @Nullable
    @OneToMany(mappedBy = "id")
    private Set<StorageNest> storage;

    //Foreign key from storageNest
    @ManyToOne
    @JoinColumn(name = STORAGE_NEST)
    private StorageNest storage_nest;

    //reference to item in storage
    @OneToMany(mappedBy = "id")
    private Set<StorageItem> item_storage;

    //Foreign key from user
    @ManyToOne
    @JoinColumn(name = USER_ID, nullable = false)
    private User user;
}
