package hw2.task_3;

import java.util.Map;
class ScoobyTeam {
    private Map<String, String> scoobyTeamMap;

    public Map<String, String> getScoobyTeamMap() {
        return scoobyTeamMap;
    }

    public void setScoobyTeamMap(Map<String, String> scoobyTeamMap) {
        this.scoobyTeamMap = scoobyTeamMap;
    }
    void showAll() {
        scoobyTeamMap.forEach((k, v) -> System.out.println(("Agent "+ k + ": " + v)));
    }
}
