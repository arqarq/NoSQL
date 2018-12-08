package pl.sda.nosql;

public class Runner {
    public static void main(String[] args) {
        MongoDB mongoDB = new MongoDB("firma", "pracownicy");

//        mongoDB.executeA();
        mongoDB.executeC();
    }
}
