package org.framework.view;

import com.google.gson.Gson;
import org.framework.web.ActionContext;
import org.framework.web.ViewResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangl on 2016/12/12.
 */
public class JsonView implements ViewResult{

    private Object obj;

    public JsonView(Object obj){
        this.obj = obj;
    }

    @Override
    public void view() throws ServletException, IOException {
        HttpServletResponse response = ActionContext.getContext().getResponse();
        response.setContentType("application/json;charset=utf-8");
        String json = new Gson().toJson(obj);
        response.getWriter().println(json);
    }
}
