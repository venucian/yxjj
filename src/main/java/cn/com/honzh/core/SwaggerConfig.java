package cn.com.honzh.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
//	 @Bean
//	    public Docket createRestApi(){
//	        return new Docket(DocumentationType.SWAGGER_2)
//	        		
//        	       .enableUrlTemplating(true)
//                   .select()
//                   // 扫描所有有注解的api，用这种方式更灵活
//                   .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//	               .paths(PathSelectors.any())
//	               .build()
//	               .groupName("用户分组").pathMapping("/");
//
////	                .apiInfo(apiInfo())
////	                .select()
////	                //为当前包下controller生成API文档
//////	                .apis(RequestHandlerSelectors.basePackage("cn.com.honzh.modules"))
//////	                为有@Api注解的Controller生成API文档
////	                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
////
////	                //为任何接口生成API文档
//////	                .apis(RequestHandlerSelectors.any())
////	                .paths(PathSelectors.any())
////	                .build();
//	    }
	 
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOrigins("*")
                //是否允许证书 不再默认开启
                .allowCredentials(true)
                //设置允许的方法
                .allowedMethods("*")
                //跨域允许时间
                .maxAge(3600);
    }

	 @Bean
	 public Docket userApi() {
	     return new Docket(DocumentationType.SWAGGER_2)
	             .groupName("WEB接口")
	             .apiInfo(apiInfo())
	             .select()
	             .apis(RequestHandlerSelectors.basePackage("cn.com.honzh.modules.yxjj.web"))
	             .paths(PathSelectors.ant("/web/**"))
	             .build();
	 }
	 
	 @Bean
	 public Docket applyerApi() {
	     return new Docket(DocumentationType.SWAGGER_2)
	             .groupName("APP接口")
	             .apiInfo(apiInfo())
	             .select()
	             .apis(RequestHandlerSelectors.basePackage("cn.com.honzh.modules.yxjj.app"))
	             .paths(PathSelectors.ant("/app/**"))
	             .build();
	 }
//	 	@Bean
//	    public Docket app_api() {
//	        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("cn.com.honzh.modules.apply"))
//	                .paths(PathSelectors.ant("/users/**")).build().groupName("APP接口文档V4.4").pathMapping("/")
//	                .apiInfo(apiInfo("APP接口文档V4.4及之前","文档中可以查询及测试接口调用参数和结果","4.4"));
//	    }
//	 
//	    @Bean
//	    public Docket web_api() {
//	        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("cn.com.honzh.modules.user"))
//	                .paths(PathSelectors.ant("/applyer/**")).build().groupName("WAP接口文档V4.4").pathMapping("/")
//	                .apiInfo(apiInfo("WAP接口文档V4.4及之前","文档中可以查询及测试接口调用参数和结果","4.4"));
//	    }
	    private ApiInfo apiInfo(String name,String description,String version) {
	        ApiInfo apiInfo = new ApiInfoBuilder().title(name).description(description).version(version).build();
	        return apiInfo;
	    }

	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("SwaggerUI演示")
	                .description("更多Spring Boot相关文章请百度：http://www.baidu.com")
	                .termsOfServiceUrl("http://www.baidu.com/")
	                .build();
	    }

	    /**
	     * 配置swagger2的静态资源路径
	     * @param registry
	     */
	    @Override
	    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
	        // 解决静态资源无法访问
	        registry.addResourceHandler("/**")
	                .addResourceLocations("classpath:/static/");
	        // 解决swagger无法访问
	        registry.addResourceHandler("/swagger-ui.html")
	                .addResourceLocations("classpath:/META-INF/resources/");
	        // 解决swagger的js文件无法访问
	        registry.addResourceHandler("/webjars/**")
	                .addResourceLocations("classpath:/META-INF/resources/webjars/");
	    }

}
