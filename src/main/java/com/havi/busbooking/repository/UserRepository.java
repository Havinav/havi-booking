package com.havi.busbooking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.havi.busbooking.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.email = ?1")
    User findByUserName(String email);
}
