package com.dapang.spring.beans.factory.support;


import com.dapang.spring.beans.BeanDefinition;

public interface BeanDefinitionRegistry {
	BeanDefinition getBeanDefinition(String beanID);
	void registerBeanDefinition(String beanID, BeanDefinition bd);
}
