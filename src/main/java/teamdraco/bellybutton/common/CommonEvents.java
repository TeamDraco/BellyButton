package teamdraco.bellybutton.common;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teamdraco.bellybutton.BellyButton;
import teamdraco.bellybutton.registry.BBEnchantments;
import teamdraco.bellybutton.registry.BBItems;

import java.util.List;

@Mod.EventBusSubscriber(modid = BellyButton.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEvents {

    // todo - switch to GLMs
    @SubscribeEvent
    public static void lintRollerDrops(LivingDeathEvent event) {
        Entity attacker = event.getSource().getEntity();

        if (attacker instanceof LivingEntity livingEntity) {
            ItemStack heldItem = livingEntity.getMainHandItem();
            if (EnchantmentHelper.getEnchantments(heldItem).containsKey(BBEnchantments.LINT_ROLLER.get())) {
                if (livingEntity.getRandom().nextDouble() < 0.035) {
                    event.getEntity().spawnAtLocation(BBItems.LINT.get());
                }
            }
        }
    }

    @SubscribeEvent
    public static void addWandererTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> list = event.getGenericTrades();

        list.add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), new ItemStack(BBItems.VACUUM.get(), 1), 3, 5, 1.5f));
    }
}
