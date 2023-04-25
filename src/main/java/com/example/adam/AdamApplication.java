package com.example.adam;

import com.example.adam.model.SAN;
import com.example.adam.model.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AdamApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdamApplication.class, args);

	}
}



//@SpringBootApplication
//public class AdamApplication implements CommandLineRunner {
//
//	@Autowired
//	private ResourceFactoryRegistry resourceFactoryConfigurer;
//
//	public static void main(String[] args) {
//		SpringApplication.run(AdamApplication.class, args);
//	}
//
//	@Override
//	public void run(String... args) {
//		// Get SAN factory and create a SAN resource
//		Resource sanResource = resourceFactoryConfigurer.getFactory("SANFactory").createResource();
//		((SAN) sanResource).setFriendlyName("FriendlyName");
//		((SAN) sanResource).setDiskSpeed("7200RPM");
//		((SAN) sanResource).setFqdn("san.example.com");
//
//		// Get Server factory and create a Server resource
//		Resource serverResource = resourceFactoryConfigurer.getFactory("ServerFactory").createResource();
//		((Server) serverResource).setHostname("Hostname");
//		((Server) serverResource).setIpAddress("192.168.1.2");
//		((Server) serverResource).setFqdn("server.example.com");
//	}
//
//}
