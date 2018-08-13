package com.dapang.spring.test.v1;

import com.dapang.spring.service.v1.PetStoreService;
import com.dapang.spring.beans.BeanDefinition;
import com.dapang.spring.beans.factory.BeanFactory;
import com.dapang.spring.beans.factory.support.DefaultBeanFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/8/13 13:48
 */
public class BeanFactoryTest {

    @Test
    public void testGetBean(){
        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");

        BeanDefinition bd = factory.getBeanDefinition("petStore");

        Assert.assertEquals("com.dapang.spring.service.v1.PetStoreService", bd.getBeanClassName());

        PetStoreService petStore = (PetStoreService)factory.getBean("petStore");

        Assert.assertNotNull(petStore);
    }
}
