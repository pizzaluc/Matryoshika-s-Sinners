package Matryoshika.mods.matryoshikassinners.entities;

import java.util.List;
import java.util.Random;
import java.util.Set;

import Matryoshika.mods.matryoshikassinners.utils.math;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;






public class EntityGula extends EntityMob implements IBossDisplayData{
	
	public EntityGula(World world){
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
	public EntityGula(World world, double x, double y, double z){
		this(world);
		setPosition(x,y,z);		
	}
	
	private static final float MAX_HP = 500F;
	private static final double RANGE = 20F;
	static Random random = new Random();
	public boolean regen;
	private World world;
	
	public int getMaxSpawnedInChunk()
    {
        return 1;
    }
    
	@Override
	public void onEntityUpdate(){
		if(this instanceof EntityGula){
			AxisAlignedBB box = this.boundingBox.expand(RANGE, RANGE, RANGE);
			Class<EntityItem> items = EntityItem.class;
			List<EntityItem> inbox = this.worldObj.getEntitiesWithinAABB(items, box);
	        	if(this.getHealth() < MAX_HP*0.2){
	        		regen = true;
	        	}
	        	if(regen == false){
	        		lookForBlock();
	        		super.onEntityUpdate();
	        	}
	        	if(this.getHealth() == MAX_HP){
	        		regen = false;	
	        }
	        if(this.getHealth() >= 1){
	        	for (EntityItem entityItem : inbox){
	    	        vacuumItems(this);
	    	        super.onEntityUpdate();
	    	        }
	        }
	        
		}
		else {
			return;
		}super.onEntityUpdate();
    }
	
	@Override
	protected boolean canDespawn() {
		return false;
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
	private void lookForBlock(){
		Random random = worldObj.rand;
		int restartLook = 0;
		int maxLooks = 64;
		int range = 12;
		int safeRange = 2;
		for (int i = 0; i < 1 && restartLook < maxLooks; i++){
			
			
			int bX = (int) (posX + rand.nextInt(range) - rand.nextInt(range));
            int bY = (int) (posY + rand.nextInt(range) - rand.nextInt(range));
            int bZ = (int) (posZ + rand.nextInt(range) - rand.nextInt(range));
            if (getDistance(bX, bY, bZ) <= range){
            	Block block = worldObj.getBlock(bX, bY, bZ);
                float hardness = block.getBlockHardness(worldObj, bX, bY, bZ);
                
                if (!(hardness < 0 || block.isAir(worldObj, bX, bY, bZ)) && this.worldObj.getTileEntity(bX, bY, bZ) == null){
                	if(!(getDistance(bX, bY, bZ) <= safeRange)){
                		block.dropBlockAsItem(worldObj, bX, bY, bZ, 0, 0);
                    	worldObj.setBlockToAir(bX, bY, bZ);
                    	worldObj.markBlockForUpdate(bX, bY, bZ);
                    	if(this.getHealth() < MAX_HP){
                    		this.heal(4F);
                    		}
                	}
                	else{
                		i--;
                    	restartLook++;
                	}
                }
                
                else{
                	i--;
                	restartLook++;
                }
            }
            else{
            	i--;
            	restartLook++;
            }
		}
	}
	@SuppressWarnings("unchecked")
	private void vacuumItems(Entity EntityGula){
		AxisAlignedBB box = EntityGula.boundingBox.expand(RANGE, RANGE, RANGE);
		Class<EntityItem> items = EntityItem.class;
		
		List<EntityItem> inbox = EntityGula.worldObj.getEntitiesWithinAABB(items, box);
		
			for (EntityItem entityItem : inbox) {
				double dx = (EntityGula.posX- entityItem.posX);
				double dy = (EntityGula.posY - entityItem.posY);
				double dz = (EntityGula.posZ - entityItem.posZ);
				double ddt = math.py3d(dx, dy, dz);
				entityItem.motionX += (dx/ddt/ddt)*0.01;
				entityItem.motionY += (dy/ddt/ddt)*0.01;
				entityItem.motionZ += (dz/ddt/ddt)*0.01;
				if (entityItem.posY < EntityGula.posY){
					entityItem.motionY += 0.005;
				}
				if (entityItem.posY > EntityGula.posY+4){
					entityItem.motionY -= 0.001;
				}
				entityItem.delayBeforeCanPickup = 20;
				
				if(entityItem.getDistanceToEntity(EntityGula) <= 3 || entityItem.ticksExisted >= 200){
					entityItem.setDead();
				
			}
		}
    }
	public boolean doesVacuum(){
        return true;
    }
    
}
