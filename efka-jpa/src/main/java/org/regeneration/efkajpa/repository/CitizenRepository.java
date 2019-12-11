package org.regeneration.efkajpa.repository;

import org.regeneration.efkajpa.entity.Citizens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizens, String> {
}
