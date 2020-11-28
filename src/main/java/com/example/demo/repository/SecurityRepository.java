package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
import com.sun.el.stream.Optional;

@Repository
public interface SecurityRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.uid = :uid")
	public User findByUid(String uid);
}
