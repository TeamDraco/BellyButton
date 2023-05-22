package teamdraco.bellybutton.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;
import teamdraco.bellybutton.BellyButton;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BBSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BellyButton.MOD_ID);

    public static final RegistryObject<SoundEvent> VACUUM = SOUNDS.register("vacuum", () -> new SoundEvent(new ResourceLocation(BellyButton.MOD_ID, "vacuum")));
    public static final RegistryObject<SoundEvent> BELLY_BOPPIN = SOUNDS.register("belly_boppin", () -> new SoundEvent(new ResourceLocation(BellyButton.MOD_ID, "belly_boppin")));
}
