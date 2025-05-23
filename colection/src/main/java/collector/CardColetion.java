package collector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardColetion {
    private File currentFile;
    private List<Card> cardlist;
    private List<String> userlist;
    private final File USERFILE = new File("colection\\src\\main\\java\\collector\\UserList.txt");

    public CardColetion(File file){
        this.currentFile = file;
        this.cardlist = new  ArrayList<>();
        this.userlist = new ArrayList<>();
    
    }


    public static void main(String[] args) throws IOException{
        Card card1 = new Card("Matthew Barzal",2017,458,SetName.UDS21617,false);
        Scanner scanner = new Scanner(System.in);
        System.out.print("What collection would you like too see: ");
        String Username = scanner.nextLine();
        File file = new File("colection\\data\\" + Username);
        CardColetion system = new CardColetion(file);
        if(system.currentFile.length() == 0){
            System.out.println("You have created a new profile named: " + Username);
            system.addNewUser(Username);
        }else{
            System.out.println("Welcome back " + Username);
        }
        system.getUserList();
        System.out.println(system.userlist);
        system.addCard(card1);
        System.out.print(system.getCardList());
        //System.out.println(system.deleteFile());
    

     
    }

    public boolean   deleteFile(){
        return currentFile.delete();
    }

    private  void addCard(Card card){
        try (FileWriter writer = new FileWriter(currentFile,true)) {
            
            writer.append(card.getName() + " " + card.getYear() + " " + card.getCardNumber() +" " +  card.getSet() + " " + card.getSigned() + " " + card.getNumbering()  + "\n");
      
           
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
       
    }

    private List<Card> getCardList() throws  IOException{
       try(FileReader fr = new FileReader(currentFile);
            BufferedReader reader = new BufferedReader(fr)) {
            List<Card> cards = new ArrayList<>();
            String line = reader.readLine();
            while(line != null) {
                String[] cardinfo = line.split(" ");
                String year = cardinfo[2].substring(0,4);
                // System.out.println(year); debug print
                Card card = new Card(cardinfo[0] + cardinfo[1], Integer.parseInt(year) , Integer.parseInt(cardinfo[3]),SetName.getEnum(cardinfo[4]),Boolean.valueOf(cardinfo[5]),Integer.parseInt(cardinfo[6]));
                cards.add(card);
                line = reader.readLine();
            }
            return cards;
        }
        
    }

    private void addNewUser(String username){
         try (FileWriter writer = new FileWriter(USERFILE,true)) {
            
            writer.append(username + "\n");     
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    
        
    }

    private void getUserList() throws  IOException{
      
        
        try(FileReader fr = new FileReader(USERFILE);
            BufferedReader reader = new BufferedReader(fr)) {
            String line = reader.readLine();
            while(line != null) {
                userlist.add(line);
                line = reader.readLine();
            }
            
        }

    }

    public void removeUser(String user){
        
    }


    
}

   //try (FileWriter writer = new FileWriter(file)) {
        //    writer.write("Hello from the collector app!\n");
       //     writer.write("This file is inside the existing data directory.");
      //      System.out.println("Successfully wrote to: " + file.getPath());
     //   } catch (IOException e) {
    //        System.err.println("Error writing file: " + e.getMessage());
   //     }

