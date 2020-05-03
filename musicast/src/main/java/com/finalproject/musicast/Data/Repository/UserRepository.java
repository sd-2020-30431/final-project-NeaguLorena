package com.finalproject.musicast.Data.Repository;

import com.finalproject.musicast.Presentation.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findUserById(Long id);
}