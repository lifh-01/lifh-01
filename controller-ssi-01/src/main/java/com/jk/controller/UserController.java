package com.jk.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.SocketException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.jk.comm.DateUtil;
import com.jk.comm.FTPUtil;
import com.jk.comm.FileUtil;
import com.jk.comm.JedisUtil;
import com.jk.comm.JsonUtil;
import com.jk.comm.MySessionContext;
import com.jk.entity.MenuRequest;
import com.jk.entity.MenuResponse;
import com.jk.entity.RequestFiles;
import com.jk.entity.RequestUser;
import com.jk.entity.ResponseFiles;
import com.jk.entity.ResponseUser;
import com.jk.service.UserService;

@Controller
public class UserController {
     
	
	 
	
	  @Resource
	  private UserService userService;
	  
	 
	  /**
	   * <pre>uploder(注册时上传头像)   
	   * 创建人：李富豪     
	   * 创建时间：2017年7月21日 上午9:24:55    
	   * 修改人：李富豪       
	   * 修改时间：2017年7月21日 上午9:24:55    
	   * 修改备注： </pre>
	   */
	 /* @RequestMapping("uploder")
	  public void uploder(@RequestParam(value = "userNameImg", required = false) MultipartFile file, HttpServletRequest request, ModelMap model,HttpServletResponse response ){
		    String realPath = request.getSession().getServletContext().getRealPath("upImg");
		    PrintWriter writer=null;
		    File fileCheck = new File(realPath);
			if(!fileCheck.exists()){ //判断文件是否存在
				fileCheck.mkdir(); //根据文件的路径  创建文件夹
			}
			//重命名文件名  保证文件的唯一性
			String imgUrl = "\\"+UUID.randomUUID().toString()+file.getOriginalFilename();		
			String url = "upImg"+imgUrl;
	        String path=realPath+imgUrl;
	        File newFile=new File(path);
	        try {
	        	//将图片写入文件夹
				file.transferTo(newFile);
				writer = response.getWriter();
			}  catch (IOException e) {
				e.printStackTrace();
			}
	        writer.println(url);
	        writer.close();
	  }*/
	  
	  
	 @RequestMapping("uploder")
	 @ResponseBody
	  public void uploder(@RequestParam(value = "userNameImg", required = false) MultipartFile file, HttpServletRequest request, ModelMap model,HttpServletResponse response ){
		
		 Map<String,Object> map = new HashMap<String,Object>();
		    PrintWriter writer = null;
		    response.setCharacterEncoding("utf-8");
		
		    try {
		    	writer=response.getWriter();
				InputStream stream = file.getInputStream();
				String md5 = FileUtil.getMD5(stream, "md5");
				RequestFiles requestFiles= new RequestFiles();
				requestFiles.setFileFingerprint(md5);
				ResponseFiles responseFiles = userService.queryUserPhotoMd(requestFiles);
				if(null!=responseFiles&&md5.equals(responseFiles.getFileFingerprint())){
					map.put("logMsg", "上传成功");
					map.put("dataHref",responseFiles.getFileHref()+"/"+responseFiles.getFileName());
				}else{
					String originalFilename = file.getOriginalFilename();
					String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
					String fileName=UUID.randomUUID().toString()+suffix;
					String path = "img/"+DateUtil.formatDateToString(new Date(), "yyyy/MM/dd");
					boolean uploadFile = FTPUtil.uploadFile(file.getInputStream(), fileName, path);
					if(uploadFile){
						requestFiles.setFileHref(path);
						requestFiles.setFileFingerprint(md5);
						requestFiles.setFileName(fileName);
						userService.insertFiles(requestFiles);
						map.put("logMsg", "上传成功");
						map.put("dataHref",path+"/"+fileName);
					}
				}
				
			} catch (Exception e) {
				map.put("logMsg", "上传失败");
			} 
		    String jsonString = JSON.toJSONString(map);
		    writer.println(jsonString);
	  }
	  
	  /**
	   * <pre>checkUserName(根据用户名查看该用户石否存在)   
	   * 创建人：李富豪     
	   * 创建时间：2017年7月20日 下午5:33:30    
	   * 修改人：李富豪       
	   * 修改时间：2017年7月20日 下午5:33:30    
	   * 修改备注： 
	   * @param requestUser
	   * @return</pre>
	   */
	  @RequestMapping("checkUserName")
	  @ResponseBody
	  public Map<String,Object> checkUserName(RequestUser requestUser){
		  Map<String,Object> map=userService.queryUserByUserName(requestUser);
		  return map;
	  }
	  
	  
	  
	  /**
	   * <pre>login(用户登陆)   
	   * 创建人：李富豪     
	   * 创建时间：2017年7月20日 下午5:33:12    
	   * 修改人：李富豪       
	   * 修改时间：2017年7月20日 下午5:33:12    
	   * 修改备注： 
	   * @param requestUser
	   * @param request
	   * @return</pre>
	   */
	  @ResponseBody
	  @RequestMapping({"login"})
	  public Map<String,Object> login(RequestUser requestUser ,HttpServletRequest request){
		  HttpSession session = request.getSession();
		  Object objCode = session.getAttribute("imageCode");
		  if(null==objCode){
			  objCode="";			  
		  }
		  requestUser.setSysImgCode(objCode.toString());
		  Map<String,Object> map =userService.login(requestUser);
		  if(null!=map.get("userInfo")){
			  session.setAttribute("userInfo", map.get("userInfo"));
			  ResponseUser responseUser = (ResponseUser) map.get("userInfo");
			  String userId = responseUser.getUserId().toString();
			  MySessionContext.FailureSession(userId,session);
			  MySessionContext.addSession(session, userId);
			  
			 
			  //登陆成功之后去查询权限菜单
			  MenuRequest menuRequest=new MenuRequest();
			  menuRequest.setUserId(responseUser.getUserId());
			  List<MenuResponse> treeList = userService.selectUserMenuListJson(menuRequest);
			  //把查询到的结果存入redis中
			  JedisUtil.setString(userId+"#treeList", JsonUtil.toJsonString(treeList), -1);
		  }
		  return map;
	  }
	  
