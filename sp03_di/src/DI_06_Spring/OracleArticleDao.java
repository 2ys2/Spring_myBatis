package DI_06_Spring;

public class OracleArticleDao implements ArticleDao {

	@Override
	public void insert(Article article) {
		System.out.println("Oracle Insert ���� ����");

	}
	
	//update, delete, select method ...

}
