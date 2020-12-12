package com.example.learnalgerienin10min;

public class Word {
    private String enWord;
    private String algWord;
    public Word(String en,String alg){
        this.enWord=en;
        this.algWord=alg;
    }
    public String getEnWord(){
        return this.enWord;
    }
    public void setEnWord(String en){
        this.enWord=en;
    }
    public String getAlgWord(){
        return this.algWord;
    }
    public void setAlgWord(String alg){
        this.algWord=alg;
    }
}
