import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class genFizzBuzz {

  public static void main(String[] args) throws IOException {
  	Integer fileCount = Integer.parseInt(args[0]);
  	
  	for (Integer i = 0; i < fileCount; i++) {
  	  Random r = new Random();
  	  File file = new File(Integer.toString(r.nextInt(10000)) + ".java");
  	  permutateFile(file);
  	}
  }
  
  public static void permutateFile(File file) throws IOException {
  	FileWriter fw = new FileWriter(file);
  	BufferedWriter bw = new BufferedWriter(fw);
  	Random r = new Random();
  	Character c = (char)(r.nextInt(26) + 'a');
  	
    try (BufferedReader br = new BufferedReader(new FileReader("FizzBuzzTemplate.java"))) {
  	  String line;
  	  
  	  while ((line = br.readLine()) != null) {
  	  	bw.write(line.replaceAll("X", Character.toString(c))
  	  				 .replaceAll("3", Integer.toString((int)(Math.random() * 101))));
  	  	bw.newLine();
  	  }
  	  
  	  bw.flush();
  	  bw.close();
  	} catch (Exception e) {
  	  System.out.println(e);
  	}
  }

}