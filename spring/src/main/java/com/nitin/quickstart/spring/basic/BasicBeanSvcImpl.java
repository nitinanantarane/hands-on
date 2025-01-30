package com.nitin.quickstart.spring.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BasicBeanSvcImpl implements BasicBeanSvc {

	private final List<BasicBean> basicBeanList = new ArrayList<BasicBean>();
	
	@Override
	public void add(BasicBean basicBean) {
		basicBeanList.add(basicBean);
	}

	@Override
	public BasicBean get(long id) {
		return basicBeanList.stream().filter(b -> b.getId() == id)
				.collect(Collectors.toList()).get(0);
	}

	@Override
	public void update(BasicBean basicBean) {
		basicBeanList.stream().forEach(t -> {
				if (t.getId() == basicBean.getId()) {
					t.setName(basicBean.getName());
					t.setType(basicBean.getType());
				}			
		});
		
	}

	@Override
	public void delete(long id) {
		basicBeanList.removeIf(t -> t.getId() == id);
	}

	@Override
	public List<BasicBean> getAll() {
		return basicBeanList;
	}

	@Override
	public void deleteAll() {
		basicBeanList.clear();
	}

}
