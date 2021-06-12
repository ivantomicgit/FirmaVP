package com.firmavp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.Place;
@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {

	Place findCompanyById(Integer id);


	
}
