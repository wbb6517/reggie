package com.ourslook.reggie;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
/**
 * @Slf4j 是 lombok 中的一个注解，它会在编译期间自动生成一个 log 变量，
 * 用于输出日志信息，避免了手动定义
 * private static final Logger log = LoggerFactory.getLogger(XXX.class);
 * 的过程。
 *
 * 具体使用方法为在类上加上注解 @Slf4j，
 * 然后在需要输出日志的地方直接使用 log 变量输出即可，
 * 例如： log.info("message")。
 * 其中，log 变量的类型为 org.slf4j.Logger，是一个标准的日志接口，可以输出不同级别的日志信息。
 */
@SpringBootApplication
/**
 * @SpringBootApplication 是Spring Boot项目中的核心注解，
 * 它包含了@ComponentScan和@EnableAutoConfiguration注解。
 * 其中
 * @ComponentScan 是用来扫描应用程序中的所有Spring组件，例如@Service、@Controller、@Repository等，将它们注入Spring容器中。
 * @EnableAutoConfiguration 则是用来自动配置Spring Boot应用程序，通过类路径下的各种jar包来推断Spring应用程序所需的bean配置。
 * 这样，在使用@SpringBootApplication注解时，就能让Spring Boot应用程序更加快速地构建和运行。
 */
@ServletComponentScan
/**
 * @ServletComponentScan 是一个Spring Boot注解，用于自动扫描指定包及其子包中的servlet、filter和listener类，并注册它们。
 * 它使得开发者不必在web.xml文件中配置这些组件，而是可以通过Java类来配置。
 * 这个注解通常在Spring Boot启动类上使用，以确保在应用程序启动时自动注册这些组件。
 */
@EnableTransactionManagement
/**
 * @EnableTransactionManagement 是Spring提供的一个注解，用于开启事务管理功能。
 * 通常在Spring Boot中，我们无需显式地添加该注解，因为Spring Boot会自动配置并启用该功能。
 * 在使用纯Spring框架时，需要手动添加该注解才能启用事务管理。
 */
public class ReggieApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReggieApplication.class, args);
        log.info("项目启动成功...");
    }


}
