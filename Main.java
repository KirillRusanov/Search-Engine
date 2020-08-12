package SearchEngine;

public class Main {

    private static String filename;

    public static void main(String[] args) {

        if (args[0].equals("--data")) {
            filename = args[1];
        }

        Dataset dataset = new Dataset();
        dataset.enter(filename);

        Menu menu = new Menu(dataset);
        menu.start();


    }
}