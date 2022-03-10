//Author Name: Kylie Fauquher
//Date: 3/6/2022
//Program Name: Smith_module7_word_occurrence
//Purpose: A GUI in Java that counts word frequency in your text.



package WordCount;


import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;
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
	
	//Launches the program
	public static void main(String[] args) {
	new wordCount();
	
	}	
		wordCount() {
			
			//This creates my GUI box
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(800,600);
			this.setTitle("Word Count");
			this.setLayout(null);
			this.setVisible(true);
			
			//This is the guts of our GUI, below creates the text area, labels and buttons. As well as set their position on the GUI.
			
			//The textbox that will take your input
			textbox = new JTextArea("Please input the text you want scanned here.");
			textbox.setBounds(25,150,500,500);
			textbox.setLineWrap(true);
			textbox.setMargin(new Insets(10,10,10,10));
			this.add(textbox);
			this.setSize(800,600);
			
			//The textbox that prints your results
			resulttextbox = new JTextArea("Your results will print here.");
			resulttextbox.setBounds(400,100,300,500);
			resulttextbox.setLineWrap(true);
			resulttextbox.setMargin(new Insets(10,10,10,10));
			this.add(resulttextbox);
			this.setSize(800,600);
					
			
			//Scroll bars for both text areas to make sure you have no post limit
			scroll = new JScrollPane(textbox);
			scroll.setBounds(25,150,500,500);
			
			resultscroll = new JScrollPane(resulttextbox);
			resultscroll.setBounds(800,150,300,500);
			
			title = new JLabel("JAVA TEXT ANALYZER");
			title.setBounds(300,25,200,50);
		
			subtitle = new JLabel("After entering your text please click on submit to see your most frequently used words!");
			subtitle.setBounds(120,60,500,50);
			
			//The button that when pressed, begins the function
			button = new JButton("SUBMIT");
			button.setBounds(250,700,200,50);
			
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
			String[] words = text.split("\\s+");
			
			Map<String, Integer> wordFreq = new LinkedHashMap<String, Integer>();
	        if (words != null) {
	            for (String word : words) {
	                if (word != null) {
	                    word = word.trim();
	                    if (!wordFreq.containsKey(word)) {
	                    	wordFreq.put(word, 0);
	                    }
	                    int count = wordFreq.get(word);
	                    wordFreq.put(word, ++count);
	                }
	            }
	        }
	        
	        resulttextbox.setText("Word Frequency: \n" + wordFreq);
		}
}
	                	            	        
	    

  
	 
