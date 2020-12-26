package com.example.learnalgerienin10min;

public class Word {
    private String enWord;
    private String algWord;
    private int image=0;
    private int soundID;
    public Word(String en,String alg){
        this.enWord=en;
        this.algWord=alg;
    }
    public Word(String en,String alg,int img){
        this.enWord=en;
        this.algWord=alg;
        this.image=img;
    }
    public Word(String en,String alg,int img,int sound){
        this.enWord=en;
        this.algWord=alg;
        this.image=img;
        this.soundID=sound;
    }
    public String getEnWord(){
        return this.enWord;
    }
    public String getAlgWord(){
        return this.algWord;
    }
    public int getImage(){ return this.image; }
    public int getSoundID(){return this.soundID;}
    public boolean hasImage(){return image!= 0;}
    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + enWord + '\'' +
                ", mAlgerianTranslation='" + algWord + '\'' +
                ", mAudioResourceId=" + soundID +
                ", mImageResourceId=" + image +
                '}';
    }
}
