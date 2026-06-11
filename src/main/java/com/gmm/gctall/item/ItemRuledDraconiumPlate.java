
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTabWitheric;
import net.minecraft.item.Item;

public class ItemRuledDraconiumPlate extends Item {
    public static final Item block = new ItemRuledDraconiumPlate();

    public ItemRuledDraconiumPlate() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("ruled_draconium_plate");
        this.setRegistryName("ruled_draconium_plate");
        this.setCreativeTab(TabCTabWitheric.tab);

    }
}
