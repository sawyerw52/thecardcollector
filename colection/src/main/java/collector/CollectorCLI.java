package collector;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectorCLI {
    private List<String> startinguserlist = new ArrayList<>();
    private final File USERFILE = new File("colection\\src\\main\\java\\collector\\UserList.txt");
   
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean programloop = true;
        System.out.println("Welcome to the card collector\nTo see exsisting users type in User list\nEnter your username");
        CardColetion collector = new CardColetion();
        collector.getUserList();

        while(true){
            System.out.print("> ");
            String cmdstart = scanner.nextLine();
            switch(cmdstart){
                case "user list":
                    List<String> startinguserlist = collector.getUserList();

            }
            


            break;
        }


        while(programloop){
            System.out.print("> ");
            String cmd = scanner.nextLine();
            switch (cmd) {
                case "quit":
                    programloop = false;
                    break;
                default:
                    System.out.println("I work");
            }
            

        }


        scanner.close();
    }
}
