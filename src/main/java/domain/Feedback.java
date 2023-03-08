package domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Feedback implements Serializable {

    private static final long serialVersionUID = -6166573962950076593L;
    private int id;
    private Timestamp feedbackData;
    private String textFeedback;
    private int rating;

    public Feedback() {}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public Timestamp  getFeedbackData() {return feedbackData;}

    public void setFeedbackData(Timestamp  feedbackData) {this.feedbackData = feedbackData;}

    public String getTextFeedback() {return textFeedback;}

    public void setTextFeedback(String textFeedback) {this.textFeedback = textFeedback;}

    public int getRating() {return rating;}

    public void setRating(int rating) {this.rating = rating;}

    @Override
    public String toString() {
        return "Feedback{ " +
                " id = " + id +
                ", feedbackData = " + feedbackData +
                ", textFeedback = '" + textFeedback + '\'' +
                ", rating = " + rating +
                '}';
    }
}
