package edu.kosa.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.kosa.dao_di.UserDAO;
import edu.kosa.model.UserVO;

/*
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.kosa.dao.OracleUserDAOImpl;
import edu.kosa.dao.UserDAO;
import edu.kosa.model.UserVO;
*/

public class MainEntry {
	public static void main(String[] args) throws Exception{
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ctx.xml");
		UserDAO dao = ctx.getBean("dao", UserDAO.class);
		dao.menu();
		Scanner sc = new Scanner(System.in);
		
		
		switch(sc.nextInt()) {
		case 1:
			UserVO vo = new UserVO();
			System.out.print("user id= "); vo.setId(sc.next());
			System.out.print("user name= "); vo.setName(sc.next());
			System.out.print("user pwd= "); vo.setPassword(sc.next());
			
			dao.insert(vo);
			System.out.println(vo.getId() + "�߰� ����!!");
			System.out.println("-------------------------------");
			break;
		case 2: //selectAll()
			List<UserVO> list = new ArrayList<>();
			list = dao.selectAll();
			for (int i = 0; i < list.size(); i++ ) {
				UserVO selevo = list.get(i);
				System.out.println(selevo.getId() + " " + selevo.getName() + " " + selevo.getPassword());
				System.out.println("-------------------------------");
			}
			break;
		case 3: //selectById()
			System.out.println("�˻��� ID�� �Է��ϼ���.");
			UserVO seleidvo = new UserVO();
			seleidvo = dao.selectById(sc.next());
			System.out.println(seleidvo.getId() + " " + seleidvo.getName() + " " + seleidvo.getPassword());
			System.out.println("-------------------------------");
			break;
		case 4: //updateById()
			UserVO upvo = new UserVO();
			System.out.print("�����ϰ� ���� ID�� �Է��ϼ��� = "); upvo.setId(sc.next());
			System.out.print("���ο� �̸��� �Է��ϼ��� : "); upvo.setName(sc.next());
			System.out.print("���ο� ��й�ȣ�� �Է��ϼ��� : "); upvo.setPassword(sc.next());
			dao.updateById(upvo);
			System.out.println("-------------------------------");
			break;
		case 5: //deledById() - �ǽ�����
			System.out.println("������ ID�� �Է��ϼ���.");
			dao.deleteById(sc.next());
			System.out.println("-------------------------------");
			break;
		default:
			System.out.println("-��-");
			break;
		}
		
		
		/*
		 * JAVA
		UserDAO dao = new OracleUserDAOImpl();
		Scanner sc = new Scanner(System.in);
		
		dao.menu();
		switch(sc.nextInt()) {
		case 1:
			UserVO vo = new UserVO();
			System.out.print("user id= "); vo.setId(sc.next());
			System.out.print("user name= "); vo.setName(sc.next());
			System.out.print("user pwd= "); vo.setPassword(sc.next());
			
			dao.insert(vo);
			System.out.println(vo.getId() + "�߰� ����!!");
			System.out.println("-------------------------------");
			break;
		case 2: //selectAll()
			List<UserVO> list = new ArrayList<>();
			list = dao.selectAll();
			for (int i = 0; i < list.size(); i++ ) {
				UserVO selevo = list.get(i);
				System.out.println(selevo.getId() + " " + selevo.getName() + " " + selevo.getPassword());
				System.out.println("-------------------------------");
			}
			break;
		case 3: //selectById()
			System.out.println("�˻��� ID�� �Է��ϼ���.");
			UserVO seleidvo = new UserVO();
			seleidvo = dao.selectById(sc.next());
			System.out.println(seleidvo.getId() + " " + seleidvo.getName() + " " + seleidvo.getPassword());
			System.out.println("-------------------------------");
			break;
		default:
			System.out.println("-��-");
			break;
		}
		*/
	}
}
