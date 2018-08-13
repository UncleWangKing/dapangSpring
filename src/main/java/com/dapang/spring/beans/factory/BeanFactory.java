package com.dapang.spring.beans.factory;

import com.dapang.spring.beans.BeanDefinition;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/8/13 13:52
 */
public interface BeanFactory {
    public BeanDefinition getBeanDefinition(String beanID);

    public Object getBean(String beanID);
}
