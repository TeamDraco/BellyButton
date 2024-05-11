package teamdraco.bellybutton.registry;

import com.mojang.serialization.Codec;
import net.minecraftforge.common.world.StructureModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import teamdraco.bellybutton.BellyButton;
import teamdraco.bellybutton.common.levelgen.AddSpawnsStructureModifier;

public class BBStructureModifiers {
    public static final DeferredRegister<Codec<? extends StructureModifier>> STRUCTURE_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.STRUCTURE_MODIFIER_SERIALIZERS, BellyButton.MOD_ID);

    public static final RegistryObject<Codec<AddSpawnsStructureModifier>> ADD_SPAWNS_MODIFIER = STRUCTURE_MODIFIERS.register("add_spawn", () -> AddSpawnsStructureModifier.CODEC);
}
