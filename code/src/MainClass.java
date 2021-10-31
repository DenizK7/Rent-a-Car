import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Command commands = new Command();	
		Scanner scan = new Scanner(System.in);	
		System.out.println("--- Date:1.1.2021 ---\n");
		while(true){
			String textCommands = "";	
			System.out.print(">>>");
			String textInput = scan.nextLine();
			if(textInput.length()>4&&textInput.substring(0,5).equals("load;")) {
				File newFile = new File(textInput.substring(5));	
				if (newFile.exists()) {
					try {
						BufferedReader buffer = new BufferedReader(new FileReader(newFile));
						while((textCommands = (buffer.readLine())) != null) {
							System.out.println(">"+textCommands);
							commands.runCommand(textCommands, ">");				
						}
						buffer.close();
					} catch (Exception e) {
						e.printStackTrace();
					}				
				}else {
					System.out.println("!\tError:"+"The file does not exist");
				}
							
				
			}
			else{	
				commands.runCommand(textInput, ">>>");

			}
			
		}
	
	}
	
}
