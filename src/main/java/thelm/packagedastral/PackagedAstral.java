package thelm.packagedastral;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thelm.packagedastral.block.BlockAttunementCrafter;
import thelm.packagedastral.block.BlockConstellationCrafter;
import thelm.packagedastral.block.BlockDiscoveryCrafter;
import thelm.packagedastral.block.BlockTraitCrafter;
import thelm.packagedastral.proxy.CommonProxy;
import thelm.packagedastral.tile.TileAttunementCrafter;
import thelm.packagedastral.tile.TileConstellationCrafter;
import thelm.packagedastral.tile.TileDiscoveryCrafter;
import thelm.packagedastral.tile.TileTraitCrafter;

@Mod(
		modid = PackagedAstral.MOD_ID,
		name = PackagedAstral.NAME,
		version = PackagedAstral.VERSION,
		dependencies = PackagedAstral.DEPENDENCIES,
		guiFactory = PackagedAstral.GUI_FACTORY
		)
public class PackagedAstral {

	public static final String MOD_ID = "packagedastral";
	public static final String NAME = "PackagedAstral";
	public static final String VERSION = "1.12.2-1.0.1.8";
	public static final String DEPENDENCIES = "required-after:packagedauto@[1.12.2-1.0.8,);required-after:astralsorcery;";
	public static final String GUI_FACTORY = "thelm.packagedastral.client.gui.GuiPackagedAstralConfigFactory";
	public static final CreativeTabs CREATIVE_TAB = new CreativeTabs("packagedastral") {
		@SideOnly(Side.CLIENT)
		@Override
		public ItemStack createIcon() {
			if(TileTraitCrafter.enabled) {
				return new ItemStack(BlockTraitCrafter.INSTANCE);
			}
			if(TileConstellationCrafter.enabled) {
				return new ItemStack(BlockConstellationCrafter.INSTANCE);
			}
			if(TileAttunementCrafter.enabled) {
				return new ItemStack(BlockAttunementCrafter.INSTANCE);
			}
			if(TileDiscoveryCrafter.enabled) {
				return new ItemStack(BlockDiscoveryCrafter.INSTANCE);
			}
			return ItemStack.EMPTY;
		}
	};
	@Instance
	public static PackagedAstral instance;
	@SidedProxy(clientSide = "thelm.packagedastral.proxy.ClientProxy", serverSide = "thelm.packagedastral.proxy.CommonProxy", modId = PackagedAstral.MOD_ID)
	public static CommonProxy proxy;
	public static ModMetadata metadata;

	@EventHandler
	public void firstMovement(FMLPreInitializationEvent event) {
		metadata = event.getModMetadata();
		metadata.autogenerated = false;
		metadata.version = VERSION;
		metadata.authorList.add("TheLMiffy1111");
		metadata.description = "A PackagedAuto addon that adds Astral Sorcery autocrafting.";

		proxy.register(event);
	}

	@EventHandler
	public void secondMovement(FMLInitializationEvent event) {
		proxy.register(event);
	}
}
