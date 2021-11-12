package com.epam.demo.spring.dbaccess.repo;

import com.epam.demo.spring.dbaccess.entities.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepo extends CrudRepository<Session, Integer> {
}
