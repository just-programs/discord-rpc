import javax.swing.JFrame;

/*
 * Library
 */
import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class Main {
	
	/*
	 * Wrote by xLeakify on 20.09.18
	 * 
	 * All rights reserved. Discord and github.com/just-programs
	 */

	public static void main(String[] args) {
		Window window = new Window("Discord RPC (default by xLeakify)");
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(280, 80);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		DiscordRPC lib = DiscordRPC.INSTANCE;
		/*
		 * Client ID to identificate it. Change #id# to your id.
		 */
		String applicationId = "#id#";
		String steamId = "";
		DiscordEventHandlers handlers = new DiscordEventHandlers();
		lib.Discord_Initialize(applicationId, handlers, true, steamId);
		DiscordRichPresence presence = new DiscordRichPresence();
		presence.startTimestamp = System.currentTimeMillis() / 1000;
		/*
		 * Detail of your RPC/Game, change #details# to your string.
		 */
		presence.details = "#details#";
		/*
		 * State of RPC/Game, change #state# to your string. Delete '//' for work with it.
		 */
		//presence.state = "#state#";
		/*
		 * Image text.
		 */
		presence.largeImageText = presence.details;
		/*
		 * Key of image, change #likey# to your key. Key gets on https://discordapp.com/developers/applications/#your-app#/rich-presence/assets (#your-app# to client ID)
		 */
		presence.largeImageKey = "#likey#";
		lib.Discord_UpdatePresence(presence);
		
		new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				lib.Discord_RunCallbacks();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ignored) {}
			}
		}, "RPC-Callback-Handler").start();
	}
	
}
