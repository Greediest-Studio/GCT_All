
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemRuledDraconiumIngot extends Item {
    public static final Item block = new ItemRuledDraconiumIngot();

    public ItemRuledDraconiumIngot() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("ruled_draconium_ingot");
        this.setRegistryName("ruled_draconium_ingot");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
