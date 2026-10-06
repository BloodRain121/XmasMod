package com.bloodrain.xmasmod.blocks;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.IShearable;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringLightsBlock extends Block implements IShearable {
    public static final MapCodec<StringLightsBlock> CODEC = simpleCodec(StringLightsBlock::new);
    public static final BooleanProperty UP;
    public static final BooleanProperty NORTH;
    public static final BooleanProperty EAST;
    public static final BooleanProperty SOUTH;
    public static final BooleanProperty WEST;
    public static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION;
    protected static final float AABB_OFFSET = 1.0F;
    private static final VoxelShape UP_AABB;
    private static final VoxelShape WEST_AABB;
    private static final VoxelShape EAST_AABB;
    private static final VoxelShape NORTH_AABB;
    private static final VoxelShape SOUTH_AABB;
    private final Map<BlockState, VoxelShape> shapesCache;

    public MapCodec<StringLightsBlock> codec() {
        return CODEC;
    }

    public StringLightsBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(UP, false)).setValue(NORTH, false)).setValue(EAST, false)).setValue(SOUTH, false)).setValue(WEST, false));
        this.shapesCache = ImmutableMap.copyOf((Map)this.stateDefinition.getPossibleStates().stream().collect(Collectors.toMap(Function.identity(), StringLightsBlock::calculateShape)));
    }

    private static VoxelShape calculateShape(BlockState state) {
        VoxelShape voxelshape = Shapes.empty();
        if ((Boolean)state.getValue(UP)) {
            voxelshape = UP_AABB;
        }

        if ((Boolean)state.getValue(NORTH)) {
            voxelshape = Shapes.or(voxelshape, NORTH_AABB);
        }

        if ((Boolean)state.getValue(SOUTH)) {
            voxelshape = Shapes.or(voxelshape, SOUTH_AABB);
        }

        if ((Boolean)state.getValue(EAST)) {
            voxelshape = Shapes.or(voxelshape, EAST_AABB);
        }

        if ((Boolean)state.getValue(WEST)) {
            voxelshape = Shapes.or(voxelshape, WEST_AABB);
        }

        return voxelshape.isEmpty() ? Shapes.block() : voxelshape;
    }

    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return (VoxelShape)this.shapesCache.get(state);
    }

    protected boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
        return true;
    }

    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return this.hasFaces(this.getUpdatedState(state, level, pos));
    }

    private boolean hasFaces(BlockState state) {
        return this.countFaces(state) > 0;
    }

    private int countFaces(BlockState state) {
        int i = 0;

        for(BooleanProperty booleanproperty : PROPERTY_BY_DIRECTION.values()) {
            if ((Boolean)state.getValue(booleanproperty)) {
                ++i;
            }
        }

        return i;
    }

    private boolean canSupportAtFace(BlockGetter level, BlockPos pos, Direction direction) {
        if (direction == Direction.DOWN) {
            return false;
        } else {
            BlockPos blockpos = pos.relative(direction);
            if (isAcceptableNeighbour(level, blockpos, direction)) {
                return true;
            } else if (direction.getAxis() == Direction.Axis.Y) {
                return false;
            } else {
                BooleanProperty booleanproperty = (BooleanProperty)PROPERTY_BY_DIRECTION.get(direction);
                BlockState blockstate = level.getBlockState(pos.above());
                return blockstate.is(this) && (Boolean)blockstate.getValue(booleanproperty);
            }
        }
    }

    public static boolean isAcceptableNeighbour(BlockGetter blockReader, BlockPos neighborPos, Direction attachedFace) {
        return MultifaceBlock.canAttachTo(blockReader, attachedFace, neighborPos, blockReader.getBlockState(neighborPos));
    }

    private BlockState getUpdatedState(BlockState state, BlockGetter level, BlockPos pos) {
        BlockPos blockpos = pos.above();
        if ((Boolean)state.getValue(UP)) {
            state = (BlockState)state.setValue(UP, isAcceptableNeighbour(level, blockpos, Direction.DOWN));
        }

        BlockState blockstate = null;

        for(Direction direction : Direction.Plane.HORIZONTAL) {
            BooleanProperty booleanproperty = getPropertyForFace(direction);
            if ((Boolean)state.getValue(booleanproperty)) {
                boolean flag = this.canSupportAtFace(level, pos, direction);
                if (!flag) {
                    if (blockstate == null) {
                        blockstate = level.getBlockState(blockpos);
                    }

                    flag = blockstate.is(this) && (Boolean)blockstate.getValue(booleanproperty);
                }

                state = (BlockState)state.setValue(booleanproperty, flag);
            }
        }

        return state;
    }

    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (facing == Direction.DOWN) {
            return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
        } else {
            BlockState blockstate = this.getUpdatedState(state, level, currentPos);
            return !this.hasFaces(blockstate) ? Blocks.AIR.defaultBlockState() : blockstate;
        }
    }

    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.getGameRules().getBoolean(GameRules.RULE_DO_VINES_SPREAD) && level.random.nextInt(4) == 0 && level.isAreaLoaded(pos, 4)) {
            Direction direction = Direction.getRandom(random);
            BlockPos blockpos = pos.above();
            if (direction.getAxis().isHorizontal() && !(Boolean)state.getValue(getPropertyForFace(direction))) {
                if (this.canSpread(level, pos)) {
                    BlockPos blockpos4 = pos.relative(direction);
                    BlockState blockstate4 = level.getBlockState(blockpos4);
                    if (blockstate4.isAir()) {
                        Direction direction3 = direction.getClockWise();
                        Direction direction4 = direction.getCounterClockWise();
                        boolean flag = (Boolean)state.getValue(getPropertyForFace(direction3));
                        boolean flag1 = (Boolean)state.getValue(getPropertyForFace(direction4));
                        BlockPos blockpos2 = blockpos4.relative(direction3);
                        BlockPos blockpos3 = blockpos4.relative(direction4);
                        if (flag && isAcceptableNeighbour(level, blockpos2, direction3)) {
                            level.setBlock(blockpos4, (BlockState)this.defaultBlockState().setValue(getPropertyForFace(direction3), true), 2);
                        } else if (flag1 && isAcceptableNeighbour(level, blockpos3, direction4)) {
                            level.setBlock(blockpos4, (BlockState)this.defaultBlockState().setValue(getPropertyForFace(direction4), true), 2);
                        } else {
                            Direction direction1 = direction.getOpposite();
                            if (flag && level.isEmptyBlock(blockpos2) && isAcceptableNeighbour(level, pos.relative(direction3), direction1)) {
                                level.setBlock(blockpos2, (BlockState)this.defaultBlockState().setValue(getPropertyForFace(direction1), true), 2);
                            } else if (flag1 && level.isEmptyBlock(blockpos3) && isAcceptableNeighbour(level, pos.relative(direction4), direction1)) {
                                level.setBlock(blockpos3, (BlockState)this.defaultBlockState().setValue(getPropertyForFace(direction1), true), 2);
                            } else if ((double)random.nextFloat() < 0.05 && isAcceptableNeighbour(level, blockpos4.above(), Direction.UP)) {
                                level.setBlock(blockpos4, (BlockState)this.defaultBlockState().setValue(UP, true), 2);
                            }
                        }
                    } else if (isAcceptableNeighbour(level, blockpos4, direction)) {
                        level.setBlock(pos, (BlockState)state.setValue(getPropertyForFace(direction), true), 2);
                    }
                }
            } else {
                if (direction == Direction.UP && pos.getY() < level.getMaxBuildHeight() - 1) {
                    if (this.canSupportAtFace(level, pos, direction)) {
                        level.setBlock(pos, (BlockState)state.setValue(UP, true), 2);
                        return;
                    }

                    if (level.isEmptyBlock(blockpos)) {
                        if (!this.canSpread(level, pos)) {
                            return;
                        }

                        BlockState blockstate3 = state;

                        for(Direction direction2 : Direction.Plane.HORIZONTAL) {
                            if (random.nextBoolean() || !isAcceptableNeighbour(level, blockpos.relative(direction2), direction2)) {
                                blockstate3 = (BlockState)blockstate3.setValue(getPropertyForFace(direction2), false);
                            }
                        }

                        if (this.hasHorizontalConnection(blockstate3)) {
                            level.setBlock(blockpos, blockstate3, 2);
                        }

                        return;
                    }
                }

                if (pos.getY() > level.getMinBuildHeight()) {
                    BlockPos blockpos1 = pos.below();
                    BlockState blockstate = level.getBlockState(blockpos1);
                    if (blockstate.isAir() || blockstate.is(this)) {
                        BlockState blockstate1 = blockstate.isAir() ? this.defaultBlockState() : blockstate;
                        BlockState blockstate2 = this.copyRandomFaces(state, blockstate1, random);
                        if (blockstate1 != blockstate2 && this.hasHorizontalConnection(blockstate2)) {
                            level.setBlock(blockpos1, blockstate2, 2);
                        }
                    }
                }
            }
        }

    }

    private BlockState copyRandomFaces(BlockState sourceState, BlockState spreadState, RandomSource random) {
        for(Direction direction : Direction.Plane.HORIZONTAL) {
            if (random.nextBoolean()) {
                BooleanProperty booleanproperty = getPropertyForFace(direction);
                if ((Boolean)sourceState.getValue(booleanproperty)) {
                    spreadState = (BlockState)spreadState.setValue(booleanproperty, true);
                }
            }
        }

        return spreadState;
    }

    private boolean hasHorizontalConnection(BlockState state) {
        return (Boolean)state.getValue(NORTH) || (Boolean)state.getValue(EAST) || (Boolean)state.getValue(SOUTH) || (Boolean)state.getValue(WEST);
    }

    private boolean canSpread(BlockGetter blockReader, BlockPos pos) {
        int i = 4;
        Iterable<BlockPos> iterable = BlockPos.betweenClosed(pos.getX() - 4, pos.getY() - 1, pos.getZ() - 4, pos.getX() + 4, pos.getY() + 1, pos.getZ() + 4);
        int j = 5;

        for(BlockPos blockpos : iterable) {
            if (blockReader.getBlockState(blockpos).is(this)) {
                --j;
                if (j <= 0) {
                    return false;
                }
            }
        }

        return true;
    }

    protected boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        BlockState blockstate = useContext.getLevel().getBlockState(useContext.getClickedPos());
        return blockstate.is(this) ? this.countFaces(blockstate) < PROPERTY_BY_DIRECTION.size() : super.canBeReplaced(state, useContext);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        boolean flag = blockstate.is(this);
        BlockState blockstate1 = flag ? blockstate : this.defaultBlockState();

        for(Direction direction : context.getNearestLookingDirections()) {
            if (direction != Direction.DOWN) {
                BooleanProperty booleanproperty = getPropertyForFace(direction);
                boolean flag1 = flag && (Boolean)blockstate.getValue(booleanproperty);
                if (!flag1 && this.canSupportAtFace(context.getLevel(), context.getClickedPos(), direction)) {
                    return (BlockState)blockstate1.setValue(booleanproperty, true);
                }
            }
        }

        return flag ? blockstate1 : null;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{UP, NORTH, EAST, SOUTH, WEST});
    }

    protected BlockState rotate(BlockState state, Rotation rotate) {
        switch (rotate) {
            case CLOCKWISE_180 -> {
                return (BlockState)((BlockState)((BlockState)((BlockState)state.setValue(NORTH, (Boolean)state.getValue(SOUTH))).setValue(EAST, (Boolean)state.getValue(WEST))).setValue(SOUTH, (Boolean)state.getValue(NORTH))).setValue(WEST, (Boolean)state.getValue(EAST));
            }
            case COUNTERCLOCKWISE_90 -> {
                return (BlockState)((BlockState)((BlockState)((BlockState)state.setValue(NORTH, (Boolean)state.getValue(EAST))).setValue(EAST, (Boolean)state.getValue(SOUTH))).setValue(SOUTH, (Boolean)state.getValue(WEST))).setValue(WEST, (Boolean)state.getValue(NORTH));
            }
            case CLOCKWISE_90 -> {
                return (BlockState)((BlockState)((BlockState)((BlockState)state.setValue(NORTH, (Boolean)state.getValue(WEST))).setValue(EAST, (Boolean)state.getValue(NORTH))).setValue(SOUTH, (Boolean)state.getValue(EAST))).setValue(WEST, (Boolean)state.getValue(SOUTH));
            }
            default -> {
                return state;
            }
        }
    }

    protected BlockState mirror(BlockState state, Mirror mirror) {
        switch (mirror) {
            case LEFT_RIGHT -> {
                return (BlockState)((BlockState)state.setValue(NORTH, (Boolean)state.getValue(SOUTH))).setValue(SOUTH, (Boolean)state.getValue(NORTH));
            }
            case FRONT_BACK -> {
                return (BlockState)((BlockState)state.setValue(EAST, (Boolean)state.getValue(WEST))).setValue(WEST, (Boolean)state.getValue(EAST));
            }
            default -> {
                return super.mirror(state, mirror);
            }
        }
    }

    public static BooleanProperty getPropertyForFace(Direction face) {
        return (BooleanProperty)PROPERTY_BY_DIRECTION.get(face);
    }

    static {
        UP = PipeBlock.UP;
        NORTH = PipeBlock.NORTH;
        EAST = PipeBlock.EAST;
        SOUTH = PipeBlock.SOUTH;
        WEST = PipeBlock.WEST;
        PROPERTY_BY_DIRECTION = (Map)PipeBlock.PROPERTY_BY_DIRECTION.entrySet().stream().filter((p_57886_) -> p_57886_.getKey() != Direction.DOWN).collect(Util.toMap());
        UP_AABB = Block.box((double)0.0F, (double)15.0F, (double)0.0F, (double)16.0F, (double)16.0F, (double)16.0F);
        WEST_AABB = Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)1.0F, (double)16.0F, (double)16.0F);
        EAST_AABB = Block.box((double)15.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)16.0F, (double)16.0F);
        NORTH_AABB = Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)16.0F, (double)1.0F);
        SOUTH_AABB = Block.box((double)0.0F, (double)0.0F, (double)15.0F, (double)16.0F, (double)16.0F, (double)16.0F);
    }
}
