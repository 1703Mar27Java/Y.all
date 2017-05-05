package com.revature.dao;

import com.revature.beans.Moderator;

public interface ModDao {
	public void persistMod(Moderator m);
	public void deleteMod(Moderator m);
	public Moderator getModById(int id);
	public Moderator getModByLogin(String username, String password);
}
