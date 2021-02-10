package me.tankgame.game.lobby;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.time.LocalTime;

public class LocalTimeSerializer extends Serializer<LocalTime> {


	@Override
	public LocalTime read(Kryo arg0, Input arg1, Class<LocalTime> arg2) {
		return LocalTime.parse(arg1.readString());
	}

	@Override
	public void write(Kryo arg0, Output arg1, LocalTime arg2) {
		arg1.writeString(arg2.toString());
	}

}
