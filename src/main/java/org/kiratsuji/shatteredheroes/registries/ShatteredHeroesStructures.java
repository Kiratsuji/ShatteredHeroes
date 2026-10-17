package org.kiratsuji.shatteredheroes.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.kiratsuji.shatteredheroes.Shatteredheroes;
import org.kiratsuji.shatteredheroes.worldgen.structure.DojoPiece;
import org.kiratsuji.shatteredheroes.worldgen.structure.DojoStructure;

public class ShatteredHeroesStructures {
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES =
            DeferredRegister.create(Registries.STRUCTURE_TYPE, Shatteredheroes.MODID);
    public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECES =
            DeferredRegister.create(Registries.STRUCTURE_PIECE, Shatteredheroes.MODID);

    public static final RegistryObject<StructureType<DojoStructure>> DOJO_TYPE = STRUCTURE_TYPES.register("dojo", ()-> ()-> DojoStructure.CODEC);
    public static final RegistryObject<StructurePieceType> DOJO_PIECE = STRUCTURE_PIECES.register("dojo_piece", ()-> (StructurePieceType) (context, tag)-> new DojoPiece(context.structureTemplateManager(), tag));
}
