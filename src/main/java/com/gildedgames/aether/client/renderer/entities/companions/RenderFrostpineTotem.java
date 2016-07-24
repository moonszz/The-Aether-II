package com.gildedgames.aether.client.renderer.entities.companions;

import com.gildedgames.aether.client.models.entities.companions.ModelFrostpineTotem;
import com.gildedgames.aether.common.AetherCore;
import com.gildedgames.aether.common.entities.companions.EntityFrostpineTotem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

public class RenderFrostpineTotem extends RenderLiving<EntityFrostpineTotem>
{
	private static final ResourceLocation TEXTURE = AetherCore.getResource("textures/entities/companions/frostpine_totem.png");

	public RenderFrostpineTotem(RenderManager renderManager)
	{
		super(renderManager, new ModelFrostpineTotem(), 0.5f);
	}

	@Override
	protected void preRenderCallback(EntityFrostpineTotem entity, float partialTicks)
	{
		GL11.glTranslatef(0, MathHelper.sin((entity.ticksExisted + partialTicks) / 10.0F) / 10.0f, 0);

		EntityPlayer owner = entity.getOwner();

		if (owner != null)
		{
			GlStateManager.enableBlend();

			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

			double distance = entity.getDistanceSqToEntity(owner);

			GL11.glColor4f(1.0f, 1.0f, 1.0f, (float) Math.min(0.1f + (1.0f * (distance / 3.0f)), 1.0f));
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityFrostpineTotem entity)
	{
		return TEXTURE;
	}
}
