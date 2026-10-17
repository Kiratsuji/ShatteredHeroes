package org.kiratsuji.shatteredheroes.worldgen.structure;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraft.world.level.block.Rotation;
import org.jetbrains.annotations.NotNull;
import org.kiratsuji.shatteredheroes.Shatteredheroes;
import org.kiratsuji.shatteredheroes.entity.custom.DojoMasterEntity;
import org.kiratsuji.shatteredheroes.registries.ShatteredHeroesEntities;
import org.kiratsuji.shatteredheroes.registries.ShatteredHeroesStructures;

/**
 * Peça do dojo: carrega o NBT salvo com o structure block e, ao ser colocada,
 * spawna exatamente 1 DojoMaster.
 */
public class DojoPiece extends TemplateStructurePiece {
    public static final ResourceLocation TEMPLATE_ID = ResourceLocation.fromNamespaceAndPath(Shatteredheroes.MODID, "dojo");

    private static final int MASTER_OFFSET_X = -1;
    private static final int MASTER_OFFSET_Y = 1;
    private static final int MASTER_OFFSET_Z = -1;

    public DojoPiece(StructureTemplateManager manager, BlockPos pos, Rotation rotation) {
        super(ShatteredHeroesStructures.DOJO_PIECE.get(), 0, manager, TEMPLATE_ID, TEMPLATE_ID.toString(),
                makeSettings(rotation), pos);
    }

    public DojoPiece(StructureTemplateManager manager, CompoundTag tag) {
        super(ShatteredHeroesStructures.DOJO_PIECE.get(), tag, manager,
                id -> makeSettings(Rotation.valueOf(tag.getString("Rot"))));
    }

    private static StructurePlaceSettings makeSettings(Rotation rotation) {
        return new StructurePlaceSettings()
                .setRotation(rotation)
                .addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK);
    }

    @Override
    protected void addAdditionalSaveData(net.minecraft.world.level.levelgen.structure.pieces.@NotNull StructurePieceSerializationContext context, @NotNull CompoundTag tag) {
        super.addAdditionalSaveData(context, tag);
        tag.putString("Rot", this.placeSettings.getRotation().name());
    }

    @Override
    protected void handleDataMarker(@NotNull String marker, @NotNull BlockPos pos, net.minecraft.world.level.@NotNull ServerLevelAccessor level,
                                    @NotNull RandomSource random, @NotNull BoundingBox box) {
    }

    @Override
    public void postProcess(@NotNull WorldGenLevel level, @NotNull StructureManager structureManager, @NotNull ChunkGenerator generator,
                            @NotNull RandomSource random, @NotNull BoundingBox box, @NotNull ChunkPos chunkPos, @NotNull BlockPos pivot) {
        super.postProcess(level, structureManager, generator, random, box, chunkPos, pivot);

        BlockPos spawnPos = getMasterPos();
        if (!box.isInside(spawnPos)) {
            return;
        }

        DojoMasterEntity master = ShatteredHeroesEntities.DOJO_MASTER.get().create(level.getLevel());
        if (master == null) {
            return;
        }
        master.moveTo(spawnPos.getX() + 0.5D, spawnPos.getY(), spawnPos.getZ() + 0.5D,
                random.nextFloat() * 360.0F, 0.0F);
        master.finalizeSpawn(level, level.getCurrentDifficultyAt(spawnPos), MobSpawnType.STRUCTURE, null, null);
        level.addFreshEntityWithPassengers(master);
    }

    private BlockPos getMasterPos() {
        var size = this.template.getSize();
        int x = MASTER_OFFSET_X >= 0 ? MASTER_OFFSET_X : size.getX() / 2;
        int z = MASTER_OFFSET_Z >= 0 ? MASTER_OFFSET_Z : size.getZ() / 2;
        BlockPos relative = StructureTemplate.calculateRelativePosition(
                this.placeSettings, new BlockPos(x, MASTER_OFFSET_Y, z));
        return this.templatePosition.offset(relative);
    }
}