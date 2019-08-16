package com.numa.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WSConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/soapws/*");
	}
	
	@Bean(name = "clubs")
	public DefaultWsdl11Definition clubsWsdl11Definition(XsdSchema clubsSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ClubsPort");
		wsdl11Definition.setLocationUri("/soapws");
		wsdl11Definition.setTargetNamespace("http://www.numapage.com/clubs-ws");
		wsdl11Definition.setSchema(clubsSchema);
		return wsdl11Definition;
	}
	@Bean
	public XsdSchema clubsSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsds/clubs.xsd"));
	}
	
	@Bean(name = "players")
	public DefaultWsdl11Definition playersWsdl11Definition(XsdSchema playersSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("PlayersPort");
		wsdl11Definition.setLocationUri("/soapws");
		wsdl11Definition.setTargetNamespace("http://www.numapage.com/player-ws");
		wsdl11Definition.setSchema(playersSchema);
		return wsdl11Definition;
	}
	@Bean
	public XsdSchema playersSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsds/players.xsd"));
	}
	
	@Bean(name = "countries")
	public DefaultWsdl11Definition countriesWsdl11Definition(XsdSchema countriesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("CountriesPort");
		wsdl11Definition.setLocationUri("/soapws");
		wsdl11Definition.setTargetNamespace("http://www.numapage.com/country-ws");
		wsdl11Definition.setSchema(countriesSchema);
		return wsdl11Definition;
	}
	@Bean
	public XsdSchema countriesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsds/countries.xsd"));
	}
}
