package com.application.system.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.application.common.GlobalConstants;

public class StaticSourceTag extends TagSupport {
	
	private final static String webroot = GlobalConstants.GLOAB_WEB_ROOT;
	
	private String title = "";
	
	private String type = "";
	
	@Override
	public int doStartTag() throws JspException {
		try {
			// 默认风格
			//HttpServletRequest request = (HttpServletRequest) super.pageContext.getRequest();
			//Cookie[] cookies = request.getCookies();
			JspWriter out = this.pageContext.getOut();
			StringBuffer sb = new StringBuffer();
			String types[] = type.split(",");
			sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
			if(!"".equals(title)){
				sb.append("<title>"+title+"</title>");
			}
			//layui_css
			//<link rel="stylesheet" href="//res.layui.com/layui/dist/css/layui.css?t=1522709297490"  media="all">
			if (exists("layui_css", types)) {
				sb.append("<link rel=\"stylesheet\" href=\"").append(webroot).append("/public/js/common/layui/css/layui.css\"></link> \n");
			}
			//jquery
			if (exists("jquery", types)) {
                sb.append("<script type=\"text/javascript\" src=\"").append(webroot).append("/public/js/common/jquery/jquery.min.js\"></script> \n");
			}
			//layui
			if (exists("layui", types)) {
				sb.append("<script type=\"text/javascript\" src=\"").append(webroot).append("/public/js/common/layui/layui.all.js\"></script> \n");
			}
		
			//添加ctx js
			sb.append("<script type=\"text/javascript\">var ctxPath = '").append(webroot).append("';</script> \n"); 
			//IE8
//			sb.append("<!--[if lte IE 8]><link href=\"").append(webroot).append("/public/bootstrap/css/custom_ie8.css\" rel=\"stylesheet\"><![endif]--> \n");
			out.print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return EVAL_PAGE;
	}
	
	public boolean exists(String substring, String[] source) {
		if (source == null || source.length == 0) {
			return false;
		}
		for (int i = 0; i < source.length; i++) {
			String aSource = source[i];
			if (aSource.equals(substring)) {
				return true;
			}
		}
		return false;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
