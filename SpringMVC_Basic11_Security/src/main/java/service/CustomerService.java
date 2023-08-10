package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.NoticeDao;
import vo.Notice;

@Service
public class CustomerService {

	//Mybatis �۾�
	private SqlSession sqlsession;

	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	//�۸�Ϻ��� ���� (DB)
	public List<Notice> notices(String pg , String f , String q) {
		
		//default �� ����
		int page = 1;
		String field="TITLE";
		String query = "%%";
		
		if(pg != null   && ! pg.equals("")) {
			page  = Integer.parseInt(pg);
		}
		
		if(f != null   && ! f.equals("")) {
			field = f;
		}

		if(q != null   && ! q.equals("")) {
			query = q;
		}
		
		//DAO �۾�
		List<Notice> list = null;
		try {
				//����ȭ/////////////////////////////////////////////////////
			 	NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
				///////////////////////////////////////////////////////////
			 	list = noticedao.getNotices(page, field, query);
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		} catch (SQLException e) {
					e.printStackTrace();
		}
		return list;
	}
	
	//�ۻ󼼺��� ����
	public Notice noticesDetail(String seq) {
		Notice notice = null;
		try {
				//����ȭ/////////////////////////////////////////////////////
			 	NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
				///////////////////////////////////////////////////////////	
			    notice = noticedao.getNotice(seq);
		} catch (ClassNotFoundException e) {
						e.printStackTrace();
		} catch (SQLException e) {
						e.printStackTrace();
		}
		return notice;		
	}
	
	
	//�۾���ó�� ����
	public String noticeReg(Notice n , HttpServletRequest request , Principal principal) {
	  
	    List<CommonsMultipartFile> files = n.getFiles();
	    List<String> filenames = new ArrayList<String>(); //���ϸ� ����
	 
	    if(files != null  && files.size() > 0) {  //1���� ���ε�� ������ �����ϸ�
			for(CommonsMultipartFile  mutifile  : files) {
				String filename =  mutifile.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/customer/upload"); //������ ���� ��� 
				String fpath = path + "\\" + filename;
				System.out.println(fpath);
				
				if(!filename.equals("")) {  //�� ���� ���ε� (������)
					FileOutputStream fs =null;
					try {
						     fs = new FileOutputStream(fpath);
						     fs.write(mutifile.getBytes());
		     
						     filenames.add(filename);  //db�� �Էµ� ���ϸ�
						     
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						 try {
							fs.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
	    }
	    
	    //
	    // Spring Security ����ó�� �ϱ� 
	    // (Spring Security ������ ��ü������ ������ �ͼ� �ʿ��� ���� ����)
	    //  �ʿ��� ���� : �α����� ID , �������� (������: ROLE_ADMIN or ROLE_USER)
	    
	    /*
	       ����Ҷ��� ������� ������������ �ʿ��ϴٸ� ... 
	    SecurityContext context = SecurityContextHolder.getContext(); //������ ��ť��Ƽ ��ü ����
	    Authentication auth = context.getAuthentication(); // ������ ���ø� �͸�
	    
	    UserDetails userinfo = (UserDetails) auth.getPrincipal(); //������ ����� ������
	    
	    System.out.println("�������� : " + userinfo.getAuthorities());
	    System.out.println("�����ID: " + userinfo.getUsername());
	    n.setWriter(userinfo.getUsername());
	    */
	    
	    /*
	       ü�ι������ ����ϴ� ���� ���ƿ� 
	    UserDetails user = (UserDetails)SecurityContextHolder.
                getContext().
                getAuthentication().
                getPrincipal(); //User���� ������ ������ ���ڴ�
	    */
	    
	    //session.getAttribute("userid") ������� ....
	    //�α����� ����� ID
	   
	    //���� ������ ���
	    //public String noticeReg(Notice n , HttpServletRequest request , Principal principal)
	    //Principal �������̽��� �����ϸ� ... ���������Ǹ� ������ ���� ��ü�� �ּҸ� ���� �� �ִ� ..�ڵ����� ..
	    //�����Ǹ� ���� ��ü�� ������ �޴´�
	    n.setWriter(principal.getName().trim());
	    
	    
		//���ϸ� (DTO)
		n.setFileSrc(filenames.get(0));
		n.setFileSrc2(filenames.get(1));
		try {
				//����ȭ/////////////////////////////////////////////////////
			 	NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
				///////////////////////////////////////////////////////////	
			    noticedao.insert(n);  //DB insert
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
	  return "redirect:notice.htm";
}
	
	
	
	
	//�ۻ����ϱ� ó�� ����
	public String noticeDel(String seq) {
		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		try {
				noticedao.delete(seq);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return "redirect:notice.htm";
	}
	
	
	
	//�ۼ����ϱ� ����
	public Notice noticeEdit(String seq) {
		Notice notice=null;
		try {
				//����ȭ/////////////////////////////////////////////////////
			 	NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
				///////////////////////////////////////////////////////////	
				notice =  noticedao.getNotice(seq);
		} catch( Exception e) {
				e.printStackTrace();
		} 
		return notice;
	}
	
	
	//�ۼ����ϱ� ó�� ����
	public String noticeEdit(Notice n , HttpServletRequest request) {
 
		 List<CommonsMultipartFile> files = n.getFiles();
		 List<String> filenames = new ArrayList<String>();  //���ϸ� ����
		
		if(files != null  && files.size() > 0) {  //1���� ���ε�� ������ �����ϸ�
				for(CommonsMultipartFile  mutifile  : files) {
					String filename =  mutifile.getOriginalFilename();
					String path = request.getServletContext().getRealPath("/customer/upload"); //������ ���� ��� 
					String fpath = path + "\\" + filename;
					System.out.println(fpath);
					
					if(!filename.equals("")) {  //�� ���� ���ε� (������)
						FileOutputStream fs =null;
						try {
							     fs = new FileOutputStream(fpath);
							     fs.write(mutifile.getBytes());
			     
							     filenames.add(filename);  //db�� �Էµ� ���ϸ�
							     
						} catch (Exception e) {
							e.printStackTrace();
						}finally {
							 try {
								fs.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
				
		}
		 
		 
			//���Ͼ��ε� 2�� �Ѵٴ� ����
			//���ϸ� (DTO)
			n.setFileSrc(filenames.get(0));
			n.setFileSrc2(filenames.get(1));
			try {
					//����ȭ/////////////////////////////////////////////////////
				 	NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
					///////////////////////////////////////////////////////////				
					noticedao.update(n);  //DB insert
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		//ó���� ������ �� �������� : redirect  �۹�ȣ�� ������ ....
		return "redirect:noticeDetail.htm?seq="+n.getSeq();    //�������� �� ��û ....
	}
	
   
	// ���� �ٿ�ε� ���� �Լ�
	public void download(String p, String f, HttpServletRequest request, HttpServletResponse response)
		throws IOException {

			String fname = new String(f.getBytes("euc-kr"), "8859_1");
			response.setHeader("Content-Disposition", "attachment;filename=" + fname + ";");

			String fullpath = request.getServletContext().getRealPath("/customer/" + p + "/" + f);
			System.out.println(fullpath);
			FileInputStream fin = new FileInputStream(fullpath);

			ServletOutputStream sout = response.getOutputStream();
			byte[] buf = new byte[1024]; // ��ü�� ������ �ʰ� 1204byte�� �о
			int size = 0;
			while ((size = fin.read(buf, 0, buf.length)) != -1) {
				sout.write(buf, 0, size);
			}
			fin.close();
			sout.close();
		}
	
}
