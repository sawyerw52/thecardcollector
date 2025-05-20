package collector;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CardColetion {
    private File currentFile;

    public CardColetion(File file){
        this.currentFile = file;

    }


    public static void main(String[] args) {
        Card card1 = new Card("Matthew Barzal",2017,458,"Upper Deck 2016-2017 Series  Two",false);
        Scanner scanner = new Scanner(System.in);
        System.out.print("What collection would you like too see: ");
        String Username = scanner.nextLine();
        File file = new File("colection\\data\\" + Username);
        CardColetion system = new CardColetion(file);
        if(system.currentFile.length() == 0){
            System.out.println("You have created a new profile named: " + Username);
        }else{
            System.out.println("Welcome back " + Username);
        }
        system.addCard(card1);
        //System.out.println(system.deleteFile());

     
    }

    public boolean   deleteFile(){
        if(currentFile.delete()){
            return true;
        }else{
            return false;
        }
    }

    private  void addCard(Card card){
        try (FileWriter writer = new FileWriter(currentFile,true)) {
            
            writer.append(card.getName() + " " + card.getYear() + " " + card.getCardNumber() +" " +  card.getSet() + " " + card.getSigned() + " " + card.getNumbering()  + "\n");
      
           
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
       
    }

    private void printCards(){
        
    }


    
}

   //try (FileWriter writer = new FileWriter(file)) {
        //    writer.write("Hello from the collector app!\n");
       //     writer.write("This file is inside the existing data directory.");
      //      System.out.println("Successfully wrote to: " + file.getPath());
     //   } catch (IOException e) {
    //        System.err.println("Error writing file: " + e.getMessage());
   //     }

