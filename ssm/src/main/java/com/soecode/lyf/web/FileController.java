package com.soecode.lyf.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/file")
public class FileController {

	@RequestMapping("/toFile")
	public String toFileUpload() {
		System.out.println("成功进入");
		return "/imge/fileUpload";
	}

	@RequestMapping("/toFile2")
	public String toFileUpload2() {
		return "/imge/fileUpload2";
	}

	/**
	 * ����һ�ϴ��ļ�
	 */
	@RequestMapping("/onefile")
	public String oneFileUpload(
			@RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request, ModelMap model) {

		// ���ԭʼ�ļ���
		String fileName = file.getOriginalFilename();
		System.out.println("ԭʼ�ļ���:" + fileName);

		// ���ļ���
		String newFileName = UUID.randomUUID() + fileName;

		// �����Ŀ��·��
		ServletContext sc = request.getSession().getServletContext();
		// �ϴ�λ��
		String path = sc.getRealPath("/img") + "/"; // �趨�ļ������Ŀ¼

		File f = new File(path);
		if (!f.exists())
			f.mkdirs();
		if (!file.isEmpty()) {
			try {
				FileOutputStream fos = new FileOutputStream(path + newFileName);
				InputStream in = file.getInputStream();
				int b = 0;
				while ((b = in.read()) != -1) {
					fos.write(b);
				}
				fos.close();
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("�ϴ�ͼƬ��:" + path + newFileName);
		// �����ļ���ַ������JSPҳ�����
		model.addAttribute("fileUrl", path + newFileName);
		return "/imge/fileUpload";
	}

	/**
	 * �������ϴ��ļ���һ��һ��
	 */
	@RequestMapping("/onefile2")
	public String oneFileUpload2(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CommonsMultipartResolver cmr = new CommonsMultipartResolver(
				request.getServletContext());
		if (cmr.isMultipart(request)) {
			MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) (request);
			Iterator<String> files = mRequest.getFileNames();
			while (files.hasNext()) {
				MultipartFile mFile = mRequest.getFile(files.next());
				if (mFile != null) {
					String fileName = UUID.randomUUID()
							+ mFile.getOriginalFilename();
					String path = "E:/upload/" + fileName;

					File localFile = new File(path);
					mFile.transferTo(localFile);
					request.setAttribute("fileUrl", path);
				}
			}
		}
		return "/imge/fileUpload";
	}

	/**
	 * һ���ϴ�����ͼƬ
	 */
	@RequestMapping("/threeFile")
	public String threeFileUpload(
			@RequestParam("file") CommonsMultipartFile files[],
			HttpServletRequest request, ModelMap model) {

		List<String> list = new ArrayList<String>();
		// �����Ŀ��·��
		ServletContext sc = request.getSession().getServletContext();
		// �ϴ�λ��
		String path = sc.getRealPath("/img") + "/"; // �趨�ļ������Ŀ¼
		File f = new File(path);
		if (!f.exists())
			f.mkdirs();

		for (int i = 0; i < files.length; i++) {
			// ���ԭʼ�ļ���
			String fileName = files[i].getOriginalFilename();
			System.out.println("ԭʼ�ļ���:" + fileName);
			// ���ļ���
			String newFileName = UUID.randomUUID() + fileName;
			if (!files[i].isEmpty()) {
				try {
					FileOutputStream fos = new FileOutputStream(path
							+ newFileName);
					InputStream in = files[i].getInputStream();
					int b = 0;
					while ((b = in.read()) != -1) {
						fos.write(b);
					}
					fos.close();
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("�ϴ�ͼƬ��:" + path + newFileName);
			list.add(path + newFileName);

		}
		// �����ļ���ַ������JSPҳ�����
		model.addAttribute("fileList", list);
		return "/imge/fileUpload2";

	}

	/**
	 * �г����е�ͼƬ
	 */
	@RequestMapping("/listFile")
	public String listFile(HttpServletRequest request,
			HttpServletResponse response) {
		// ��ȡ�ϴ��ļ���Ŀ¼
		ServletContext sc = request.getSession().getServletContext();
		// �ϴ�λ��
		String uploadFilePath = sc.getRealPath("/img") + "/"; // �趨�ļ������Ŀ¼
		// �洢Ҫ���ص��ļ���
		Map<String, String> fileNameMap = new HashMap<String, String>();
		// �ݹ����filepathĿ¼�µ������ļ���Ŀ¼�����ļ����ļ����洢��map������
		listfile(new File(uploadFilePath), fileNameMap);// File�ȿ��Դ���һ���ļ�Ҳ���Դ���һ��Ŀ¼
		// ��Map���Ϸ��͵�listfile.jspҳ�������ʾ
		request.setAttribute("fileNameMap", fileNameMap);
		return "/imge/listFile";
	}

	public void listfile(File file, Map<String, String> map) {
		// ���file����Ĳ���һ���ļ�������һ��Ŀ¼
		if (!file.isFile()) {
			// �г���Ŀ¼�µ������ļ���Ŀ¼
			File files[] = file.listFiles();
			// ����files[]����
			for (File f : files) {
				// �ݹ�
				listfile(f, map);
			}
		} else {
			/**
			 * �����ļ������ϴ�����ļ�����uuid_�ļ�������ʽȥ���������ģ�ȥ���ļ�����uuid_����
			 * file.getName().indexOf
			 * ("_")�����ַ����е�һ�γ���"_"�ַ���λ�ã�����ļ��������ڣ�9349249849-88343-8344_��_��_��.avi
			 * ��ôfile.getName().substring(file.getName().indexOf("_")+1)
			 * ����֮��Ϳ��Եõ�
			 */
			String realName = file.getName().substring(
					file.getName().indexOf("_") + 1);
			// file.getName()�õ������ļ���ԭʼ���ƣ����������Ψһ�ģ���˿�����Ϊkey��realName�Ǵ����������ƣ��п��ܻ��ظ�
			map.put(file.getName(), realName);
		}
	}

	@RequestMapping("/downFile")
	public void downFile(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("1");
		// �õ�Ҫ���ص��ļ���
		String fileName = request.getParameter("filename");
		System.out.println("2");
		try {
			fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
			System.out.println("3");
			// ��ȡ�ϴ��ļ���Ŀ¼
			ServletContext sc = request.getSession().getServletContext();
			System.out.println("4");
			// �ϴ�λ��
			String fileSaveRootPath = sc.getRealPath("/img"); 
			
			System.out.println(fileSaveRootPath + "\\" + fileName);
			// �õ�Ҫ���ص��ļ�
			File file = new File(fileSaveRootPath + "\\" + fileName);
			
			// ����ļ�������
			if (!file.exists()) {
				request.setAttribute("message", "��Ҫ���ص���Դ�ѱ�ɾ������");
				System.out.println("��Ҫ���ص���Դ�ѱ�ɾ������");
				return;
			}
			// �����ļ���
			String realname = fileName.substring(fileName.indexOf("_") + 1);
			// ������Ӧͷ��������������ظ��ļ�
			response.setHeader("content-disposition", "attachment;filename="
					+ URLEncoder.encode(realname, "UTF-8"));
			// ��ȡҪ���ص��ļ������浽�ļ�������
			FileInputStream in = new FileInputStream(fileSaveRootPath + "\\" + fileName);
			// ���������
			OutputStream out = response.getOutputStream();
			// ����������
			byte buffer[] = new byte[1024];
			int len = 0;
			// ѭ�����������е����ݶ�ȡ������������
			while ((len = in.read(buffer)) > 0) {
				// ��������������ݵ��������ʵ���ļ�����
				out.write(buffer, 0, len);
			}
			// �ر��ļ�������
			in.close();
			// �ر������
			out.close();
		} catch (Exception e) {

		}
	}
}
