package Matryoshika.mods.matryoshikassinners.rendering.entities;

import Matryoshika.mods.matryoshikassinners.entities.matryoshikassinners_Entities;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;

public class RenderAvaritia extends RenderBiped implements IBossDisplayData{

	public RenderAvaritia(ModelBiped model, float shadowsize) {
		super(model, shadowsize);
	}
	
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		return new ResourceLocation("matryoshikassinners:textures/entity/Matryoshika.png");
	}
	@Override
	public void doRender(Entity entity, double x, double y, double z, float rotationYaw, float rotationPitch)
	{
		super.doRender((EntityLiving)entity, x, y, z, rotationYaw, rotationPitch);
		BossStatus.setBossStatus((IBossDisplayData)entity, false);
	}

	@Override
	public float getMaxHealth() {
		return 0;
	}

	@Override
	public float getHealth() {
		return 0;
	}

	@Override
	public IChatComponent func_145748_c_() {
		return null;
	}

}