package hw1.task_1;

class Knight {
    private Quest quest;

    Knight(Quest quest) {
        this.quest = quest;
    }

    void startQuest(){
        quest.act();
    }
}
