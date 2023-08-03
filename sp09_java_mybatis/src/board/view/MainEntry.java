package board.view;

import java.util.List;
import java.util.Scanner;

import board.controller.BoardDAO;
import board.model.BoardVO;

public class MainEntry {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = null;
		List<BoardVO> list = null;

		Scanner sc = new Scanner(System.in);
		System.out.print("선택 : 1. select 2. update 3. insert 4. delete");
		switch (sc.nextInt()) {
		case 1:
			list = dao.selectAll();
			for (BoardVO board : list) {
				System.out.println(board);
			}
			break;

		case 2:
			vo = new BoardVO();
			System.out.println("수정할 번호를 입력하세요");
			vo.setSeq(sc.nextInt());
			System.out.println("새로운 content, title, writer 순으로 입력하세요");
			vo.setContent(sc.next());
			vo.setTitle(sc.next());
			vo.setWriter(sc.next());
			dao.update(vo);

			list = dao.selectAll();
			for (BoardVO board : list) {
				System.out.println(board);
			}
			break;

		case 3:
			vo = new BoardVO();
			System.out.println("content, title, writer 순으로 입력하세요");
			vo.setContent(sc.next());
			vo.setTitle(sc.next());
			vo.setWriter(sc.next());
			dao.insert(vo);

			list = dao.selectAll();
			for (BoardVO board : list) {
				System.out.println(board);
			}
			break;
		case 4:
			System.out.println("삭제할 번호를 입력하세요");
			dao.delete(sc.nextInt());
			
			list = dao.selectAll();
			for (BoardVO board : list) {
				System.out.println(board);
			}
			break;
		} // end switch

	}
}
