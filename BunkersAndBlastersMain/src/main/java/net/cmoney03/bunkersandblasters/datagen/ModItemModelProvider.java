package net.cmoney03.bunkersandblasters.datagen;

import net.cmoney03.bunkersandblasters.BunkersAndBlasters;

import net.cmoney03.bunkersandblasters.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BunkersAndBlasters.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.VISCOROK_INGOT);
        simpleItem(ModItems.VISCOROK_SHARD);
        simpleItem(ModItems.PLASTEEL_INGOT);
        simpleItem(ModItems.PLASTEEL_INGOT);
        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.BRACHITE_INGOT);



    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BunkersAndBlasters.MOD_ID,"item/" + item.getId().getPath()));
    }
}
