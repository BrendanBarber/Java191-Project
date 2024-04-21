package cisc191.app;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SearchBar
{
	
	private JPanel panel;
	private JTextField searchField;
	private JLabel searchLabel;
	
	private String search;
	private boolean changed;
	
	public SearchBar() {
		panel = new JPanel();
		
		search = "";
		searchField = new JTextField();
		searchLabel = new JLabel();
		
		searchLabel.setText("Search:");
		searchField.setColumns(20);
		
		// https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/events/documentlistener.html
		searchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
            public void insertUpdate(DocumentEvent e) {
                updateSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSearch();
            }
		});
		
		panel.add(searchLabel);
		panel.add(searchField);
	}
	
	private void updateSearch() {
		if(search != searchField.getText()) {
			search = searchField.getText();
			changed = true;
		}
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public String getCurrentSearch() {
		return search;
	}
	
	public boolean isChanged() {
		return changed;
	}
	
	public void setChanged(boolean change) {
		this.changed = change;
	}
}
