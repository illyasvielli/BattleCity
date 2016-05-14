public class ReduceOppenentSpeedPowerUp implements Runnable{
	private int shot = 0;
	public void setAmmo(){
	}
	public void resetAmmo(){
		this.ammoStr = 1;
	}
	public void shoot(Tank opponent){
		opponent.hp -= this.ammoStr;
		opponent.movementSpeed -= 1; /*decreases opponent's speed*/
		flag = 1;
		if(flag == 1){
			this.resetAmmo();
		}
		/*sleep thread for counter*/
		opponent.movementSpeed += 1;/*return movementSpeed to normal*/
	}
	


}