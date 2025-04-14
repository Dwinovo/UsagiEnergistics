package com.yuntang.ueovo.init;

import java.util.function.Supplier;

import com.yuntang.ueovo.UsagiEnergistics;
import com.yuntang.ueovo.entity.UEEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

public class InitEntity {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, UsagiEnergistics.MODID);
    
    
    public static Supplier<EntityType<UEEntity>> UEOVO = ENTITY_TYPES.register("ueovo", 
        ()->EntityType.Builder.<UEEntity>of(UEEntity::new, MobCategory.CREATURE)
        .sized(0.6f, 1.5f)
        .clientTrackingRange(10)
        .build("ueovo"));
}
