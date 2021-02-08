package me.tankgame.network;

import com.esotericsoftware.kryo.Kryo;

import me.tankgame.network.paquet.database.*;

public class Register {

	public static void register(Kryo k) {
		k.register(LoginRequest.class);
		k.register(LoginResponse.class);
	}
}
