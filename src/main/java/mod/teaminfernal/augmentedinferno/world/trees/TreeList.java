package mod.teaminfernal.augmentedinferno.world.trees;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import mod.teaminfernal.augmentedinferno.util.ITreeMapping;

public class TreeList {

	private static Map<String, ITreeMapping> trees = new HashMap<String, ITreeMapping>();
	
	public static void add(String treeName, ITreeMapping treeMapping) {
		trees.put(treeName, treeMapping);
	}
	
	/**
	 * Returns the specific ITreeMapping from the Registry.
	 * Returns null if list empty or tree not recognized.
	 * @param treeName
	 * @return
	 */
	@Nullable
	public static ITreeMapping get(String treeName) {
		if(trees.size() == 0 || !trees.containsKey(treeName)) return null;
		return trees.get(treeName);
	}
	
}
