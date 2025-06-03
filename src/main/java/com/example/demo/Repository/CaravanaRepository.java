package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Caravana;

@Repository
public interface CaravanaRepository extends JpaRepository<Caravana, Long> {

}
