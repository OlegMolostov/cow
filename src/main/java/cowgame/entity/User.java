package cowgame.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private Boolean active;

    private Long countOfAttempts = 0l;
    private Long countOfGames = 0l;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getCountOfAttempts() {
        return countOfAttempts;
    }

    public void setCountOfAttempts(Long countOfAttempts) {
        this.countOfAttempts = countOfAttempts;
    }

    public Long getCountOfGames() {
        return countOfGames;
    }

    public void setCountOfGames(Long countOfGames) {
        this.countOfGames = countOfGames;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int rating() {
        return (int) (countOfAttempts / countOfGames - countOfGames / 50);
    }
}
