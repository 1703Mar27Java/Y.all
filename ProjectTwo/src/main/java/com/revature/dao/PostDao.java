package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.*;

public interface PostDao {
	public List<Post> loadAll() throws SQLException;

	public void update(Post post) throws SQLException;

	public int delete(Post post) throws SQLException;
}