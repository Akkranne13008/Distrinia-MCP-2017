package net.minecraft.client.audio;

import net.minecraft.entity.player.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.*;

public class MovingSoundMinecartRiding extends MovingSound
{
    private final EntityPlayer field_147672_k;
    private final EntityMinecart field_147671_l;
    private static final String __OBFID = "CL_00001119";
    
    public MovingSoundMinecartRiding(final EntityPlayer p_i45106_1_, final EntityMinecart p_i45106_2_) {
        super(new ResourceLocation("minecraft:minecart.inside"));
        this.field_147672_k = p_i45106_1_;
        this.field_147671_l = p_i45106_2_;
        this.field_147666_i = ISound.AttenuationType.NONE;
        this.field_147659_g = true;
        this.field_147665_h = 0;
    }
    
    @Override
    public void update() {
        if (!this.field_147671_l.isDead && this.field_147672_k.isRiding() && this.field_147672_k.ridingEntity == this.field_147671_l) {
            final float var1 = MathHelper.sqrt_double(this.field_147671_l.motionX * this.field_147671_l.motionX + this.field_147671_l.motionZ * this.field_147671_l.motionZ);
            if (var1 >= 0.01) {
                this.field_147662_b = 0.0f + MathHelper.clamp_float(var1, 0.0f, 1.0f) * 0.75f;
            }
            else {
                this.field_147662_b = 0.0f;
            }
        }
        else {
            this.field_147668_j = true;
        }
    }
}
