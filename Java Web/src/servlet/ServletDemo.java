package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//直接继承servlet实现servlet方法
public class ServletDemo implements Servlet{
	public ServletDemo() {
		System.out.println("constructor");
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println(config.getInitParameter("username"));
		System.out.println(config.getInitParameterNames());
		System.out.println("init");
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//通过ServletRequest
		HttpServletRequest httpServletRequest = (HttpServletRequest) req;
		String method = httpServletRequest.getMethod();
		if (method.equals("GET")) {
			doGet();
		}
		else if (method.equals("POST")) {
			doPost();
		}
		
	}

	private void doPost() {
		System.out.println("POST");
		
	}

	private void doGet() {
		System.out.println("GET");
		
	}

}
