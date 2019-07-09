package com.gildedgames.aether.client.models.entities.living;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTaegoreLodLow extends ModelTaegoreBase
{
	public ModelTaegoreLodLow()
	{
		this.textureWidth = 128;
		this.textureHeight = 256;
		this.HindLegRightShin = new ModelRenderer(this, 23, 236);
		this.HindLegRightShin.setRotationPoint(-7.0F, 6.0F, 14.0F);
		this.HindLegRightShin.addBox(-2.0F, 10.0F, -2.0F, 3, 8, 5, 0.0F);
		this.HindLegLeftCalf = new ModelRenderer(this, 92, 202);
		this.HindLegLeftCalf.setRotationPoint(7.0F, 6.0F, 14.0F);
		this.HindLegLeftCalf.addBox(-2.0F, 0.0F, -4.0F, 5, 12, 8, 0.0F);
		this.setRotateAngle(this.HindLegLeftCalf, -0.34906584024429316F, -0.0F, 0.0F);
		this.TorsoShoulderPlateRight2 = new ModelRenderer(this, 12, 109);
		this.TorsoShoulderPlateRight2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoShoulderPlateRight2.addBox(-8.0F, -1.0F, -4.0F, 3, 11, 7, 0.0F);
		this.setRotateAngle(this.TorsoShoulderPlateRight2, 0.06923949821968768F, 0.25268026165818797F, 0.27059742313116786F);
		this.FrontLegRightUpper = new ModelRenderer(this, 44, 202);
		this.FrontLegRightUpper.setRotationPoint(-7.0F, 5.0F, -5.0F);
		this.FrontLegRightUpper.addBox(-4.0F, 0.0F, -3.0F, 6, 11, 6, 0.0F);
		this.setRotateAngle(this.FrontLegRightUpper, 0.17453292012214658F, -0.0F, 0.0F);
		this.FrontLegLeftUpper = new ModelRenderer(this, 68, 202);
		this.FrontLegLeftUpper.setRotationPoint(7.0F, 5.0F, -5.0F);
		this.FrontLegLeftUpper.addBox(-2.0F, 0.0F, -3.0F, 6, 11, 6, 0.0F);
		this.setRotateAngle(this.FrontLegLeftUpper, 0.17453292012214658F, -0.0F, 0.0F);
		this.FrontLegLeftLower = new ModelRenderer(this, 70, 219);
		this.FrontLegLeftLower.setRotationPoint(7.0F, 5.0F, -5.0F);
		this.FrontLegLeftLower.addBox(-1.5F, 8.0F, -0.6000000238418579F, 5, 11, 5, 0.0F);
		this.HeadMain = new ModelRenderer(this, 50, 26);
		this.HeadMain.setRotationPoint(0.0F, 2.0F, -11.0F);
		this.HeadMain.addBox(-6.0F, -4.5F, -7.0F, 12, 12, 6, 0.0F);
		this.TorsoShoulderPlateLeft1 = new ModelRenderer(this, 82, 105);
		this.TorsoShoulderPlateLeft1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoShoulderPlateLeft1.addBox(5.0F, -1.0F, -8.5F, 4, 15, 7, 0.0F);
		this.setRotateAngle(this.TorsoShoulderPlateLeft1, 0.0F, -0.0F, -0.34906584024429316F);
		this.HeadEyeRight = new ModelRenderer(this, 42, 58);
		this.HeadEyeRight.setRotationPoint(0.0F, 2.0F, -11.0F);
		this.HeadEyeRight.addBox(1.5F, -1.0F, -8.5F, 4, 5, 2, 0.0F);
		this.setRotateAngle(this.HeadEyeRight, 0.0F, 0.7853981852531433F, 0.0F);
		this.HeadThroat = new ModelRenderer(this, 79, 80);
		this.HeadThroat.setRotationPoint(0.0F, 2.0F, -12.0F);
		this.HeadThroat.addBox(-4.0F, 7.0F, -6.0F, 8, 6, 6, 0.0F);
		this.TorsoBack = new ModelRenderer(this, 31, 124);
		this.TorsoBack.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoBack.addBox(-6.0F, -2.0F, -9.0F, 12, 15, 25, 0.0F);
		this.setRotateAngle(this.TorsoBack, -0.2617993950843811F, -0.0F, 0.0F);
		this.HindLegRightCalf = new ModelRenderer(this, 18, 202);
		this.HindLegRightCalf.setRotationPoint(-7.0F, 6.0F, 14.0F);
		this.HindLegRightCalf.addBox(-3.0F, 0.0F, -4.0F, 5, 12, 8, 0.0F);
		this.setRotateAngle(this.HindLegRightCalf, -0.34906584024429316F, -0.0F, 0.0F);
		this.TorsoShoulderPlateRight1 = new ModelRenderer(this, 32, 105);
		this.TorsoShoulderPlateRight1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoShoulderPlateRight1.addBox(-9.0F, -1.0F, -8.5F, 4, 15, 7, 0.0F);
		this.setRotateAngle(this.TorsoShoulderPlateRight1, 0.0F, -0.0F, 0.34906584024429316F);
		this.HeadSnoutRight = new ModelRenderer(this, 28, 42);
		this.HeadSnoutRight.setRotationPoint(0.0F, 2.0F, -11.0F);
		this.HeadSnoutRight.addBox(-8.0F, 0.5F, -14.0F, 3, 6, 10, 0.0F);
		this.setRotateAngle(this.HeadSnoutRight, 0.2978848147081808F, -0.3911233985652171F, -0.0944154918241396F);
		this.HeadJawFront = new ModelRenderer(this, 61, 70);
		this.HeadJawFront.setRotationPoint(0.0F, 2.0F, -11.0F);
		this.HeadJawFront.addBox(-1.5F, 8.0F, -17.0F, 3, 3, 4, 0.0F);
		this.HeadSnout = new ModelRenderer(this, 60, 62);
		this.HeadSnout.setRotationPoint(0.0F, 6.0F, -9.0F);
		this.HeadSnout.addBox(-2.0F, 0.3F, -19.0F, 4, 4, 4, 0.0F);
		this.HeadEyeLeft = new ModelRenderer(this, 82, 58);
		this.HeadEyeLeft.setRotationPoint(0.0F, 2.0F, -11.0F);
		this.HeadEyeLeft.addBox(-5.5F, -1.0F, -8.5F, 4, 5, 2, 0.0F);
		this.setRotateAngle(this.HeadEyeLeft, 0.0F, -0.7853981852531433F, 0.0F);
		this.HeadBrowLeft = new ModelRenderer(this, 68, 58);
		this.HeadBrowLeft.setRotationPoint(0.0F, 2.0F, -11.0F);
		this.HeadBrowLeft.addBox(-4.800000190734863F, -2.0F, -9.0F, 5, 2, 2, 0.0F);
		this.setRotateAngle(this.HeadBrowLeft, 0.0F, -0.6981316804885863F, 0.0F);
		this.FrontLegRightLower = new ModelRenderer(this, 46, 219);
		this.FrontLegRightLower.setRotationPoint(-7.0F, 5.0F, -5.0F);
		this.FrontLegRightLower.addBox(-3.5F, 8.0F, -0.6000000238418579F, 5, 11, 5, 0.0F);
		this.HeadSnoutLeft = new ModelRenderer(this, 82, 42);
		this.HeadSnoutLeft.setRotationPoint(0.0F, 2.0F, -11.0F);
		this.HeadSnoutLeft.addBox(5.0F, 0.5F, -14.0F, 3, 6, 10, 0.0F);
		this.setRotateAngle(this.HeadSnoutLeft, 0.2978848147081808F, 0.3911233985652171F, 0.0944154918241396F);
		this.HeadJawBack = new ModelRenderer(this, 57, 80);
		this.HeadJawBack.setRotationPoint(0.0F, 2.0F, -12.0F);
		this.HeadJawBack.addBox(-2.0F, 8.5F, -12.0F, 4, 4, 7, 0.0F);
		this.HeadCrestRight = new ModelRenderer(this, 48, 8);
		this.HeadCrestRight.setRotationPoint(0.0F, 2.0F, -11.0F);
		this.HeadCrestRight.addBox(-4.0F, -9.0F, -7.0F, 2, 3, 4, 0.0F);
		this.setRotateAngle(this.HeadCrestRight, 0.2617993950843811F, -0.0F, -0.17453292012214658F);
		this.TorsoFront = new ModelRenderer(this, 56, 98);
		this.TorsoFront.setRotationPoint(0.0F, 2.0F, 2.0F);
		this.TorsoFront.addBox(-4.0F, 7.0F, -14.0F, 8, 6, 4, 0.0F);
		this.HindLegLeftKnee = new ModelRenderer(this, 91, 222);
		this.HindLegLeftKnee.setRotationPoint(7.0F, 6.0F, 14.0F);
		this.HindLegLeftKnee.addBox(-1.5F, 9.0F, -5.0F, 4, 4, 10, 0.0F);
		this.setRotateAngle(this.HindLegLeftKnee, -0.17453292012214658F, -0.0F, 0.0F);
		this.HeadBrowRight = new ModelRenderer(this, 54, 58);
		this.HeadBrowRight.setRotationPoint(0.0F, 2.0F, -11.0F);
		this.HeadBrowRight.addBox(-0.20000000298023224F, -2.0F, -9.0F, 5, 2, 2, 0.0F);
		this.setRotateAngle(this.HeadBrowRight, 0.0F, 0.6981316804885863F, 0.0F);
		this.TorsoNeck = new ModelRenderer(this, 54, 108);
		this.TorsoNeck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoNeck.addBox(-5.0F, -3.0F, -12.0F, 10, 12, 4, 0.0F);
		this.TorsoBackPlateLeft = new ModelRenderer(this, 82, 127);
		this.TorsoBackPlateLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoBackPlateLeft.addBox(5.5F, 3.0F, 9.0F, 4, 14, 8, 0.0F);
		this.setRotateAngle(this.TorsoBackPlateLeft, 0.07438152130324906F, -0.15803570099691838F, -0.4422247463038985F);
		this.HeadEarRight = new ModelRenderer(this, 40, 37);
		this.HeadEarRight.setRotationPoint(0.0F, 2.0F, -11.0F);
		this.HeadEarRight.addBox(-8.0F, 1.0F, -6.0F, 4, 4, 1, 0.0F);
		this.setRotateAngle(this.HeadEarRight, 0.2617993950843811F, -0.0F, 1.0471975803375244F);
		this.HindLegLeftShin = new ModelRenderer(this, 97, 236);
		this.HindLegLeftShin.setRotationPoint(7.0F, 6.0F, 14.0F);
		this.HindLegLeftShin.addBox(-1.0F, 10.0F, -2.0F, 3, 8, 5, 0.0F);
		this.HeadSnoutRidge = new ModelRenderer(this, 54, 44);
		this.HeadSnoutRidge.setRotationPoint(0.0F, 2.0F, -11.0F);
		this.HeadSnoutRidge.addBox(-2.0F, -8.5F, -13.0F, 4, 4, 10, 0.0F);
		this.setRotateAngle(this.HeadSnoutRidge, 0.8726646304130553F, -0.0F, 0.0F);
		this.HeadCrestBase = new ModelRenderer(this, 52, 15);
		this.HeadCrestBase.setRotationPoint(0.0F, 2.0F, -11.0F);
		this.HeadCrestBase.addBox(-1.0F, -7.0F, -7.0F, 8, 3, 8, 0.0F);
		this.setRotateAngle(this.HeadCrestBase, 0.5026421442141991F, 0.7273591993519751F, 0.3538470981396608F);
		this.HeadCrestLeft = new ModelRenderer(this, 76, 8);
		this.HeadCrestLeft.setRotationPoint(0.0F, 2.0F, -11.0F);
		this.HeadCrestLeft.addBox(2.0F, -9.0F, -7.0F, 2, 3, 4, 0.0F);
		this.setRotateAngle(this.HeadCrestLeft, 0.2617993950843811F, -0.0F, 0.17453292012214658F);
		this.HeadEarLeft = new ModelRenderer(this, 86, 37);
		this.HeadEarLeft.setRotationPoint(0.0F, 2.0F, -11.0F);
		this.HeadEarLeft.addBox(4.0F, 1.0F, -6.0F, 4, 4, 1, 0.0F);
		this.setRotateAngle(this.HeadEarLeft, 0.2617993950843811F, -0.0F, -1.0471975803375244F);
		this.TorsoShoulderPlateLeft2 = new ModelRenderer(this, 104, 109);
		this.TorsoShoulderPlateLeft2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoShoulderPlateLeft2.addBox(5.0F, -1.0F, -4.0F, 3, 11, 7, 0.0F);
		this.setRotateAngle(this.TorsoShoulderPlateLeft2, 0.06923949821968768F, -0.25268026165818797F, -0.27059742313116786F);
		this.HeadCrestMiddle = new ModelRenderer(this, 60, 6);
		this.HeadCrestMiddle.setRotationPoint(0.0F, 2.0F, -11.0F);
		this.HeadCrestMiddle.addBox(-1.5F, -9.0F, -8.0F, 3, 4, 5, 0.0F);
		this.setRotateAngle(this.HeadCrestMiddle, 0.2617993950843811F, -0.0F, 0.0F);
		this.HindLegRightKnee = new ModelRenderer(this, 17, 222);
		this.HindLegRightKnee.setRotationPoint(-7.0F, 6.0F, 14.0F);
		this.HindLegRightKnee.addBox(-2.5F, 9.0F, -5.0F, 4, 4, 10, 0.0F);
		this.setRotateAngle(this.HindLegRightKnee, -0.17453292012214658F, -0.0F, 0.0F);
		this.TorsoBelly = new ModelRenderer(this, 30, 166);
		this.TorsoBelly.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoBelly.addBox(-7.0F, 3.0F, -8.0F, 14, 12, 24, 0.0F);
		this.TorsoBackPlateRight = new ModelRenderer(this, 30, 127);
		this.TorsoBackPlateRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TorsoBackPlateRight.addBox(-9.5F, 3.0F, 9.0F, 4, 14, 8, 0.0F);
		this.setRotateAngle(this.TorsoBackPlateRight, 0.07438152130324906F, 0.15803570099691838F, 0.4422247463038985F);
		this.Tail = new ModelRenderer(this, 0, 61);
		this.Tail.setRotationPoint(0.0F, 2.0F, 16.0F);
		this.Tail.addBox(-7.0F, 0.0F, -7.0F, 8, 16, 8, 0.0F);
		this.setRotateAngle(this.Tail, 0.7621319882394909F, -0.6491209619999105F, -0.5096392150483358F);

	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.HindLegRightShin.render(f5);
		this.HindLegLeftCalf.render(f5);
		this.TorsoShoulderPlateRight2.render(f5);
		this.FrontLegRightUpper.render(f5);
		this.FrontLegLeftUpper.render(f5);
		this.FrontLegLeftLower.render(f5);
		this.HeadMain.render(f5);
		this.TorsoShoulderPlateLeft1.render(f5);
		this.HeadEyeRight.render(f5);
		this.HeadThroat.render(f5);
		this.TorsoBack.render(f5);
		this.HindLegRightCalf.render(f5);
		this.TorsoShoulderPlateRight1.render(f5);
		this.HeadSnoutRight.render(f5);
		this.HeadJawFront.render(f5);
		this.HeadSnout.render(f5);
		this.HeadEyeLeft.render(f5);
		this.HeadBrowLeft.render(f5);
		this.FrontLegRightLower.render(f5);
		this.HeadSnoutLeft.render(f5);
		this.HeadJawBack.render(f5);
		this.HeadCrestRight.render(f5);
		this.TorsoFront.render(f5);
		this.HindLegLeftKnee.render(f5);
		this.HeadBrowRight.render(f5);
		this.TorsoNeck.render(f5);
		this.TorsoBackPlateLeft.render(f5);
		this.HeadEarRight.render(f5);
		this.HindLegLeftShin.render(f5);
		this.HeadSnoutRidge.render(f5);
		this.HeadCrestBase.render(f5);
		this.HeadCrestLeft.render(f5);
		this.HeadEarLeft.render(f5);
		this.TorsoShoulderPlateLeft2.render(f5);
		this.HeadCrestMiddle.render(f5);
		this.HindLegRightKnee.render(f5);
		this.TorsoBelly.render(f5);
		this.TorsoBackPlateRight.render(f5);
		this.Tail.render(f5);

	}

}
