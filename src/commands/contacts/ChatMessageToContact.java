package commands.contacts;

import commands.Command;
import clientPackage.Client;

public class ChatMessageToContact extends Command{

	private static boolean enabled = true;
	private static int counter = 0;
	
	/**
	 * Implements 2f requirement
	 */
	@Override
	public void execute(Client sourceClient, String... params) {
	
		String sourceUsername = sourceClient.getInfo().getUsername();
		String targetUsername = params[1];
		Client targetClient = Client.getClient(targetUsername);
		if(targetClient != null){
			String message = params[2];
			String response = "2fR~" + sourceUsername +"~"+ targetUsername +"~"+message+ "~\n";
			targetClient.send(response);
			sourceClient.send(response);
		}		
	}

	@Override
	public boolean isEnabled() {
		return ChatMessageToContact.enabled;
	}

	@Override
	public void setEnabled(boolean enabled) {
		ChatMessageToContact.enabled = enabled;
	}


	@Override
	public String getCode() {
		return "2f";
	}

	@Override
	public void increaseCounter() {
		counter++;
	}

	@Override
	public long getCounter() {
		return counter;
	}
}
