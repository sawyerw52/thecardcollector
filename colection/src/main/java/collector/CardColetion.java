package collector;

import java.io.File;
import java.util.Scanner;

public class CardColetion {
    private File currentFile;

    public CardColetion(File file){
        this.currentFile = file;

    }


    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("What collection would you like too see: ");
        String Username = scanner.nextLine();
        File file = new File("colection\\data\\" + Username);
        CardColetion system = new CardColetion(file);
        //System.out.println(system.deleteFile());

     
    }

    public boolean   deleteFile(){
        if(currentFile.delete()){
            return true;
        }else{
            return false;
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

