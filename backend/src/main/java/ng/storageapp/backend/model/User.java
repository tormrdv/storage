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
    @Column(name = "id")
    private long id;
    private String name;
    private String email;
    private String passwordHash;
    private boolean isAdmin;

    //self reference
    @Nullable
    @OneToMany(mappedBy = "id")
    private Set<User> user;
    @ManyToOne
    @JoinColumn(name = "business_client_owner_id")
    private User businessClientOwnerId;

    @Nullable
    private int storageLimit;

    //role reference
    @OneToMany(mappedBy = "id")
    private Set<UserRole> users;

    //storage reference
    @OneToMany(mappedBy = "id")
    private Set<Storage> storages;
}

