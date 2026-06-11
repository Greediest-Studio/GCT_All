
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemChaoticDraconiumNugget extends Item {
    public static final Item block = new ItemChaoticDraconiumNugget();

    public ItemChaoticDraconiumNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("chaotic_draconium_nugget");
        this.setRegistryName("chaotic_draconium_nugget");
        this.setCreativeTab(TabCTab.tab);

    }
}
