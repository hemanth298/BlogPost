package com.ge.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ge.entity.Post;

public interface PostRepo extends JpaRepository<Post,Integer> {

}
