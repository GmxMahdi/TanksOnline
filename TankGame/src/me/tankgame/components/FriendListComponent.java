package me.tankgame.components;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import me.tankgame.network.ClientHandler;
import me.tankgame.network.NetManager;
import me.tankgame.network.paquet.database.AddFriendRequest;
import me.tankgame.network.paquet.database.FriendListRequest;
import me.tankgame.network.paquet.database.RemoveFriendRequest;
import me.tankgame.network.paquet.database.ReplyFriendRequest;

public class FriendListComponent extends JPanel {
	private JPopupMenu popup;
	private DefaultListModel<Friend> model;
	
	public FriendListComponent() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 28, 163, 230);
		add(scrollPane);
		
		JList<Friend> list = new JList<Friend>();
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel = new JLabel("Friends");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 0, 163, 26);
		add(lblNewLabel);
		
		JButton btnAddFriend = new JButton("Add Friend");
		btnAddFriend.setBounds(74, 297, 89, 23);
		add(btnAddFriend);
		
		
		model = new DefaultListModel<Friend>();
		list.setModel(model);
		
		TextFieldWithPrompt txtAddFriend = new TextFieldWithPrompt("Add friend here...");
		txtAddFriend.setBounds(0, 269, 163, 20);
		add(txtAddFriend);	
		
		btnAddFriend.addActionListener(e -> {
			String username = txtAddFriend.getText();
			ClientHandler.send(new AddFriendRequest(NetManager.getPlayer().getUsername(), username));
			txtAddFriend.setText("");
		});
		
		popup = new JPopupMenu();
		JMenuItem JMIremoveFriend = new JMenuItem("Remove Friend");
		JMenuItem JMIacceptFriend = new JMenuItem("Accept Friend Request");
		JMenuItem JMIdeclineFriend = new JMenuItem("Decline Friend Request");
		
		
		JMIacceptFriend.addActionListener(e -> {
			ReplyFriendRequest frf = new ReplyFriendRequest(
					list.getSelectedValue().username,
					NetManager.getPlayer().getUsername(),
					FriendStatus.APPROVED
					);
			ClientHandler.send(frf);
		});
		
		JMIdeclineFriend.addActionListener(e -> {
			ReplyFriendRequest frf = new ReplyFriendRequest(
					list.getSelectedValue().username,
					NetManager.getPlayer().getUsername(),
					FriendStatus.DECLINED
					);
			ClientHandler.send(frf);
		});
		
		JMIremoveFriend.addActionListener(e -> {
			Friend f = list.getSelectedValue();
			RemoveFriendRequest rfr = new RemoveFriendRequest(NetManager.getPlayer().getUsername(), f.username);
			ClientHandler.send(rfr);
		});
		
		list.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e)
	        {
	            if (SwingUtilities.isRightMouseButton(e))
	            {
	                // JList list = (JList)e.getSource();
	                int row = list.locationToIndex(e.getPoint());
	                list.setSelectedIndex(row);
	                
	                Friend f = list.getSelectedValue();
	                if (f.status == FriendStatus.APPROVED) {
	                	popup.remove(JMIacceptFriend);
	                	popup.remove(JMIdeclineFriend);
	                	popup.add(JMIremoveFriend);
	                }
	                else {
	                	popup.remove(JMIremoveFriend);
	                	popup.add(JMIacceptFriend);
	                	popup.add(JMIdeclineFriend);
	                }
	            	showPopup(e);
	            }
	        }
		});

	}

   public void refreshFriendList() {
	   ClientHandler.send(new FriendListRequest(NetManager.getPlayer().getUsername()));
   }
   
   public void populateFriendList(ArrayList<Friend> friends) {
	   model.removeAllElements();
	   model.addAll(friends);
   }
   
   private void showPopup(MouseEvent me) {
	   popup.show(me.getComponent(), me.getX(), me.getY());
   }
}
