package Entity;

import javax.persistence.*;


@Entity
@Table(name = "app_role")
public class AppRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id", nullable = false)
    private Long appRoleId;


    @Column(name = "role_name", nullable = false, length = 30)
    private String roleName;

    public Long getRoleId() {
        return appRoleId;
    }

    public void setRoleId(Long roleId) {
        this.appRoleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
