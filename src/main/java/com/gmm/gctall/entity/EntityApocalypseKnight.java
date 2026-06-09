package com.gmm.gctall.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import com.gmm.gctall.registry.GctAllContent;
import com.gmm.gctall.registry.GctAllElement;
import com.gmm.gctall.registry.GctAllElement.Tag;
import com.gmm.gctall.procedure.ProcedureProApocalypseDeath;
import com.gmm.gctall.procedure.ProcedureProApocalypseKnightSkill;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
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
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
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

@Tag
public class EntityApocalypseKnight extends GctAllElement {
  public static final int ENTITYID = 23;
  
  public static final int ENTITYID_RANGED = 24;
  
  public EntityApocalypseKnight(GctAllContent instance) {
    super(instance, 6);
  }
  
  public void initElements() {
    this.elements.entities
      .add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("gct_all", "apocalypse_knight"), 23).name("apocalypse_knight").tracker(128, 3, true).egg(-16777216, -3407770).build());
  }
  
  private Biome[] allbiomes(RegistryNamespaced<ResourceLocation, Biome> in) {
    Iterator<Biome> itr = in.iterator();
    ArrayList<Biome> ls = new ArrayList<>();
    while (itr.hasNext())
      ls.add(itr.next()); 
    return ls.<Biome>toArray(new Biome[ls.size()]);
  }
  
  @SideOnly(Side.CLIENT)
  public void preInit(FMLPreInitializationEvent event) {
    RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
          RenderBiped customRender = new RenderBiped(renderManager, new ModelBiped(), 0.5F) {
              protected ResourceLocation getEntityTexture(Entity entity) {
                return new ResourceLocation("gct_all:textures/apkn.png");
              }
            };
          customRender.addLayer((LayerRenderer)new LayerBipedArmor((RenderLivingBase)customRender) {
                protected void initArmor() {
                  this.modelLeggings = new ModelBiped(0.5F);
                  this.modelArmor = new ModelBiped(1.0F);
                }
              });
          return (Render)customRender;
        });
  }
  
  public static class EntityCustom extends EntityMob {
    private final BossInfoServer bossInfo;
    
    public EntityCustom(World world) {
      super(world);
      this.bossInfo = new BossInfoServer(getDisplayName(), BossInfo.Color.WHITE, BossInfo.Overlay.PROGRESS);
      setSize(0.6F, 1.8F);
      this.experienceValue = 1000;
      this.isImmuneToFire = true;
      setNoAI(false);
      enablePersistence();
      setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD, 1));
      this.navigator = (PathNavigate)new PathNavigateFlying((EntityLiving)this, this.world);
      this.moveHelper = (EntityMoveHelper)new EntityFlyHelper((EntityLiving)this);
    }
    
    protected void initEntityAI() {
      super.initEntityAI();
      this.tasks.addTask(1, new EntityAIBase() {
            public boolean shouldExecute() {
              if (EntityApocalypseKnight.EntityCustom.this.getAttackTarget() != null && !EntityApocalypseKnight.EntityCustom.this.getMoveHelper().isUpdating())
                return true; 
              return false;
            }
            
            public boolean shouldContinueExecuting() {
              return (EntityApocalypseKnight.EntityCustom.this.getMoveHelper().isUpdating() && EntityApocalypseKnight.EntityCustom.this.getAttackTarget() != null && EntityApocalypseKnight.EntityCustom.this.getAttackTarget().isEntityAlive());
            }
            
            public void startExecuting() {
              EntityLivingBase livingentity = EntityApocalypseKnight.EntityCustom.this.getAttackTarget();
              Vec3d vec3d = livingentity.getPositionEyes(1.0F);
              EntityApocalypseKnight.EntityCustom.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 5.5D);
            }
            
            public void updateTask() {
              EntityLivingBase livingentity = EntityApocalypseKnight.EntityCustom.this.getAttackTarget();
              double d0 = EntityApocalypseKnight.EntityCustom.this.getDistanceSq((Entity)livingentity);
              if (d0 <= getAttackReachSq(livingentity)) {
                EntityApocalypseKnight.EntityCustom.this.attackEntityAsMob((Entity)livingentity);
              } else if (d0 < 64.0D) {
                Vec3d vec3d = livingentity.getPositionEyes(1.0F);
                EntityApocalypseKnight.EntityCustom.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 5.5D);
              } 
            }
            
            protected double getAttackReachSq(EntityLivingBase attackTarget) {
              return EntityApocalypseKnight.EntityCustom.this.width * 1.5D * EntityApocalypseKnight.EntityCustom.this.height * 1.5D + attackTarget.height;
            }
          });
      this.tasks.addTask(2, (EntityAIBase)new EntityAIWander((EntityCreature)this, 4.0D, 20) {
            protected Vec3d getPosition() {
              Random random = EntityApocalypseKnight.EntityCustom.this.getRNG();
              double dir_x = EntityApocalypseKnight.EntityCustom.this.posX + ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
              double dir_y = EntityApocalypseKnight.EntityCustom.this.posY + ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
              double dir_z = EntityApocalypseKnight.EntityCustom.this.posZ + ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
              return new Vec3d(dir_x, dir_y, dir_z);
            }
          });
      this.tasks.addTask(3, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 5.5D, false));
      this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
      this.targetTasks.addTask(5, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
      this.targetTasks.addTask(6, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, false, false));
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
      return (SoundEvent)SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.irongolem.hurt"));
    }
    
    public SoundEvent getDeathSound() {
      return (SoundEvent)SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.enderdragon.death"));
    }
    
    protected float getSoundVolume() {
      return 1.0F;
    }
    
    public void fall(float l, float d) {}
    
    public boolean attackEntityFrom(DamageSource source, float amount) {
      if (source.getImmediateSource() instanceof net.minecraft.entity.projectile.EntityArrow)
        return false; 
      if (source.getImmediateSource() instanceof net.minecraft.entity.projectile.EntityPotion)
        return false; 
      if (source == DamageSource.FALL)
        return false; 
      return super.attackEntityFrom(source, amount);
    }
    
    public void onDeath(DamageSource source) {
      super.onDeath(source);
      int x = (int)this.posX;
      int y = (int)this.posY;
      int z = (int)this.posZ;
      EntityCustom entityCustom = this;
      Map<String, Object> $_dependencies = new HashMap<>();
      $_dependencies.put("x", Integer.valueOf(x));
      $_dependencies.put("y", Integer.valueOf(y));
      $_dependencies.put("z", Integer.valueOf(z));
      $_dependencies.put("world", this.world);
      ProcedureProApocalypseDeath.executeProcedure($_dependencies);
    }
    
    public void onEntityUpdate() {
      super.onEntityUpdate();
      int x = (int)this.posX;
      int y = (int)this.posY;
      int z = (int)this.posZ;
      EntityCustom entityCustom = this;
      Map<String, Object> $_dependencies = new HashMap<>();
      $_dependencies.put("x", Integer.valueOf(x));
      $_dependencies.put("y", Integer.valueOf(y));
      $_dependencies.put("z", Integer.valueOf(z));
      $_dependencies.put("world", this.world);
      ProcedureProApocalypseKnightSkill.executeProcedure($_dependencies);
    }
    
    protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      if (getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
        getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(6.0D); 
      if (getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(4.5D); 
      if (getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6000.0D); 
      if (getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(25.0D); 
      getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
      getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(4.5D);
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
    
    public void onLivingUpdate() {
      super.onLivingUpdate();
      int i = (int)this.posX;
      int j = (int)this.posY;
      int k = (int)this.posZ;
      Random random = this.rand;
      for (int l = 0; l < 1; l++) {
        double d0 = i + 0.5D + (random.nextFloat() - 0.5D) * 0.5D;
        double d1 = j + 0.7D + (random.nextFloat() - 0.5D) * 0.5D + 0.5D;
        double d2 = k + 0.5D + (random.nextFloat() - 0.5D) * 0.5D;
        this.world.spawnParticle(EnumParticleTypes.SPELL_MOB_AMBIENT, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
      } 
    }
  }
}

