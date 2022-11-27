package net.minecraft.client.audio;

import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;

public class SoundEventAccessorComposite implements ISoundEventAccessor
{
    private final List field_148736_a;
    private final Random field_148734_b;
    private final ResourceLocation field_148735_c;
    private final SoundCategory field_148732_d;
    private double field_148733_e;
    private double field_148731_f;
    private static final String __OBFID = "CL_00001146";
    
    public SoundEventAccessorComposite(final ResourceLocation p_i45120_1_, final double p_i45120_2_, final double p_i45120_4_, final SoundCategory p_i45120_6_) {
        this.field_148736_a = Lists.newArrayList();
        this.field_148734_b = new Random();
        this.field_148735_c = p_i45120_1_;
        this.field_148731_f = p_i45120_4_;
        this.field_148733_e = p_i45120_2_;
        this.field_148732_d = p_i45120_6_;
    }
    
    @Override
    public int func_148721_a() {
        int var1 = 0;
        for (final ISoundEventAccessor var3 : this.field_148736_a) {
            var1 += var3.func_148721_a();
        }
        return var1;
    }
    
    @Override
    public SoundPoolEntry func_148720_g() {
        final int var1 = this.func_148721_a();
        if (!this.field_148736_a.isEmpty() && var1 != 0) {
            int var2 = this.field_148734_b.nextInt(var1);
            for (final ISoundEventAccessor var4 : this.field_148736_a) {
                var2 -= var4.func_148721_a();
                if (var2 < 0) {
                    final SoundPoolEntry var5 = (SoundPoolEntry)var4.func_148720_g();
                    var5.func_148651_a(var5.func_148650_b() * this.field_148733_e);
                    var5.func_148647_b(var5.func_148649_c() * this.field_148731_f);
                    return var5;
                }
            }
            return SoundHandler.field_147700_a;
        }
        return SoundHandler.field_147700_a;
    }
    
    public void func_148727_a(final ISoundEventAccessor p_148727_1_) {
        this.field_148736_a.add(p_148727_1_);
    }
    
    public ResourceLocation func_148729_c() {
        return this.field_148735_c;
    }
    
    public SoundCategory func_148728_d() {
        return this.field_148732_d;
    }
}
