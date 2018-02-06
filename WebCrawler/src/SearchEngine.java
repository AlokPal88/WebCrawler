import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SearchEngine {

	private static JFrame frame;
	private static JTextField searchQuery;
	private static JTextArea searchResult;
	private static String[] result = {"Lets","see", "if","this","works!"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEngine window = new SearchEngine();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchEngine() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 924, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		searchQuery = new JTextField();
		searchQuery.setFont(new Font("Tahoma", Font.BOLD, 25));
		searchQuery.setBounds(0, 0, 902, 60);
		frame.getContentPane().add(searchQuery);
		searchQuery.setColumns(10);
		
		JButton search = new JButton("Search");
		search.setFont(new Font("Tahoma", Font.BOLD, 20));
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displaySearchResult();
			}
		});
		search.setBounds(390, 64, 136, 46);
		frame.getContentPane().add(search);
		
		//result = {"Lets","see", "if","this","works!"};
		
		searchResult = new JTextArea();
		searchResult.setFont(new Font("Rockwell", Font.PLAIN, 25));
		searchResult.setBounds(0, 115, 902, 240);
		frame.getContentPane().add(searchResult);
		searchResult.setColumns(10);
		
		JButton prev = new JButton("Next");
		prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchResult.setText("");
			}
		});
		prev.setBounds(617, 371, 115, 40);
		frame.getContentPane().add(prev);
		
		JButton next = new JButton("Previous");
		next.setBounds(161, 371, 115, 40);
		frame.getContentPane().add(next);
	}
	public static void displaySearchResult(){
		for(int i=0; i < result.length; i++)
		{
			searchResult.setText(searchResult.getText() + result[i] + "\n");
		}
	}
}
