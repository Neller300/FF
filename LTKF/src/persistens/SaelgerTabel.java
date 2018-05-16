package persistens;

public class SaelgerTabel implements HasAutoKey{
private int sælgerId;
private String initialer;
private int fastGrænse;


public SaelgerTabel(int sealgerId, String initialer, int fastGraense) {
	this.sælgerId=sealgerId;
	this.initialer=initialer;
	this.fastGrænse=fastGraense;
}
@Override
public void setAutoKey(int key) {
  this.sælgerId = key;
}

}
