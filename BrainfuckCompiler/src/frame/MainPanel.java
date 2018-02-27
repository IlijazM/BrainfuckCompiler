package frame;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

import compile.Compiler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	
	private JTextPane code;
	
	public MainPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		code = new JTextPane();
		code.setFont(new Font("Courier New", Font.PLAIN, 20));
		tabbedPane.addTab("Code", null, code, null);
		
		JTextPane output = new JTextPane();
		output.setFont(new Font("Courier New", Font.PLAIN, 20));
		tabbedPane.addTab("Output", null, output, null);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				output.setText(Compiler.compileCode(getCode()));
				
				tabbedPane.setSelectedIndex(1);
			}
		});
		panel.add(btnConvert);
	}
	
	public String getCode() {
		return code.getText();
	}

}
