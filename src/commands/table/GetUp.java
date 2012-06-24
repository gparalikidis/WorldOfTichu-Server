package commands.table;

import tablePackage.CustomTable;
import tablePackage.CustomTable;
import clientPackage.Client;
import commands.Command;

public class GetUp extends Command {

	private static boolean enabled = true;
	private static int counter = 0;
	
	@Override
	public void execute(Client client, String... params) {
		CustomTable t = client.getTable();
		if(t!=null){
			t.smnGotUp(client);
		}
	}

	@Override
	public void setEnabled(boolean enabled) {
		GetUp.enabled = enabled;
	}

	@Override
	public boolean isEnabled() {
		return GetUp.enabled;
	}


	@Override
	public String getCode() {
		return "3e";
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