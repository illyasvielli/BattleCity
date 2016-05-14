public class IncreaseAmmoStrengthPowerUp implements Runnable{
	private int shot = 0;
	public void buffAmmo(){
		this.ammoStr += 1; /*increase strength of tank's ammo*/
	}
	public void normalizeAmmo(){
		this.ammoStr -= 1;
	}
	public void shoot(Tank opponent){
		opponent.hp -= this.ammoStr;
		flag = 1;
		if(flag == 1){
			this.resetAmmo();
		}
	}
	


}