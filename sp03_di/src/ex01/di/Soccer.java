package ex01.di;

import org.springframework.beans.factory.annotation.Autowired;

public class Soccer {
	
	@Autowired /* �ڵ����Եȴ�. */
	private PlayerImpl player;

	public void setPlayer(PlayerImpl player) {
		this.player = player;
	}

}
     