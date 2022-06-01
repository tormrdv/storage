package ng.storageapp.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class UserRole {
    private final String RoleId = "user_role_role_id";
    private final String UserId = "user_role_user_id";

    @Id
    @GeneratedValue
    private long id;

    //role reference
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = RoleId)
    private Role role;
    //user reference
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = UserId)
    private User user;
}
