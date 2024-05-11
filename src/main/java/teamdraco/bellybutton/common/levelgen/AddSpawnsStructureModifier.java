package teamdraco.bellybutton.common.levelgen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraftforge.common.world.ModifiableStructureInfo;
import net.minecraftforge.common.world.StructureModifier;
import teamdraco.bellybutton.registry.BBStructureModifiers;

public record AddSpawnsStructureModifier(HolderSet<Structure> structures, MobCategory category, MobSpawnSettings.SpawnerData spawn) implements StructureModifier {
    public static final Codec<AddSpawnsStructureModifier> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            RegistryCodecs.homogeneousList(BuiltinRegistries.STRUCTURES.key(), Structure.DIRECT_CODEC).fieldOf("structures").forGetter(AddSpawnsStructureModifier::structures),
            MobCategory.CODEC.fieldOf("category").forGetter(AddSpawnsStructureModifier::category),
            MobSpawnSettings.SpawnerData.CODEC.fieldOf("spawn").forGetter(AddSpawnsStructureModifier::spawn)
    ).apply(builder, AddSpawnsStructureModifier::new));

    @Override
    public void modify(Holder<Structure> structure, Phase phase, ModifiableStructureInfo.StructureInfo.Builder builder) {
        if (phase == Phase.ADD && this.structures.contains(structure)) {
            builder.getStructureSettings().getOrAddSpawnOverrides(category).addSpawn(spawn);
        }
    }

    @Override
    public Codec<? extends StructureModifier> codec() {
        return BBStructureModifiers.ADD_SPAWNS_MODIFIER.get();
    }
}