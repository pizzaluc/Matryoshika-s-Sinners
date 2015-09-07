package Matryoshika.mods.matryoshikassinners.entities;

import java.util.List;

import Matryoshika.mods.matryoshikassinners.items.matryoshikassinners_Items;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;


public class EntityInvidia extends EntityMob implements IBossDisplayData{
	
	private static final float MAX_HP = 500F;
	private static final double RANGE = 20F;
	
	public EntityInvidia(World world)
    {
        super(world);
        setSize(1,2);
        this.isImmuneToFire = true;
        preventEntitySpawning = true;
        getNavigator().setCanSwim(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(2, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }
	
	@Override
	public void onEntityUpdate(){
		copyPlayer(this);
		super.onEntityUpdate();
	}
	@Override
	public void onDeath(DamageSource source){
		for(int i = 0; i<5; i++){
		this.equipmentDropChances[i] = -1;
		}
		super.onDeath(source);
	}
	
	@Override
	protected boolean canDespawn() {
		return false;
	}
	
	public EntityInvidia(World world, double x, double y, double z){
		this(world);
		setPosition(x,y,z);		
	}
	
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(MAX_HP);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10D);
	}
	
	public boolean isAIEnabled(){

		return true;
		}
	
	private void copyPlayer(Entity EntityInvidia){
		AxisAlignedBB box = EntityInvidia.boundingBox.expand(RANGE, RANGE, RANGE);
		Class<EntityPlayer> player = EntityPlayer.class;
		List<EntityPlayer> inbox = EntityInvidia.worldObj.getEntitiesWithinAABB(player, box);
		
		for (EntityPlayer entityplayer : inbox) {
			
			if(entityplayer.getCurrentArmor(3) != null){
				ItemStack helm = entityplayer.getCurrentArmor(3).copy();
				EntityInvidia.setCurrentItemOrArmor(4, helm);
			}
			if(entityplayer.getCurrentArmor(2) != null){
				ItemStack torso = entityplayer.getCurrentArmor(2).copy();
				EntityInvidia.setCurrentItemOrArmor(3, torso);
			}
			if(entityplayer.getCurrentArmor(1) != null){
				ItemStack leggings = entityplayer.getCurrentArmor(1).copy();
				EntityInvidia.setCurrentItemOrArmor(2, leggings);
			}
			if(entityplayer.getCurrentArmor(0) != null){
				ItemStack boots = entityplayer.getCurrentArmor(0).copy();
				EntityInvidia.setCurrentItemOrArmor(1, boots);
			}
			ItemStack weapon = new ItemStack(matryoshikassinners_Items.SinDagger);
			EntityInvidia.setCurrentItemOrArmor(0, weapon);
		}
		
	}
}