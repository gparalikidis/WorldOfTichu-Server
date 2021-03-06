package communication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import commands.Command;
import commands.CommandFactory;
import commands.account.Logout;

import client.Client;

public class ReaderThread extends Thread{

	private BufferedReader in;
	private Client client;
	
	public ReaderThread(Client client, Socket socket){
		this.client = client;
		try{
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}catch (Exception e) {}
	}
	
	public void run(){
		try{
			while (true){
				String input = in.readLine();
				if(input!=null){
					System.err.println(input);
					String[] params = input.split("~");
					Command command = CommandFactory.createCommand(params[0]);
					if(command!=null && command.isEnabled()){
						command.execute(client, params);
						command.increaseCounter();
					}else{
						System.err.println("Uknown command :"+ input);
					}
				}else{
					throw new NullPointerException();
				}
			
			}
		}catch (Exception e) {
			e.printStackTrace();
			new Logout().execute(client, new String[]{});
		}
	}
}
