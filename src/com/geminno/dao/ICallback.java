package com.geminno.dao;

import java.sql.ResultSet;
import java.util.List;

public interface ICallback {
	public List execute(ResultSet rs);
}
