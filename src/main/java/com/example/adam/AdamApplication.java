package com.example.adam;
import com.example.adam.factory.AbstractResourceFactory;
import com.example.adam.factory.ResourceFactory;
import com.example.adam.factory.ResourceType;
import com.example.adam.model.Resource;
import com.example.adam.service.AuditService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class AdamApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdamApplication.class, args);

		AbstractResourceFactory resourceFactory = new ResourceFactory();
		Resource server = resourceFactory.createResource(ResourceType.SERVER);
		Resource san = resourceFactory.createResource(ResourceType.SAN);
		Resource ltm = resourceFactory.createResource(ResourceType.LTM);
		Resource gtm = resourceFactory.createResource(ResourceType.GTM);

		server.activeRecord();
		san.activeRecord();
		ltm.activeRecord();
		gtm.activeRecord();

		AuditService auditService = new AuditService();
		auditService.audit("Alice", LocalDateTime.now(), "Bob", LocalDateTime.now().plusDays(1));
	}
}
