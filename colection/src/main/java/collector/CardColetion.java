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
    private String currentUser;
    private List<Card> cardlist;
    private List<String> userlist;
    private final File USERFILE = new File("colection\\src\\main\\java\\collector\\UserList.txt");

    public CardColetion() throws IOException{
        this.currentUser = null;
        this.currentFile = null;
        this.cardlist = null;
        this.userlist = makeUserList();
    }
    


    public static void main(String[] args) throws IOException{
        Card card1 = new Card("Matthew Barzal",2017,458,SetName.UDS21617,false);
        Scanner scanner = new Scanner(System.in);
        System.out.print("What collection would you like too see: ");
        String Username = scanner.nextLine();
        File file = new File("colection\\data\\" + Username);
        CardColetion system = new CardColetion();
        
        
        if(file.length() == 0){
            System.out.println("You have created a new profile named: " + Username);
            system.addNewUser(Username);
            system.currentFile = file;
        }else{
            System.out.println("Welcome back " + Username);
            system.currentFile = file;
        }
        system.addInfo(Username,file);
        //system.makeUserList();
        System.out.println(system.userlist);
        system.addCard(card1);
        System.out.print(system.cardlist);
        //System.out.println(system.deleteFile());
    

     
    }

    public boolean  deleteFile(){
        userlist.remove(currentUser);
        return currentFile.delete();
    }

    private  void addCard(Card card){
        try (FileWriter writer = new FileWriter(currentFile,true)) {
            
            writer.append(card.getName() + " " + card.getYear() + " " + card.getCardNumber() +" " +  card.getSet() + " " + card.getSigned() + " " + card.getNumbering()  + "\n");
      
           
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
       
    }

    private List<Card> makeCardList() throws  IOException{
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

    private List<String> makeUserList() throws  IOException{
      
        ArrayList<String> user = new ArrayList<>();
        try(FileReader fr = new FileReader(USERFILE);
            BufferedReader reader = new BufferedReader(fr)) {
            String line = reader.readLine();
            while(line != null) {
                user.add(line);
                line = reader.readLine();
            }
            
        }
        return user;

    }

    public void removeUser(String user){


    }

    public void addInfo(String username,File file)throws IOException{
        this.currentUser = username;
        this.currentFile = file;
        this.cardlist = makeCardList();
    }



    public File getCurrentFile() {
        return currentFile;
    }



    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }



    public String getCurrentUser() {
        return currentUser;
    }



    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }



    public List<Card> getCardlist() {
        return cardlist;
    }



    public void setCardlist(List<Card> cardlist) {
        this.cardlist = cardlist;
    }



    public List<String> getUserlist() {
        return userlist;
    }



    public void setUserlist(List<String> userlist) {
        this.userlist = userlist;
    }



    public File getUSERFILE() {
        return USERFILE;
    }


    
}

   //try (FileWriter writer = new FileWriter(file)) {
        //    writer.write("Hello from the collector app!\n");
       //     writer.write("This file is inside the existing data directory.");
      //      System.out.println("Successfully wrote to: " + file.getPath());
     //   } catch (IOException e) {
    //        System.err.println("Error writing file: " + e.getMessage());
   //     }

