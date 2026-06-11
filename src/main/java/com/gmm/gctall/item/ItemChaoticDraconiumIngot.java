
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemChaoticDraconiumIngot extends Item {
    public static final Item block = new ItemChaoticDraconiumIngot();

    public ItemChaoticDraconiumIngot() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("chaotic_draconium_ingot");
        this.setRegistryName("chaotic_draconium_ingot");
        this.setCreativeTab(TabCTab.tab);

    }
}
