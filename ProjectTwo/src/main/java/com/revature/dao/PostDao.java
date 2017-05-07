package com.revature.dao;

import java.util.List;
import com.revature.beans.*;

public interface PostDao {
	public void create(Post p);
	
	public List<Post> loadFlags();
	
	public Post loadPost(int id);

	public List<Post> loadThread(int id);

	public void update(Post p);

	public void delete(Post p);
}