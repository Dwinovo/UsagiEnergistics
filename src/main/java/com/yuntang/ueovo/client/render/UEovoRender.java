package com.yuntang.ueovo.client.render;

import com.yuntang.ueovo.client.model.entity.UEovoModel;
import com.yuntang.ueovo.entity.UEovoEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class UEovoRender extends GeoEntityRenderer<UEovoEntity>{

    public UEovoRender(Context renderManager) {
        super(renderManager, new UEovoModel());
    }
    
}
