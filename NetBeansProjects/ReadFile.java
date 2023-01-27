package principal2;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Arrays;
import java.util.Scanner;

public class ReadFile{
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("si535.tsp")));
        int [][] matriz535 = new int[535][535];
        int i = 0;
        int j = 0;
        int const1 = 0;
        while(sc.hasNextLine()) {
            String[] line = sc.nextLine().trim().split(" ");
            for (int k=0; k<line.length; k++) {
                if(j > 534){
                    j=i;
                    i++;
                }

                matriz535[i][j] = Integer.parseInt(line[k]);
                matriz535[j][i] = Integer.parseInt(line[k]);
                const1++;
                j++;
            }
        }
        Scanner sc2 = new Scanner(new BufferedReader(new FileReader("pa561.tsp")));
        
        int [][] matriz561 = new int[561][561];
        i = 0;
        j = 0;
        const1 = 0;
        while(sc2.hasNextLine()) {
            String[] line = sc2.nextLine().trim().split(" ");
            for (int k=0; k<line.length; k++) {
                matriz561[i][j] = Integer.parseInt(line[k]);
                matriz561[j][i] = Integer.parseInt(line[k]);
                const1++;
                j++;
            }
            i++;
            j=0;
        }

        Scanner sc3 = new Scanner(new BufferedReader(new FileReader("si1032.tsp")));
        
        int [][] matriz1032 = new int[1032][1032];
        i = 0;
        j = 0;
        const1 = 0;
        while(sc3.hasNextLine()) {
            String[] line = sc3.nextLine().trim().split(" ");
            for (int k=0; k<line.length; k++) {
                if(j > 1031){
                    j=i;
                    i++;
                }
                matriz1032[i][j] = Integer.parseInt(line[k]);
                matriz1032[j][i] = Integer.parseInt(line[k]);
                const1++;
                j++;
            }
        }

    }
}