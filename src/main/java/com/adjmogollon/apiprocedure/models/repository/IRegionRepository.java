package com.adjmogollon.apiprocedure.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adjmogollon.apiprocedure.models.entity.Region;


public interface IRegionRepository extends JpaRepository<Region, Long>{

}
