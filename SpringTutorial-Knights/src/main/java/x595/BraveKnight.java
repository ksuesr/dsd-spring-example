package x595;

public class BraveKnight implements Knight {
	
	public Quest quest;
	
	public BraveKnight(Quest quest) {
		super();
		this.quest = quest;
	}

	@Override
	public void embarkOnQuest() {
		// TODO Auto-generated method stub
		quest.embark();
	}

}
