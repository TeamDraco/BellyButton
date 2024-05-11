package teamdraco.bellybutton.registry;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.RegistryObject;
import teamdraco.bellybutton.BellyButton;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import teamdraco.bellybutton.common.items.DustBunnyItem;
import teamdraco.bellybutton.common.items.ItchySweaterItem;
import teamdraco.bellybutton.common.items.MaidArmorItem;

public class BBItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BellyButton.MOD_ID);

    public static final RegistryObject<Item> LINT = ITEMS.register("lint", () -> new Item(new Item.Properties().tab(BellyButton.GROUP)));
    public static final RegistryObject<Item> VACUUM = ITEMS.register("vacuum", () -> new Item(new Item.Properties().tab(BellyButton.GROUP).stacksTo(1)));
    public static final RegistryObject<Item> DUST_BUNNY = ITEMS.register("dust_bunny", () -> new DustBunnyItem(BBEntities.DUST_BUNNY, new Item.Properties().tab(BellyButton.GROUP).stacksTo(1)));
    public static final RegistryObject<Item> MUSIC_DISC_BELLY_BOPPIN = ITEMS.register("music_disc_belly_boppin", () -> new RecordItem(15, BBSounds.BELLY_BOPPIN, new Item.Properties().tab(BellyButton.GROUP).stacksTo(1).rarity(Rarity.EPIC), 3187));
    public static final RegistryObject<Item> ITCHY_SWEATER = ITEMS.register("itchy_sweater", () -> new ItchySweaterItem(ArmorMaterials.LEATHER, EquipmentSlot.CHEST, new Item.Properties().tab(BellyButton.GROUP).stacksTo(1)));
    public static final RegistryObject<Item> MAID_HAIRBAND = ITEMS.register("maid_hairband", () -> new MaidArmorItem(ArmorMaterials.LEATHER, EquipmentSlot.HEAD, new Item.Properties().tab(BellyButton.GROUP).stacksTo(1)));
    public static final RegistryObject<Item> MAID_DRESS = ITEMS.register("maid_dress", () -> new MaidArmorItem(ArmorMaterials.LEATHER, EquipmentSlot.CHEST, new Item.Properties().tab(BellyButton.GROUP).stacksTo(1)));
    public static final RegistryObject<Item> MAID_SKIRT = ITEMS.register("maid_skirt", () -> new MaidArmorItem(ArmorMaterials.LEATHER, EquipmentSlot.LEGS, new Item.Properties().tab(BellyButton.GROUP).stacksTo(1)));
    public static final RegistryObject<Item> MAID_SHOES = ITEMS.register("maid_shoes", () -> new MaidArmorItem(ArmorMaterials.LEATHER, EquipmentSlot.FEET, new Item.Properties().tab(BellyButton.GROUP).stacksTo(1)));

    public static final RegistryObject<Item> BELLY_BUTTON = ITEMS.register("belly_button", () -> new BlockItem(BBBlocks.BELLY_BUTTON.get(), new Item.Properties().tab(BellyButton.GROUP)));
    public static final RegistryObject<Item> LINT_BLOCK = ITEMS.register("lint_block", () -> new BlockItem(BBBlocks.LINT_BLOCK.get(), new Item.Properties().tab(BellyButton.GROUP)));
    public static final RegistryObject<Item> LINT_CARPET = ITEMS.register("lint_carpet", () -> new BlockItem(BBBlocks.LINT_CARPET.get(), new Item.Properties().tab(BellyButton.GROUP)));

    public static final RegistryObject<Item> DUSTY_BUNNY_SPAWN_EGG = ITEMS.register("dust_bunny_spawn_egg", () -> new ForgeSpawnEggItem(BBEntities.DUST_BUNNY, 0x726b65, 0xa9a6a1, new Item.Properties().tab(BellyButton.GROUP)));
    public static final RegistryObject<Item> MAID_SPAWN_EGG = ITEMS.register("maid_spawn_egg", () -> new ForgeSpawnEggItem(BBEntities.MAID, 0x29242c, 0xd7d7d7, new Item.Properties().tab(BellyButton.GROUP)));
    public static final RegistryObject<Item> EVIL_DUSTY_BUNNY_SPAWN_EGG = ITEMS.register("evil_dust_bunny_spawn_egg", () -> new ForgeSpawnEggItem(BBEntities.EVIL_DUST_BUNNY, 0x726b65, 0x3d3d3d, new Item.Properties().tab(BellyButton.GROUP)));

}