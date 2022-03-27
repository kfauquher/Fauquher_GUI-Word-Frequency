//Author Name: Kylie Fauquher
//Date: 3/2022

package WordCount;



import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;




public class wordCount extends JFrame implements ActionListener {
	
	JTextArea textbox,resulttextbox;
	JLabel subtitle, title;
	JButton button;
	JScrollPane scroll, resultscroll;
	

		wordCount() {
			
			//This creates my GUI box
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(1200,800);
			this.setTitle("Word Count");
			this.setLayout(null);
			this.setVisible(true);
			
			//This is the guts of our GUI, below creates the text area, labels and buttons. As well as set their position on the GUI.
			
			//The textbox that will take your input
			textbox = new JTextArea("Please input the text you want scanned here.");
			textbox.setBounds(50,150,500,500);
			textbox.setLineWrap(true);
			textbox.setMargin(new Insets(10,10,10,10));
			this.add(textbox);
			
			
			//The textbox that prints your results
			resulttextbox = new JTextArea("Your results will print here.");
			resulttextbox.setBounds(600,150,500,500);
			resulttextbox.setLineWrap(true);
			resulttextbox.setMargin(new Insets(10,10,10,10));
			this.add(resulttextbox);
			
					
			
			//Scroll bars for both text areas to make sure you have no post limit
			scroll = new JScrollPane(textbox);
			scroll.setBounds(50,150,500,500);
			
			resultscroll = new JScrollPane(resulttextbox);
			resultscroll.setBounds(600,150,500,500);
			
			title = new JLabel("JAVA TEXT ANALYZER");
			title.setBounds(475,25,200,50);
			
		
			subtitle = new JLabel("After entering your text please click on submit to see your most frequently used words!");
			subtitle.setBounds(315,60,500,50);
			
			//The button that when pressed, begins the function
			button = new JButton("SUBMIT");
			button.setBounds(475,675,200,50);
			
			button.addActionListener(this);
			
			
			this.add(subtitle);
			this.add(title);
			this.add(button);
			this.add(scroll);
			this.add(resultscroll);
		}
			
	
		//This function as of now prints out how much each word is used in whatever you enter in your textbox
		@Override
		public void actionPerformed(java.awt.event.ActionEvent e) { 
			String text = textbox.getText();;
			try (Scanner scan = new Scanner(text)) {
				Map<String, Integer> map = new HashMap<String, Integer>();
				while (scan.hasNext()) {
					String word = scan.next();
					if(map.containsKey(word) == false)
						map.put(word,1);
					
					else {
						int count = (int)(map.get(word));
						map.remove(word);
						map.put(word, count + 1);
					}
					
			        }
				
				resulttextbox.setText("Word Frequency: \n" + map);
			}
		}
		
	//Launches the program
	public static void main(String[] args) {
		new wordCount();
		
		}	
}

	                	            	        
	    

  
	 
