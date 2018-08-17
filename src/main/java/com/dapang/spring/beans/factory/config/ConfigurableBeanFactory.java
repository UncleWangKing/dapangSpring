package com.dapang.spring.beans.factory.config;


import com.dapang.spring.beans.factory.BeanFactory;

public interface ConfigurableBeanFactory extends BeanFactory {
	void setBeanClassLoader(ClassLoader beanClassLoader);
	ClassLoader getBeanClassLoader();	
}
