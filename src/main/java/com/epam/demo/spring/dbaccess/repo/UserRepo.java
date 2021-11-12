package com.epam.demo.spring.dbaccess.repo;

import com.epam.demo.spring.dbaccess.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends PagingAndSortingRepository<User, Integer> {
    User findByUserName(String userName);

    List<User> findAllByUserNameAndUserPass(String name, String password);

}
