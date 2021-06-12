package com.firmavp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.Pictures;

@Repository
public interface PicturesRepository extends JpaRepository<Pictures,Integer> {



	Pictures findPicturesById(Integer id);

	
	@Query(nativeQuery = true, value = "select p.url_pictures from pictures as p WHERE p.category=? AND p.entity_id=?")
	List<String> findPicturesByEntityId(Integer category, Integer entity_id);

}
