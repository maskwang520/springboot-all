package com.java.util;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;
/**
 * druid 过滤器
 * @author maskwang
 *2017年6月10日
 */

@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
initParams={
         @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
 }
)
public class DruidStatFilter extends WebStatFilter{

}

