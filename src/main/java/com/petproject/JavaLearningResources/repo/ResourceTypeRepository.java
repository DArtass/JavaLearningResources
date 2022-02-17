package com.petproject.JavaLearningResources.repo;

import com.petproject.JavaLearningResources.models.Resource;
import com.petproject.JavaLearningResources.models.ResourceType;
import org.springframework.data.repository.CrudRepository;

public interface ResourceTypeRepository extends CrudRepository<ResourceType, Long> {

}
