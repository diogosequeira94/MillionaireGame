package com.example.millionaire.QuestionTypes;

public class Questions {

    private String mQestions[] = {
            "What is Java?",
            "What is OOP?",
            "What are variables?",
            "Which is the most effiecient way to declare a String?",
            "What are frameworks?",
            "What is a Singleton?",
            "What is a Robin?",
            "A object has three main characteristics: ",
            "Define constructor in Java",
            "In Java, string objects are immutable in nature. This means: ",
            "What is a process?",
            "Polymorphism is one of the most powerful tools in Java. With it we can: ",
            "What is the main advantage of the OOP paradigm?",
            "192.168.0.255 which class does this IP belong to?",
            "How many values can be represented by a single byte?",
            "What is a final method in Java?"
    };

    private String mChoices[][] = {

            {"Programming Language", "A Potato", "A framework OOP", "Chonco"},
            {"Object Over Procedures", "Object Oriented Programming", "Oriented Procedural Programming", "Over Objects Procedure"},
            {"Special keywords", "Data structures", "Container that holds values", "A chonco"},
            {"Programming Language", "A final method", "Polymorphism", "Something Else"},
            {"A type of Programming", "Tool to boost Efficiency", "Good guy", "Walter"},
            {"A design Pattern", "A variable type", "Null Pointer", "Over Objects Procedure"},
            {"Null Pointer", "Bad programmer", "Good guy", "A chonco"},
            {"State,Behavior,Identity", "Identity,Gender,Scope", "State,Identity,Score", "Behavior,State,Variables"},
            {"It's used to build sockets", "It's a normal method","Used to initialize the state of an object", "None of the above"},
            {"You program can only have one String", "Robin", "Once the String object is created its state cannot be modified", "RAM can't fetch more strings"},
            {"Compiler buffer", "Interface", "A thread", "A program executing in memory"},
            {"Postpone decision to compile time", "Extend multiple classes", "Save a subclass type in a superclass variable", "Sockets"},
            {"Program runs faster", "Control scalability and complexity", "We will have less null pointers", "We can use polymorphism anytime"},
            {"D", "B", "C", "That is a subnet mask"},
            {"253", "256", "128", "254"},
            {"A method that is executed first", "It needs to have return value", "A method cannot be overridden by any subclasses", "Has at least one parameter"},


    };

    private String mCorrectAnswer[] = {
            "Programming Language",
            "Object Oriented Programming",
            "Container that holds values",
            "Something Else",
            "Tool to boost Efficiency",
            "A design Pattern",
            "A chonco",
            "State,Behavior,Identity",
            "Used to initialize the state of an object",
            "Once the String object is created its state cannot be modified",
            "A program executing in memory",
            "Save a subclass type in a superclass variable",
            "Control scalability and complexity",
            "C",
            "256",
            "A method cannot be overridden by any subclasses"
    };

    //Getters

    public String getQuestion(int i){
        String question = mQestions[i];
        return question;
    }

    public String getChoice1(int i){
        String choice = mChoices[i][0];
        return choice;
    }

    public String getChoice2(int i){
        String choice = mChoices[i][1];
        return choice;

    }  public String getChoice3(int i){
        String choice = mChoices[i][2];
        return choice;

    }  public String getChoice4(int i){
        String choice = mChoices[i][3];
        return choice;
    }

    public String getCorrectAnswer(int i){
        String answer = mCorrectAnswer[i];
        return answer;
    }

    public String[] getmQestions() {
        return mQestions;
    }
}
