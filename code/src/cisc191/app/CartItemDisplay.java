package cisc191.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

class CartItemDisplay extends JPanel implements ListCellRenderer<String>
{

	// https://stackoverflow.com/questions/38778178/java-listcellrenderer-and-jlist-handle-selection
	// and
	// https://www.codejava.net/java-se/swing/jlist-custom-renderer-example

	private JButton removeButton;
	private JLabel itemNameLabel;

	public CartItemDisplay()
	{
		setLayout(new BorderLayout());
		itemNameLabel = new JLabel();
		itemNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(itemNameLabel, BorderLayout.CENTER);

		removeButton = new JButton("X");
		removeButton.setForeground(Color.RED);
		removeButton.setMargin(new Insets(1, 1, 1, 1));
		removeButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// Remove the item from the list model
				Container parent = CartItemDisplay.this.getParent();
				if (parent instanceof JList)
				{
					JList list = (JList) parent;
					DefaultListModel<String> model = (DefaultListModel<String>) list
							.getModel();
					int index = list.getSelectedIndex();
					if (index != -1)
					{
						model.remove(index);
					}
				}
			}
		});
		add(removeButton, BorderLayout.EAST);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends String> list,
			String value, int index, boolean isSelected, boolean cellHasFocus)
	{
		itemNameLabel.setText(value);
		return this;
	}
}
