package com.dapang.spring.context.support;

import com.dapang.spring.beans.core.io.FileSystemResource;
import com.dapang.spring.beans.core.io.Resource;

public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

	public FileSystemXmlApplicationContext(String path) {
		super(path);		
	}

	@Override
	protected Resource getResourceByPath(String path) {
		return new FileSystemResource(path);
	}
}
