package collector;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CollectorCLI {
    private List<String> startinguserlist = new ArrayList<>();
    private final File USERFILE = new File("colection\\src\\main\\java\\collector\\UserList.txt");
   
    
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean programloop = true;
        System.out.println("Welcome to the card collector\nTo see exsisting users type in User list\nEnter your username");
        CardColetion collector = new CardColetion();
        List<String> startinguserlist = collector.getUserlist();
        
        
        while(collector.getCurrentUser().equals("")){
            System.out.print("> ");
            String cmdstart = scanner.nextLine().toLowerCase();
            switch(cmdstart){
                case "user list":
                    for (String user : startinguserlist) {
                        System.out.println(user);
                    }
                    break;
                default:
                    if(startinguserlist.contains(cmdstart)){
                        System.out.println("Welcome back " + cmdstart);
                        collector.addInfo(cmdstart);
                        
                    }else{
                        System.out.println("Welcome " + cmdstart);
                        collector.addInfo(cmdstart);

                    }

            }
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
        System.out.println("Good Bye");
    }
}
