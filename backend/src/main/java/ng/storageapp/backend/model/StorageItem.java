package ng.storageapp.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = StorageItem.STORAGE_ITEM_TABLE_NAME)
public class StorageItem {
    public static final String STORAGE_ITEM_TABLE_NAME = "storage_item";

    @Id
    @SequenceGenerator(
            name = "item_storage_sequence",
            sequenceName = "item_storage_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_storage_sequence"
    )
    @Column(name = "id")
    private Long id;

    //FK from item table
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "item_id")
    private Item item;

    //FK from storage table
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "storage_id")
    private Storage storage;
}
