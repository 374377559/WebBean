package org.framework.view;

import org.framework.web.ActionContext;
import org.framework.web.ViewResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangl on 2016/12/12.
 * 重定向视图
 */
public class RedirectView implements ViewResult{

    private String uri;

    public RedirectView(String uri){
        this.uri = uri;
    }

    @Override
    public void view() throws ServletException, IOException {
        HttpServletResponse response = ActionContext.getContext().getResponse();
        response.sendRedirect(uri);
    }
}
