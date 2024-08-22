package contoller.net;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class ListenService extends Service<String>{

	private VierGewinntSocket socketToServer;
	
	
	public ListenService(VierGewinntSocket socketToServer) {
		this.socketToServer = socketToServer;
	}
	
	
	
	@Override
	protected Task<String> createTask() {
		return new Task<String>() {

			@Override
			protected String call() throws Exception {
				return socketToServer.receiveMessage();
			}
			
		};
	}

}
