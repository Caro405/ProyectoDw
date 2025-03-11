package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long>{

}
