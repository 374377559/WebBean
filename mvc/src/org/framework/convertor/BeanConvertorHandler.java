package org.framework.convertor;

import org.apache.commons.beanutils.BeanUtils;
import org.framework.web.ActionContext;
import org.framework.web.ConvertorHandler;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Parameter;
import java.util.Map;

import static org.apache.commons.beanutils.BeanUtils.*;

/**
 * Created by wangl on 2016/12/13.
 * 对象类型转换器
 */
public class BeanConvertorHandler implements ConvertorHandler{

    @Override
    public Object convert(Parameter parameter) {
        HttpServletRequest request = ActionContext.getContext().getRequest();
        Map<String, String[]> map = request.getParameterMap();
        try{
            Object instance = parameter.getType().newInstance();
            BeanUtils.populate(instance, map);
            return instance;
        }catch(Exception e){
            return null;
        }
    }
}
