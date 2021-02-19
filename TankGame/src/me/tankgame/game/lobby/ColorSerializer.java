package me.tankgame.game.lobby;

import java.awt.Color;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class ColorSerializer extends Serializer<Color> {
    
	@Override
	public Color read(Kryo arg0, Input arg1, Class<Color> arg2) {
		return new Color(arg1.readInt());
	}

	@Override
	public void write(Kryo arg0, Output arg1, Color arg2) {
		arg1.writeInt(arg2.getRGB());
	}
}