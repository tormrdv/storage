package ng.storageapp.backend.model;

import lombok.*;
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
    public static final String BUSINESS_USER = "business_client_owner_id";
    public static final String ID = "id";

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
    private long id;
    private String name;
    private String email;
    //encrypt password
    private String passwordHash;
    private boolean isAdmin;

    //self reference
    @Nullable
    @OneToMany(mappedBy = "id")
    private Set<User> user;
    @ManyToOne
    @JoinColumn(name = BUSINESS_USER)
    private User businessClientOwnerId;

    @Nullable
    @Column(name = "storage_limit")
    private int storageLimit;

    //role reference
    @OneToMany(mappedBy = "id")
    private Set<UserRole> users;

    //storage reference
    @OneToMany(mappedBy = "id")
    private Set<Storage> storages;


    public User(
            String name,
            String email,
            String password,
            boolean admin)
    {
    }
}

