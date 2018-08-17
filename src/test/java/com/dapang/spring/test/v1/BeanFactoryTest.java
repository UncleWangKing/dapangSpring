package com.dapang.spring.test.v1;

import com.dapang.spring.beans.core.io.ClassPathResource;
import com.dapang.spring.beans.core.io.FileSystemResource;
import com.dapang.spring.beans.factory.BeanCreationException;
import com.dapang.spring.beans.factory.BeanDefinitionStoreException;
import com.dapang.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.dapang.spring.service.v1.PetStoreService;
import com.dapang.spring.beans.BeanDefinition;
import com.dapang.spring.beans.factory.support.DefaultBeanFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/8/13 13:48
 */
public class BeanFactoryTest {

    DefaultBeanFactory factory = null;
    XmlBeanDefinitionReader reader = null;

    @Before
    public void setUp(){
        factory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(factory);

    }
    @Test
    public void testGetBean() {

        reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));

        BeanDefinition bd = factory.getBeanDefinition("petStore");

        assertTrue(bd.isSingleton());

        assertFalse(bd.isPrototype());

        assertEquals(BeanDefinition.SCOPE_DEFAULT,bd.getScope());

        assertEquals("com.dapang.spring.service.v1.PetStoreService",bd.getBeanClassName());

        PetStoreService petStore = (PetStoreService)factory.getBean("petStore");

        assertNotNull(petStore);

        PetStoreService petStore1 = (PetStoreService)factory.getBean("petStore");

        assertTrue(petStore.equals(petStore1));
    }

    @Test
    public void testInvalidBean(){

        reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
        try{
            factory.getBean("invalid");
        }catch(BeanCreationException e){
            return;
        }
        Assert.fail("expect BeanCreationException ");
    }
    @Test
    public void testInvalidXML(){

        try{
            reader.loadBeanDefinitions(new FileSystemResource("invalid"));
        }catch(BeanDefinitionStoreException e){
            return;
        }
        Assert.fail("expect BeanDefinitionStoreException ");
    }
}
