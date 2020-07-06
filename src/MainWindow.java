import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

public class MainWindow {
	
	public JFrame frame;
	
	public MainWindow() {
		frame = new JFrame("Credit Card Completer");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		BoxLayout boxLayoutManager = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxLayoutManager);
		
		frame.setSize(1000, 200);
		frame.add(panel);
		
		placeComponents(panel);
	}
	
	private static void placeComponents(JPanel panel) {		
		JLabel title = new JLabel("Find The Missing Number!");
		panel.add(title);
		
		JTextArea description = new JTextArea("Enter in a credit/debit/gift card number"
				+ " with one number replaced by '*' (without the quotes),"
				+ " and I will guess the missing number.");
		description.setFont(new Font("Serif", Font.PLAIN, 14));
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		panel.add(description);
		
		JLabel label = new JLabel("Enter the number with the '*':");
		panel.add(label);
		
		JTextField code = new JTextField(16);
		panel.add(code);
		
		JButton completeButton = new JButton("Find Missing Number");
		panel.add(completeButton);

		completeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String input = code.getText();
				String message;
				if (Validate.checkLength(input)) {
					message = "The number must be 16 digits.";
				} else if (!Validate.checkStar(input)) {
					message = "The number must have exactly one digit replaced with"
						+ " a '*' (without the quotes).";
				} else {
					int missingNumber = Complete.findMissingNumber(code.getText());
					message = "Your number is " + missingNumber;
				}
				JOptionPane.showMessageDialog(null, message);
			}
		});
	}
	
	public void show() {
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		mainWindow.show();
		System.out.println(Validate.checkStar("1234567891234567"));
	}

}
