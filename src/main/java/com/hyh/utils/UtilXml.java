package com.hyh.utils;

import com.hyh.dao.UserDao;
import com.hyh.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 潮7000
 * @vesion 1.0
 * @date 2022/5/14 11:32
 */
public class UtilXml {

    public static <T> T getBeanConfig(Class<T> requiredType) throws BeansException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        T bean = applicationContext.getBean(requiredType);
        return bean;

    }


}
