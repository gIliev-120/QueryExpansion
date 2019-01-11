package models;

public class DatamuseWord {
    private String word;
    private int score;
    private String[] tags;


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
