package DI_06_Spring;

public class ArticleService {  //중계역할
	
	//ArticleService 는  ArticleDao 의존
	//주입
	//생성자
	//setter
	
	private ArticleDao articledao; //has-a
	public ArticleService(ArticleDao articledao) {
		this.articledao = articledao;
		System.out.println("ArticleService 생성자 호출");
	}
    
	//글쓰기 서비스
	public void write(Article article) {
		this.articledao.insert(article);
	}
}
