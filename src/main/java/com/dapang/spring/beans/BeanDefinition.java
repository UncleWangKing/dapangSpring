package com.dapang.spring.beans;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/8/13 13:52
 */
public interface BeanDefinition {
    public static final String SCOPE_SINGLETON = "singleton";
    public static final String SCOPE_PROTOTYPE = "prototype";
    public static final String SCOPE_DEFAULT = "";

    public boolean isSingleton();
    public boolean isPrototype();
    String getScope();
    void setScope(String scope);

    public String getBeanClassName();
}