	  /**
	   * <pre>loadImgUser(加载头像)   
	   * 创建人：李富豪     
	   * 创建时间：2017年7月24日 上午8:25:20    
	   * 修改人：李富豪       
	   * 修改时间：2017年7月24日 上午8:25:20    
	   * 修改备注： 
	   * @return</pre>
	   */
	  @ResponseBody
	  @RequestMapping("loadImgUser")
	  public Map<String,Object> loadImgUser(RequestUser requestUser){
		  ResponseUser responseUser=userService.loadImgUser(requestUser);
		  Map<String,Object> map = new HashMap<String,Object>();
		  if(null!=responseUser){
			  map.put("img", responseUser.getUserNameImg());
		  }else{
			  map.put("img", false);
		  }
		  return map;
	  }
	  
	  /**
	   * <pre>loginOut(退出登陆销毁session)   
	   * 创建人：李富豪     
	   * 创建时间：2017年7月22日 上午8:50:49    
	   * 修改人：李富豪       
	   * 修改时间：2017年7月22日 上午8:50:49    
	   * 修改备注： 
	   * @param request
	   * @return</pre>
	   */
	  @RequestMapping("loginOut")
	  public String loginOut(HttpServletRequest request){
		  HttpSession session = request.getSession();
		  session.invalidate();
		  return "redirect:index.jsp";
	  }
	  
	  /**
	   * <pre>registerUser(把用户提交的注册信息存到数据库)   
	   * 创建人：李富豪     
	   * 创建时间：2017年7月22日 上午8:53:53    
	   * 修改人：李富豪       
	   * 修改时间：2017年7月22日 上午8:53:53    
	   * 修改备注： 
	   * @return</pre>
	   */
	  @ResponseBody
	  @RequestMapping("registerUserLog")
	  public Map<String,Boolean> registerUser(RequestUser requestUser){
		  Map<String,Boolean> map = new HashMap<String,Boolean>();
		    try {
		    	userService.registerUser(requestUser);
		    	map.put("bool", true);
			} catch (Exception e) {
				map.put("bool", false);
			}
		  return map;
	  }
	  
	  /**
	   * <pre>queryUserData(加载用户信息)   
	   * 创建人：李富豪     
	   * 创建时间：2017年7月24日 下午1:57:41    
	   * 修改人：李富豪       
	   * 修改时间：2017年7月24日 下午1:57:41    
	   * 修改备注： 
	   * @return</pre>
	   */
	  @ResponseBody
	  @RequestMapping("queryUserData")
	  public Map<String,Object> queryUserData(String pageNumber,String pageSize, RequestUser requestUser){
			Integer pageNumbers = Integer.parseInt(pageNumber);
			Integer pageSizes = Integer.parseInt(pageSize);
			//开始位置
			requestUser.setPageStart(pageSizes*(pageNumbers-1)+1);
			//结束位置
			requestUser.setPageEnd(pageSizes*pageNumbers);
			//分页查询结果
			List<ResponseUser> responseList = userService.queryUserData(requestUser);
			Long count =userService.queryUserCount();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("total", count);
			map.put("rows", responseList);
			return map;
	  }
	  
	  /**
	   * <pre>deleteCheckedUser(删除一个用户)   
	   * 创建人：李富豪     
	   * 创建时间：2017年7月26日 下午10:15:32    
	   * 修改人：李富豪       
	   * 修改时间：2017年7月26日 下午10:15:32    
	   * 修改备注： </pre>
	   */
	  @RequestMapping("deleteCheckedUser")
	  @ResponseBody
	  public String deleteCheckedUser(RequestUser requestUser){
		  userService.deleteCheckedUser(requestUser);
		  return "{}";
	  }
	  
	  /**
	   * <pre>insertUser(判断是新增还是修改)   
	   * 创建人：李富豪     
	   * 创建时间：2017年7月27日 下午7:52:27    
	   * 修改人：李富豪       
	   * 修改时间：2017年7月27日 下午7:52:27    
	   * 修改备注： 
	   * @return</pre>
	   */
	  @RequestMapping("insertUser")
	  public String insertUser(Model m ,RequestUser requestUser){
		  if(null!=requestUser&&null!=requestUser.getUserId()){
			  ResponseUser responseUser =userService.selectUserAccountByUserId(requestUser);
		      m.addAttribute("responseUser", responseUser);
		  }
		  return"add_user";
	  }
	  
	  /**
	   * <pre>insertUserOrUpdateUser(修改或者删除)   
	   * 创建人：李富豪     
	   * 创建时间：2017年7月27日 下午8:41:39    
	   * 修改人：李富豪       
	   * 修改时间：2017年7月27日 下午8:41:39    
	   * 修改备注： 
	   * @param requestUser
	   * @return</pre>
	   */
	  @RequestMapping("insertUserOrUpdate")
	  @ResponseBody
	  public String insertUserOrUpdateUser(RequestUser requestUser){
		  if(null!=requestUser&&null!=requestUser.getUserId()){
			  userService.UpdateUser(requestUser);
		  }else{
			  userService.insertUser(requestUser);
		  }
		  return "{}";
	  }
}
