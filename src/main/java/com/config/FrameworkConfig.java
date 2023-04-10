package com.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
	"system:properties",
	"system:env",
	"file:${user.dir}/config.properties"
	})
public interface FrameworkConfig extends Config {

	
	String browser();
	
	@DefaultValue("staging")
	String environment();
	
	@Key("${environment}.url")
	String url();
}
