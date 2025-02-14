package com.nitin.core;

import java.util.List;

public interface BasicBeanSvc {

	void add(final BasicBean basicBean);
	BasicBean get(final long id);
	void update(final BasicBean basicBean);
	void delete(final long id);
	
	List<BasicBean> getAll();
	void deleteAll();
	
}
