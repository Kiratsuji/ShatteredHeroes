package org.kiratsuji.shatteredheroes.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;
import org.kiratsuji.shatteredheroes.registries.ShatteredHeroesItems;

public class DojoMasterEntity extends PathfinderMob {
    public DojoMasterEntity(EntityType<? extends DojoMasterEntity> entityType, Level level) {
        super(entityType, level);
        this.setDropChance(EquipmentSlot.MAINHAND, 0.0f);

        this.setItemSlot(EquipmentSlot.HEAD, ShatteredHeroesItems.RONIN_HAT.get().getDefaultInstance());
        this.setItemSlot(EquipmentSlot.CHEST, ShatteredHeroesItems.MASTER_KIMONO.get().getDefaultInstance());
        this.setItemSlot(EquipmentSlot.LEGS, ShatteredHeroesItems.BLACK_HAKAMA.get().getDefaultInstance());
        this.setItemSlot(EquipmentSlot.FEET, ShatteredHeroesItems.SANDALS.get().getDefaultInstance());

        this.setDropChance(EquipmentSlot.HEAD, 0.0f);
        this.setDropChance(EquipmentSlot.CHEST, 0.0f);
        this.setDropChance(EquipmentSlot.LEGS, 0.0f);
        this.setDropChance(EquipmentSlot.FEET, 0.0f);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 200.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.12D)
                .add(Attributes.ATTACK_DAMAGE, 8.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 0.3D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.6D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    @Override
    public void setTarget(@Nullable LivingEntity target) {
        boolean wasUnarmed = this.getMainHandItem().isEmpty();
        super.setTarget(target);

        if (target != null & wasUnarmed){
            this.setItemInHand(InteractionHand.MAIN_HAND, ShatteredHeroesItems.KATANA.get().getDefaultInstance());
        }
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (!this.level().isClientSide && hand == InteractionHand.MAIN_HAND && !player.isSecondaryUseActive() && this.getTarget() == null){
            return InteractionResult.CONSUME;
        }
        return super.mobInteract(player, hand);
    }

    @Override public boolean canBeLeashed(Player p_21418_) {
        return false;
    }
    @Override public boolean removeWhenFarAway(double p_21542_) {
        return false;
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
                                                  MobSpawnType reason, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        this.setPersistenceRequired();
        return super.finalizeSpawn(levelAccessor, difficultyInstance, reason, spawnGroupData, compoundTag);
    }
}