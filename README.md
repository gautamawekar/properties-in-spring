<<<<<<< HEAD
Configuration starting with Spring 3.1
=========

Basics:

  - &lt;context:component-scan&gt; : In short - used for defining beans without using XML. Scans packages & registers bean in the context. It works in conjunction with stereotype annotations such as @Component, @Service, @Controller,@Repository, @Configuration. @Configuration is meta-annotated with @Component, therefore @Configuration classes are candidates for component scanning. Note: &lt;context:component-scan/> extends &lt;context:annotation-config/> that is to say that you do not need to define both the declaration at the same time in Spring context file.
  - &lt;context:annotation-config&gt; : &lt;context:annotation-config&gt; tag tells Spring to scan the codebase for automatically resolving dependency requirements of the classes containing @Autowired (@Inject),@Resource, @PostConstruct, @PreDestroy, @ annotation. Use of these annotations also requires that certain BeanPostProcessors be registered within the Spring container. As always, these can be registered as individual bean definitions, but they can also be implicitly registered by including &lt;context:annotation-config> tag
  - Registering Properties via bean:
  ```
<bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
        <property name="location">
            <value>classpath:fullName.properties</value>
        </property>
    </bean>
``` 
  - Registering Properties via the XML namespace:
```
<context:property-placeholder location="classpath:fullName-used-by-namespace.properties" />
```
  - Registering Properties via Java Annotations:
```
@PropertySource("classpath:fullName-via-annotations.properties")
```
  - Use "Environment" object to extract property values.If you use @Value then you need to explicitly define  PropertySourcesPlaceholderConfigurer.
As opposed to using XML namespace element, the Java @PropertySource annotation does not automatically 
register a PropertySourcesPlaceholderConfigurer with Spring
  - Starting with Spring 3.1, the new Environment and PropertySource has simplified working with properties.By default Spring Environment now contains two property sources: the "System" properties and the "JVM" properties.(Note: System properties having precedence.)


Examples:
---


*  @ComponentScan : see com.gawekar.spring.config.basic.MyConfig & BasicAnnotationBasedConfigurationTest.use_annotation_config_NameSpace
  
*  &lt;context:component-scan/> : see BasicAnnotationBasedConfigurationTest.use_component_scan_NameSpace & component-scan-annotation-config.xml
  
*  &lt;context:annotation-config> : see BasicAnnotationBasedConfigurationTest.use_annotation_config_NameSpace & annotation-config-only.xml
  
* Use Environment : see UseEnvironmentConfig & UseEnvironmentConfigTest
  
* Use @Value : see UseValueConfig & UseValueConfigTest

=======
properties-in-spring
====================

Properties with Spring
>>>>>>> ba235b966ac9450732288da191155bd2de7a7a64
