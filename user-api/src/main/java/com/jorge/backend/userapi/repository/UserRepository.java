package com.jorge.backend.userapi.repository;

import com.jorge.backend.userapi.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByCpfAndUserKey(String cpf, String userKey);

    List<User> queryByNameLike(String name);
}
