package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
}
