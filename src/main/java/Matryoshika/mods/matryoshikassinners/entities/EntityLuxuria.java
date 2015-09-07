package Matryoshika.mods.matryoshikassinners.entities;

import java.util.List;
import java.util.Random;

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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;


public class EntityLuxuria extends EntityMob implements IBossDisplayData{
	
	private static final float MAX_HP = 500F;
	private static final double RANGE = 5F;
	private int timer;
	private int regen;
	private int teleport;
	public boolean meeting;
	
	public EntityLuxuria(World world) {
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
		timer++;
		regen++;
		teleport++;
		Random randx = new Random();
		int randomx = randx.nextInt(8) + 1;
		Random randz = new Random();
		int randomz = randx.nextInt(8) + 1;
		
		Random rand3 = new Random();
		int random3 = rand3.nextInt(2) + 1;
		int invert;
		if(random3 == 1){
			invert = 1;
		}
		else{
			invert = -1;
		}
		
		drugPlayers(this);
		super.onEntityUpdate();
		if(meeting == false){
			this.hurtResistantTime = 30;
		}
		if(this.getHealth() < this.MAX_HP){
			if(regen >=10 && this.getHealth() > 1){
				float currentHealth = this.getHealth();
				this.setHealth(currentHealth+8);
				regen = 0;
			}
		}
		if(teleport >= 600){
			this.newPosX= (this.posX + (randomx * invert));
			this.newPosZ= (this.posZ + (randomz * invert));
		}
	}
	
	@Override
	protected boolean canDespawn() {
		return false;
	}
	
	public EntityLuxuria(World world, double x, double y, double z){
		this(world);
		setPosition(x,y,z);
	}
	
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(MAX_HP);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(100D);
	}
	
	public boolean isAIEnabled(){

		return true;
		}
	private void drugPlayers(Entity EntityLuxuria){
		AxisAlignedBB box = EntityLuxuria.boundingBox.expand(RANGE, RANGE, RANGE);
		Class<EntityPlayer> players = EntityPlayer.class;
		
		List<EntityPlayer> inbox = EntityLuxuria.worldObj.getEntitiesWithinAABB(players, box);
		for (EntityPlayer entityPlayer : inbox) {
			if(timer >= 400){
				entityPlayer.addPotionEffect(new PotionEffect(Potion.weakness.id, 200,1));
				entityPlayer.addPotionEffect(new PotionEffect(Potion.confusion.id, 250,3));
				entityPlayer.addPotionEffect(new PotionEffect(Potion.blindness.id, 200,1));
				entityPlayer.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 250,1));
				entityPlayer.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 200,1));
				timer = 0;
				meeting = true;
			}
		}
	}
}
