package ng.storageapp.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = StorageNest.NEST_TABLE_NAME)
public class StorageNest {
    public static final String NEST_TABLE_NAME = "storage_nest";
    public static final String STORAGE = "storage_id";

    @Id
    @SequenceGenerator(
            name = "storage_nest_sequence",
            sequenceName = "storage_nest_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "storage_nest_sequence"
    )
    @Column(name = "id")
    private Long id;

    //FK from Storage
    @ManyToOne
    @JoinColumn(name = STORAGE)
    private Storage storage;

    //export StorageNest primary key to storage table
    @OneToMany(mappedBy = "id")
    private Set<Storage> storage_nest;
}
