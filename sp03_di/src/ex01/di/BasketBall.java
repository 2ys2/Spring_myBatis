package ex01.di;

import org.springframework.beans.factory.annotation.Autowired;

public class BasketBall {
	
	@Autowired
	private PlayerImpl player;

	public void setPlayer(PlayerImpl player) {
		this.player = player;
	}

}
