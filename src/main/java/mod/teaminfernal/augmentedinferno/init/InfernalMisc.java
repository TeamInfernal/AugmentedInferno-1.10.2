package mod.teaminfernal.augmentedinferno.init;

import mod.teaminfernal.augmentedinferno.world.trees.TreeAcacia;
import mod.teaminfernal.augmentedinferno.world.trees.TreeBirch;
import mod.teaminfernal.augmentedinferno.world.trees.TreeDarkOak;
import mod.teaminfernal.augmentedinferno.world.trees.TreeEbon;
import mod.teaminfernal.augmentedinferno.world.trees.TreeHellbark;
import mod.teaminfernal.augmentedinferno.world.trees.TreeJungle;
import mod.teaminfernal.augmentedinferno.world.trees.TreeList;
import mod.teaminfernal.augmentedinferno.world.trees.TreeOak;
import mod.teaminfernal.augmentedinferno.world.trees.TreeSpruce;

public class InfernalMisc {

	public static void init() {
		TreeList.add("ebon", new TreeEbon());
		TreeList.add("hellbark", new TreeHellbark());
		TreeList.add("oak", new TreeOak());
		TreeList.add("spruce", new TreeSpruce());
		TreeList.add("birch", new TreeBirch());
		TreeList.add("jungle", new TreeJungle());
		TreeList.add("acacia", new TreeAcacia());
		TreeList.add("dark_oak", new TreeDarkOak());
	}

}
