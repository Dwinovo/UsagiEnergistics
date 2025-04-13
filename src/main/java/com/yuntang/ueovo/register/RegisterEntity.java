package com.yuntang.ueovo.register;

import java.util.function.Supplier;

import com.yuntang.ueovo.UsagiEnergistics;
import com.yuntang.ueovo.entity.UEovoEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RegisterEntity {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, UsagiEnergistics.MODID);
    
    
    public static Supplier<EntityType<UEovoEntity>> UEOVO = ENTITY_TYPES.register("ueovo", 
        ()->EntityType.Builder.<UEovoEntity>of(UEovoEntity::new, MobCategory.CREATURE)
        .sized(0.6f, 1.5f)
        .clientTrackingRange(10)
        .build("ueovo"));
}
