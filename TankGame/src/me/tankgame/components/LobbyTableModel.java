package me.tankgame.components;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import me.tankgame.game.lobby.Lobby;
import me.tankgame.game.lobby.Player;



public class LobbyTableModel extends AbstractTableModel {

	static private ArrayList<Lobby> lobbies;
	
	public LobbyTableModel() {
		lobbies = new ArrayList<Lobby>();
	}
	
	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return lobbies.size();
	}
	
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: return String.class;
            case 1: return String.class;
        }
        return Object.class;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Lobby Name";
            case 1: return "Players";
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lobby item = lobbies.get(rowIndex);
        switch (columnIndex) {
            case 0: return item.getLobbyName();
            case 1: return item.getPlayerCount();
        }
        return null;
    }
    
    public Lobby getLobby(int rowIndex) {
    	if (rowIndex >= lobbies.size()) return null;
    	return lobbies.get(rowIndex);
    }

    public void add(Lobby lobby) {
    	lobbies.add(lobby);
        int row = lobbies.indexOf(lobby);
        fireTableRowsInserted(row, row);
    }

    public void remove(Lobby lobby) {
        if (lobbies.contains(lobby)) {
            int row = lobbies.indexOf(lobby);
            lobbies.remove(row);
            fireTableRowsDeleted(row, row);
        }
    }
    
    public void removeAll() {
    	while (lobbies.size() != 0)
    		this.remove(lobbies.get(0));
    }
    public void addAll(ArrayList<Lobby> lobbies) {
    	for (int i = 0; i < lobbies.size(); ++i)
    		this.add(lobbies.get(i));
    }
 

}
