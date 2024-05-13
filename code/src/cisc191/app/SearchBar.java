package cisc191.app;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * @author Ophir Maor
 * @author Brendan Barber
 *
 *         References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         Version/date: 4/14/2024
 * 
 *         Responsibilities of class:
 *         Contains methods used by PickUpable items
 */

public class SearchBar
{
	// SearchBar has a panel
	private JPanel panel;
	// SearchBar has a searchField
	private JTextField searchField;
	// SearchBar has a searchLabel
	private JLabel searchLabel;
	// SearchBar has a search
	private String search;
	// SearchBar has a changed
	private boolean changed;

	public SearchBar()
	{
		panel = new JPanel();

		search = "";
		searchField = new JTextField();
		searchLabel = new JLabel();

		Font bigFont = searchField.getFont().deriveFont(Font.PLAIN, 16f);
		searchField.setFont(bigFont);
		searchLabel.setText("Search");
		searchField.setColumns(20);

		// Update search string when input is changed
		// https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/events/documentlistener.html
		searchField.getDocument().addDocumentListener(new DocumentListener()
		{
			@Override
			public void insertUpdate(DocumentEvent e)
			{
				updateSearch();
			}

			@Override
			public void removeUpdate(DocumentEvent e)
			{
				updateSearch();
			}

			@Override
			public void changedUpdate(DocumentEvent e)
			{
				updateSearch();
			}
		});

		panel.add(searchLabel);
		panel.add(searchField);
	}

	private void updateSearch()
	{
		if (!search.equals(searchField.getText()))
		{
			search = searchField.getText();
			changed = true;
		}
	}

	public JPanel getPanel()
	{
		return panel;
	}

	public String getCurrentSearch()
	{
		return search;
	}

	public boolean isChanged()
	{
		return changed;
	}

	public void setChanged(boolean change)
	{
		this.changed = change;
	}
}
