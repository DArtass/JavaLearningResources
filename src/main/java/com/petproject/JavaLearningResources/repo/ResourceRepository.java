package com.petproject.JavaLearningResources.repo;

import com.petproject.JavaLearningResources.models.Resource;
import org.springframework.data.repository.CrudRepository;

public interface ResourceRepository extends CrudRepository<Resource, Long> {

}
