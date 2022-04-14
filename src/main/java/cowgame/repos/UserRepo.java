package cowgame.repos;

import cowgame.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);

    @Transactional
    @Modifying
    @Query("update User u set u.countOfAttempts =u.countOfAttempts+?1, u.countOfGames=u.countOfGames+1 where u.username=?2")
    void setUpdate(Long countOfAttempts,String username);

    @Query("select u from User u where u.countOfGames>0")
    List<User> TopUsers();
}
