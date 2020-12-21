package com.example.learnalgerienin10min;

public class Word {
    private String enWord;
    private String algWord;
    private int image=0;
    public Word(String en,String alg){
        this.enWord=en;
        this.algWord=alg;
    }
    public Word(String en,String alg,int img){
        this.enWord=en;
        this.algWord=alg;
        this.image=img;
    }
    public String getEnWord(){
        return this.enWord;
    }
    public String getAlgWord(){
        return this.algWord;
    }
    public int getImage(){ return this.image; }
    public boolean hasImage(){return image!= 0;}
}
