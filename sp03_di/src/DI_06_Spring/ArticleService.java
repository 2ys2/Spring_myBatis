package DI_06_Spring;

public class ArticleService {  //�߰迪��
	
	//ArticleService ��  ArticleDao ����
	//����
	//������
	//setter
	
	private ArticleDao articledao; //has-a
	public ArticleService(ArticleDao articledao) {
		this.articledao = articledao;
		System.out.println("ArticleService ������ ȣ��");
	}
    
	//�۾��� ����
	public void write(Article article) {
		this.articledao.insert(article);
	}
}
