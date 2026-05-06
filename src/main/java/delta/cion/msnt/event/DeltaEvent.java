package delta.cion.msnt.event;

import delta.cion.msnt.Server;
import delta.cion.msnt.event.registration.SimpleEventRegistration;
import net.minestom.server.event.Event;
import net.minestom.server.event.EventNode;

import java.util.UUID;
import java.util.function.Consumer;

public abstract class DeltaEvent<T extends Event> {
	private static UUID EVENT_UUID = null;
	private Class<T> MINECRAFT_EVENT = null;

	EventNode<Event> MY_NODE;

	public DeltaEvent(Class<T> event, Consumer<T> handler) {
		 EVENT_UUID = UUID.randomUUID();
		 MINECRAFT_EVENT = event;
		 MY_NODE = EventNode.all(EVENT_UUID.toString());
		 MY_NODE.addListener(new SimpleEventRegistration<>(MINECRAFT_EVENT, EVENT_UUID.toString(), handler))
	}

	public register() {
		Server.getGlobalEventHandler().addChild(MY_NODE);
	}

	public unregister() {

	}

	public static UUID getEventUuid() {
		return EVENT_UUID;
	}

	public static Event getMinecraftEvent() {
		return MINECRAFT_EVENT;
	}
}
