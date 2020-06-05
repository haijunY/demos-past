package com.yhj.study.mini.springmvc.framework.webmvc.servlet;

import com.yhj.study.mini.springmvc.framework.annotation.GPController;
import com.yhj.study.mini.springmvc.framework.annotation.GPRequestMapping;
import com.yhj.study.mini.springmvc.framework.context.GPApplicationContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @date: 2019/05/30 11:11
 */
@Slf4j
public class GPDispatchServlet extends HttpServlet {

    private static final String CONTEXT_CONFIG_LOCATION = "contextConfigLocation";
    //保存url和method的对应关系
    private List<GPHandlerMapping> handlerMappings = new ArrayList<GPHandlerMapping>();
    //
    private Map<GPHandlerMapping, GPHandlerAdapter> handlerAdapters = new HashMap<GPHandlerMapping, GPHandlerAdapter>();

    private List<GPViewResolver> viewResolvers = new ArrayList<GPViewResolver>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.doDispath(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            //如果匹配过程出现异常，将异常信息打印出去
            resp.getWriter().write("500 Exception, Details:\r\n" + Arrays.toString(e.getStackTrace()));
            //new ModelAndView("500")
        }
    }

    private void doDispath(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1、通过从request中拿到URL,去匹配一个HandlerMapper
        GPHandlerMapping handler = getHandler(req);
        if(handler == null ){
            processDispatchResult(req, resp, new GPModelAndView("404"));
            //new ModelAndView("404")
            return;
        }
        //2、准备调用前的参数
        GPHandlerAdapter ha = getHandlerAdapter(handler);

        //3、真正的调用方法,返回ModelAndView存储了要传页面上的值，和页面模板的名称
        GPModelAndView mv = ha.handler(req, resp, handler);

        //4、这一步才是真正的输出
        processDispatchResult(req, resp, mv);
    }

    private void processDispatchResult(HttpServletRequest req, HttpServletResponse resp, GPModelAndView mv) throws Exception {
        //把给我的ModelAndView变成一个HTML、OutputStream、json、freemark、veolcity
        //ContextType
        if(null == mv){return;}

        //如果ModelAndView不是null，渲染
        if(this.viewResolvers.isEmpty()){return;}

        for (GPViewResolver viewResolver : this.viewResolvers) {
            GPView view = viewResolver.resolveViewName(mv.getViewName(), null);
            view.render(mv.getModel(), req, resp);
            return;
        }


    }

    private GPHandlerAdapter getHandlerAdapter(GPHandlerMapping handlerMapping) {
        if(this.handlerAdapters.isEmpty()){
            return null;
        }
        GPHandlerAdapter ha = this.handlerAdapters.get(handlerMapping);
        if(ha.supports(handlerMapping)){
            return ha;
        }
        return null;
    }

    private GPHandlerMapping getHandler(HttpServletRequest req)throws Exception{
        if(this.handlerMappings.isEmpty()){
            return null;
        }
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replace(contextPath, "").replaceAll("/+", "/");
        for(GPHandlerMapping handler : handlerMappings){
            try{
                Matcher matcher = handler.getPattern().matcher(url);
                if(!matcher.matches()){
                    continue;
                }
                return handler;
            }catch (Exception e){
                throw e;
            }
        }
        return null;
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        String contextConfigLocation = config.getInitParameter(CONTEXT_CONFIG_LOCATION);
        //初始化ApplicationContext
        GPApplicationContext applicationContext = new GPApplicationContext(contextConfigLocation);
        applicationContext.refresh();

        //初始化9大组件
        initStrategies(applicationContext);
    }

    //初始化策略
    protected void initStrategies(GPApplicationContext context) {
        //多文件上传的组件
        initMultipartResolver(context);
        //本地语言环境
        initLocaleResolver(context);
        //主题
        initThemeResolver(context);
        //HandlerMapping
        initHandlerMappings(context);
        //参数适配器
        initHandlerAdapters(context);
        //异常拦截器
        initHandlerExceptionResolvers(context);
        //视图预处理器
        initRequestToViewNameTranslator(context);
        //视图转换器
        initViewResolvers(context);
        initFlashMapManager(context);
    }
    private void initMultipartResolver(GPApplicationContext context) {
    }
    private void initLocaleResolver(GPApplicationContext context) {
    }
    private void initThemeResolver(GPApplicationContext context) {
    }
    private void initHandlerMappings(GPApplicationContext context) {
        String[] beanNames = context.getBeanDefinionNames();
        try {
            for(String beanName : beanNames){
                Object controller = context.getBean(beanName);
                Class<?> clazz = controller.getClass();
                if(!clazz.isAnnotationPresent(GPController.class)){
                    continue;
                }

                //保存写在类上面的url
                String baseUrl = "";
                if(clazz.isAnnotationPresent(GPRequestMapping.class)){
                    GPRequestMapping requestMapping = clazz.getAnnotation(GPRequestMapping.class);
                    baseUrl = requestMapping.value();
                }

                //默认获取所有public方法
                for(Method method : clazz.getMethods()){
                    if(!method.isAnnotationPresent(GPRequestMapping.class)){continue;}

                    GPRequestMapping requestMapping = method.getAnnotation(GPRequestMapping.class);

                    //多个/相连，替换成一个/
                    String regex = ("/" + baseUrl + "/" +requestMapping.value()).replaceAll("\\*", ".*").replaceAll("/+", "/");
                    Pattern pattern = Pattern.compile(regex);

                    handlerMappings.add(new GPHandlerMapping(pattern, controller, method));
                    log.info("Mapped" + regex + "," + method);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void initHandlerAdapters(GPApplicationContext context) {
        //把一个request请求变成一个Handler，参数都是字符串的，自动匹配到handler中的形参
        for(GPHandlerMapping handlerMapping : handlerMappings){
            handlerAdapters.put(handlerMapping, new GPHandlerAdapter());
        }

    }
    private void initHandlerExceptionResolvers(GPApplicationContext context) {
    }
    private void initRequestToViewNameTranslator(GPApplicationContext context) {
    }
    private void initViewResolvers(GPApplicationContext context) {
        //拿到模板的存放目录
        Properties properties = context.getConfig();
        String templateRoot = properties.getProperty("templateRoot");
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();
        File templateRootDir = new File(templateRootPath);
        for(File template : templateRootDir.listFiles()){
            //这里主要是为了兼容多模板
            this.viewResolvers.add(new GPViewResolver(templateRoot));
        }
    }
    private void initFlashMapManager(GPApplicationContext context) {
    }

}
