package me.tankgame.components;

public enum FriendStatus {
	PENDING(1),
	APPROVED(2),
	DECLINED(3);
	
	private final int value;
	private FriendStatus(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static FriendStatus getFriendStatus(int value) {
		switch (value) {
		case 1: return FriendStatus.PENDING;
		case 2: return FriendStatus.APPROVED;
		case 3: return FriendStatus.DECLINED;
		default: return null;
		}
	}
}
