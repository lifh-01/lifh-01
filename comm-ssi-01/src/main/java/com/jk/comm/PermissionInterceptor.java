package com.jk.comm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.gson.Gson;
import com.google.gson.JsonParser;


public class PermissionInterceptor extends HandlerInterceptorAdapter{
     
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("userInfo");
		String json = new Gson().toJson(obj);
		int userId = new JsonParser().parse(json).getAsJsonObject().get("userId").getAsInt();
		String uri = request.getRequestURI();
		String string = JedisUtil.getString(userId+"#treeList");
		List<Map<String,Object>> treeList=JsonUtil.fromJson(string, new ArrayList<Map<String,Object>>(){}.getClass());
		int flag=0;
		for (Map<String, Object> map : treeList) {
			Object url = map.get("url");
			if(null==url){
				continue;
			}else if(uri.contains(url.toString())){
				flag=1;
				break;
			}
		}
		if(flag==1){
			return true;
		}else{
			return false;
		}	
	}
}
