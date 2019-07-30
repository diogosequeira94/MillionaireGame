package com.example.millionaire.QuestionTypes;

import java.util.ArrayList;

public class ChallengerQuestions {

    ArrayList<QuestionItem> question = new ArrayList<>();

    public void addElements(){

        question.add(new QuestionItem("Iterators: Select the WRONG answer", "Is an interface found in the java.util package","Allow removing elements from the given collection during the iteration","Uses: hasNext(),next(),remove()","They are strict to one class","They are strict to one class"));
        question.add(new QuestionItem("How can we restrict inheritance for a class? Select the WRONG one", "By using final keyword","By using private constructors","Make all methods final, then we cannot override.","Having an object of that class","Having an object of that class"));
        question.add(new QuestionItem("Select the right option about ArrayLists ", "Are synchronized","Is slow as it’s non-synchronized.","Does not define the increment size","They can implement other lists","Does not define the increment size"));
        question.add(new QuestionItem("Why is Runnable Interface used in Java?", "Implementing multi threaded applications","To prevent concurrency","So we can have only 1 Thread","Prevents null-pointers","Implementing multi threaded applications"));
        question.add(new QuestionItem("When does the Garbage collector take action? ", "When an object is not referenced any more","When there are multiple references","If an object has two methods","If its not on the global scope","When an object is not referenced any more"));
        question.add(new QuestionItem("Non-access modifiers are used to provide information about entities behavior to JVM. One isn't one of them: ","syncronized","abstract","protected","final","protected"));
        question.add(new QuestionItem("When can parseInt() method be used? ","To extract an integer value from a String","To add an integer to a String","To cast Strings into Booleans","Only inside of final methods","To extract an integer value from a String"));
        question.add(new QuestionItem("Select one difference between HashMap and Hashtable","Hashtable does not allow null keys or values","Hashtable is not synchronized","HashMap is synchronized","Both can extend each other","Hashtable does not allow null keys or values"));
    }


    public ArrayList<QuestionItem> getQuestion() {

        return question;
    }

    public int sizeOf(){
        return question.size();
    }



}
