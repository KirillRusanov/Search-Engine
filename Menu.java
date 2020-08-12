package SearchEngine;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);
    private final Dataset dataset;


    public Menu(Dataset dataset) {
        this.dataset = dataset;
    }

    public void start() {

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");

            String item = scanner.nextLine();

            switch (item) {
                case "1":

                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    String type = scanner.nextLine();

                    SearcherSet finder = null;

                    switch (type) {
                        case "ALL":
                            finder = new SearcherSet(new AllSearchStrategy());
                            break;
                        case "ANY":
                            finder = new SearcherSet(new AnySearchStrategy());
                            break;
                        case "NONE":
                            finder = new SearcherSet(new NoneSearchStrategy());
                            break;
                        default:
                            break;
                    }

                    if (finder == null) {
                        throw new RuntimeException(
                                "Unknown strategy type passed. Please, write to the author of the problem.");
                    }

                    System.out.println("Enter a name or email to search all suitable people.");
                    String[] data = scanner.nextLine().trim().toUpperCase().split(" ");

                    System.out.println(finder.search(dataset, data));

                    System.out.print("\n");

                    break;
                case "2":
                    System.out.println("=== List of people ===");

                    for (String record : dataset.getPeopleListString()) {
                        System.out.println(String.join(" ", record));
                    }
                    break;
                case "0":
                    System.out.println("Bye!");
                    System.exit(0);
                default:
                    System.out.println("Incorrect option! Try again");
            }
        }

    }
}