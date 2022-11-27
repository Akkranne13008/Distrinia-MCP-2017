package fr.telozia.bastienr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public class GuiWiki
  extends GuiContainer
{ 
  private static final ResourceLocation tabCraft = new ResourceLocation("textures/gui/container/wiki.png");
  private static final Set<IRecipe> recipes = new LinkedHashSet();
  private static InventoryBasic inventory = new InventoryBasic("tmp", true, 45);
  private static GuiTextField textField;
  private static boolean field_147057_D;
  private float field_147067_x;
  private boolean field_147066_y;
  private boolean field_147065_z;
  private static int field_147058_w = CreativeTabs.tabAllSearch.getTabIndex();
private static EntityPlayer entity;
  private List field_147063_B;
  private Slot field_147064_C;

  public GuiWiki(EntityClientPlayerMP thePlayer)
  {
    super(new ContainerCrafts(entity));
    field_147057_D = true;
    if (recipes.size() == 0)
    {
      Iterator var2 = CraftingManager.getInstance().getRecipeList().iterator();
      while (var2.hasNext())
      {
        IRecipe recipe = (IRecipe)var2.next();
        if (recipe.getRecipeOutput() != null) {
          recipes.add(recipe);
        }
      }
    }
  }
  
  protected void func_146979_b(int p_146979_1_, int p_146979_2_)
  {
    GL11.glDisable(3042);
    this.fontRendererObj.drawString(I18n.format(EnumChatFormatting.DARK_PURPLE + "Recherche :", new Object[0]), 8, 6, 4210752);
  }
  
  protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_)
  {
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    this.mc.getTextureManager().bindTexture(tabCraft);
    drawTexturedModalRect(this.field_147003_i, this.field_147009_r, 0 , 0, 200 + 55, 190);
    textField.drawTextBox();
    int var9 = this.field_147003_i + 175;
    int var6 = this.field_147009_r + 18;
    int var7 = var6 + 112;
    this.mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/creative_inventory/tabs.png"));
    drawTexturedModalRect(var9, var6 + (int)((float)(var7 - var6 - 17) * this.field_147067_x), 232 + (this.func_147055_p() ? 0 : 12), 0, 12, 15);
  }
  
  public void initGui()
  {
    super.initGui();
    
    this.buttonList.clear();
    Keyboard.enableRepeatEvents(true);
    textField = new GuiTextField(this.fontRendererObj, this.field_147003_i + 82, this.field_147009_r + 6, 89, this.fontRendererObj.FONT_HEIGHT);
    textField.func_146203_f(15);
    textField.func_146185_a(false);
    textField.func_146189_e(false);
    textField.func_146193_g(16777215);
    int var1 = field_147058_w;
    func_147050_b(CreativeTabs.creativeTabArray[var1]);
    
    
  }
  
  protected void actionPerformed(GuiButton p_146284_1_)
  {
            
      //Bouton retour
      if (p_146284_1_.id == 3)
      {
      	this.mc.displayGuiScreen(new GuiInventory(this.mc.thePlayer));
      }
      
      //Bouton fermer
      if(p_146284_1_.id == 4) 
      {
      	this.mc.displayGuiScreen((GuiScreen)null);
          this.mc.setIngameFocus();        	
      }
      
  }
  
  public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_)
  {
    boolean var4 = Mouse.isButtonDown(0);
    int var5 = this.field_147003_i;
    int var6 = this.field_147009_r;
    int var7 = var5 + 175;
    int var8 = var6 + 18;
    int var9 = var7 + 14;
    int var10 = var8 + 112;
    if ((!this.field_147065_z) && (var4) && (p_73863_1_ >= var7) && (p_73863_2_ >= var8) && (p_73863_1_ < var9) && (p_73863_2_ < var10)) {
      this.field_147066_y = func_147055_p();
    }
    if (!var4) {
      this.field_147066_y = false;
    }
    this.field_147065_z = var4;
    if (this.field_147066_y)
    {
      this.field_147067_x = ((p_73863_2_ - var8 - 7.5F) / (var10 - var8 - 15.0F));
      if (this.field_147067_x < 0.0F) {
        this.field_147067_x = 0.0F;
      }
      if (this.field_147067_x > 0.77F) {
        this.field_147067_x = 0.77F;
      }
      ((ContainerCrafts)this.field_147002_h).func_148329_a(this.field_147067_x);
    }
     super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
     GL11.glDisable(2896);
  }
  
  protected void keyTyped(char p_73869_1_, int p_73869_2_)
  {
    if (field_147057_D)
    {
      field_147057_D = false;
      textField.setText  ("");
    }
    if (textField.textboxKeyTyped(p_73869_1_, p_73869_2_)) {
      func_147053_i();
    } else {
      super.keyTyped(p_73869_1_, p_73869_2_);
    }
  }
  
  private void func_147053_i()
  {
    ContainerCrafts var1 = (ContainerCrafts)this.field_147002_h;
    var1.field_148330_a.clear();
    Iterator var2 = Item.itemRegistry.iterator();
    while (var2.hasNext())
    {
      Item var8 = (Item)var2.next();
      if ((var8 != null) && (var8.getCreativeTab() != null)) {
        var8.getSubItems(var8, null, var1.field_148330_a);
      }
    }
    Enchantment[] var101 = Enchantment.enchantmentsList;
    int var9 = var101.length;
    for (int var10 = 0; var10 < var9; var10++)
    {
      Enchantment var11 = var101[var10];
      if ((var11 != null) && (var11.type != null)) {
        Items.enchanted_book.func_92113_a(var11, var1.field_148330_a);
      }
    }
    var2 = var1.field_148330_a.iterator();
    String var111 = textField.getText().toLowerCase();
    while (var2.hasNext())
    {
      ItemStack var121 = (ItemStack)var2.next();
      boolean var12 = false;
      Iterator var6 = var121.getTooltip(this.mc.thePlayer, this.mc.gameSettings.advancedItemTooltips).iterator();
      while (var6.hasNext())
      {
        String var7 = (String)var6.next();
        if (var7.toLowerCase().contains(var111)) {
          var12 = true;
        }
      }
      if (!var12) {
        var2.remove();
      }
    }
    this.field_147067_x = 0.0F;
    var1.func_148329_a(0.0F);
  }
  
  private void func_147050_b(CreativeTabs p_147050_1_)
  {
    int var2 = field_147058_w;
    field_147058_w = p_147050_1_.getTabIndex();
    ContainerCrafts var3 = (ContainerCrafts)this.field_147002_h;
    this.field_147008_s.clear();
    var3.field_148330_a.clear();
    p_147050_1_.displayAllReleventItems(var3.field_148330_a);
    if (var2 == CreativeTabs.tabInventory.getTabIndex())
    {
      var3.inventorySlots = this.field_147063_B;
      this.field_147063_B = null;
    }
    if (textField != null) {
      if (p_147050_1_ == CreativeTabs.tabAllSearch)
      {
        textField.func_146189_e(true);
        textField.func_146205_d(false);
        textField.setFocused(true);
        textField.setText("");
        func_147053_i();
      }
      else
      {
        textField.func_146189_e(false);
        textField.func_146205_d(true);
        textField.setFocused(false);
      }
    }
    this.field_147067_x = 0.0F;
    var3.func_148329_a(0.0F);
  }
  
  private boolean func_147055_p()
  {
    return (CreativeTabs.creativeTabArray[field_147058_w].shouldHidePlayerInventory()) && (((ContainerCrafts)this.field_147002_h).func_148328_e());
  }
  
  public void handleMouseInput()
  {
    super.handleMouseInput();
    int var1 = Mouse.getEventDWheel();
    if ((var1 != 0) && (func_147055_p()))
    {
      int var2 = ((ContainerCrafts)this.field_147002_h).field_148330_a.size() / 4  - 1 + 1;
      if (var1 > 0) {
        var1 = 1;
      }
      if (var1 < 0) {
        var1 = -1;
      }
      this.field_147067_x = (float)((double)this.field_147067_x - (double)var1 / (double)var2);
      if (this.field_147067_x < 0.0F) {
        this.field_147067_x = 0.0F;
      }
      if (this.field_147067_x > 0.77F) {
        this.field_147067_x = 0.77F;
      }
      ((ContainerCrafts)this.field_147002_h).func_148329_a(this.field_147067_x);
    }
  }
  
  protected void func_146984_a(Slot p_146984_1_, int p_146984_2_, int p_146984_3_, int p_146984_4_)
  {
    if ((p_146984_1_ != null) && (p_146984_1_.getHasStack()))
    {
      ContainerCrafts craft = (ContainerCrafts)this.field_147002_h;
      ItemStack stack = p_146984_1_.getStack();
      if (stack != null) {
        craft.setRecipe(stack);
      }
    }
  }
  
  static class ContainerCrafts
    extends Container
  {
    public List field_148330_a = new ArrayList();
    public IInventory[] matrixs = new IInventory[9];
    public IInventory craftResult = new InventoryCraftResult();
    
    public ContainerCrafts(EntityPlayer p_i1086_1_)
    {
      for (int var3 = 0; var3 < 5; var3++) {
        for (int i = 0; i < 9; i++) {
          addSlotToContainer(new Slot(GuiWiki.inventory, var3 * 9 + i, 9 + i * 18, 18 + var3 * 18));
        }
      }
      addSlotToContainer(new Slot(this.craftResult, 46, 128, 138));
      int i = 0;
      for (int var6 = 0; var6 < 3; var6++) {
        for (int var7 = 0; var7 < 3; var7++)
        {
          IInventory inventory = this.matrixs[i] = new InventoryCraftResult();
          addSlotToContainer(new Slot(inventory, i + 47, 30 + var7 * 18 + 4, 17 + var6 * 18 + 103));
          i++;
        }
      }
      func_148329_a(0.0F);
    }
    
    public void func_148329_a(float p_148329_1_)
    {
      int var2 = this.field_148330_a.size() / 9 - 5 + 1;
      int var3 = (int)(p_148329_1_ * var2 * 1.25D + 0.5D);
      if (var3 < 0) {
        var3 = 0;
      }
      for (int var4 = 0; var4 < 5; var4++) {
        for (int var5 = 0; var5 < 9; var5++)
        {
          int var6 = var5 + (var4 + var3) * 9;
          if ((var6 >= 0) && (var6 < this.field_148330_a.size())) {
            GuiWiki.inventory.setInventorySlotContents(var5 + var4 * 9, (ItemStack)this.field_148330_a.get(var6));
          } else {
            GuiWiki.inventory.setInventorySlotContents(var5 + var4 * 9, null);
          }
        }
      }
    }
    
    public void setRecipe(ItemStack stack)
    {
      clearMatrix();
      this.craftResult.setInventorySlotContents(0, stack);
      IRecipe recipe = null;
      Iterator shape = CraftingManager.getInstance().getRecipeList().iterator();
      while (shape.hasNext())
      {
        IRecipe stacks = (IRecipe)shape.next();
        if ((stacks != null) && (stacks.getRecipeOutput() != null) && (stacks.getRecipeOutput().getItem() != null) && (stacks.getRecipeOutput().getItem().equals(stack.getItem())))
        {
          recipe = stacks;
          break;
        }
      }
      if (recipe != null)
      {
        this.craftResult.setInventorySlotContents(0, recipe.getRecipeOutput());
        if ((recipe instanceof ShapedRecipes))
        {
          ShapedRecipes var10 = (ShapedRecipes)recipe;
          ItemStack[] var12 = var10.recipeItems;
          if ((!recipe.getRecipeOutput().getItem().equals(Items.wooden_sword)) && (!recipe.getRecipeOutput().getItem().equals(Items.stone_sword)) && (!recipe.getRecipeOutput().getItem().equals(Items.golden_sword)) && (!recipe.getRecipeOutput().getItem().equals(Items.iron_sword)) && (!recipe.getRecipeOutput().getItem().equals(Items.diamond_sword)))
          {
            if ((!recipe.getRecipeOutput().getItem().equals(Items.wooden_axe)) && (!recipe.getRecipeOutput().getItem().equals(Items.stone_axe)) && (!recipe.getRecipeOutput().getItem().equals(Items.golden_axe)) && (!recipe.getRecipeOutput().getItem().equals(Items.iron_axe)) && (!recipe.getRecipeOutput().getItem().equals(Items.diamond_axe)))
            {
              if ((!recipe.getRecipeOutput().getItem().equals(Items.wooden_hoe)) && (!recipe.getRecipeOutput().getItem().equals(Items.stone_hoe)) && (!recipe.getRecipeOutput().getItem().equals(Items.golden_hoe)) && (!recipe.getRecipeOutput().getItem().equals(Items.iron_hoe)) && (!recipe.getRecipeOutput().getItem().equals(Items.diamond_hoe)))
              {
                if ((!recipe.getRecipeOutput().getItem().equals(Items.wooden_shovel)) && (!recipe.getRecipeOutput().getItem().equals(Items.stone_shovel)) && (!recipe.getRecipeOutput().getItem().equals(Items.golden_shovel)) && (!recipe.getRecipeOutput().getItem().equals(Items.iron_shovel)) && (!recipe.getRecipeOutput().getItem().equals(Items.diamond_shovel)))
                {
                  if ((!recipe.getRecipeOutput().getItem().equals(Item.getItemFromBlock(Blocks.iron_block))) && (!recipe.getRecipeOutput().getItem().equals(Item.getItemFromBlock(Blocks.gold_block))) && (!recipe.getRecipeOutput().getItem().equals(Item.getItemFromBlock(Blocks.emerald_block))) && (!recipe.getRecipeOutput().getItem().equals(Item.getItemFromBlock(Blocks.diamond_block))) && (!recipe.getRecipeOutput().getItem().equals(Item.getItemFromBlock(Blocks.coal_block))) && (!recipe.getRecipeOutput().getItem().equals(Item.getItemFromBlock(Blocks.redstone_block))) && (!recipe.getRecipeOutput().getItem().equals(Item.getItemFromBlock(Blocks.lapis_block))))
                  {
                    if (recipe.getRecipeOutput().getItem().equals(Item.getItemFromBlock(Blocks.sandstone)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[1].setInventorySlotContents(0, var12[1]);
                      this.matrixs[3].setInventorySlotContents(0, var12[2]);
                      this.matrixs[4].setInventorySlotContents(0, var12[3]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemFromBlock(Blocks.sticky_piston)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[3].setInventorySlotContents(0, var12[1]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemFromBlock(Blocks.wool)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[1].setInventorySlotContents(0, var12[1]);
                      this.matrixs[3].setInventorySlotContents(0, var12[2]);
                      this.matrixs[4].setInventorySlotContents(0, var12[3]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemFromBlock(Blocks.brick_block)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[1].setInventorySlotContents(0, var12[1]);
                      this.matrixs[3].setInventorySlotContents(0, var12[2]);
                      this.matrixs[4].setInventorySlotContents(0, var12[3]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(50)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[3].setInventorySlotContents(0, var12[1]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(58)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[1].setInventorySlotContents(0, var12[1]);
                      this.matrixs[3].setInventorySlotContents(0, var12[2]);
                      this.matrixs[4].setInventorySlotContents(0, var12[3]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(69)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[3].setInventorySlotContents(0, var12[1]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(76)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[3].setInventorySlotContents(0, var12[1]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemFromBlock(Blocks.snow)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[1].setInventorySlotContents(0, var12[1]);
                      this.matrixs[3].setInventorySlotContents(0, var12[2]);
                      this.matrixs[4].setInventorySlotContents(0, var12[3]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemFromBlock(Blocks.clay)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[1].setInventorySlotContents(0, var12[1]);
                      this.matrixs[3].setInventorySlotContents(0, var12[2]);
                      this.matrixs[4].setInventorySlotContents(0, var12[3]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemFromBlock(Blocks.glowstone)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[1].setInventorySlotContents(0, var12[1]);
                      this.matrixs[3].setInventorySlotContents(0, var12[2]);
                      this.matrixs[4].setInventorySlotContents(0, var12[3]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(91)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[3].setInventorySlotContents(0, var12[1]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(170)))
                    {
                      for (int i = 0; i < 9; i++) {
                        this.matrixs[i].setInventorySlotContents(0, new ItemStack(var12[0].getItem(), 1));
                      }
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemFromBlock(Blocks.stonebrick)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[1].setInventorySlotContents(0, var12[1]);
                      this.matrixs[3].setInventorySlotContents(0, var12[2]);
                      this.matrixs[4].setInventorySlotContents(0, var12[3]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemFromBlock(Blocks.nether_brick)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[1].setInventorySlotContents(0, var12[1]);
                      this.matrixs[3].setInventorySlotContents(0, var12[2]);
                      this.matrixs[4].setInventorySlotContents(0, var12[3]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(131)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[3].setInventorySlotContents(0, var12[1]);
                      this.matrixs[6].setInventorySlotContents(0, var12[2]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemFromBlock(Blocks.trapped_chest)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[3].setInventorySlotContents(0, var12[1]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemFromBlock(Blocks.quartz_block)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[1].setInventorySlotContents(0, var12[1]);
                      this.matrixs[3].setInventorySlotContents(0, var12[2]);
                      this.matrixs[4].setInventorySlotContents(0, var12[3]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(262)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[3].setInventorySlotContents(0, var12[1]);
                      this.matrixs[6].setInventorySlotContents(0, var12[2]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(342)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[3].setInventorySlotContents(0, var12[1]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(343)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[3].setInventorySlotContents(0, var12[1]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(407)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[3].setInventorySlotContents(0, var12[1]);
                    }
                    else if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(408)))
                    {
                      this.matrixs[0].setInventorySlotContents(0, var12[0]);
                      this.matrixs[3].setInventorySlotContents(0, var12[1]);
                    }
                    else
                    {
                      int i = 0;
                      ItemStack[] var6 = var12;
                      int item = var12.length;
                      for (int var8 = 0; var8 < item; var8++)
                      {
                        ItemStack item1 = var6[var8];
                        this.matrixs[i].setInventorySlotContents(0, item1);
                        i++;
                      }
                    }
                  }
                  else {
                    for (int i = 0; i < 9; i++) {
                      this.matrixs[i].setInventorySlotContents(0, new ItemStack(var12[0].getItem(), 1));
                    }
                  }
                }
                else
                {
                  this.matrixs[1].setInventorySlotContents(0, var12[0]);
                  this.matrixs[4].setInventorySlotContents(0, var12[1]);
                  this.matrixs[7].setInventorySlotContents(0, var12[2]);
                }
              }
              else
              {
                this.matrixs[0].setInventorySlotContents(0, var12[0]);
                this.matrixs[1].setInventorySlotContents(0, var12[1]);
                this.matrixs[4].setInventorySlotContents(0, var12[3]);
                this.matrixs[7].setInventorySlotContents(0, var12[3]);
              }
            }
            else
            {
              this.matrixs[0].setInventorySlotContents(0, var12[0]);
              this.matrixs[1].setInventorySlotContents(0, var12[1]);
              this.matrixs[3].setInventorySlotContents(0, var12[2]);
              this.matrixs[4].setInventorySlotContents(0, var12[3]);
              this.matrixs[7].setInventorySlotContents(0, var12[3]);
            }
          }
          else
          {
            this.matrixs[1].setInventorySlotContents(0, var12[0]);
            this.matrixs[4].setInventorySlotContents(0, var12[1]);
            this.matrixs[7].setInventorySlotContents(0, var12[2]);
          }
        }
        else if ((recipe instanceof ShapelessRecipes))
        {
          ShapelessRecipes var11 = (ShapelessRecipes)recipe;
          List var13 = var11.recipeItems;
          if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(259)))
          {
            this.matrixs[0].setInventorySlotContents(0, (ItemStack)var13.get(0));
            this.matrixs[3].setInventorySlotContents(0, (ItemStack)var13.get(1));
          }
          else if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(282)))
          {
            this.matrixs[0].setInventorySlotContents(0, (ItemStack)var13.get(0));
            this.matrixs[3].setInventorySlotContents(0, (ItemStack)var13.get(1));
            this.matrixs[6].setInventorySlotContents(0, (ItemStack)var13.get(2));
          }
          else if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(378)))
          {
            this.matrixs[0].setInventorySlotContents(0, (ItemStack)var13.get(0));
            this.matrixs[3].setInventorySlotContents(0, (ItemStack)var13.get(1));
          }
          else if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(381)))
          {
            this.matrixs[0].setInventorySlotContents(0, (ItemStack)var13.get(0));
            this.matrixs[3].setInventorySlotContents(0, (ItemStack)var13.get(1));
          }
          else if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(385)))
          {
            this.matrixs[0].setInventorySlotContents(0, (ItemStack)var13.get(0));
            this.matrixs[3].setInventorySlotContents(0, (ItemStack)var13.get(1));
            this.matrixs[6].setInventorySlotContents(0, (ItemStack)var13.get(2));
          }
          else if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(386)))
          {
            this.matrixs[0].setInventorySlotContents(0, (ItemStack)var13.get(0));
            this.matrixs[3].setInventorySlotContents(0, (ItemStack)var13.get(1));
            this.matrixs[6].setInventorySlotContents(0, (ItemStack)var13.get(2));
          }
          else if (recipe.getRecipeOutput().getItem().equals(Item.getItemById(400)))
          {
            this.matrixs[0].setInventorySlotContents(0, (ItemStack)var13.get(0));
            this.matrixs[3].setInventorySlotContents(0, (ItemStack)var13.get(1));
            this.matrixs[6].setInventorySlotContents(0, (ItemStack)var13.get(2));
          }
          else
          {
            int i = 0;
            for (Iterator var14 = var13.iterator(); var14.hasNext(); i++)
            {
              ItemStack var15 = (ItemStack)var14.next();
              this.matrixs[i].setInventorySlotContents(0, var15);
            }
          }
        }
      }
    }
    
    private void clearMatrix()
    {
      IInventory[] var1 = this.matrixs;
      int var2 = var1.length;
      for (int var3 = 0; var3 < var2; var3++)
      {
        IInventory matrix = var1[var3];
        matrix.setInventorySlotContents(0, null);
      }
    }
    
    public boolean isFurnace(ItemStack stack)
    {
      Iterator var2 = FurnaceRecipes.smelting().getSmeltingList().keySet().iterator();
      ItemStack item;
      do
      {
        if (!var2.hasNext()) {
          return false;
        }
        Object items = var2.next();
        item = (ItemStack)items;
      } while (!item.getItem().equals(stack.getItem()));
      return true;
    }
    
    public boolean canInteractWith(EntityPlayer p_75145_1_)
    {
      return true;
    }
    
    public boolean func_148328_e()
    {
      return this.field_148330_a.size() > 45;
    }
    
    protected void retrySlotClick(int p_75133_1_, int p_75133_2_, boolean p_75133_3_, EntityPlayer p_75133_4_) {}
    
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
      if ((p_82846_2_ >= this.inventorySlots.size() - 9) && (p_82846_2_ < this.inventorySlots.size()))
      {
        Slot var3 = (Slot)this.inventorySlots.get(p_82846_2_);
        if ((var3 != null) && (var3.getHasStack())) {
          var3.putStack(null);
        }
      }
      return null;
    }
    
    public boolean canDragIntoSlot(Slot p_94531_1_)
    {
      return true;
    }
  }
}