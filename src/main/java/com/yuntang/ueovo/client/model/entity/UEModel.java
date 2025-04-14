package com.yuntang.ueovo.client.model.entity;

import com.yuntang.ueovo.UsagiEnergistics;
import com.yuntang.ueovo.entity.UEEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
public class UEModel extends GeoModel<UEEntity> {

    // @Override
    // public ResourceLocation getModelResource(UEEntity animatable) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getModelResource'");
    // }

    // @Override
    // public ResourceLocation getTextureResource(UEEntity animatable) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getTextureResource'");
    // }

    // @Override
    // public ResourceLocation getAnimationResource(UEEntity animatable) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getAnimationResource'");
    // }
    @Override
    public ResourceLocation getModelResource(UEEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(UsagiEnergistics.MODID, "geo/entity/your_model.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(UEEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(UsagiEnergistics.MODID, "textures/entity/your_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(UEEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(UsagiEnergistics.MODID, "animations/entity/your_animation.animation.json");
    }

    
    
    
}
