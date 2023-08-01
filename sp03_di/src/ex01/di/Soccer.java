package ex01.di;

import org.springframework.beans.factory.annotation.Autowired;

public class Soccer {
	
	@Autowired /* 자동주입된다. */
	private PlayerImpl player;

	public void setPlayer(PlayerImpl player) {
		this.player = player;
	}

}
     