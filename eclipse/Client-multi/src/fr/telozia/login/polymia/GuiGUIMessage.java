/*     */ package fr.telozia.login.polymia;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class GuiGUIMessage
/*     */ {
/*     */   private static final String __OBFID = "CL_0004602";
/*  10 */   public String message = "";
/*  11 */   public boolean shadow = true;
/*  12 */   public String id = "default";
/*     */   public Anchor anchor;
/*     */   public int displayTimer;
/*     */   public int elapsedTimer;
/*     */   public int y;
/*     */   public int yFinal;
/*     */   public int x;
/*     */   public int xFinal;
/*     */   public int renderPass;
/*     */   public int renderPassed;
/*     */   public float scale;
/*     */   public float rotation;
/*     */   public ItemStack stack;
/*     */   public ROTATION spin;
/*     */   public float spinValue;
/*     */   
/*     */   public GuiGUIMessage()
/*     */   {
/*  30 */     this.anchor = Anchor.DEFAULT;
/*  31 */     this.displayTimer = 90;
/*  32 */     this.elapsedTimer = 0;
/*  33 */     this.y = 0;
/*  34 */     this.yFinal = 64537;
/*  35 */     this.x = 0;
/*  36 */     this.xFinal = 64537;
/*  37 */     this.renderPass = 0;
/*  38 */     this.renderPassed = 0;
/*  39 */     this.scale = 1.0F;
/*  40 */     this.rotation = 0.0F;
/*  41 */     this.stack = null;
/*  42 */     this.spin = ROTATION.DEFAULT;
/*  43 */     this.spinValue = 0.0F;
/*     */   }
/*     */   
/*     */   public void setShadow(boolean shadow)
/*     */   {
/*  48 */     this.shadow = shadow;
/*     */   }
/*     */   
/*     */   public void setMessage(String message)
/*     */   {
/*  53 */     message = message.replace('&', '§');
/*  54 */     this.message = message;
/*     */   }
/*     */   
/*     */   public void setId(String id)
/*     */   {
/*  59 */     this.id = id;
/*     */   }
/*     */   
/*     */   public void setDisplayTimer(int timer)
/*     */   {
/*  64 */     this.displayTimer = timer;
/*     */   }
/*     */   
/*     */   public void setAnchor(Anchor anchor)
/*     */   {
/*  69 */     this.anchor = anchor;
/*     */   }
/*     */   
/*     */   public void setSpin(ROTATION spin)
/*     */   {
/*  74 */     this.spin = spin;
/*     */   }
/*     */   
/*     */   public void setSpinValue(float f)
/*     */   {
/*  79 */     this.spinValue = f;
/*     */   }
/*     */   
/*     */   public void setX(int x)
/*     */   {
/*  84 */     this.x = x;
/*     */   }
/*     */   
/*     */   public void setYFinal(int y)
/*     */   {
/*  89 */     this.yFinal = y;
/*     */   }
/*     */   
/*     */   public void setXFinal(int x)
/*     */   {
/*  94 */     this.xFinal = x;
/*     */   }
/*     */   
/*     */   public void setY(int y)
/*     */   {
/*  99 */     this.y = y;
/*     */   }
/*     */   
/*     */   public void setRenderPass(int number)
/*     */   {
/* 104 */     this.renderPass = number;
/*     */   }
/*     */   
/*     */   public void setScale(float scale)
/*     */   {
/* 109 */     this.scale = scale;
/*     */   }
/*     */   
/*     */   public void setRotation(float rotation)
/*     */   {
/* 114 */     this.rotation = rotation;
/*     */   }
/*     */   
/*     */   public void setStack(int id)
/*     */   {
/* 119 */     Item item = Item.getItemById(id);
/* 120 */     Block block = Block.getBlockById(id);
/* 121 */     if (item != null) {
/* 122 */       this.stack = new ItemStack(item);
/* 123 */     } else if (block != null) {
/* 124 */       this.stack = new ItemStack(block);
/*     */     }
/*     */   }
/*     */   
/*     */   public static enum Anchor
/*     */   {
/* 130 */     DEFAULT,  LEFT,  RIGHT,  TOP,  BOT,  TOPLEFT,  TOPRIGHT,  BOTLEFT,  BOTRIGHT,  CENTER;
/*     */     
/* 132 */     private static final Anchor[] $VALUES = { DEFAULT, LEFT, RIGHT, TOP, BOT, TOPLEFT, TOPRIGHT, BOTLEFT, BOTRIGHT, CENTER };
/*     */   }
/*     */   
/*     */   public static enum ROTATION
/*     */   {
/* 137 */     LEFT,  RIGHT,  CUSTOMLEFT,  CUSTOMRIGHT,  DEFAULT;
/*     */     
/* 139 */     private static final ROTATION[] $VALUES = { LEFT, RIGHT, CUSTOMLEFT, CUSTOMRIGHT, DEFAULT };
/*     */   }
/*     */ }