
package testeFileApps;

import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import principalRyan.Agenda;
import principalRyan.Contato;

public class LerArquivo
{
   private static Scanner input;

   public static void openFile()
   {
      try
      {
         input = new Scanner(Paths.get("agenda.txt")); 
      } 
      catch (IOException ioException)
      {
         System.err.println("Error opening file. Terminating.");
         System.exit(1);
      } 
   }


   public static void readRecords(Agenda agenda)
   {
      openFile();
      try 
      {
         while (input.hasNext()) 
         {
            Contato c = new Contato(input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine());
                      
            agenda.inserirContato(c);
         }
      } 
      catch (NoSuchElementException elementException)
      {
         System.err.println("File improperly formed. Terminating.");
      } 
      catch (IllegalStateException stateException)
      {
         System.err.println("Error reading from file. Terminating.");
      } 
      closeFile();
   } 

   public static void closeFile()
   {
      if (input != null)
         input.close();
   }
}

