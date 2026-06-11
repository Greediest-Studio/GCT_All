package com.gmm.gctall.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import javax.annotation.Nullable;
import com.gmm.gctall.procedure.ProcedureProZethurSkill;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityFlyHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class EntityZethur {
  public static final int ENTITYID = 29;

  public static final int ENTITYID_RANGED = 30;  public static void registerEntities(net.minecraftforge.event.RegistryEvent.Register<EntityEntry> event) {
    event.getRegistry().register(EntityEntryBuilder.create().entity(ZethurEntity.class).id(new ResourceLocation("gct_all", "zethur"), 29).name("zethur").tracker(256, 3, true).egg(-16777216, -10066330).build());
  }

  private Biome[] allbiomes(RegistryNamespaced<ResourceLocation, Biome> in) {
    Iterator<Biome> itr = in.iterator();
    ArrayList<Biome> ls = new ArrayList<>();
    while (itr.hasNext())
      ls.add(itr.next());
    return ls.<Biome>toArray(new Biome[ls.size()]);
  }

  @SideOnly(Side.CLIENT)
  public static void registerRenderers(FMLPreInitializationEvent event) {
    RenderingRegistry.registerEntityRenderingHandler(ZethurEntity.class, renderManager -> new RenderLiving(renderManager, new ModelZephyrModel(), 4.0F) {
          protected ResourceLocation getEntityTexture(Entity entity) {
            return new ResourceLocation("gct_all:textures/zephyr.png");
          }
        });
  }

  public static class ZethurEntity extends EntityMob {
    private final BossInfoServer bossInfo;

    public ZethurEntity(World world) {
      super(world);
      this.bossInfo = new BossInfoServer(getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS);
      setSize(4.0F, 1.8F);
      this.experienceValue = 1000;
      this.isImmuneToFire = true;
      setNoAI(false);
      enablePersistence();
      this.navigator = (PathNavigate)new PathNavigateFlying((EntityLiving)this, this.world);
      this.moveHelper = (EntityMoveHelper)new EntityFlyHelper((EntityLiving)this);
    }

    protected void initEntityAI() {
      super.initEntityAI();
      this.tasks.addTask(1, new EntityAIBase() {
            public boolean shouldExecute() {
              if (EntityZethur.ZethurEntity.this.getAttackTarget() != null && !EntityZethur.ZethurEntity.this.getMoveHelper().isUpdating())
                return true;
              return false;
            }

            public boolean shouldContinueExecuting() {
              return (EntityZethur.ZethurEntity.this.getMoveHelper().isUpdating() && EntityZethur.ZethurEntity.this.getAttackTarget() != null && EntityZethur.ZethurEntity.this.getAttackTarget().isEntityAlive());
            }

            public void startExecuting() {
              EntityLivingBase livingentity = EntityZethur.ZethurEntity.this.getAttackTarget();
              Vec3d vec3d = livingentity.getPositionEyes(1.0F);
              EntityZethur.ZethurEntity.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 7.0D);
            }

            public void updateTask() {
              EntityLivingBase livingentity = EntityZethur.ZethurEntity.this.getAttackTarget();
              double d0 = EntityZethur.ZethurEntity.this.getDistanceSq((Entity)livingentity);
              if (d0 <= getAttackReachSq(livingentity)) {
                EntityZethur.ZethurEntity.this.attackEntityAsMob((Entity)livingentity);
              } else if (d0 < 128.0D) {
                Vec3d vec3d = livingentity.getPositionEyes(1.0F);
                EntityZethur.ZethurEntity.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 7.0D);
              }
            }

            protected double getAttackReachSq(EntityLivingBase attackTarget) {
              return EntityZethur.ZethurEntity.this.width * 1.5D * EntityZethur.ZethurEntity.this.height * 1.5D + attackTarget.height;
            }
          });
      this.tasks.addTask(2, (EntityAIBase)new EntityAIWander((EntityCreature)this, 5.0D, 20) {
            protected Vec3d getPosition() {
              Random random = EntityZethur.ZethurEntity.this.getRNG();
              double dir_x = EntityZethur.ZethurEntity.this.posX + ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
              double dir_y = EntityZethur.ZethurEntity.this.posY + ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
              double dir_z = EntityZethur.ZethurEntity.this.posZ + ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
              return new Vec3d(dir_x, dir_y, dir_z);
            }
          });
      this.tasks.addTask(3, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 5.0D, false));
      this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
      this.targetTasks.addTask(5, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, false, false));
      this.targetTasks.addTask(6, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
    }

    public EnumCreatureAttribute getCreatureAttribute() {
      return EnumCreatureAttribute.UNDEFINED;
    }

    protected boolean canDespawn() {
      return false;
    }

    protected Item getDropItem() {
      return null;
    }

    public SoundEvent getAmbientSound() {
      return (SoundEvent)SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
    }

    public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
    }

    public SoundEvent getDeathSound() {
      return (SoundEvent)SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
    }

    protected float getSoundVolume() {
      return 1.0F;
    }

    public void fall(float l, float d) {}

    public boolean attackEntityFrom(DamageSource source, float amount) {
      if (source == DamageSource.FALL)
        return false;
      if (source == DamageSource.DROWN)
        return false;
      if (source == DamageSource.LIGHTNING_BOLT)
        return false;
      return super.attackEntityFrom(source, amount);
    }

    public void onDeath(DamageSource source) {
      super.onDeath(source);
    }

    @Nullable
    protected ResourceLocation getLootTable() {
      return new ResourceLocation("gct_all:entities/zethur");
    }

    public void onEntityUpdate() {
      super.onEntityUpdate();
      int x = (int)this.posX;
      int y = (int)this.posY;
      int z = (int)this.posZ;
      ZethurEntity entityCustom = this;
      Map<String, Object> $_dependencies = new HashMap<>();
      $_dependencies.put("x", Integer.valueOf(x));
      $_dependencies.put("y", Integer.valueOf(y));
      $_dependencies.put("z", Integer.valueOf(z));
      $_dependencies.put("world", this.world);
      ProcedureProZethurSkill.executeProcedure($_dependencies);
    }

    protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      if (getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
        getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10.0D);
      if (getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
      if (getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(19000.0D);
      if (getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(40.0D);
      getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
      getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.3D);
    }

    public boolean isNonBoss() {
      return false;
    }

    public void addTrackingPlayer(EntityPlayerMP player) {
      super.addTrackingPlayer(player);
      this.bossInfo.addPlayer(player);
    }

    public void removeTrackingPlayer(EntityPlayerMP player) {
      super.removeTrackingPlayer(player);
      this.bossInfo.removePlayer(player);
    }

    public void onUpdate() {
      super.onUpdate();
      setNoGravity(true);
      this.bossInfo.setPercent(getHealth() / getMaxHealth());
    }

    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {}

    public void setNoGravity(boolean ignored) {
      super.setNoGravity(true);
    }
  }

  public static class ModelZephyrModel extends ModelBase {
    private final ModelRenderer BodyLeftSide2;

    private final ModelRenderer BodyLeftSide1;

    private final ModelRenderer LeftFace;

    private final ModelRenderer Mouth;

    private final ModelRenderer BodyRightSide1;

    private final ModelRenderer BodyRightSide2;

    private final ModelRenderer CloudButt;

    private final ModelRenderer tail1;

    private final ModelRenderer tail2;

    private final ModelRenderer Tail1ChildChild;

    private final ModelRenderer RightFace;

    private final ModelRenderer Body;

    public ModelZephyrModel() {
      this.textureWidth = 384;
      this.textureHeight = 96;
      this.BodyLeftSide2 = new ModelRenderer(this);
      this.BodyLeftSide2.setRotationPoint(16.5F, -21.0F, 6.0F);
      this.BodyLeftSide2.cubeList.add(new ModelBox(this.BodyLeftSide2, 79, 27, 0.0F, 30.0F, -7.5F, 6, 18, 18, 0.0F, false));
      this.BodyLeftSide1 = new ModelRenderer(this);
      this.BodyLeftSide1.setRotationPoint(18.0F, -24.0F, -12.0F);
      this.BodyLeftSide1.cubeList.add(new ModelBox(this.BodyLeftSide1, 54, 27, 0.0F, 31.0F, -9.0F, 6, 18, 18, 0.0F, false));
      this.LeftFace = new ModelRenderer(this);
      this.LeftFace.setRotationPoint(0.0F, -24.0F, 0.0F);
      this.LeftFace.cubeList.add(new ModelBox(this.LeftFace, 121, 27, 9.0F, 37.0F, -27.0F, 12, 18, 6, 0.0F, false));
      this.Mouth = new ModelRenderer(this);
      this.Mouth.setRotationPoint(0.0F, -24.0F, 0.0F);
      this.Mouth.cubeList.add(new ModelBox(this.Mouth, 120, 27, -9.0F, 43.0F, -24.0F, 18, 9, 3, 0.0F, false));
      this.BodyRightSide1 = new ModelRenderer(this);
      this.BodyRightSide1.setRotationPoint(-18.0F, -24.0F, -12.0F);
      this.BodyRightSide1.cubeList.add(new ModelBox(this.BodyRightSide1, 54, 27, -6.0F, 31.0F, -9.0F, 6, 18, 18, 0.0F, false));
      this.BodyRightSide2 = new ModelRenderer(this);
      this.BodyRightSide2.setRotationPoint(-16.5F, -21.0F, 6.0F);
      this.BodyRightSide2.cubeList.add(new ModelBox(this.BodyRightSide2, 79, 27, -6.0F, 30.0F, -7.5F, 6, 18, 18, 0.0F, false));
      this.CloudButt = new ModelRenderer(this);
      this.CloudButt.setRotationPoint(6.0F, -24.0F, 21.0F);
      this.CloudButt.cubeList.add(new ModelBox(this.CloudButt, 54, 27, -18.0F, 31.0F, 0.0F, 24, 18, 6, 0.0F, false));
      this.tail1 = new ModelRenderer(this);
      this.tail1.setRotationPoint(0.0F, -24.0F, 37.2F);
      this.tail1.cubeList.add(new ModelBox(this.tail1, 150, 27, -7.5F, 32.5F, -7.5F, 15, 15, 15, 0.0F, false));
      this.tail2 = new ModelRenderer(this);
      this.tail2.setRotationPoint(0.0F, 0.0F, 18.0F);
      this.tail1.addChild(this.tail2);
      setRotationAngle(this.tail2, 0.0F, 0.25F, 0.0F);
      this.tail2.cubeList.add(new ModelBox(this.tail2, 134, 27, -6.0F, 34.0F, -5.9F, 12, 12, 12, 0.0F, false));
      this.Tail1ChildChild = new ModelRenderer(this);
      this.Tail1ChildChild.setRotationPoint(0.0F, 0.0F, 15.0F);
      this.tail2.addChild(this.Tail1ChildChild);
      setRotationAngle(this.Tail1ChildChild, 0.0F, 0.6F, 0.0F);
      this.Tail1ChildChild.cubeList.add(new ModelBox(this.Tail1ChildChild, 54, 27, -4.5F, 35.5F, -4.5F, 9, 9, 9, 0.0F, false));
      this.RightFace = new ModelRenderer(this);
      this.RightFace.setRotationPoint(0.0F, -24.0F, 0.0F);
      this.RightFace.cubeList.add(new ModelBox(this.RightFace, 121, 27, -21.0F, 37.0F, -27.0F, 12, 18, 6, 0.0F, false));
      this.Body = new ModelRenderer(this);
      this.Body.setRotationPoint(0.0F, -24.0F, 0.0F);
      this.Body.cubeList.add(new ModelBox(this.Body, 81, 27, -18.0F, 28.0F, -21.0F, 36, 27, 42, 0.0F, false));
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.BodyLeftSide2.render(f5);
      this.BodyLeftSide1.render(f5);
      this.LeftFace.render(f5);
      this.Mouth.render(f5);
      this.BodyRightSide1.render(f5);
      this.BodyRightSide2.render(f5);
      this.CloudButt.render(f5);
      this.tail1.render(f5);
      this.RightFace.render(f5);
      this.Body.render(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
      modelRenderer.rotateAngleX = x;
      modelRenderer.rotateAngleY = y;
      modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
      super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
    }
  }
}

