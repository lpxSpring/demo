/*
 * 文 件 名:  ValidationResult.java
 * 版    权:  Copyright 2017 咪咕互动娱乐有限公司,  All rights reserved
 * 描    述:  <描述>
 * 版    本： <版本号> 
 * 创 建 人:  ttg
 * 创建时间:  2017年3月21日
 */
package com.example.test.hibernatevalidator;

import java.util.Map;

/**
 * 
 * 数据验证信息类
 * 
 * @author  ttg
 * @version  [版本号, 2017年3月21日]
 */
public class ValidationResult
{
    
    /**
     * 校验结果是否有错
     */
    private boolean hasErrors;
    
    /**
     * 校验错误信息
     */
    private Map<String, String> errorMsg;
    
    public boolean hasErrors()
    {
        return hasErrors;
    }
    
    public void setHasErrors(boolean hasErrors)
    {
        this.hasErrors = hasErrors;
    }
    
    public Map<String, String> getErrorMsg()
    {
        return errorMsg;
    }
    
    public void setErrorMsg(Map<String, String> errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString()
    {
        return "ValidationResult [hasErrors=" + hasErrors + ", errorMsg=" + errorMsg + "]";
    }
    
}