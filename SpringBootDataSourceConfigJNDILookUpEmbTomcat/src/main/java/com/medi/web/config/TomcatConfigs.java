/* 
 * Author ::. Sivateja Kandula | www.java4s.com 
 *
 */

package com.medi.web.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
public class TomcatConfigs {
	
	 @Bean
	 public TomcatEmbeddedServletContainerFactory tomcatFactory() {  // if datasouce defind in tomcat xml configuration then no need to create this bean
	        
		 return new TomcatEmbeddedServletContainerFactory() {
	          
	        	@Override
	            protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(Tomcat tomcat) 
	        	{
	                tomcat.enableNaming();
	                return super.getTomcatEmbeddedServletContainer(tomcat);
	            }
	        	
	            @Override
	            protected void postProcessContext(Context context) 
	            {
	                ContextResource resource = new ContextResource();

	                resource.setType(DataSource.class.getName());
	                resource.setName("j4s");
	                resource.setProperty("factory", "org.apache.tomcat.jdbc.pool.DataSourceFactory");
	                resource.setProperty("driverClassName", "oracle.jdbc.driver.OracleDriver");
	                resource.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
	                resource.setProperty("username", "system");
	                resource.setProperty("password", "oracle");
	                
	                context.getNamingResources().addResource(resource);
	            }
	        };
	    }
	 
	    @Bean
	    public DataSource jndiDataSource() throws IllegalArgumentException, NamingException 
	    {
	        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();    
	        bean.setJndiName("java:/comp/env/j4s");
	        bean.setProxyInterface(DataSource.class);
	        bean.setLookupOnStartup(false);
	        bean.afterPropertiesSet();
	        
	        return (DataSource) bean.getObject();
	    }
}

//URL: http://localhost:8080/springboot-jndi-lookup/get-cust-info