package com.example.janche.web.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * SwaggerProperties
 *
 * @author lirong
 * @date 2020-9-21 14:43:41
 */
@ConfigurationProperties("swagger")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SwaggerProperties {
	private String title;
	private String basePackage;
	private String version;
	private String contractName;
	private String description;
	private String contractUrl;
	private String contractEmail;
}
