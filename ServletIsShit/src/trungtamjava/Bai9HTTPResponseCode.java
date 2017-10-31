package trungtamjava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
Status code

Status code là thông tin quan trọng server trả về cho client, cho biết kết quả xử lý request của server. Các loại status code thường gặp:

1xx: Informational Messages

Loại status code này được mô tả ở HTTP/1.1 và hoàn toàn mang tính chất tạm thời, client có thể bỏ qua chúng.

2xx: Successful

Server trả về status dạng này khi đã xử lý thành công request của client. Đối với GET request, dữ liệu trả về nằm trong message body. Phổ biến nhất là mã 200 OK. Ngoài ra còn có:

202 Accepted: request từ client đã được chấp nhận nhưng có thể server không trả về kết quả cho client. Điều này hữu dụng trong trường hợp xử lý bất đồng bộ phía server: server thông báo cho client không phải tiếp tục chờ đợi cho tới khi quá trình xử lý trên server hoàn tất.
204 No content: không có phần message body trong response.
205 Reset content: tương tự như 204, nhưng mã trả về này yêu cầu client reset document view.
206 Partial content: server chỉ gửi về một phần dữ liệu phụ thuộc và giá trị range header client gửi lên. Giá trị này được sử dụng bởi các tool hỗ trợ download như wget, IDM để phân mảnh dữ liệu thành nhiều phần nhằm tải về đồng thời hoặc hỗ trợ tiếp tục download khi bị ngắt giữa chừng.
3xx: Redirection

Server thông báo cho client phải thực hiện thêm action để hoàn thành request.

301 Moved Permanently: resource đã được chuyển hoàn toàn tới địa chỉ trong trường Location của response.
303 See Other: resource được chuyển tạm thời tới địa chỉ trong trường Location của response.
304 Not Modified: resource không thay đổi từ lần cuối cùng client gửi request, và client nên sử dụng dữ liệu đã lưu trong bộ nhớ cache. Điều này được thực hiện bằng cách khi gửi request, client gửi đi trường ETag là định danh của phần dữ liệu đã request lần trước, server so sánh với trường ETag ứng với dữ liệu của nó để kiểu tra sự thay đổi.
4xx: Client Error

400 Bad Request: request không đúng định dạng, cú pháp.
401 Unauthorized: client chưa xác thực.
403 Forbidden: client không có quyền truy cập.
404 Not Found: không tìm thấy resource.
405 Method Not Allowed: phương thức (HTTP verb) không được server hỗ trợ.
5xx: Server Error

Có lỗi xảy ra trong quá trình xử lý của server. Mã 500 Internal Server Error là phổ biến nhất.

501 Not Implemented: server không hỗ trợ chức năng client yêu cầu.
503 Service Unavailable: một thành phần xử lý trên server bị lỗi hoặc server bị quá tải.
 */

@WebServlet(urlPatterns={"/test-code"})

public class Bai9HTTPResponseCode extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		//resp.sendError(404);
		resp.sendError(500);
		PrintWriter pw = resp.getWriter();
		pw.println("Ko the hien ra dong nay o phia client neu sendError(500)");
		
	}
	
}
