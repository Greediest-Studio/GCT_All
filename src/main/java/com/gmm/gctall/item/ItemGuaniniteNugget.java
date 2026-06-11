
package com.gmm.gctall.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import com.gmm.gctall.creativetab.TabCTab;
import net.minecraft.item.Item;

public class ItemGuaniniteNugget extends Item {
    public static final Item block = new ItemGuaniniteNugget();

    public ItemGuaniniteNugget() {
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.setTranslationKey("guaninite_nugget");
        this.setRegistryName("guaninite_nugget");
        this.setCreativeTab(TabCTab.tab);

    }
}
