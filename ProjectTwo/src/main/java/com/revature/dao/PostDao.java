package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.*;

public interface PostDao {
	public int create(Post post) throws SQLException;

	public List<Post> loadAll() throws SQLException;

	public int update(Post post) throws SQLException;

	public int delete(Post post) throws SQLException;
}