### springboot-jsp
### 技术点：
### 1. 官方不支持jsp,但是jsp相比与其他几个模板，更让大家熟悉。
### 2. 配置也挺简单的。页面默认前缀目录spring.mvc.view.prefix=/WEB-INF/，响应页面默认后缀spring.mvc.view.suffix=.jsp
### 3. 从配置文件中读取值@value注解。
### 4. 运行原生的servlet.只需要在正常的servlet类上，应用@WebServlet注解，即是一个servlet,在主类上标注@ServletComponentScan，即可以扫描到servlet。
