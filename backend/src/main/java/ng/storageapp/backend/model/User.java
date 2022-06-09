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
@Table(name = User.TABLE_NAME)

public class User {
    public static final String TABLE_NAME = "users";
    private static final String ID = "id";
    private static final String STORAGE_LIMIT = "storage_limit";

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = ID)
    private Long id;
    private String name;
    private String email;
    private String role;
    //encrypt password
    private String password;

    @Nullable
    @Column(name = STORAGE_LIMIT)
    private Integer storageLimit;

    //export PK to storage
    @OneToMany(mappedBy = "id")
    private Set<Storage> storages;


    public User(
            String name,
            String email,
            String password,
            String role
    ) {
    }
}

