/*
 * 文 件 名:  ValidationUtils.java
 * 版    权:  Copyright 2017 咪咕互动娱乐有限公司,  All rights reserved
 * 描    述:  <描述>
 * 版    本： <版本号> 
 * 创 建 人:  ttg
 * 创建时间:  2017年3月21日
 */
package com.example.test.hibernatevalidator;

import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 数据验证工具类
 * 
 * 
 * @author  ttg
 * @version  [版本号, 2017年3月21日]
 */
public class ValidationUtils
{
    
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    
    private ValidationUtils()
    {
    }
    
    /**
     * 校验实体对象
     * @param obj
     * @param groups
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static <T> ValidationResult validateEntity(T obj, Class<?>... groups)
    {
        ValidationResult result = new ValidationResult();
        /**
         * 这三个方法都会返回一个Set<ConstraintViolation>对象,
         * 如果整个验证过程没有发现问题的话,那么这个set是空的, 否则, 每个违反约束的地方都会被包装成一个ConstraintViolation的实例然后添加到set当中.
         */
        Set<ConstraintViolation<T>> set = validator.validate(obj, groups);
        if (!CollectionUtils.isEmpty(set))
        {
            result.setHasErrors(true);
            Map<String, String> errorMsg = new HashMap<>();
            for (ConstraintViolation<T> cv : set)
            {
                errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
            }
            result.setErrorMsg(errorMsg);
        }
        return result;
    }
    
    /**
     * 校验属性
     * @param obj
     * @param propertyName
     * @param groups
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static <T> ValidationResult validateProperty(T obj, String propertyName, Class<?>... groups)
    {
        ValidationResult result = new ValidationResult();
        Set<ConstraintViolation<T>> set = validator.validateProperty(obj, propertyName, groups);
        if (!CollectionUtils.isEmpty(set))
        {
            result.setHasErrors(true);
            Map<String, String> errorMsg = new HashMap<>();
            for (ConstraintViolation<T> cv : set)
            {
                errorMsg.put(propertyName, cv.getMessage());
            }
            result.setErrorMsg(errorMsg);
        }
        return result;
    }
}