package com.revature.web;

import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
@RequestMapping("/applyToMoveRest")
public class ApplyToMoveRestController
{
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Boolean applyToMove_JSON(@RequestBody String tester, HttpSession session, ModelMap modelMap){
		
		JsonElement jelement = new JsonParser().parse(tester);
		JsonObject jobject = jelement.getAsJsonObject();
		
		boolean result = applyToMove(false);
		return result;
	}
	
	public boolean applyToMove(boolean b){
		
		return false;
	}
}
