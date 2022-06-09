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

public class Item {
    public static final String ITEM_ID = "id";
    public static final String SERIAL_NUM = "serial_number";
    public static final String FILE = "file_name";

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
    @Column(name = ITEM_ID)
    private Long id;
    private String name;

    @Nullable
    @Column(name = SERIAL_NUM)
    //no primitive
    private Integer serialNumber;

    private Double weight;
    private String colour;
    private Integer value;

    @Nullable
    @Column(name = FILE)
    private String fileName;

    //reference to item in storage
    @OneToMany(mappedBy = "id")
    private Set<StorageItem> item;


}


