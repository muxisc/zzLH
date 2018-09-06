package com.lh.blog.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icinfo.framework.core.web.BaseController;

@Controller
@RequestMapping("/admin/system/websocket/")
public class WebSocketController extends BaseController {
	
	private static final Logger logger=LoggerFactory.getLogger(WebSocketController.class);

	@RequestMapping("enterWebSocket")
	public String enterWebSocket() {
		return "system/websocket/webSocket";
	}
	

}
