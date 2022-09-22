package com.zulu.Mintic_Ciclo3_Textilera.repositories;

import com.zulu.Mintic_Ciclo3_Textilera.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
