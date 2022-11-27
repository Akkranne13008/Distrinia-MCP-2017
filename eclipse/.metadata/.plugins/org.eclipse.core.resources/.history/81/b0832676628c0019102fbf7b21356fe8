package net.minecraft.client.audio;

import net.minecraft.entity.item.*;
import net.minecraft.util.*;

public class MovingSoundMinecart extends MovingSound
{
    private final EntityMinecart field_147670_k;
    private float field_147669_l;
    private static final String __OBFID = "CL_00001118";
    
    public MovingSoundMinecart(final EntityMinecart p_i45105_1_) {
        super(new ResourceLocation("minecraft:minecart.base"));
        this.field_147669_l = 0.0f;
        this.field_147670_k = p_i45105_1_;
        this.field_147659_g = true;
        this.field_147665_h = 0;
    }
    
    @Override
    public void update() {
        if (this.field_147670_k.isDead) {
            this.field_147668_j = true;
        }
        else {
            this.field_147660_d = (float)this.field_147670_k.posX;
            this.field_147661_e = (float)this.field_147670_k.posY;
            this.field_147658_f = (float)this.field_147670_k.posZ;
            final float var1 = MathHelper.sqrt_double(this.field_147670_k.motionX * this.field_147670_k.motionX + this.field_147670_k.motionZ * this.field_147670_k.motionZ);
            if (var1 >= 0.01) {
                this.field_147669_l = MathHelper.clamp_float(this.field_147669_l + 0.0025f, 0.0f, 1.0f);
                this.field_147662_b = 0.0f + MathHelper.clamp_float(var1, 0.0f, 0.5f) * 0.7f;
            }
            else {
                this.field_147669_l = 0.0f;
                this.field_147662_b = 0.0f;
            }
        }
    }
}
