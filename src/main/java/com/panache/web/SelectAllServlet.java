package com.panache.web;

import com.alibaba.fastjson.JSON;
import com.panache.pojo.Brand;
import com.panache.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Auther:作者Panache1356
 * @Date:日期2022/6/7 - 06 - 07 - 15:34
 * @Description:${PACKAGE_NAME}
 * @version:1.0
 */
@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service
        List<Brand> brands = service.selectAll();

        //将对象  转换成json 数据   一般成为 序列化
        String s = JSON.toJSONString(brands);

        //响应给界面
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
