package org.regeneration.efkajpa.repository;

import org.regeneration.efkajpa.entity.Citizens;
import org.regeneration.efkajpa.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizens, String> {
    Citizens findByAmka(String amka);
    Citizens findByUsers(Users user);
    boolean existsByAmka(String amka);
}
