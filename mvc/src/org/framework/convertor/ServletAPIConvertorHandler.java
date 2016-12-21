package org.framework.convertor;

import org.framework.web.ActionContext;
import org.framework.web.ConvertorHandler;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Parameter;

/**
 * Created by wangl on 2016/12/13.
 */
public class ServletAPIConvertorHandler implements ConvertorHandler{

    @Override
    public Object convert(Parameter parameter) {
         if(parameter.getType() == HttpServletRequest.class){
             return ActionContext.getContext().getRequest();
         }else if(parameter.getType() == HttpServletResponse.class){
             return ActionContext.getContext().getResponse();
         }else if(parameter.getType() == HttpSession.class){
             return ActionContext.getContext().getSesison();
         }else if(parameter.getType() == ServletContext.class){
             return ActionContext.getContext().getApplication();
         }else{
             return null;
         }

    }
}
