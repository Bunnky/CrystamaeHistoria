package io.github.sefiraat.crystamaehistoria.slimefun.gadgets;

import io.github.sefiraat.crystamaehistoria.utils.GeneralUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class AngelBlock extends SlimefunItem {

    public AngelBlock(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, @Nullable ItemStack recipeOutput) {
        super(itemGroup, item, recipeType, recipe, recipeOutput);
        this.addItemHandler(
            (ItemUseHandler) e -> {
                Location location = e.getPlayer().getEyeLocation();
                Block block = location.add(location.getDirection()).getBlock();
                if (block.isEmpty() && GeneralUtils.hasPermission(e.getPlayer(), block, Interaction.PLACE_BLOCK)) {
                    block.setType(e.getItem().getType());
                    BlockStorage.store(block, e.getItem());
                    e.getItem().setAmount(e.getItem().getAmount() - 1);
                }
            }
        );
    }
}
