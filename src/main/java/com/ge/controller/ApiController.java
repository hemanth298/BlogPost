package com.ge.controller;

import java.util.Hashtable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ge.entity.Post;
import com.ge.services.PostRepo;

//blog/post  - accept two paramters title and body 
//blog/posts - returns all blogs from post table

@RestController
@RequestMapping("/blog")
public class ApiController {
    @Autowired
    PostRepo postrepo;
	
    //End point accept title and body and insert data to post table
    @RequestMapping(value="/post",method = RequestMethod.POST)
	public String submitPost(
			@RequestParam(value="title", required = true) String title,@RequestParam(value="body" ,required=true) String body){
		Post newpost = new Post();
		newpost.setTitle(title);
		newpost.setBody(body);
		return postrepo.save(newpost).toString();
	}
	
   
    //End point returns all posts from post table in Json formate
	@RequestMapping(value="/posts",method = RequestMethod.GET)
	@ResponseBody
	public List<Post> getAllPosts(){
		return postrepo.findAll();
	}
}
