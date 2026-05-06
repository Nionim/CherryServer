package delta.cion.msnt.motd;

import delta.cion.msnt.event.EventManager;
import net.minestom.server.MinecraftServer;
import net.minestom.server.event.EventListener;
import net.minestom.server.event.EventNode;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.server.ServerListPingEvent;
import net.minestom.server.ping.ResponseData;

public class MOTDHandler {

	private static EventListener<ServerListPingEvent> MOTD_LISTENER;

	public static void registerVanillaMOTD() {
		setupVanillaMOTD();
	}

	public static void unregisterVanillaMOTD() {
		GlobalEventHandler globalEventHandler = MinecraftServer.getGlobalEventHandler();
		EventNode<?> MOTD_NODE =
		globalEventHandler.unregister(MOTD_LISTENER);
		MOTD_LISTENER
	}

	private static void setupVanillaMOTD() {
		MOTD_LISTENER = EventManager.registerTempEvent(ServerListPingEvent.class, event -> {
			ResponseData responseData = new ResponseData();
			responseData.setMaxPlayer(1663);
			responseData.setVersion("MSNT server 1.21.4");
			responseData.setOnline(-1);
			responseData.setDescription("MSNT Server");
			event.setResponseData(responseData);
		});
	}

}
