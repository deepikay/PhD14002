

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VideoData
 */
public class VideoData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArrayList<Video> video_list = new ArrayList<Video>();
     
    
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public VideoData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method 
		//PrintWriter out = response.getWriter();
        //out.println("Hello Android !!!!");
		//response.setContentType("text/plain");
		//response.getWriter().write("Hello Android !!!!");
		response.setContentType("text/plain");
		
		for(Video v : this.video_list){
		response.getWriter().write(v.getFile_name()+"\n"+v.getUrl());
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/plain");
		 
		 String file_name = request.getParameter("file_name");
		 String file_size = request.getParameter("file_size");
		 String duration_str = request.getParameter("duration");
		 String type = request.getParameter("type");
		 String url = request.getParameter("url");
		 
		 long duration = -1;
		 
		 try{
			 duration = Long.parseLong(duration_str);
		 }catch(NumberFormatException e){
			 
		 }
		 
		 if(file_name == null || file_size == null || duration_str == null||
				 file_name.trim().length() < 1 ||file_size.trim().length() < 1 
				 || duration_str.trim().length() < 1 || duration <= 0
				 )
		 {
			 
			 response.sendError(400);
			 response.getWriter().write("\nWrong input");
		 }else{
			 video_list.add(new Video(file_name,file_size,duration,type ,url));
			 
			 
			 response.getWriter().write("\nvideo data added");
			 for(Video v : this.video_list){
					System.out.println(v.getFile_name()+"\n"+v.getUrl());
					}
		 	
		 }
	}

	
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/plain");
		 boolean present = false;
		 
		 String file_name = request.getParameter("file_name");
		 String file_size = request.getParameter("file_size");
		 String duration_str = request.getParameter("duration");
		 String type = request.getParameter("type");
		 String url = request.getParameter("url");
		 
		 long duration = -1;
		 
		 try{
			 duration = Long.parseLong(duration_str);
		 }catch(NumberFormatException e){
			 
		 }
		 
		 	 
		 for(Video v : this.video_list){
				
			 
			 if(v.getFile_name().equalsIgnoreCase(file_name)){
				
				 present = true;
				 if(file_name == null || file_size == null || duration_str == null||
						 file_name.trim().length() < 1 ||file_size.trim().length() < 1 
						 || duration_str.trim().length() < 1 || duration <= 0
						 )
				 {
					 
					 response.sendError(400);
					 response.getWriter().write("\nWrong input");
				 }
				 else{
					 
					 
					 v.setFile_name(file_name);
					 v.setFile_size(file_size);
					 v.setDuration(duration);
					 v.setType(type);
					 v.setUrl(url);
					 response.getWriter().write("\nvideo data updated");
					 
					 
				 }
				 
			 }
			 else{
				 present = false;
				 if(file_name == null || file_size == null || duration_str == null||
						 file_name.trim().length() < 1 ||file_size.trim().length() < 1 
						 || duration_str.trim().length() < 1 || duration <= 0
						 )
				 {
					 
					 response.sendError(400);
					 response.getWriter().write("\nWrong input");
				 }else{
					 video_list.add(new Video(file_name,file_size,duration,type ,url));
					 
					 
					 response.getWriter().write("\nvideo data added");
					 
				 	
				 }
				 
			 }
		 }
		 
		 
		 
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain");
		String file_name = request.getParameter("file_name");
		for(Video v : this.video_list){
			
			if(v.getFile_name()==file_name){
			
				video_list.remove(v);
			}
		}
	
	}
	
}
