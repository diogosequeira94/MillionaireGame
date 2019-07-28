package com.example.millionaire.QuestionTypes;

public class ImageQuestions {

    private String imageQestions[] = {
            "Image 1",

    };

    private String imageChoices[][] = {

            {"RAM", "ROM", "ROBIN", "Chonco"},

    };

    private String imageCorrectAnswer[] = {
            "RAM",

    };

    //Getters

    public String getQuestion(int i) {
        String question = imageQestions[i];
        return question;
    }

    public String getChoice1(int i) {
        String choice = imageChoices[i][0];
        return choice;
    }

    public String getChoice2(int i) {
        String choice = imageChoices[i][1];
        return choice;

    }

    public String getChoice3(int i) {
        String choice = imageChoices[i][2];
        return choice;

    }

    public String getChoice4(int i) {
        String choice = imageChoices[i][3];
        return choice;
    }

    public String getCorrectAnswer(int i) {
        String answer = imageCorrectAnswer[i];
        return answer;
    }

    public String[] getmQestions() {
        return imageQestions;
    }

}