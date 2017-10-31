package subject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Course;
import beans.Pair;
import database.CourseUtils;
import servlet_home.HomeServlet;
import servlet_login.SelectRoleServlet;

/**
 * Servlet implementation class CourseList
 */
@WebServlet("/CourseList")
public class CourseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PREVIOUS = "previous";
	private static final String NEXT = "next";
	
	List<Course> courseList;
	Course [] courses;
	int pageIndex;	//Vị trí của trang hiện tại đc hiển thị
	boolean isFinalPage;
	List<Pair> indexList;		//  lưu trữ vị trí đầu và cuối của từng trang
								//	VD: tại trang thứ 3 hiển thị từ courses[32] - courses[44] thì indexList.get(3) = Pair(32, 44)
	boolean isCallInitMethod = false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseList() {
    	System.out.println("constructor CourseList");
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	System.out.println("init CourseList");
    	CourseUtils cu = new CourseUtils();
		cu.connect();
		courses = cu.getAllCoursesArray(HomeServlet.currentTerm);
    	courseList = new ArrayList<>();
    	indexList = new ArrayList<>();
    	isCallInitMethod = true;
    }
    
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	super.destroy();
    	System.out.println("destroy CourseList");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid, eid;
		if(!isCallInitMethod) {
			CourseUtils cu = new CourseUtils();
			cu.connect();
			courses = cu.getAllCoursesArray(HomeServlet.currentTerm);
	    	courseList = new ArrayList<>();
	    	indexList = new ArrayList<>();
	    	isCallInitMethod = true;
		}
		if(indexList.size() > 0) {
			pageIndex = 0;
			isFinalPage = false;
			courseList.clear();
			sid = indexList.get(0).getFirst();
			eid = indexList.get(0).getSecond();
			for(int i = sid; i <= eid; i++) {
				courseList.add(courses[i]);
			}
		} else {
			pageIndex = 0;
	    	isFinalPage = false;
			courseList.clear();
			eid = 9;
			for(int i = 0; i <= eid; i++) {
				courseList.add(courses[i]);
				if(courses[i].getCourseID() == courses[i+1].getCourseID()) eid++;		//10 lớp học đầu tiên trong tất cả các lớp học của kỳ này. Ý tưởng: mỗi lần chỉ hiển thị 10 lớp, muốn xem tiếp phải ấn next/previous
			}
			indexList.add(new Pair(0, eid));
		}
		
		System.out.println("doGet()! indexList.size = " + indexList.size());
		request.setAttribute("courseList", courseList);
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/" + SelectRoleServlet.roleOfUser +"/course_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestIndex = request.getParameter("requestIndex");
		if(PREVIOUS.equals(requestIndex)) {
			if(pageIndex > 0) {
				pageIndex--;
				isFinalPage = false;
			}
			else {
				request.setAttribute("errorString", "This is the first page, can't go previous!");
			}
		} else if(NEXT.equals(requestIndex) && !isFinalPage) {
			pageIndex++;
		}
		
		courseList.clear();
		if(indexList.size() > pageIndex) {
			//nếu như trang này đã duyệt qua 1 lần rồi
			int sid = indexList.get(pageIndex).getFirst();
			int eid = indexList.get(pageIndex).getSecond();

			for(int i = sid; i <= eid; i++) {
				courseList.add(courses[i]);
			}
		} else {
			//nếu như trang này chưa đc duyệt qua lần nào, nghĩa là người dùng từ trước tới giờ chỉ ấn next mà ko ấn previous 
			int sid = indexList.get(pageIndex - 1).getSecond() + 1;
			int eid = sid + 9;
			for(int i = sid; i <= eid; i++) {
				if(courses[i] == null) {
					if(i == sid) {
						isFinalPage = true;		//nếu thằng đầu tiên mà null chứng tỏ trang này ko có môn nào
						request.setAttribute("errorString", "There's no course left to display!");
					}
					//Nếu i != sid nghĩa là trang này có số môn < 10
					eid = i - 1;	//tại vị trí thứ i, courses[i] == null nên cần sửa lại eid
					break;
				}
				courseList.add(courses[i]);
				if(courses[i+1] != null) {
					if(courses[i].getCourseID() == courses[i+1].getCourseID()) eid++;
				}
			}
			if(courses[sid] != null) indexList.add(new Pair(sid, eid));
		}

		System.out.println("pageIndex = " + pageIndex);
		System.out.println("indexList.size() = " + indexList.size());
		request.setAttribute("courseList", courseList);
		request.getServletContext().getRequestDispatcher("/WEB-INF/jsps/" + SelectRoleServlet.roleOfUser +"/course_list.jsp").forward(request, response);
	}
}
