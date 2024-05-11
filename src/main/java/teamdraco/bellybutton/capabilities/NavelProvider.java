package teamdraco.bellybutton.capabilities;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class NavelProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<NavelData> NAVEL_POS = CapabilityManager.get(new CapabilityToken<>(){});
    private NavelData navelData = null;
    private final LazyOptional<NavelData> opt = LazyOptional.of(this::createNavelData);

    @Nonnull
    private NavelData createNavelData() {
        if (navelData == null) {
            navelData = new NavelData();
        }
        return navelData;
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        if (cap == NAVEL_POS) {
            return opt.cast();
        }
        return LazyOptional.empty();
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return getCapability(cap);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        createNavelData().saveNBTData(tag);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        createNavelData().loadNBTData(tag);
    }
}
