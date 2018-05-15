package persistens;

public class SaelgerTabel implements HasAutoKey{
private int saelgerId;
private String initialer;
private int fastGraense;


public SaelgerTabel(int sealgerId, String initialer, int fastGraense) {
	this.saelgerId=sealgerId;
	this.initialer=initialer;
	this.fastGraense=fastGraense;
}
@Override
public void setAutoKey(int key) {
  this.saelgerId = key;
}

}
