package net.minecraft.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandNotFoundException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerSelector;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandHandler implements ICommandManager {

   private static final Logger field_147175_a = LogManager.getLogger();
   private final Map field_71562_a = new HashMap();
   private final Set field_71561_b = new HashSet();
   private static final String __OBFID = "CL_00001765";


   public int func_71556_a(ICommandSender p_71556_1_, String p_71556_2_) {
      p_71556_2_ = p_71556_2_.trim();
      if(p_71556_2_.startsWith("/")) {
         p_71556_2_ = p_71556_2_.substring(1);
      }

      String[] var3 = p_71556_2_.split(" ");
      String var4 = var3[0];
      var3 = func_71559_a(var3);
      ICommand var5 = (ICommand)this.field_71562_a.get(var4);
      int var6 = this.func_82370_a(var5, var3);
      int var7 = 0;

      ChatComponentTranslation var9;
      try {
         if(var5 == null) {
            throw new CommandNotFoundException();
         }

         if(var5.func_71519_b(p_71556_1_)) {
            if(var6 > -1) {
               EntityPlayerMP[] var8 = PlayerSelector.func_82380_c(p_71556_1_, var3[var6]);
               String var22 = var3[var6];
               EntityPlayerMP[] var10 = var8;
               int var11 = var8.length;

               for(int var12 = 0; var12 < var11; ++var12) {
                  EntityPlayerMP var13 = var10[var12];
                  var3[var6] = var13.func_70005_c_();

                  try {
                     var5.func_71515_b(p_71556_1_, var3);
                     ++var7;
                  } catch (CommandException var17) {
                     ChatComponentTranslation var15 = new ChatComponentTranslation(var17.getMessage(), var17.func_74844_a());
                     var15.func_150256_b().func_150238_a(EnumChatFormatting.RED);
                     p_71556_1_.func_145747_a(var15);
                  }
               }

               var3[var6] = var22;
            } else {
               try {
                  var5.func_71515_b(p_71556_1_, var3);
                  ++var7;
               } catch (CommandException var16) {
                  var9 = new ChatComponentTranslation(var16.getMessage(), var16.func_74844_a());
                  var9.func_150256_b().func_150238_a(EnumChatFormatting.RED);
                  p_71556_1_.func_145747_a(var9);
               }
            }
         } else {
            ChatComponentTranslation var21 = new ChatComponentTranslation("commands.generic.permission", new Object[0]);
            var21.func_150256_b().func_150238_a(EnumChatFormatting.RED);
            p_71556_1_.func_145747_a(var21);
         }
      } catch (WrongUsageException var18) {
         var9 = new ChatComponentTranslation("commands.generic.usage", new Object[]{new ChatComponentTranslation(var18.getMessage(), var18.func_74844_a())});
         var9.func_150256_b().func_150238_a(EnumChatFormatting.RED);
         p_71556_1_.func_145747_a(var9);
      } catch (CommandException var19) {
         var9 = new ChatComponentTranslation(var19.getMessage(), var19.func_74844_a());
         var9.func_150256_b().func_150238_a(EnumChatFormatting.RED);
         p_71556_1_.func_145747_a(var9);
      } catch (Throwable var20) {
         var9 = new ChatComponentTranslation("commands.generic.exception", new Object[0]);
         var9.func_150256_b().func_150238_a(EnumChatFormatting.RED);
         p_71556_1_.func_145747_a(var9);
         field_147175_a.error("Couldn\'t process command: \'" + p_71556_2_ + "\'", var20);
      }

      return var7;
   }

   public ICommand func_71560_a(ICommand p_71560_1_) {
      List var2 = p_71560_1_.func_71514_a();
      this.field_71562_a.put(p_71560_1_.func_71517_b(), p_71560_1_);
      this.field_71561_b.add(p_71560_1_);
      if(var2 != null) {
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            String var4 = (String)var3.next();
            ICommand var5 = (ICommand)this.field_71562_a.get(var4);
            if(var5 == null || !var5.func_71517_b().equals(var4)) {
               this.field_71562_a.put(var4, p_71560_1_);
            }
         }
      }

      return p_71560_1_;
   }

   private static String[] func_71559_a(String[] p_71559_0_) {
      String[] var1 = new String[p_71559_0_.length - 1];

      for(int var2 = 1; var2 < p_71559_0_.length; ++var2) {
         var1[var2 - 1] = p_71559_0_[var2];
      }

      return var1;
   }

   public List func_71558_b(ICommandSender p_71558_1_, String p_71558_2_) {
      String[] var3 = p_71558_2_.split(" ", -1);
      String var4 = var3[0];
      if(var3.length == 1) {
         ArrayList var8 = new ArrayList();
         Iterator var6 = this.field_71562_a.entrySet().iterator();

         while(var6.hasNext()) {
            Entry var7 = (Entry)var6.next();
            if(CommandBase.func_71523_a(var4, (String)var7.getKey()) && ((ICommand)var7.getValue()).func_71519_b(p_71558_1_)) {
               var8.add(var7.getKey());
            }
         }

         return var8;
      } else {
         if(var3.length > 1) {
            ICommand var5 = (ICommand)this.field_71562_a.get(var4);
            if(var5 != null) {
               return var5.func_71516_a(p_71558_1_, func_71559_a(var3));
            }
         }

         return null;
      }
   }

   public List func_71557_a(ICommandSender p_71557_1_) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.field_71561_b.iterator();

      while(var3.hasNext()) {
         ICommand var4 = (ICommand)var3.next();
         if(var4.func_71519_b(p_71557_1_)) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public Map func_71555_a() {
      return this.field_71562_a;
   }

   private int func_82370_a(ICommand p_82370_1_, String[] p_82370_2_) {
      if(p_82370_1_ == null) {
         return -1;
      } else {
         for(int var3 = 0; var3 < p_82370_2_.length; ++var3) {
            if(p_82370_1_.func_82358_a(p_82370_2_, var3) && PlayerSelector.func_82377_a(p_82370_2_[var3])) {
               return var3;
            }
         }

         return -1;
      }
   }

}
