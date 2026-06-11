
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemRuledDraconiumNugget extends Item {
    public static final Item block = new ItemRuledDraconiumNugget();

    public ItemRuledDraconiumNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("ruled_draconium_nugget");
        this.setRegistryName("ruled_draconium_nugget");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
