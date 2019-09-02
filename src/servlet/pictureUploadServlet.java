package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import domian.picturefile;
import service.pictureUploadService;

@WebServlet("/pictureUploadServlet")
public class pictureUploadServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	picturefile picturefile = new picturefile();
	pictureUploadService pictureUploadservice = new pictureUploadService();
	
	//获取所有的已上传文件
	public String getAllPicFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<domian.picturefile> allPicFile = pictureUploadservice.getAllPicFile();
			Collections.reverse(allPicFile);
			HttpSession session = request.getSession();
			session.setAttribute("allPicFile", allPicFile);
			return "admin/picture_upload.jsp";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//删除以上传文件
	public String deletePicFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			pictureUploadservice.deletePicFile(id);
			return "/pictureUploadServlet?action=getAllPicFile";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	//用户端根据用户名查看照片
	public String getPicFileWname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("我的照片呢");
		String cname = request.getParameter("cname");
		System.out.println("用户名"+cname);
		try {
			domian.picturefile picFileWname = pictureUploadservice.getPicFileWname(cname);
			System.out.println(picFileWname);
			HttpSession session = request.getSession();
			session.setAttribute("picFileWname", picFileWname);
			return "/user/ord_form.jsp";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	//上传文件
	public String PictureUpLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户名并封装为对象
		String name = request.getParameter("name");
		System.out.println("前端获得的name是："+name);
		Map<String, Object> map = new HashMap<String, Object>();
		String savepath = "";
		// 打印map.size
		System.out.println("map.size--" + map.size());
		System.out.println("map.path---" + map.get("name"));
		//生成文件上传的路径和名称
		try {
			savepath = uploadFile(request, response, map);
			System.out.println("map.size--" + map.size());
			System.out.println("savepath===" + savepath);
			map.put("savepath", savepath);
			map.put("name", name);
			System.out.println("map====="+map.get(0));
			picturefile.setUsername("renjian");
			picturefile.setFile_add(savepath);
			System.out.println("picturefile里的name是："+name);
			System.out.println("picturefile里的PictureUpload是："+savepath);
			System.out.println("分装的picturefile是"+picturefile);
			//调用Service，将文件的信息录入数据库
			pictureUploadservice.add(picturefile);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/pictureUploadServlet?action=getAllPicFile";
	
	}

	
	//将文件下载到本地
	public void PictureDownLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("下载了哈哈哈");
		String filename = request.getParameter("path");
		System.out.println(filename);
		// GET请求中，参数中包含中文需要自己动手来转换。
		// 如果使用了“全局编码过滤器”，那么这里就不用处理了
		String filepath = this.getServletContext().getRealPath( filename);
		System.out.println("我是filepath呀："+filepath);
		File file = new File(filepath);
		if(!file.exists()) {
			response.getWriter().print("file is none");
		 //response.getWriter().print("您要下载的文件不存在！");
		 return;
		}
		// 所有浏览器都会使用本地编码，即中文操作系统使用GBK
		// 浏览器收到这个文件名后，会使用iso-8859-1来解码
		filename = new String(filename.getBytes("GBK"), "ISO-8859-1");
		response.addHeader("content-disposition", "attachment;filename=" + filename);
		IOUtils.copy(new FileInputStream(file), response.getOutputStream());
			
		}

	
	//上传文件
	public String uploadFile(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> map)
			throws IOException, FileUploadException {
		// 得到上传文件的保存目录，将要上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		String savePath = "E:\\eclipe\\apache-tomcat-8.5.34\\webapps\\Photo_Stu2\\upload";
		// 上传生成的临时文件保存目录
		//String tempPath = "F:\\appupload\\temp";
		String tempPath = "E:\\eclipe\\apache-tomcat-8.5.34\\webapps\\Photo_Stu2\\temp";
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			// 创建临时目录
			tmpFile.mkdir();
		}
		// 消息提示
		String message = "";
		String realSavePath = "";
		String saveFileName = "";
		// 使用Apache文件上传组件处理文件上传步骤：
		// 1.创建一个DiskFileItemFactory工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置工厂缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录中
		factory.setSizeThreshold(1024 * 100);// 设置缓冲区大小为100kb,如果不指定，那么缓冲区默认大小10kb
		// 设置上传时文件生成的临时文件的保存目录
		factory.setRepository(tmpFile);
		// 创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 监听文件上传进度
		upload.setProgressListener(new ProgressListener() {

			public void update(long pBytesRead, long pContentLength, int arg2) {
				System.out.println("文件的大小为：" + pContentLength + "当前已处理："
						+ pBytesRead);
			}
		});
		// 解决上传文件名的中文乱码
		upload.setHeaderEncoding("UTF-8");
		// 3.判断提交上来的数据是否是上传表单的数据
		if (!ServletFileUpload.isMultipartContent(request)) {
			// 按照传统方式获取数据
			return null;
		}

		// 设置上传单个文件的大小的最大值，目前设置的是1MB.即1024*1024字节
		upload.setFileSizeMax(1024 * 1024);
		// 设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
		upload.setSizeMax(10 * 1024 * 1024);
		// 4.使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FIleItem>集合，每一个FileItem对应一个Form表单的输入项
		List<FileItem> list;
		list = upload.parseRequest(request);
		for (FileItem item : list) {
			// 如果fileitem中封装的是普通输入项的数据
			if (item.isFormField()) {
				String name = item.getFieldName();
				String value = item.getString("UTF-8");
				System.out.println(name + "=" + value);
				map.put(name, value);
				System.out.println("mapsize=" + map.size());
			} else {
				// 如果fileitem中封装的是上传文件
				// 得到上传的文件名称
				String filename = item.getName();
				System.out.println(filename);
				if (filename == null || filename.trim().equals("")) {
					continue;
				}
				// 注意，不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：c:\a\b\1.txt,而有些只是单纯的文件名，如：1.txt
				// 处理获取到的上传文件的文件名的路径部分，只保留文件名的部分
				filename = filename.substring(filename.lastIndexOf("\\") + 1);
				// 得到上传文件的扩展名
				String fileExtName = filename.substring(filename
						.lastIndexOf(".") + 1);
				// 如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
				System.out.println("上传的文件的扩展名是：" + fileExtName);
				// 获取item中的上传文件的输入流
				InputStream in = item.getInputStream();
				// 得到文件保存的名称
				saveFileName = makeFileName(filename);
				picturefile.setFilename(filename);
				// 得到文件的保存目录
				realSavePath = makePath(saveFileName, savePath);
				System.out.println("path==" + realSavePath);
				System.out.println("filename==" + saveFileName);
				// realSavePath=realSavePath.i
				// 创建一个文件输出流
				OutputStream out = new FileOutputStream(realSavePath + "\\"
						+ saveFileName);
				// 创建一个缓冲区
				byte buffer[] = new byte[1024];
				// 判断输入流中的数据是否已经读完的标识
				int len = 0;
				// 循环将输入流督导缓冲区当中，(len = in.read(buffer)) > 0表示in里面还有数据
				while ((len = in.read(buffer)) > 0) {
					// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath+"\\"+filename)中
					out.write(buffer, 0, len);
				}
				// 关闭输入流
				in.close();
				// 关闭输出流
				out.close();
				// 删除处理文件上传时生成的临时文件
				// item.delete();
				message = "文件上传成功！";
				realSavePath = realSavePath.substring(realSavePath
						.indexOf("\\upload") + 1);
				System.out.println("resavepath" + realSavePath);
				realSavePath = realSavePath.replaceAll("\\\\", "/");
				System.out.println("resavepath" + realSavePath);

			}
		}
		return realSavePath + "/" + saveFileName;
	}

	/**
	 * 为防止一个目录下面出现太多文件，要使用hash算法打散存储
	 * @Method:makePath
	 * @param filename   文件名，要根据文件名生成存储目录
	 * @param savePath   文件存储路径
	 * @return 新的存储目录
	 */
	private String makePath(String filename, String savePath) {
		// 得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
		int hashcode = filename.hashCode();
		
		int dir1 = hashcode & 0xf;// 0-15
		int dir2 = (hashcode & 0xf0) >> 4;// 0-15
		// 构造新的保存目录
		String dir = savePath + "\\" + dir1 + "\\" + dir2;// upload\2\3
															// upload\3\5
		// File既可以代表文件也可以代表目录
		File file = new File(dir);
		if (!file.exists()) {
			// 创建目录
			file.mkdirs();
		}
		return dir;
	}

	private String makeFileName(String filename) {
		// 为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
		return UUID.randomUUID().toString() + "_" + filename;
	}


}
