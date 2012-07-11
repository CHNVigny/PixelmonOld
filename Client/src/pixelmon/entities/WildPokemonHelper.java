package pixelmon.entities;

import net.minecraft.src.ModLoader;
import net.minecraft.src.World;

public class WildPokemonHelper {

	@SuppressWarnings("unchecked")
	public static IHaveHelper getCapturedPokemonEntity(String name, World world) {
		try 
		{
			Class<? extends BaseEntityPixelmon> entity = (Class<? extends BaseEntityPixelmon>) Class.forName("Pokemon.Entity" + name); 
			return  (IHaveHelper) entity.getConstructor(new Class[] { World.class })
					.newInstance(new Object[] { ModLoader.getMinecraftInstance().theWorld });
		} catch (Exception e) 
		{
			System.err.println("Can not find class Entity" + name );
			e.printStackTrace();
		}
		return null;
	}

}
