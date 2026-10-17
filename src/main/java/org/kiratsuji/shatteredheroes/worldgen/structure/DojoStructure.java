package org.kiratsuji.shatteredheroes.worldgen.structure;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;
import org.kiratsuji.shatteredheroes.registries.ShatteredHeroesStructures;

import java.util.Optional;

public class DojoStructure extends Structure {
    // ── Variables ─────────────────────────────────────────────────────────────
    public static final Codec<DojoStructure> CODEC = simpleCodec(DojoStructure::new);

    // ── Constructor ───────────────────────────────────────────────────────────
    public DojoStructure(StructureSettings settings) {
        super(settings);
    }

    @Override
    protected @NotNull Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        Rotation rotation = Rotation.getRandom(context.random());
        StructureTemplate template = context.structureTemplateManager().getOrCreate(DojoPiece.TEMPLATE_ID);

        BlockPos origin = context.chunkPos().getWorldPosition();
        BoundingBox box = template.getBoundingBox(new StructurePlaceSettings().setRotation(rotation), origin);

        int[][] samples = {
                {box.minX(), box.minZ()}, {box.maxX(), box.minZ()},
                {box.minX(), box.maxZ()}, {box.maxX(), box.maxZ()},
                {box.getCenter().getX(), box.getCenter().getZ()}
        };

        int lowest = Integer.MAX_VALUE;
        for (int[] s : samples) {
            int surface = context.chunkGenerator().getFirstOccupiedHeight(
                    s[0], s[1], Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor(), context.randomState());
            int ground = context.chunkGenerator().getFirstOccupiedHeight(
                    s[0], s[1], Heightmap.Types.OCEAN_FLOOR_WG, context.heightAccessor(), context.randomState());
            if (surface != ground) {
                return Optional.empty();
            }
            lowest = Math.min(lowest, surface);
        }

        BlockPos pos = new BlockPos(origin.getX(), lowest, origin.getZ());
        return Optional.of(new GenerationStub(pos, builder ->
                builder.addPiece(new DojoPiece(context.structureTemplateManager(), pos, rotation))));
    }
    @Override
    public @NotNull StructureType<?> type() {
        return ShatteredHeroesStructures.DOJO_TYPE.get();
    }
}