package ng.storageapp.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Item {
    private final String storageId = "item_storage_id";

    @Id
    @SequenceGenerator(
            name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_sequence"
    )
    private Long id;
    private String name;

    @Nullable
    private int serialNumber;

    private Double weight;
    private String colour;
    private int value;
    private String fileName;

    //reference to storage
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = storageId)
    private Storage storage;
}


