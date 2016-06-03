package com.yk.example.repository.primary;

import com.yk.example.entity.primary.User;
import com.yk.example.repository.MyRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by yk on 15/12/8.
 */
public interface UserRepository extends MyRepository<User, Long> {

    User findByName(String name);

    User findByToken(String token);

    @Query(value = " select * from t_user u order by convert(u.name using gbk) ", nativeQuery = true)
    List<User> findAllOrderByName();

    @Query(value = "SELECT a.* FROM t_user a right join t_user_relation b on(a.tel = b.tel)", nativeQuery = true)
    List<User> findUserRelationByTel();
}
