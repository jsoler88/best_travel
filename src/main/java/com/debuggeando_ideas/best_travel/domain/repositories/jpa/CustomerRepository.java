package com.debuggeando_ideas.best_travel.domain.repositories.jpa;

import com.debuggeando_ideas.best_travel.domain.entitites.jpa.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, String> {
}
