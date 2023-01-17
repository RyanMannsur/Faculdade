
package testeFileApps;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import principalRyan.Agenda;
import principalRyan.Contato;


public class CriarArquivo {
   private static Formatter output;     


   public static void openFile()
   {
      try
      {
         output = new Formatter("agenda.txt");
      }
      catch (SecurityException securityException)
      {
         System.err.println("Write permission denied. Terminating.");
         System.exit(1);
      } 
      catch (FileNotFoundException fileNotFoundException)
      {
         System.err.println("Error opening file. Terminating.");
         System.exit(1); 
      } 
   } 


   public static void addRecords(Agenda agenda)
   {
      openFile();
      Scanner input = new Scanner(System.in);
      Iterator it = agenda.getContatos().iterator();
      while (it.hasNext()) 
      {
         try
         {
            Contato aux = (Contato)it.next();
            output.format("%s\n%s\n%s\n%s\n", aux.getNome(),
               aux.getEndereco(), aux.getTelefone(), aux.getEmail());                             
         } 
         catch (FormatterClosedException formatterClosedException)
         {
            System.err.println("Error writing to file. Terminating.");
            break;
         } 
         catch (NoSuchElementException elementException)
         {
            System.err.println("Invalid input. Please try again.");
            input.nextLine();
         } 
      }
      closeFile();
   }

   public static void closeFile()
   {
      if (output != null)
         output.close();
   } 
}  

