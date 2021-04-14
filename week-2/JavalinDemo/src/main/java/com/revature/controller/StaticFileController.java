package com.revature.controller;

import java.io.InputStream;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class StaticFileController implements Controller {
	
	private Handler createFileHandler(String classpathPath) {
		return ctx -> {
			InputStream is = StaticFileController.class.getResourceAsStream(classpathPath);
			byte[] ourFileInBytes = is.readAllBytes();
			String html = new String(ourFileInBytes);
			ctx.html(html);
			ctx.status(200);
		};
	}
	
	@Override
	public void mapEndpoints(Javalin app) {
		app.get("/", createFileHandler("/static/index.html"));
		app.get("/test", createFileHandler("/static/test.html"));
	}

}
