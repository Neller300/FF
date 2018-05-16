package persistens;

public class SælgerTabel implements HasAutoKey{
private int sælgerId;
private String initialer;
private int fastGrænse;


public SælgerTabel(int sælgerId, String initialer, int fastGraense) {
	this.sælgerId=sælgerId;
	this.initialer=initialer;
	this.fastGrænse=fastGraense;
}
@Override
public void setAutoKey(int key) {
  this.sælgerId = key;
}


}
