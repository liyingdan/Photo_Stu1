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
	
	//��ȡ���е����ϴ��ļ�
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
	
	//ɾ�����ϴ��ļ�
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
	
	
	//�û��˸����û����鿴��Ƭ
	public String getPicFileWname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("�ҵ���Ƭ��");
		String cname = request.getParameter("cname");
		System.out.println("�û���"+cname);
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
	
	
	
	//�ϴ��ļ�
	public String PictureUpLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�û�������װΪ����
		String name = request.getParameter("name");
		System.out.println("ǰ�˻�õ�name�ǣ�"+name);
		Map<String, Object> map = new HashMap<String, Object>();
		String savepath = "";
		// ��ӡmap.size
		System.out.println("map.size--" + map.size());
		System.out.println("map.path---" + map.get("name"));
		//�����ļ��ϴ���·��������
		try {
			savepath = uploadFile(request, response, map);
			System.out.println("map.size--" + map.size());
			System.out.println("savepath===" + savepath);
			map.put("savepath", savepath);
			map.put("name", name);
			System.out.println("map====="+map.get(0));
			picturefile.setUsername("renjian");
			picturefile.setFile_add(savepath);
			System.out.println("picturefile���name�ǣ�"+name);
			System.out.println("picturefile���PictureUpload�ǣ�"+savepath);
			System.out.println("��װ��picturefile��"+picturefile);
			//����Service�����ļ�����Ϣ¼�����ݿ�
			pictureUploadservice.add(picturefile);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/pictureUploadServlet?action=getAllPicFile";
	
	}

	
	//���ļ����ص�����
	public void PictureDownLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("�����˹�����");
		String filename = request.getParameter("path");
		System.out.println(filename);
		// GET�����У������а���������Ҫ�Լ�������ת����
		// ���ʹ���ˡ�ȫ�ֱ��������������ô����Ͳ��ô�����
		String filepath = this.getServletContext().getRealPath( filename);
		System.out.println("����filepathѽ��"+filepath);
		File file = new File(filepath);
		if(!file.exists()) {
			response.getWriter().print("file is none");
		 //response.getWriter().print("��Ҫ���ص��ļ������ڣ�");
		 return;
		}
		// �������������ʹ�ñ��ر��룬�����Ĳ���ϵͳʹ��GBK
		// ������յ�����ļ����󣬻�ʹ��iso-8859-1������
		filename = new String(filename.getBytes("GBK"), "ISO-8859-1");
		response.addHeader("content-disposition", "attachment;filename=" + filename);
		IOUtils.copy(new FileInputStream(file), response.getOutputStream());
			
		}

	
	//�ϴ��ļ�
	public String uploadFile(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> map)
			throws IOException, FileUploadException {
		// �õ��ϴ��ļ��ı���Ŀ¼����Ҫ�ϴ����ļ������WEB-INFĿ¼�£����������ֱ�ӷ��ʣ���֤�ϴ��ļ��İ�ȫ
		String savePath = "E:\\eclipe\\apache-tomcat-8.5.34\\webapps\\Photo_Stu2\\upload";
		// �ϴ����ɵ���ʱ�ļ�����Ŀ¼
		//String tempPath = "F:\\appupload\\temp";
		String tempPath = "E:\\eclipe\\apache-tomcat-8.5.34\\webapps\\Photo_Stu2\\temp";
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			// ������ʱĿ¼
			tmpFile.mkdir();
		}
		// ��Ϣ��ʾ
		String message = "";
		String realSavePath = "";
		String saveFileName = "";
		// ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
		// 1.����һ��DiskFileItemFactory����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ���ù����������Ĵ�С�����ϴ����ļ���С�����������Ĵ�Сʱ���ͻ�����һ����ʱ�ļ���ŵ�ָ������ʱĿ¼��
		factory.setSizeThreshold(1024 * 100);// ���û�������СΪ100kb,�����ָ������ô������Ĭ�ϴ�С10kb
		// �����ϴ�ʱ�ļ����ɵ���ʱ�ļ��ı���Ŀ¼
		factory.setRepository(tmpFile);
		// ����һ���ļ��ϴ�������
		ServletFileUpload upload = new ServletFileUpload(factory);
		// �����ļ��ϴ�����
		upload.setProgressListener(new ProgressListener() {

			public void update(long pBytesRead, long pContentLength, int arg2) {
				System.out.println("�ļ��Ĵ�СΪ��" + pContentLength + "��ǰ�Ѵ���"
						+ pBytesRead);
			}
		});
		// ����ϴ��ļ�������������
		upload.setHeaderEncoding("UTF-8");
		// 3.�ж��ύ�����������Ƿ����ϴ���������
		if (!ServletFileUpload.isMultipartContent(request)) {
			// ���մ�ͳ��ʽ��ȡ����
			return null;
		}

		// �����ϴ������ļ��Ĵ�С�����ֵ��Ŀǰ���õ���1MB.��1024*1024�ֽ�
		upload.setFileSizeMax(1024 * 1024);
		// �����ϴ��ļ����������ֵ�����ֵ=ͬʱ�ϴ��Ķ���ļ��Ĵ�С�����ֵ�ĺͣ�Ŀǰ����Ϊ10MB
		upload.setSizeMax(10 * 1024 * 1024);
		// 4.ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FIleItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
		List<FileItem> list;
		list = upload.parseRequest(request);
		for (FileItem item : list) {
			// ���fileitem�з�װ������ͨ�����������
			if (item.isFormField()) {
				String name = item.getFieldName();
				String value = item.getString("UTF-8");
				System.out.println(name + "=" + value);
				map.put(name, value);
				System.out.println("mapsize=" + map.size());
			} else {
				// ���fileitem�з�װ�����ϴ��ļ�
				// �õ��ϴ����ļ�����
				String filename = item.getName();
				System.out.println(filename);
				if (filename == null || filename.trim().equals("")) {
					continue;
				}
				// ע�⣬��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺c:\a\b\1.txt,����Щֻ�ǵ������ļ������磺1.txt
				// �����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ����Ĳ���
				filename = filename.substring(filename.lastIndexOf("\\") + 1);
				// �õ��ϴ��ļ�����չ��
				String fileExtName = filename.substring(filename
						.lastIndexOf(".") + 1);
				// �����Ҫ�����ϴ����ļ����ͣ���ô����ͨ���ļ�����չ�����ж��ϴ����ļ������Ƿ�Ϸ�
				System.out.println("�ϴ����ļ�����չ���ǣ�" + fileExtName);
				// ��ȡitem�е��ϴ��ļ���������
				InputStream in = item.getInputStream();
				// �õ��ļ����������
				saveFileName = makeFileName(filename);
				picturefile.setFilename(filename);
				// �õ��ļ��ı���Ŀ¼
				realSavePath = makePath(saveFileName, savePath);
				System.out.println("path==" + realSavePath);
				System.out.println("filename==" + saveFileName);
				// realSavePath=realSavePath.i
				// ����һ���ļ������
				OutputStream out = new FileOutputStream(realSavePath + "\\"
						+ saveFileName);
				// ����һ��������
				byte buffer[] = new byte[1024];
				// �ж��������е������Ƿ��Ѿ�����ı�ʶ
				int len = 0;
				// ѭ�����������������������У�(len = in.read(buffer)) > 0��ʾin���滹������
				while ((len = in.read(buffer)) > 0) {
					// ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath+"\\"+filename)��
					out.write(buffer, 0, len);
				}
				// �ر�������
				in.close();
				// �ر������
				out.close();
				// ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
				// item.delete();
				message = "�ļ��ϴ��ɹ���";
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
	 * Ϊ��ֹһ��Ŀ¼�������̫���ļ���Ҫʹ��hash�㷨��ɢ�洢
	 * @Method:makePath
	 * @param filename   �ļ�����Ҫ�����ļ������ɴ洢Ŀ¼
	 * @param savePath   �ļ��洢·��
	 * @return �µĴ洢Ŀ¼
	 */
	private String makePath(String filename, String savePath) {
		// �õ��ļ�����hashCode��ֵ���õ��ľ���filename����ַ����������ڴ��еĵ�ַ
		int hashcode = filename.hashCode();
		
		int dir1 = hashcode & 0xf;// 0-15
		int dir2 = (hashcode & 0xf0) >> 4;// 0-15
		// �����µı���Ŀ¼
		String dir = savePath + "\\" + dir1 + "\\" + dir2;// upload\2\3
															// upload\3\5
		// File�ȿ��Դ����ļ�Ҳ���Դ���Ŀ¼
		File file = new File(dir);
		if (!file.exists()) {
			// ����Ŀ¼
			file.mkdirs();
		}
		return dir;
	}

	private String makeFileName(String filename) {
		// Ϊ��ֹ�ļ����ǵ���������ҪΪ�ϴ��ļ�����һ��Ψһ���ļ���
		return UUID.randomUUID().toString() + "_" + filename;
	}


}
