package kr.ac.yonsei.a5days.item;


//데이터를 처리해주는 클래스
public class Goal {
    private String date;
    private int level;
    private int point;
    private String name;

    public Goal(String name,int level,String date) {
        this.date = date;
        this.level = level;
        this.point = 100;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point += point;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
