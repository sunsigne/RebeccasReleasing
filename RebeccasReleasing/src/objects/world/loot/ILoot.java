package objects.world.loot;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public interface ILoot {

	LootObject getLootObject();
	
	void setLootObject(LootObject loot);
	
	public default void loot()
	{
		if(getLootObject() != null) HandlerObject.getInstance().addObject(getLootObject());
	}
}
