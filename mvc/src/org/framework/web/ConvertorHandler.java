package org.framework.web;

import java.lang.reflect.Parameter;

/**
 * Created by wangl on 2016/12/13.
 * 抽象的类型转换器
 */
public interface ConvertorHandler {

    public Object convert(Parameter parameter);
}
