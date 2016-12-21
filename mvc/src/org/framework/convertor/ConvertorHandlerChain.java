package org.framework.convertor;

import org.framework.web.ConvertorHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangl on 2016/12/13.
 */
public class ConvertorHandlerChain {

    private static List<ConvertorHandler> list = new ArrayList<>();

    static {
        list.add(new BasicConvertorHandler());
        list.add(new BeanConvertorHandler());
        list.add(new ServletAPIConvertorHandler());
    }

    public static Object[] execute(Method method){
        //获取当前方法所有的参数
        Parameter[] params = method.getParameters();
        //Object数组用于存放转换后的值
        Object[] values = new Object[params.length];
        //循环遍历参数
        for(int i=0; i<params.length; i++){
            //循环一次获取一个方法中的参数
            Parameter param = params[i];
            //将方法中的参数进行类型转换，会经过多个不同的转换器
            //只要转换成功，那么就返回一个转换后的值，并复制给Object数组
            //如果返回null，表示转换失败，则接着循环下一个转换器继续转换
            for (ConvertorHandler handler : list) {
                Object value = handler.convert(param);
                if(value != null){
                    values[i] = value;
                    break;
                }
            }
        }
        return values;
    }
}
