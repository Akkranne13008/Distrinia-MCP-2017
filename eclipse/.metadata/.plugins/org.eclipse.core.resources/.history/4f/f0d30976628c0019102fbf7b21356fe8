package net.minecraft.client.audio;

import java.lang.reflect.*;
import net.minecraft.util.*;
import org.apache.commons.lang3.*;
import com.google.gson.*;

public class SoundListSerializer implements JsonDeserializer
{
    private static final String __OBFID = "CL_00001124";
    
    public SoundList deserialize(final JsonElement p_deserialize_1_, final Type p_deserialize_2_, final JsonDeserializationContext p_deserialize_3_) {
        final JsonObject var4 = JsonUtils.getJsonElementAsJsonObject(p_deserialize_1_, "entry");
        final SoundList var5 = new SoundList();
        var5.func_148572_a(JsonUtils.getJsonObjectBooleanFieldValueOrDefault(var4, "replace", false));
        final SoundCategory var6 = SoundCategory.func_147154_a(JsonUtils.getJsonObjectStringFieldValueOrDefault(var4, "category", SoundCategory.MASTER.getCategoryName()));
        var5.func_148571_a(var6);
        Validate.notNull((Object)var6, "Invalid category", new Object[0]);
        if (var4.has("sounds")) {
            final JsonArray var7 = JsonUtils.getJsonObjectJsonArrayField(var4, "sounds");
            for (int var8 = 0; var8 < var7.size(); ++var8) {
                final JsonElement var9 = var7.get(var8);
                final SoundList.SoundEntry var10 = new SoundList.SoundEntry();
                if (JsonUtils.jsonElementTypeIsString(var9)) {
                    var10.func_148561_a(JsonUtils.getJsonElementStringValue(var9, "sound"));
                }
                else {
                    final JsonObject var11 = JsonUtils.getJsonElementAsJsonObject(var9, "sound");
                    var10.func_148561_a(JsonUtils.getJsonObjectStringFieldValue(var11, "name"));
                    if (var11.has("type")) {
                        final SoundList.SoundEntry.Type var12 = SoundList.SoundEntry.Type.func_148580_a(JsonUtils.getJsonObjectStringFieldValue(var11, "type"));
                        Validate.notNull((Object)var12, "Invalid type", new Object[0]);
                        var10.func_148562_a(var12);
                    }
                    if (var11.has("volume")) {
                        final float var13 = JsonUtils.getJsonObjectFloatFieldValue(var11, "volume");
                        Validate.isTrue(var13 > 0.0f, "Invalid volume", new Object[0]);
                        var10.func_148553_a(var13);
                    }
                    if (var11.has("pitch")) {
                        final float var13 = JsonUtils.getJsonObjectFloatFieldValue(var11, "pitch");
                        Validate.isTrue(var13 > 0.0f, "Invalid pitch", new Object[0]);
                        var10.func_148559_b(var13);
                    }
                    if (var11.has("weight")) {
                        final int var14 = JsonUtils.getJsonObjectIntegerFieldValue(var11, "weight");
                        Validate.isTrue(var14 > 0, "Invalid weight", new Object[0]);
                        var10.func_148554_a(var14);
                    }
                    if (var11.has("stream")) {
                        var10.func_148557_a(JsonUtils.getJsonObjectBooleanFieldValue(var11, "stream"));
                    }
                }
                var5.func_148570_a().add(var10);
            }
        }
        return var5;
    }
}
