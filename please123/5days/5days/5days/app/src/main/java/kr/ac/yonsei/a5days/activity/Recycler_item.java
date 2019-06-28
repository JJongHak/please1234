package kr.ac.yonsei.a5days.activity;

public class Recycler_item {
    int image;
    String title;

    int getImage(){
        return this.image;
    }
    String getTitle(){
        return this.title;
    }
    void setAll(int image, String title){
        this.image = image;
        this.title = title;
    }
    Recycler_item(int image, String title){
        this.image=image;
        this.title=title;
    }
}
