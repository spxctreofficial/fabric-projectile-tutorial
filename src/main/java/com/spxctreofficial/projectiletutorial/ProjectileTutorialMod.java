package com.spxctreofficial.projectiletutorial;

import com.spxctreofficial.projectiletutorial.entity.PackedSnowballEntity;
import com.spxctreofficial.projectiletutorial.item.PackedSnowballItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ProjectileTutorialMod implements ModInitializer {
	public static final String ModID = "projectiletutorial"; // This is just so we can refer to our ModID easier.

	public static final EntityType<PackedSnowballEntity> PackedSnowballEntityType = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(ModID, "packed_snowball"),
			FabricEntityTypeBuilder.<PackedSnowballEntity>create(SpawnGroup.MISC, PackedSnowballEntity::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
					.trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
					.build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
	);

	public static final Item PackedSnowballItem = new PackedSnowballItem(new Item.Settings().group(ItemGroup.MISC).maxCount(16));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier(ModID, "packed_snowball"), PackedSnowballItem);
	}
}