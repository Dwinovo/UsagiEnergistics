package com.yuntang.ueovo.client.render;

import com.yuntang.ueovo.client.model.entity.UEModel;
import com.yuntang.ueovo.entity.UEEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class UERender extends GeoEntityRenderer<UEEntity>{

    public UERender(Context renderManager) {
        super(renderManager, new UEModel());
    }
    
}
