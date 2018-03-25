package com.jerseyweb;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Root resource (exposed at "myresource" path)
 */

@ApplicationPath("myresource")
public class MyResourceApp extends Application {
	
}
