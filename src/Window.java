import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Window extends JFrame {
	
	JLabel rpcl;

	public Window(String s) {
		super(s);
		setLayout(new FlowLayout());
		rpcl = new JLabel("RPC label. Close window to close RPC.");
		add(rpcl);
	}
}
