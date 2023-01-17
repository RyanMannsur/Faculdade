
package servicos;

import dominio.JogoDaForca;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class TestFileApps 
{
   private static Scanner input;

   public static void openFile()
   {
      try
      {
         input = new Scanner(Paths.get("palavras7letras.txt")); 
      } 
      catch (IOException ioException)
      {
         System.err.println("Error opening file. Terminating.");
         System.exit(1);
      } 
   }


   public static void readRecords(JogoDaForca jogo)
   {
      openFile();
      String arq = "";
      try 
      {
         while (input.hasNext()) 
         {
            arq = input.nextLine();
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
      StringTokenizer tokens = new StringTokenizer(arq," ");
      while(tokens.hasMoreTokens()){
          jogo.getPalavras().add(tokens.nextToken());
      }
   } 

   public static void closeFile()
   {
      if (input != null)
         input.close();
   }
}
